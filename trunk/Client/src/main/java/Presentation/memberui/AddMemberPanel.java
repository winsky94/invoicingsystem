package Presentation.memberui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import vo.MemberVO;
import Presentation.mainui.MainFrame;
import businesslogic.memberbl.MemAccountInfo;
import businesslogic.memberbl.MemBaseInfo;
import businesslogic.memberbl.MemContactInfo;
import businesslogic.memberbl.Member;
import businesslogicservice.memberblservice.MemberBLService;

//未加输入检测
public class AddMemberPanel extends JPanel {
	/**
	 * !!!!已写监听
	 */

	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MainFrame parent;
	String ID;
	typeListener typel;
	MemberBLService service;
	MemberType mtype;
	JButton submitBtn, cancelBtn;
	JComboBox<String> typeCbox;

	JTextField nameFld, phoneFld, addressFld, postcodeFld, EMailFld,
			defaultClerkFld;
	JLabel title, IDLbl, typeLbl, nameLbl, phoneLbl, addressLbl, postcodeLbl,
			EMailLbl, defaultClerkLbl;
	String nameText, phoneText, addressText, postcodeText, EMailText,
			clerkText;
	AddListener add;
	public AddMemberPanel(MainFrame frame) throws Exception {
		parent = frame;
		service = new Member();
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();

		c.insets = new Insets(10, 60, 10, 60);
		this.setBackground(Color.white);
		// -------------title-----------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		 title = new JLabel("添加客户");
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
		// -----------------------------------
		JPanel mPnl = new JPanel();
		c.fill = GridBagConstraints.BOTH;
		mPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(mPnl, c);
		this.add(mPnl);
		mPnl.setLayout(new GridLayout(1, 2));
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		left.setBackground(Color.white);
		right.setBackground(Color.white);
		mPnl.add(left);
		mPnl.add(right);
		left.setLayout(new GridLayout(6, 1));
		right.setLayout(new GridLayout(6, 1));
		// ---------ID------------------
		JPanel IDPnl = new JPanel();
		IDPnl.setBackground(Color.white);
		IDLbl = new JLabel();
		IDLbl.setFont(font);
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：_____________";
		IDLbl.setText(text);
		IDPnl.add(IDLbl);
		left.add(IDPnl);
		// -------type--------------------
		JPanel typePnl = new JPanel();
		typePnl.setBackground(Color.white);
		left.add(typePnl);
		typeLbl = new JLabel("类型");
		typeLbl.setFont(font);
		typePnl.add(typeLbl);
		String[] type = { "请选择类型", "进货商", "销售商" };
		typeCbox = new JComboBox<String>(type);
		typeCbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		typeCbox.setBackground(Color.white);
		typel=new typeListener();
		typeCbox.addItemListener(typel);
		
		typePnl.add(typeCbox);
		// ------------name-------------
		JPanel namePnl = new JPanel();
		namePnl.setBackground(Color.white);
		left.add(namePnl);
		nameLbl = new JLabel("姓名 ");
		nameLbl.setFont(font);
		namePnl.add(nameLbl);
		nameFld = new JTextField(6);
		nameFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		namePnl.add(nameFld);
		// -----------phone-------------
		JPanel phonePnl = new JPanel();
		phonePnl.setBackground(Color.white);
		phoneLbl = new JLabel("电话 ");
		phoneLbl.setFont(font);
		phonePnl.add(phoneLbl);
		phoneFld = new JTextField(8);
		phoneFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		phonePnl.add(phoneFld);
		left.add(phonePnl);
		// ------------EMail----------
		JPanel eMailPnl = new JPanel();
		eMailPnl.setBackground(Color.white);
		EMailLbl = new JLabel("电子邮箱 ");
		EMailLbl.setFont(font);
		eMailPnl.add(EMailLbl);
		EMailFld = new JTextField(8);
		EMailFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		eMailPnl.add(EMailFld);
		left.add(eMailPnl);
		// ----------address-----------
		JPanel addPnl = new JPanel();
		addPnl.setBackground(Color.white);
		addressLbl = new JLabel("地址 ");
		addressLbl.setFont(font);
		addPnl.add(addressLbl);
		addressFld = new JTextField(10);
		addressFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		addPnl.add(addressFld);
		right.add(addPnl);
		// --------postcode---------
		JPanel pcPnl = new JPanel();
		pcPnl.setBackground(Color.white);
		postcodeLbl = new JLabel("邮编 ");
		postcodeLbl.setFont(font);
		pcPnl.add(postcodeLbl);
		postcodeFld = new JTextField(6);
		postcodeFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		pcPnl.add(postcodeFld);
		right.add(pcPnl);
		// -------defaultClerk----------
		JPanel cPnl = new JPanel();
		cPnl.setBackground(Color.white);
		defaultClerkLbl = new JLabel("默认业务员 ");
		defaultClerkLbl.setFont(font);
		cPnl.add(defaultClerkLbl);
		defaultClerkFld = new JTextField(6);
		defaultClerkFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cPnl.add(defaultClerkFld);
		right.add(cPnl);
		// ----------submitBtn---------------
		JPanel btnPnl=new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy =7;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		submitBtn = new JButton("确  定");
		submitBtn.setFont(font);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.setFocusPainted(false);
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("          "));
		cancelBtn = new JButton("取 消");
		cancelBtn.setFont(font);
		cancelBtn.setFocusPainted(false);
		cancelBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});
		add=new AddListener();
		submitBtn.addActionListener(add);
		
		// ------------------------------------------------------------------

	}
	
	class AddListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (ID == null || ID.equals("")) {
				JOptionPane.showMessageDialog(null, "请选择用户类型，并输入信息！", "提示",
						JOptionPane.CLOSED_OPTION);
			} else {
				MemBaseInfo bInfo = new MemBaseInfo(mtype, MemberLevel.ONE,
						ID, nameFld.getText(), 0, defaultClerkFld.getText());
				MemContactInfo cInfo = new MemContactInfo(phoneFld
						.getText(), addressFld.getText(), postcodeFld
						.getText(), EMailFld.getText());
				MemAccountInfo aInfo = new MemAccountInfo(1000000, 0, 0);

				MemberVO vo = new MemberVO(bInfo, aInfo, cInfo);
				int result = service.addMember(vo);
				// 改
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "添加客户成功！", "提示",
							JOptionPane.CLOSED_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "添加客户失败！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				Update();
			}
		}
		
	}
	
	class typeListener implements ItemListener{

		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			String t = typeCbox.getSelectedItem().toString();
			if (t.equals("进货商"))
				mtype = MemberType.JHS;
			else
				mtype = MemberType.XSS;
			

			ID = service.getNewID(mtype);
			IDLbl.setText("编号：" + ID);
		}
		
	}
	public void Update() {
		MemberMgrPanel mgr = new MemberMgrPanel(parent);
		parent.setRightComponent(mgr);
		if (service.showMembers() != null)
			mgr.RefreshMemberTable(service.showMembers());
	}

}
