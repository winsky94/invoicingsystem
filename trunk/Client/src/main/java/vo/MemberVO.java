package vo;

import businesslogic.memberbl.MemAccountInfo;
import businesslogic.memberbl.MemBaseInfo;
import businesslogic.memberbl.MemContactInfo;
import businesslogic.memberbl.MemberLevel;
import businesslogic.memberbl.MemberType;

public class MemberVO {
	 MemBaseInfo bInfo;
	 MemAccountInfo aInfo;
	 private MemContactInfo cInfo;

	public MemberVO(MemBaseInfo bInfo,MemAccountInfo aInfo,MemContactInfo cInfo) {
		this.bInfo=bInfo;
		this.aInfo=aInfo;
		this.cInfo=cInfo;	
	}

	public String getMemberID() {
		return bInfo.memberID;
	}

	public MemberType getmType() {
		return bInfo.mType;
	}

	public MemberLevel getmLevel() {
		return mLevel;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getEMail() {
		return EMail;
	}

	public String getDefaultClerk() {
		return defaultClerk;
	}

	public double getMaxOwe() {
		return MaxOwe;
	}

	public double getToReceive() {
		return toReceive;
	}

	public double getToPay() {
		return toPay;
	}
	public double getPoints() {
		return points;
	}
}


