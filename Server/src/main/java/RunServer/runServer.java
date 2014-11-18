package RunServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import Data.userdata.User;


//rmi 启动 服务注册  11-17 By jin
public class runServer {
	public static void main(String[] args) {
		/**
		 * 需添加安全机智
		 */
		
		try{
			LocateRegistry.createRegistry(8080);
			System.out.println("已启动服务器。。。");
			User user=new User();
			Naming.rebind("localService", user);
			
			
			
		}catch(Exception e){
			System.out.println("错误"+e);
		}
	}

}
