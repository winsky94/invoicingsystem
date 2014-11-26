package businesslogicservice.memberblservice;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.MemberVO;


public interface MemberBLService {
	public int addMember(MemberVO vo);
	public int deleteMember(String memID) ;
	public int modifyMember(MemberVO vo);
	public MemberVO findMember(String message);
	public ArrayList<MemberVO> showMembers();
	public String getNewID();
}
