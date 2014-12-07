package Presentation.financeui.moneyreceipt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vo.PaymentVO;
import businesslogic.financebl.Payment;
import businesslogicservice.financeblservice.listblservice.PaymentBLService;
import Presentation.financeui.CollectionPanel;
import Presentation.mainui.MainFrame;

public class AddPaymentPanel extends CollectionAndPaymentPanel implements ActionListener{

	/**
	 * 创建收款单
	 * 加了监听
	 */
	private static final long serialVersionUID = 1L;
    PaymentBLService service;
	
	public AddPaymentPanel(MainFrame frame) {
		super(frame);
		
		try {
			service=new Payment();
			ID=service.getNewID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建付款单");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.08;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		
		
		submitBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		ID=service.getNewID();
		IDLbl.setText("ID:"+ID);

	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*		AddCollectionPanel gp = new AddCollectionPanel();
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
*/
	}

	public void actionPerformed(ActionEvent e) {
	  
		if(e.getSource()==submitBtn){
			if(tra.size()==0){
				JOptionPane.showMessageDialog(null, "请输入转账列表", "提示",JOptionPane.WARNING_MESSAGE);
			}
			else{
			int isHurry=0;
			if(hurryBox.isSelected())
				isHurry=1;
			PaymentVO vo=new PaymentVO(ID,(String)supplierBox.getSelectedItem(),(String)sellerBox.getSelectedItem(),parent.getUser().getID(),tra,totalMoney,0,isHurry);

			try {
				service = new Payment();
				int result=service.createPayment(vo);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "创建付款单成功！", "提示",
							JOptionPane.CLOSED_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "创建付款单失败！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				Update();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
		else if(e.getSource()==exitBtn){
			Update();
			
		}
		
	}
	
	public void Update() {
		CollectionPanel mgr = new CollectionPanel(parent);
		parent.setRightComponent(mgr);
		try {
			service=new Payment();
			if (service.getPayment()!= null)
				mgr.RefreshPaymentTable(service.getPayment());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
