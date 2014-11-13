package businesslogic.memberbl;

import java.util.ArrayList;

import vo.MemberVO;
import businesslogicservice.memberblservice.MemberBLService;

public class MockMember extends  Member{
	private MemberType mType;
	private MemberLevel mLevel;
	private String memberID, name;
	private double MaxOwe, toReceive, toPay;
	private long points;

	
	public MockMember(String memberID, MemberType mType, MemberLevel mLevel,
			String name,double MaxOwe	){
		this.memberID = memberID;
		this.mType = mType;
		this.mLevel = mLevel;
		this.name = name;
		this.MaxOwe = MaxOwe;
		this.toReceive = 0;
		this.toPay = 0;
		
	}


/*客户应收变化*/
	public void updateToReceive(double newData) {
		if(newData>=0)
			this.toReceive+=newData;
		else
			this.toReceive-=newData;
	
		
	}

	public void updateToPay(double newData) {
		if(newData>=0)
            this.toPay+=newData;
		else
			this.toPay-=newData;
	}
	
	public double getToReceive(){
		return this.toReceive;
	}
	
	public double getToPay(){
		return this.toPay;
	}
}
