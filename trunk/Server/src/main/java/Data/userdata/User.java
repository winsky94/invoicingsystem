
package Data.userdata;

import java.rmi.RemoteException;

import po.UserPO;
import Dataservice.userdataservice.UserDataService;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//11-17 By jin  添加showAll 和Find 方法删除 login 判断留在bl层
public class User implements UserDataService{
	
	public String  Find(String ID){
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

