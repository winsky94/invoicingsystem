package businesslogic.userbl;

import java.rmi.Naming;
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
	private UserType type;
	private UserDataService service;
	public User() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/localService";
		//查找服务器端远程方法
		service=(UserDataService)Naming.lookup(url);
	}
	
	
	
	public int login(String ID, String password) {
		String pass=service.Find(ID);
		int result=0;//成功
		if(pass==null)
			return 2;//该用户不存在
		else if(pass.equals(password))
			return 1;//密码错误
		return result;
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
		
		UserPO po=service.showUserInfo(UserID);
		//password是否需要显示
		UserVO vo=poToVO(po);
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
				vo.getJob());
		return po;
		
	}
	
	
	private UserVO poToVO(UserPO po){
		UserVO vo=new UserVO(po.getID(),po.getName(),po.getPassword(),
				po.getJob());
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
	
	public UserType getType(){
		return type;
	}
	
}
