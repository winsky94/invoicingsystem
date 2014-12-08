package businesslogic.utilitybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.LogService;
import dataservice.userdataservice.UserDataService;
import po.LogPO;
import businesslogicservice.userblservice.LogBLService;
import vo.LogVO;
//依赖userDataService??
public class log implements LogBLService{
	LogService service;
	public log() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/userService";
	
		service=(LogService)Naming.lookup(url);
	}
	
	public void AddLog(LogVO vo){
		
		service.AddLog(voToPo(vo));
	}
	
	
	public ArrayList<LogVO> showLog(){
		ArrayList<LogPO> po=service.showAll();
		if(po==null)return null;
		else 
			{
			ArrayList<LogVO> vo=new ArrayList<LogVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			
				return vo;
			}
		
		
	}
	
	
	public LogVO poToVo(LogPO po){
		LogVO vo=new LogVO(po.getDate(),po.getUserID(),po.getUserName(),
				po.getInfo(),po.getAddGrades());
		return vo;
		
	}
	
	public LogPO voToPo(LogVO vo){
		LogPO po=new LogPO(vo.getDate(),vo.getUserID(),vo.getUserName()
				,vo.getInfo(),vo.getAddGrades());
		return po;
	}

	
}
