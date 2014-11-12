package businesslogic.memberbl;

import java.util.ArrayList;

import vo.MemberVO;
import businesslogicservice.memberblservice.MemberBLService;

public class MockMember implements MemberBLService {
	MemberType mType;
	MemberLevel mLevel;
	String memberID, name, tel, address, postcode, EMail, defaultClerk;
	double MaxOwe, toReceive, toPay;
	int points;

	public MockMember( double toReceive,double toPay) {
		
		this.toReceive = toReceive;
		this.toPay = toPay;
	}
	public MockMember(String memberID, MemberType mType, MemberLevel mLevel,
			String name,double MaxOwe, double toReceive,
			double toPay, int points){
		this.memberID = memberID;
		this.mType = mType;
		this.mLevel = mLevel;
		this.name = name;
		this.MaxOwe = MaxOwe;
		this.toReceive = toReceive;
		this.toPay = toPay;
		this.points = points;
		
	}
	public MockMember(String memberID, MemberType mType, MemberLevel mLevel,
			String name, String tel, String address, String postcode,
			String EMail, String defaultClerk, double MaxOwe, double toReceive,
			double toPay, int points) {
		this.memberID = memberID;
		this.mType = mType;
		this.mLevel = mLevel;
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.postcode = postcode;
		this.EMail = EMail;
		this.defaultClerk = defaultClerk;
		this.MaxOwe = MaxOwe;
		this.toReceive = toReceive;
		this.toPay = toPay;
		this.points = points;
	}

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

	public void updatePoints(int pointsToAdd) {

	}

	public void updateToReceive(double newData) {
		if(this.mType==MemberType.JHS)
            toReceive-=newData;
		else
			toReceive+=newData;
	}

	public void updateToPay(double newData) {
		if(this.mType==MemberType.JHS)
            toPay+=newData;
		else
			toPay-=newData;
	}
	
	public double getToReceive(){
		return toReceive;
	}
	
	public double getToPay(){
		return toPay;
	}
}
