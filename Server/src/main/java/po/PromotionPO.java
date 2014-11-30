package po;

import java.util.Date;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;

public class PromotionPO {
	Date startDate,endDate;
	PromotionType type;
	MemberLevel level;
	MemberType mtype;
	int release;
	
	public PromotionPO(Date startDate, Date endDate, PromotionType type,
			MemberLevel level, MemberType mtype, int release) {
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.level = level;
		this.mtype = mtype;
		this.release = release;
	}
	
	

	public Date getStartDate() {
		return startDate;
	}



	public Date getEndDate() {
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



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public void setEndDate(Date endDate) {
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
