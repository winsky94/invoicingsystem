package Presentation.salesui.manage.purchase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Presentation.uihelper.UIhelper;

public class PurchaseDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 65 / 100;
	int dialogHeight = screenHeight * 65 / 100;
	Container pnl;
	JLabel IDLbl, JHSLbl, stockLbl, userLbl, purchaseItemLbl, remarkLbl,
			totalLbl;
	JTextField stockFld;
	JButton submitBtn, addItemBtn, delItemBtn;
	JTextArea remarkArea;
	JTable purchaseItemTbl;
	JComboBox<String> JHSCbox;

	public PurchaseDialog() {
		pnl = this.getContentPane();
		pnl.setLayout(null);
		pnl.setBackground(Color.white);
		// ---------------下面添加各个组件----------------------------------------
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：JHD-0000001";
		IDLbl.setText(text);
		IDLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(IDLbl);
		// -----------------------JHSLabel供应商------------------------------------
		JHSLbl = new JLabel("供应商 ");
		JHSLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		JHSLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 13 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		pnl.add(JHSLbl);
		// ----------------------JHSCbox-----------------------------------------
		// !!!!!!!!!!!这里应该传入所有进货商的名字+编号！！！
		String[] memberList = { "请选择供应商", "BL写这里", "JHS-0000001 李四" };
		JHSCbox = new JComboBox<String>(memberList);
		JHSCbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		JHSCbox.setBackground(Color.white);
		JHSCbox.setBounds(dialogWidth * 10 / 100, dialogHeight * 13 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(JHSCbox);
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
		// -------------------userLbl------------------------------------------
		userLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		String userLblText = "操作员 : 李四";
		userLbl.setText(userLblText);
		userLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		userLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 33 / 100,
				dialogWidth * 40 / 100, dialogHeight * 5 / 100);
		pnl.add(userLbl);
		// -------------------purchaseItemLbl-------------------------------
		purchaseItemLbl = new JLabel("进货商品列表 ");
		purchaseItemLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		purchaseItemLbl.setBounds(dialogWidth * 40 / 100,
				dialogHeight * 13 / 100, dialogWidth * 10 / 100,
				dialogHeight * 5 / 100);
		pnl.add(purchaseItemLbl);
		// -------------------purchaseItemLbl-------------------------------
		totalLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		String totalString = "总计 : 2000000元";
		totalLbl.setText(totalString);
		totalLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		totalLbl.setBounds(dialogWidth * 60 / 100, dialogHeight * 13 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		pnl.add(totalLbl);
		// -----------------purchaseItemTbl-----------------------------------
		purchaseItemTbl = new JTable();
		purchaseItemTbl.setBounds(dialogWidth * 40 / 100,
				dialogHeight * 23 / 100, dialogWidth * 48 / 100,
				dialogHeight * 55 / 100);
		purchaseItemTbl.setBackground(Color.black);
		pnl.add(purchaseItemTbl);
		// -----------------addItemBtn---------------------------------------
		addItemBtn = new JButton("增加");
		addItemBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		addItemBtn.setBounds(dialogWidth * 89 / 100, dialogHeight * 33 / 100,
				dialogWidth * 8 / 100, dialogHeight * 6 / 100);
		addItemBtn.setFocusPainted(false);
		addItemBtn.addActionListener(new AddItemBtnListener());
		pnl.add(addItemBtn);
		// -----------------delItemBtn---------------------------------------
		delItemBtn = new JButton("删除");
		delItemBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		delItemBtn.setBounds(dialogWidth * 89 / 100, dialogHeight * 53 / 100,
				dialogWidth * 8 / 100, dialogHeight * 6 / 100);
		delItemBtn.setFocusPainted(false);
		pnl.add(delItemBtn);
		// -------------------remarkLbl------------------------------------------
		remarkLbl = new JLabel("备注");
		remarkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		remarkLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 43 / 100,
				dialogWidth * 10 / 100, dialogHeight * 5 / 100);
		pnl.add(remarkLbl);
		// -----------------remarkArea---------------------------------------
		remarkArea = new JTextArea();
		remarkArea.setBorder(BorderFactory.createLineBorder(Color.gray,1));
		remarkArea.setBackground(new Color(238,238,238));
		remarkArea.setFont(new Font("楷体", Font.PLAIN, 12));
		remarkArea.setBounds(dialogWidth * 3 / 100, dialogHeight * 50 / 100,
				dialogWidth * 35 / 100, dialogHeight * 28 / 100);
		pnl.add(remarkArea);
		//-----------------submitBtn------------------------------------------
		submitBtn=new JButton("提  交");
		submitBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		submitBtn.setBounds(dialogWidth * 40 / 100, dialogHeight * 85 / 100,
				dialogWidth * 20 / 100, dialogHeight * 6/ 100);
		submitBtn.setFocusPainted(false);
		pnl.add(submitBtn);
		// ------------------------------------------------------------------
		this.setTitle("创建进货单");
		this.setBounds((screenWidth - dialogWidth) / 2,
				(screenHeight - dialogHeight) / 2, dialogWidth, dialogHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setIconImage(UIhelper.getImage("img/sales/purchase-blue.png"));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
	class AddItemBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JDialog addItemDlg=new AddPurchaseItemDialog();
		}
		
	}
}
