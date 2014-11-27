package Presentation.salesui.manage.sale;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Presentation.uihelper.UIhelper;

public class SaleDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 65 / 100;
	int dialogHeight = screenHeight * 65 / 100;
	Container pnl;
	JLabel IDLbl, XSSLbl, clerkLbl, userLbl, stockLbl, saleItemLbl,
			totalOriginLbl, discountValueLbl, couponValueLbl, totalToPayLbl,
			remarkLbl;
	JComboBox<String> XSSCbox;
	JTextField clerkFld, stockFld, discountMoneyFld;
	JTable saleItemTbl;
	JTextArea remarkArea;
	JButton submitBtn, addCouponBtn, addItemBtn, delItemBtn;

	public SaleDialog() {
		pnl = this.getContentPane();
		pnl.setLayout(null);
		pnl.setBackground(Color.white);
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：XSD-0000001";
		IDLbl.setText(text);
		IDLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(IDLbl);
		// -----------------------JHSLabel供应商------------------------------------
		XSSLbl = new JLabel("供应商 ");
		XSSLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		XSSLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 13 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		pnl.add(XSSLbl);
		// ----------------------XSSCbox-----------------------------------------
		// !!!!!!!!!!!这里应该传入所有销售商的名字+编号！！！
		String[] memberList = { "请选择销售商", "BL写这里", "XSS-0000001 李四" };
		XSSCbox = new JComboBox<String>(memberList);
		XSSCbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		XSSCbox.setBackground(Color.white);
		XSSCbox.setBounds(dialogWidth * 10 / 100, dialogHeight * 13 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(XSSCbox);
		// -------------------stockLbl------------------------------------------
		stockLbl = new JLabel("仓库 ");
		stockLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		stockLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 23 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		pnl.add(stockLbl);
		// ------------------stockFld-----------------------------------------
		stockFld = new JTextField();
		stockFld.setFont(new Font("微软雅黑", Font.BOLD, 14));
		stockFld.setBounds(dialogWidth * 10 / 100, dialogHeight * 23 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(stockFld);
		// -------------------clerkLbl------------------------------------------
		clerkLbl = new JLabel("业务员 ");
		clerkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		clerkLbl.setBounds(dialogWidth * 17 / 100, dialogHeight * 33 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		pnl.add(clerkLbl);
		// ------------------clerkFld-----------------------------------------
		clerkFld = new JTextField();
		clerkFld.setFont(new Font("微软雅黑", Font.BOLD, 14));
		clerkFld.setBounds(dialogWidth * 24 / 100, dialogHeight * 33 / 100,
				dialogWidth * 15 / 100, dialogHeight * 5 / 100);
		pnl.add(clerkFld);
		// -------------------userLbl------------------------------------------
		userLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		String userLblText = "操作员 : 李四";
		userLbl.setText(userLblText);
		userLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		userLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 33 / 100,
				dialogWidth * 40 / 100, dialogHeight * 5 / 100);
		pnl.add(userLbl);
		// -------------------saleItemLbl-------------------------------
		saleItemLbl = new JLabel("进货商品列表 ");
		saleItemLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		saleItemLbl.setBounds(dialogWidth * 40 / 100, dialogHeight * 3 / 100,
				dialogWidth * 10 / 100, dialogHeight * 5 / 100);
		pnl.add(saleItemLbl);

		// -----------------saleItemTbl-----------------------------------
		saleItemTbl = new JTable();
		saleItemTbl.setBounds(dialogWidth * 40 / 100, dialogHeight * 23 / 100,
				dialogWidth * 68 / 100, dialogHeight * 55 / 100);
		saleItemTbl.setBackground(Color.black);
		pnl.add(saleItemTbl);
		// -----------------addItemBtn---------------------------------------
		addItemBtn = new JButton("增加");
		addItemBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		addItemBtn.setBounds(dialogWidth * 42 / 100, dialogHeight * 20 / 100,
				dialogWidth * 8 / 100, dialogHeight * 6 / 100);
		addItemBtn.setFocusPainted(false);
		addItemBtn.addActionListener(new AddItemBtnListener());
		pnl.add(addItemBtn);
		// -----------------addCouponBtn---------------------------------------
		addCouponBtn = new JButton("使用代金券");
		addCouponBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		addCouponBtn.setBounds(dialogWidth * 62 / 100, dialogHeight * 20 / 100,
				dialogWidth * 15 / 100, dialogHeight * 6 / 100);
		addCouponBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addCouponBtn.setFocusPainted(false);
		addCouponBtn.addActionListener(new AddCouponBtnListener());
		pnl.add(addCouponBtn);
		// -----------------delItemBtn---------------------------------------
		delItemBtn = new JButton("删除");
		delItemBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		delItemBtn.setBounds(dialogWidth * 52/ 100, dialogHeight * 20 / 100,
				dialogWidth * 8 / 100, dialogHeight * 6 / 100);
		delItemBtn.setFocusPainted(false);
		delItemBtn.addActionListener(new DelItemBtnListener());
		pnl.add(delItemBtn);
		// -------------------remarkLbl------------------------------------------
		remarkLbl = new JLabel("备注");
		remarkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		remarkLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 43 / 100,
				dialogWidth * 10 / 100, dialogHeight * 5 / 100);
		pnl.add(remarkLbl);
		// -----------------remarkArea---------------------------------------
		remarkArea = new JTextArea();
		remarkArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		remarkArea.setBackground(new Color(238, 238, 238));
		remarkArea.setFont(new Font("楷体", Font.PLAIN, 12));
		remarkArea.setBounds(dialogWidth * 3 / 100, dialogHeight * 50 / 100,
				dialogWidth * 35 / 100, dialogHeight * 28 / 100);
		pnl.add(remarkArea);
		// -----------------submitBtn------------------------------------------
		submitBtn = new JButton("提  交");
		submitBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		submitBtn.setBounds(dialogWidth * 40 / 100, dialogHeight * 85 / 100,
				dialogWidth * 20 / 100, dialogHeight * 6 / 100);
		submitBtn.setFocusPainted(false);
		pnl.add(submitBtn);

		// ------------------------------------------------------------------
		this.setTitle("创建销售单");
		this.setBounds((screenWidth - dialogWidth) / 2,
				(screenHeight - dialogHeight) / 2, dialogWidth, dialogHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setIconImage(UIhelper.getImage("img/sales/purchase-blue.png"));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	class AddItemBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	}

	class DelItemBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class AddCouponBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
