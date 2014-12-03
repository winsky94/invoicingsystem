package Presentation.salesui.manage.sale;

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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import po.MemberPO.MemberType;
import po.ReceiptPO.ReceiptType;
import vo.MemberVO;
import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.salesui.manage.SaleMgrPanel;
import Presentation.stockui.ChooseGoodsDialog;
import businesslogic.memberbl.Member;
import businesslogic.salesbl.SaleList;
import businesslogic.salesbl.SalesController;
import businesslogicservice.memberblservice.MemberBLService;
import businesslogicservice.salesblservice.SaleListBLService;
import businesslogicservice.salesblservice.SalesBLService;

public class SalePane extends ChooseGoodsFatherPane implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JLabel IDLbl, userLbl, totalOriginLbl,
			totalToPayLbl;
	JComboBox<String> XSSBox;
	JTextField clerkFld, stockFld, discountMoneyFld, remarkFld;
	JScrollPane jsp;
	CommodityTableModel ctm;
	JTable table;
	String[] idtxt;
	JButton submitBtn, couponBtn, addGoodsBtn, delGoodsBtn, exitBtn;
	MainFrame parent;
	SalesBLService service;
	public SalePane(MainFrame frame) throws Exception {
		parent=frame;
		service=new SalesController();
		//parent = frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建销售单");
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
		// ------midPnl-------------
		c.fill = GridBagConstraints.BOTH;
		JPanel midPnl = new JPanel();
		midPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.3;
		gbl.setConstraints(midPnl, c);
		this.add(midPnl);
		midPnl.setLayout(new GridLayout(3, 1));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		midPnl.add(p1);
		midPnl.add(p2);
		midPnl.add(p3);
		
		//--------ID----------------
		String id=service.getNewID(ReceiptType.SALE);
		IDLbl=new JLabel("ID："+id);
		IDLbl.setFont(font);
		p1.add(IDLbl);
		p1.add(new JLabel("      "));
		//--------客户---------------
		JLabel memberLbl=new JLabel("客户：");
		memberLbl.setFont(font);
		p1.add(memberLbl);
		
		MemberBLService mem=new Member();
		ArrayList<MemberVO> mvo=mem.showMembers();
		String boxText[]=new String[mvo.size()+1];
		idtxt=new String[mvo.size()];
		boxText[0]="选择交易客户";int j=0;
		for(int i=0;i<mvo.size();i++)
			if(mvo.get(i).getmType()==MemberType.XSS)
			{boxText[j+1]=mvo.get(i).getName();idtxt[j]=mvo.get(i).getMemberID();j++;}
			
		
		XSSBox=new JComboBox<String>(boxText);
		XSSBox.setFont(font);
		XSSBox.setBackground(Color.white);
		p1.add(XSSBox);
		p1.add(new JLabel("      "));
		//-------业务员---------------
		JLabel clerkLbl=new JLabel("业务员：");
		clerkLbl.setFont(font);
		p1.add(clerkLbl);
		clerkFld=new JTextField(4);
		clerkFld.setFont(font);
		p1.add(clerkFld);
		
		//-------仓库----------------
		JLabel stockLbl=new JLabel("仓库：");
		stockLbl.setFont(font);
		p2.add(stockLbl);
		stockFld=new JTextField(4);
		clerkFld.setFont(font);
		p2.add(stockFld);
		p2.add(new JLabel("      "));
		//------操作员----------------
		userLbl=new JLabel("操作员："+frame.getUser().getName());
		userLbl.setFont(font);
		p2.add(userLbl);
		p2.add(new JLabel("      "));
		//------备注------------------
		JLabel remarkLbl=new JLabel("备注：");
		remarkLbl.setFont(font);
		p2.add(remarkLbl);
		remarkFld=new JTextField(12);
		remarkFld.setFont(font);
		p2.add(remarkFld);
		//------折让-----------------
		JLabel discountLbl=new JLabel("折让：");
		discountLbl.setFont(font);
		p3.add(discountLbl);
		discountMoneyFld=new JTextField(6);
		discountMoneyFld.setFont(font);
		p3.add(discountMoneyFld);
		p3.add(new JLabel("      "));
		//------代金券----------------
		couponBtn=new JButton("已使用代金券监听元");
		couponBtn.setBackground(new Color(206,226,236));
		couponBtn.setFont(font);
		couponBtn.setFocusPainted(false);
		p3.add(couponBtn);
		p3.add(new JLabel("      "));
		//------折前-----------------
		totalOriginLbl=new JLabel("折前总价：嗷嗷嗷嗷");
		totalOriginLbl.setFont(font);
		p3.add(totalOriginLbl);
		p3.add(new JLabel("      "));
		//------折后-----------------
		totalToPayLbl=new JLabel("折后总价：嗷嗷嗷嗷");
		totalToPayLbl.setFont(font);
		p3.add(totalToPayLbl);
		// ------table--------------
		ctm = new CommodityTableModel();
		table = new JTable(ctm);
		jsp = new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 9;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//
		addGoodsBtn = new JButton("添加商品");
		addGoodsBtn.setFont(font);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog addGoodsDlg = new ChooseGoodsDialog(SalePane.this);
			}
		});
		btnPnl.add(addGoodsBtn);
		delGoodsBtn = new JButton("删除商品");
		delGoodsBtn.setFont(font);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delGoodsBtn);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.addActionListener(this);
		btnPnl.add(exitBtn);
		
		
		
		
	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		if(e.getSource()==exitBtn){
			
				SaleListBLService listservice=new SaleList();
			
			SaleMgrPanel sp=new SaleMgrPanel(parent);
			parent.setRightComponent(sp);
			if(listservice.getAllSale()!=null)
				sp.RefreshSaleTable(listservice.getAllSale());
		}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void RefreshTable(ArrayList<ArrayList<String>> s){
		for(int i=0;i<s.size();i++)
		{
			s.get(i).add("");s.get(i).add("");
			this.c.add(s.get(i));
		}
		
	}
	
}
