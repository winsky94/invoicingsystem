package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import po.ReceiptPO.ReceiptType;
import businesslogic.receiptbl.ReceiptController;
import businesslogicservice.receiptblservice.ReceiptBLService;
import Presentation.financeui.moneyreceipt.ModifyCashlistPanel;
import Presentation.financeui.moneyreceipt.ModifyCollectionPanel;
import Presentation.financeui.moneyreceipt.ModifyPaymentPanel;
import Presentation.mainui.MainFrame;
import Presentation.receiptui.ReceiptMgrPanel.MyButton;
import Presentation.salesui.manage.sale.ModSalePanel;

public  class AdvancedReceiptPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel infoPnl, btnPnl;
	MainFrame father;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	Color color = new Color(115, 46, 126);
	//
	String id;
	MyButton approvedBtn, disapprovedBtn, modBtn;
	JButton exitBtn;
	ReceiptType type;
	JPanel exitPnl;
	public AdvancedReceiptPanel(JPanel info , MainFrame frame ,String id,ReceiptType type) {
		infoPnl = info;
		 father=frame;
		 this.id=id;
		 this.type=type;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------------
		c.fill = GridBagConstraints.HORIZONTAL;
		btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		// --------通过-----------------
		approvedBtn = new MyButton("通过", new ImageIcon(
				"img/promotion/approved.png"));
		btnPnl.add(approvedBtn);
		approvedBtn.addActionListener(this);
		// -------不通过------------------
		disapprovedBtn = new MyButton("不通过", new ImageIcon(
				"img/promotion/disapproved.png"));
		btnPnl.add(disapprovedBtn);
		disapprovedBtn.addActionListener(this);
		// --------修改-------------------
		modBtn = new MyButton("修改", new ImageIcon("img/promotion/modify.png"));
		btnPnl.add(modBtn);
		modBtn.addActionListener(this);
		boolean isAbleMod=type!=ReceiptType.STOCKERROR&&type!=ReceiptType.STOCKLOW&&
				type!=ReceiptType.STOCKOVER&&type!=ReceiptType.GIFT;
		if(!isAbleMod)
			modBtn.setEnabled(false);
		//-------------------------------
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(infoPnl, c);
		this.add(infoPnl);
		//--------exitPnl------------
		exitPnl=new JPanel();
		exitPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 7;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(exitPnl, c);
		this.add(exitPnl);
		exitBtn = new JButton("返回");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitPnl.add(exitBtn);
		exitBtn.addActionListener(this);
	}

	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(font);
			this.setForeground(color);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}

		MyButton(Icon icon) {
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			ReceiptBLService service=new ReceiptController();
			if(e.getSource()==exitBtn){
				update();
			
			}else if(e.getSource()==approvedBtn){
				if(service.Approve(id, 2)!=0)
					JOptionPane.showMessageDialog(null,"审批失败！","提示",JOptionPane.WARNING_MESSAGE);
				else update();
			}else if(e.getSource()==disapprovedBtn){
				if(service.Approve(id, 1)!=0)
					JOptionPane.showMessageDialog(null,"审批失败！","提示",JOptionPane.WARNING_MESSAGE);
				else
					update();
			
			}else if(e.getSource()==modBtn){
				JPanel pane=getModPanel(id,type);
				AdvancedReceiptPanel advance=new AdvancedReceiptPanel(pane,
						father, id,type);
				father.setRightComponent(advance);
				advance.remove(advance.exitPnl);
				
			}
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void update(){
		ReceiptMgrPanel pane;
		try {
			pane = new ReceiptMgrPanel(father);
			father.setRightComponent(pane);
			pane.Refresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	class modOkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JPanel pane=ReceiptMgrPanel.getRightAdvancePanel(id, type);
			father.setRightComponent(new AdvancedReceiptPanel(pane,
					father, id,type));
			
		}
		
	}
	
	
	public JPanel getModPanel(String id,ReceiptType type) throws Exception{
		ActionListener ok=new modOkListener();
		switch(type){
		case SALE:
			ModSalePanel sale=new ModSalePanel(father,id);
			sale.UseToModify(ok);
			return sale;

		case COLLECTION:
			ModifyCollectionPanel collection=new ModifyCollectionPanel(id,father);
		    collection.UseToModify(ok); 
		    return collection;
		case PAYMENT:
			ModifyPaymentPanel payment=new ModifyPaymentPanel(id,father);
			payment.UseToModify(ok);
			return payment;
		case CASHLIST:
			ModifyCashlistPanel cashlist=new ModifyCashlistPanel(id,father);
			cashlist.UseToModify(ok);
			return cashlist;

		}
		
			
		return null;
		
	}

	
}
