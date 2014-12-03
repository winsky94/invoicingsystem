package Presentation.financeui.account;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.financebl.Account;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService;
import po.UserPO.UserJob;
import vo.AccountVO;
import vo.UserVO;
import Presentation.financeui.AccountPanel;
import Presentation.mainui.MainFrame;

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
	
	JPanel titlePnl;
	JLabel title;
	JPanel mPnl;
	JPanel namePnl;
	JLabel nameLbl;
	JPanel btnPnl;
    AddListener add;
	public AddAccountPanel(MainFrame frame)  throws Exception{
		service=new Account();
		parent=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(20, 80, 1, 80);
		this.setBackground(Color.white);
		this.setLayout(gbl);

		// ----------------------------
		titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		title = new JLabel("添加账户");
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
		mPnl = new JPanel();
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
		namePnl = new JPanel();
		namePnl.setBackground(Color.white);
		mPnl.add(namePnl);
		nameLbl = new JLabel("账户名：      ");
		nameLbl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		namePnl.add(nameLbl);
		nameFld = new JTextField(23);
		nameFld.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		namePnl.add(nameFld);
		mPnl.add(new JLabel());
		// -----------------------------
		// -------buttons-----------------
		btnPnl = new JPanel();
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
		add=new AddListener();
		submitBtn.addActionListener(add);
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("          "));
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.addActionListener(this);
		btnPnl.add(exitBtn);
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AddAccountPanel gp;
		try {
			gp = new AddAccountPanel(new MainFrame(new UserVO("1","1","1",UserJob.FINANCE,1)));
			gp.setBounds(0, 0, 920, 600);
			testFrame.add(gp);
			testFrame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	class AddListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
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
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==exitBtn){
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