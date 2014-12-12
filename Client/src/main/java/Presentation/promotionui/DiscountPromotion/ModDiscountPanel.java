package Presentation.promotionui.DiscountPromotion;

import java.util.ArrayList;

import po.PromotionPO.PromotionType;
import vo.DiscountProVO;
import Presentation.mainui.MainFrame;


public class ModDiscountPanel extends AddDiscountPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DiscountProVO vo;
	ArrayList<Object> content=new ArrayList<Object>();
	public ModDiscountPanel(String ID,MainFrame myFather) throws Exception {
		super(myFather);
		vo=(DiscountProVO)service.find(ID, PromotionType.DISCOUNT);
		title.setText("修改打折促销策略");
		from.setTime(vo.getStartDate());
		to.setTime(vo.getEndDate());
		memberGradeBox.setSelectedItem(vo.getMemberlevel());
		content.addAll(vo.getGoodsList());
		RefreshCTable(content,vo.getCountList());
		//加监听！
	}
}
