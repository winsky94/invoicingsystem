package Presentation.promotionui.GiftPromotion;

import po.PromotionPO.PromotionType;
import vo.GiftGoodsProVO;
import Presentation.mainui.MainFrame;


public class ModGiftPanel extends AddGiftPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GiftGoodsProVO vo;
	public ModGiftPanel(String ID,MainFrame myFather) throws Exception {
		super(myFather);
		vo=(GiftGoodsProVO)service.find(ID, PromotionType.GIFTGOODS);
		title.setText("修改赠品赠送策略");
		from.setTime(vo.getStartDate());
		to.setTime(vo.getEndDate());
		memberGradeBox.setSelectedItem(vo.getMemberlevel());
		limitFld.setText(String.valueOf(vo.getTotalValue()));
		//加监听!
	}
}
