package Presentation.financeui.account;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.financebl.Account;
import businesslogic.memberbl.MemAccountInfo;
import businesslogic.memberbl.MemBaseInfo;
import businesslogic.memberbl.MemContactInfo;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService;
import businesslogicservice.memberblservice.MemberBLService;
import po.MemberPO.MemberLevel;
import po.UserPO.UserJob;
import vo.AccountVO;
import vo.MemberVO;
import vo.UserVO;
import Presentation.financeui.AccountPanel;
import Presentation.mainui.MainFrame;
import Presentation.memberui.MemberMgrPanel;

public class AddAccountPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField nameFld;
	JButton submitBtn, exitBtn;
	MainFrame parent;
	FinanceAccountBLService service;
	String name;

	public AddAccountPanel(MainFrame frame) {
		service=new Account();
		parent=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(20, 80, 1, 80);
		this.setBackground(Color.white);
		this.setLayout(gbl);

		// ----------------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("添加账户");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// ------------------------------
		c.insets = new Insets(1, 80, 20, 80);
		c.fill = GridBagConstraints.BOTH;
		JPanel mPnl = new JPanel();
		mPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.8;
		gbl.setConstraints(mPnl, c);
		this.add(mPnl);
		mPnl.setLayout(new GridLayout(3, 1));
		mPnl.add(new JLabel());
		// ------------------------------
		JPanel namePnl = new JPanel();
		namePnl.setBackground(Color.white);
		mPnl.add(namePnl);
		JLabel nameLbl = new JLabel("账户名：      ");
		nameLbl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		namePnl.add(nameLbl);
		nameFld = new JTextField(23);
		nameFld.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		namePnl.add(nameFld);
		mPnl.add(new JLabel());
		// -----------------------------
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 7;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.2;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		// -------------------------------
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.addActionListener(this);
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("          "));
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.addActionListener(this);
		btnPnl.add(exitBtn);
	}

	

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submitBtn){
			name=nameFld.getText();
			if (name == null || name.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入账户名称！", "提示",
						JOptionPane.CLOSED_OPTION);
			} else {
				AccountVO vo = new AccountVO(nameFld.getText(),0);
				int result = service.addAccount(vo);
				// 改
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "添加账户成功！", "提示",
							JOptionPane.CLOSED_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "添加账户失败！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				Update();
			}
			
		}
		else if(e.getSource()==exitBtn){
			Update();
		}
		
	}
	
	public void Update() {
		AccountPanel mgr = new AccountPanel(parent);
		parent.setRightComponent(mgr);
		if (service.showAll()!= null)
			mgr.RefreshAccountTable(service.showAll());
	}
}
