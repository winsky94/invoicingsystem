package dataservice.userdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.LogPO;

public interface LogService extends Remote{

		public void AddLog(LogPO po);
		public ArrayList<LogPO>  showAll();
}
