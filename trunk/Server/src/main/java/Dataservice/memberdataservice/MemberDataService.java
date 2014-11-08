package Dataservice.memberdataservice;
import java.rmi.Remote;

import po.MemberPO;

public interface MemberDataService extends Remote{
	public int add(MemberPO po);
	public int delete(MemberPO po);
	public int modify(MemberPO po);
	public MemberPO find(String message);
}
