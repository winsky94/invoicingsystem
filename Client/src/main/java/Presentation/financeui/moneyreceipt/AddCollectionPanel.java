package Presentation.financeui.moneyreceipt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import po.MemberPO.MemberType;
import businesslogic.financebl.CashList;
import businesslogic.financebl.Collection;
import businesslogic.financebl.Payment;
import businesslogic.memberbl.Member;
import businesslogicservice.financeblservice.listblservice.CashlistBLService;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;
import businesslogicservice.financeblservice.listblservice.PaymentBLService;
import businesslogicservice.memberblservice.MemberBLService;
import vo.CollectionVO;
import vo.LogVO;
import vo.MemberVO;
import Presentation.financeui.CollectionPanel;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;

public class AddCollectionPanel extends CollectionAndPaymentPanel implements ActionListener{
	/**
	 * 创建收款单
	 * 加了监听
	 */
	private static final long serialVersionUID = 1L;
    CollectionBLService service;
	
	public AddCollectionPanel(MainFrame frame) {
		super(frame);
		
		try {
			service=new Collection();
			ID=service.getNewID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建收款单");
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
			
			MemberBLService mem = null;
			try {
				mem = new Member();

			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (NotBoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ArrayList<MemberVO> member1 = mem.show(MemberType.JHS);
			ArrayList<MemberVO> member2 = mem.show(MemberType.XSS);
			String memberID;
			int se=memBox.getSelectedIndex();
			if(member1!=null&&se<member1.size()){
				memberID=member1.get(se).getMemberID();
			}
			else if(member1==null||(member2!=null&&se>=member1.size())){
				memberID=member2.get(se-member1.size()).getMemberID();
			}
			else{
				memberID="Error";
				JOptionPane.showMessageDialog(null, "Error！", "提示",
						JOptionPane.WARNING_MESSAGE);
			}
			CollectionVO vo=new CollectionVO(ID,memberID,(String)memBox.getSelectedItem(),parent.getUser().getID(),tra,totalMoney,0,isHurry);

			try {
				service = new Collection();
				int result=service.createCollection(vo);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "创建收款单成功！", "提示",
							JOptionPane.CLOSED_OPTION);
					log.addLog(new LogVO(log.getdate(),parent.getUser().getID(),parent.getUser().getName(),
							"创建了一笔收款单",5));
					headPane.RefreshGrades();
				} else {
					JOptionPane.showMessageDialog(null, "创建收款单失败！", "提示",
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
			service=new Collection();
			PaymentBLService pp=new Payment();
			CashlistBLService cc=new CashList();
			if (service.getCollection()!= null)
				mgr.RefreshCollectionTable(service.getCollection());
			if(pp.getPayment()!=null)
				mgr.RefreshPaymentTable(pp.getPayment());
			if(cc.getCashlist()!=null)
				mgr.RefreshCashlistTable(cc.getCashlist());
			
			mgr.setSelectedTab(0);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
