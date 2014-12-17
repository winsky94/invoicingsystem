package Presentation.promotionui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import businesslogic.promotionbl.*;
import businesslogicservice.promotionblservice.PromotionBLService;
import po.PromotionPO.PromotionType;
import Presentation.mainui.MainFrame;
import Presentation.uihelper.UIhelper;

public class DelProDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submitBtn;
	JLabel textLbl;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 25 / 100;
	int dlgHeight = screenHeight * 25 / 100;
	Container pnl;
	PromotionType type;
	public DelProDialog(final String[] id,final PromotionType[] type,final MainFrame father){
		
	
		pnl = this.getContentPane();
		pnl.setBackground(Color.white);
		pnl.setLayout(null);
		//
		// ------------------textLbl------------------------------------
		textLbl = new JLabel("你确定要删除此策略吗？");
		textLbl.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		textLbl.setBounds(dlgWidth * 28 / 100, dlgHeight * 20 / 100,
				dlgWidth * 80 / 100, dlgHeight * 16 / 100);
		pnl.add(textLbl);
		// -------------------submitBtn---------------------------------------------
		submitBtn = new JButton("确定删除");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		submitBtn.setBounds(dlgWidth * 35 / 100, dlgHeight * 58 / 100,
				dlgWidth * 30 / 100, dlgHeight * 16 / 100);
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(251, 147, 121));
		pnl.add(submitBtn);
		submitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				DelProDialog.this.dispose();
				PromotionBLService service=new promotionController();
				for(int i=0;i<id.length;i++){
					
						System.out.println(service.Delete(id[i],type[i]));}
				
				
			
				PromotionPanel pp=new PromotionPanel(father);
				father.setRightComponent(pp);
				if(service.Show()!=null)
					pp.RefreshProTable(service.Show());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				
			}
		});
		//
		this.setTitle("删除确认");
		this.setBounds((screenWidth - dlgWidth) / 2,
				(screenHeight - dlgHeight) / 2, dlgWidth, dlgHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
}
