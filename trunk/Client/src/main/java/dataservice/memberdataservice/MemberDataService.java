package dataservice.memberdataservice;
import java.rmi.Remote;

public interface MemberDataService extends Remote{
	public int add(MemberPO po);
	public int delete(MemberPO po);
	public int modify(MemberPO po);
	public MemberPO find(String message);
}
