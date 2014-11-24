package Data.memberdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.MemberPO;
import dataservice.memberdataservice.MemberDataService;

public class Member extends UnicastRemoteObject implements MemberDataService{

	public Member() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int add(MemberPO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(MemberPO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modify(MemberPO po) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemberPO find(String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
