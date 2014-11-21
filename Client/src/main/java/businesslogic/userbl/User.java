package businesslogic.userbl;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import dataservice.userdataservice.UserDataService;
import po.UserPO;
import vo.UserVO;
import businesslogicservice.userblservice.UserBLService;
//11-17  By jin 0 warning 哈
public class User implements UserBLService{
	private String name;
	private String ID;
	private String password;
	private UserJob job;
	private UserDataService service;
	public User() throws Exception{
		System.setSecurityManager(new SecurityManager());
		String host="localhost:1099";
		String url="rmi://"+host+"/userService";
	
		service=(UserDataService)Naming.lookup(url);
	}
	
	
	
	public int login(String ID, String password) {
	   
		
	
			String pass = service.showUserInfo(ID).getPassword();
			int result=0;//成功
			if(pass==null)
				return 2;//该用户不存在
			else if(!pass.equals(password))
				return 1;//密码错误
		
		
		
		return 0;
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
			 vo=poToVO(po);
			
	
		//password是否需要显示
		return vo;
		
		
	}
	
	public ArrayList<UserVO> showAll(){
		ArrayList<UserPO> po=service.showAll();
		ArrayList<UserVO> vo=new ArrayList<UserVO>();
		for(int i=0;i<po.size();i++)
			vo.add(poToVO(po.get(i)));
			
		return vo;
}
	
	
	private UserPO voToPO(UserVO vo){
		UserPO po=new UserPO(vo.getID(),vo.getName(),vo.getPassword(),
				vo.getJob(),vo.getGrades());
		return po;
		
	}
	
	
	private UserVO poToVO(UserPO po){
		UserVO vo=new UserVO(po.getID(),po.getName(),po.getPassword(),
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
	
}
