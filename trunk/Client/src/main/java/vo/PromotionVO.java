package vo;

import java.util.ArrayList;
import java.util.Date;





import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import po.PromotionPO.PromotionType;


public class PromotionVO {
	String id;
	String startDate,endDate;
	PromotionType type;
	MemberLevel level;

	int release;//发布
	
	public PromotionVO(String id,String startDate, String endDate, PromotionType type,
			MemberLevel memberlevel) {
	
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.level = memberlevel;
	
	}
	public String getId() {
		return id;
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
	public MemberLevel getMemberlevel() {
		return level;
	}
	
	

}




	


