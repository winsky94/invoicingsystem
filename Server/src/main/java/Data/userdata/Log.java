package Data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.LogPO;
import Data.serutility.JXCFile;
import dataservice.userdataservice.LogService;

public class Log extends UnicastRemoteObject implements LogService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;

	public Log() throws RemoteException {
		super();
		file=new JXCFile("src/main/java/log.ser");
	}

	public void AddLog(LogPO po) throws RemoteException {
		file.write(po);
	}

	public ArrayList<LogPO> showAll() throws RemoteException {
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<LogPO> buffer=new ArrayList<LogPO>();
		for(Object b:a){
			LogPO c=(LogPO)b;
			buffer.add(c);
		}
		
		return buffer;
	}
	
	public static void main(String[] args){
		Log a;
		try {
			a = new Log();
			LogPO pp=new LogPO("2014/12/08","CW-00001","Lucy","创建一个收款单",100);
			a.AddLog(pp);
			ArrayList<LogPO> buffer=a.showAll();	
			System.out.println("-----------------我是萌萌哒的分隔线---------------------");
			for(LogPO po:buffer){
				System.out.println("Date:"+po.getDate()+" user:"+po.getUserName()+" info:"+po.getInfo()+" addGrades:"+po.getAddGrades());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
