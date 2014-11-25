package dataservice.memberdataservice;
import java.rmi.Remote;
import java.util.ArrayList;

import po.MemberPO;

public interface MemberDataService extends Remote{
	public int add(MemberPO po);
	public int delete(String memID);
	public int modify(MemberPO po);
	public MemberPO find(String message);
	public ArrayList<MemberPO> showAll();
}
