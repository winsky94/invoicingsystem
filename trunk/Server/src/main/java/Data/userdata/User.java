
package Data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.UserPO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.rmi.PortableRemoteObject;

import dataservice.userdataservice.UserDataService;
//11-17 By jin  添加showAll 和Find 方法删除 login 判断留在bl层
public class User extends UnicastRemoteObject implements UserDataService,Serializable{
	
	public  User() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String  Find(String ID)throws RemoteException{
		return "123456";
	}

	public int add(UserPO po) throws RemoteException {		
	    	try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"));                     
                oos.writeObject(po);
                oos.close();                       
        } catch (Exception ex) {  
        	ex.printStackTrace();
        	return 1;
        }
	    		    
	    return 0;
	}

	public int delete(UserPO po) throws RemoteException {
		  UserPO b;
		    try {
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"));
	            b = (UserPO) ois.readObject();
	            System.out.println();
	            ois.close();
	    } catch (Exception ex) {
	            ex.printStackTrace();
	    }
		    return 0;
	}

	public int modify(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserPO showUserInfo(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

