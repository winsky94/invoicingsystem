package businesslogic.userbl;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.NumberFormat;
import java.util.ArrayList;

import dataservice.userdataservice.UserDataService;
import po.UserPO;
import po.UserPO.UserJob;
import vo.UserVO;
import businesslogicservice.userblservice.UserBLService;
//11-17  By jin 0 warning 哈
public class User implements UserBLService{
	private String name;
	private String ID;
	private String password;
	private double points;
	private UserJob job;
	public UserDataService service;
	public User() throws Exception{
	//	System.setSecurityManager(new SecurityManager());
		String host="localhost:1099";
		String url="rmi://"+host+"/userService";
	
		service=(UserDataService)Naming.lookup(url);
		
	}
	
	
	//用户名也可以登陆
	public int login(String ID, String password) {
	   
		
			UserPO po=service.showUserInfo(ID);
		
			if(po==null)
				return 2;//该用户不存在
			else if(!po.getPassword().equals(password))
				return 1;//密码错误
		
	return 0;//登陆成功
	}

	public int addUser(UserVO vo)   {
	
		UserPO po=voToPO(vo);
		
		return service.add(po);
	}

	public int deleteUser(String ID) {
		
		return service.delete(ID);
	}

	public int modifyUser(UserVO vo) {
		
		return service.modify(voToPO(vo));
	}

	public UserVO showUser(String UserID) {
		UserVO vo = null;
		
	
			UserPO po;
			po = service.showUserInfo(UserID);
			if(po==null) return null;
			 vo=poToVO(po);
			
	
		//password是否需要显示
		return vo;
		
		
	}
	public String NewUserID(UserJob job){
		ArrayList<UserPO> po=service.showAll();
		String lastID=null;
		if(po==null) lastID="00001";
		else{
		for(int i=0;i<po.size();i++){
			if(po.get(i).getJob()==job)
				{lastID=po.get(i).getID();}
		}
		if(lastID!=null)
		{	
			double d=Double.parseDouble(lastID.substring(3,8))+1;
		     NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(5); 
		     nf.setGroupingUsed(false);
		     lastID=nf.format(d);
		}
		
		else lastID="00001";}
		switch(job){
		case MANAGER:
			return "JL-"+lastID;
		case SALE:
			return "XS-"+lastID;
		case STOCK:
			return "KC-"+lastID;
		case FINANCE:
			return "CW-"+lastID;
		default:
			return "GL-"+lastID;		
			
		}
		
	}
	
	public ArrayList<UserVO> showAll(){
		ArrayList<UserPO> po=service.showAll();
		if(po==null)
			return null;
		ArrayList<UserVO> vo=new ArrayList<UserVO>();
		for(int i=0;i<po.size();i++)
			vo.add(poToVO(po.get(i)));
			
		return vo;
}
	
	
	public static UserPO voToPO(UserVO vo){
		UserPO po=new UserPO(vo.getName(),vo.getID(),vo.getPassword(),
				(UserJob)vo.getJob(),vo.getGrades());
		return po;
		
	}
	
	
	private UserVO poToVO(UserPO po){
		UserVO vo=new UserVO(po.getName(),po.getID(),po.getPassword(),
				po.getJob(),po.getGrades());
		return vo;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}

	public String getPassWord(){
		return password;
	}
	
	public UserJob getJob(){
		return job;
	}
	
	public void setJob(UserJob job){
		this.job=job;
	}
	
	public double getPoints(){
		return points;
	}
	
}