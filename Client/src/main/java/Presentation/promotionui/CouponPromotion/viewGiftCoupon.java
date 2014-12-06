package Presentation.promotionui.CouponPromotion;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import Presentation.mainui.MainFrame;
import businesslogicservice.promotionblservice.PromotionViewService;
import vo.GiftCouponProVO;

public class viewGiftCoupon extends JPanel{
	GiftCouponProVO vo;
	PromotionViewService service;
	AddCouponPanel p;
	public viewGiftCoupon(MainFrame frame,String id){
		p=new AddCouponPanel(frame);
		vo=service.gpFindByID(id);
		p.limitFld.setText(""+vo.getTotalValue());
	
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		
	}
	

}
