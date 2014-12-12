package Presentation.promotionui.CouponPromotion;

import javax.swing.JLabel;

import po.PromotionPO.PromotionType;
import vo.GiftCouponProVO;
import Presentation.mainui.MainFrame;

public class ModCouponPanel extends AddCouponPanel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GiftCouponProVO vo;
	public ModCouponPanel(String ID,MainFrame myFather) {
		super(myFather);
		vo=(GiftCouponProVO)service.find(ID, PromotionType.GIFTCOUPON);
		title.setText("修改代金券赠送策略");
		from.setTime(vo.getStartDate());
		to.setTime(vo.getEndDate());
		memberGradeBox.setSelectedItem(vo.getMemberlevel());
		limitFld.setText(String.valueOf(vo.getTotalValue()));
		priceFld.setText(String.valueOf(vo.getCouponList().get(0).getValue()));
		priceFld.setEditable(false);
		totalFld.setText(String.valueOf(vo.getCouponList().size()));
		totalFld.setEditable(false);
		//加监听！
	}
}
