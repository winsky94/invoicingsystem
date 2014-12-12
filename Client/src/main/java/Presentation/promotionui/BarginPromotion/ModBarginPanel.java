package Presentation.promotionui.BarginPromotion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import po.MemberPO.MemberLevel;
import po.PromotionPO.PromotionType;
import vo.CommodityVO;
import vo.LogVO;
import vo.PackProVO;
import vo.PackVO;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;


public class ModBarginPanel extends AddBarginPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PackProVO vo;
	ArrayList<Object> content=new ArrayList<Object>();
	
	public ModBarginPanel(String ID,MainFrame myFather) throws Exception {
		super(myFather);
		vo=(PackProVO)service.find(ID, PromotionType.PACK);
		//------------------
		title.setText("修改特价包促销策略");
		from.setTime(vo.getStartDate());	
		to.setTime(vo.getEndDate());
		memberGradeBox.setSelectedItem(vo.getMemberlevel());
		defaultTotalLbl.setText("原价:"+vo.getTotalValue()+"元");
		priceFld.setText(String.valueOf(vo.getPackValue()));
		content.addAll(vo.getPack().getCombine());
		RefreshCTable(content);
		submitBtn.removeActionListener(slisten);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//加监听
			}
		});
	}
}
