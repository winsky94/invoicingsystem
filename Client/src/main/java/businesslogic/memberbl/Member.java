package businesslogic.memberbl;

import java.util.ArrayList;

import vo.MemberVO;
import businesslogicservice.memberblservice.MemberBLService;

public class Member implements MemberBLService{
	MemberType mType; 
	MemberLevel mLevel;
	String memberID,name,tel,address,postcode,EMail,defaultClerk;
	double MaxOwe,toReceive, toPay;

	public int addMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifyMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemberVO findMember(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MemberVO> showMembers() {
		// TODO Auto-generated method stub
		return null;
	}

}
