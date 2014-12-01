package po;

import java.io.Serializable;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;

public class PromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String startDate,endDate;
	PromotionType type;
	MemberLevel level;
	MemberType mtype;
	int release;
	
	public PromotionPO(String id,String startDate, String endDate, PromotionType type,
			MemberLevel level, MemberType mtype, int release) {		
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.level = level;
		this.mtype = mtype;
		this.release = release;
		this.id=id;
	}

	public String getStartDate() {
		return startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public PromotionType getType() {
		return type;
	}



	public MemberLevel getLevel() {
		return level;
	}



	public MemberType getMtype() {
		return mtype;
	}



	public int getRelease() {
		return release;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public void setLevel(MemberLevel level) {
		this.level = level;
	}



	public void setMtype(MemberType mtype) {
		this.mtype = mtype;
	}



	public void setRelease(int release) {
		this.release = release;
	}



	public enum PromotionType {
		GIFTGOODS,GIFTCOUPON,PACK,DISCOUNT
	}
}