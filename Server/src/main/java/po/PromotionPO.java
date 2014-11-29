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

	public enum PromotionType {
		GIFTGOODS,GIFTCOUPON,PACK,DISCOUNT
	}
}
