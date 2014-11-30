package Presentation.salesui.manage.purchase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Presentation.mainui.MainFrame;
import Presentation.mainui.outBorder;
import Presentation.uihelper.UIhelper;

public class PurchasePane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 65 / 100;
	int dialogHeight = screenHeight * 65 / 100;
	Container pnl;
	JPanel itemPnl;
	JLabel IDLbl, JHSLbl, stockLbl, userLbl, remarkLbl, totalLbl;
	JTextField stockFld;
	JButton submitBtn, addItemBtn, delItemBtn;
	JTextField remarkFld;
	JTable purchaseItemTbl;
	JComboBox<String> JHSCbox;
	MainFrame parent;
	public PurchasePane(MainFrame frame) {
		parent=frame;
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		// ---------------下面添加各个组件----------------------------------------
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：JHD-0000001";
		IDLbl.setText(text);
		IDLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		this.add(IDLbl);
		// -----------------------JHSLabel供应商------------------------------------
		JHSLbl = new JLabel("供应商：");
		JHSLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		JHSLbl.setBounds(dialogWidth * 22 / 100, dialogHeight * 3 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		this.add(JHSLbl);
		// ----------------------JHSCbox-----------------------------------------
		// !!!!!!!!!!!这里应该传入所有进货商的名字+编号！！！
		String[] memberList = { "请选择供应商", "BL写这里", "JHS-0000001 李四" };
		JHSCbox = new JComboBox<String>(memberList);
		JHSCbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		JHSCbox.setBackground(Color.white);
		JHSCbox.setBounds(dialogWidth * 28 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		this.add(JHSCbox);
		// -------------------stockLbl------------------------------------------
		stockLbl = new JLabel("仓库： ");
		stockLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		stockLbl.setBounds(dialogWidth * 63 / 100, dialogHeight * 3 / 100,
				dialogWidth * 7 / 100, dialogHeight * 5 / 100);
		this.add(stockLbl);
		// ------------------stockFld-----------------------------------------
		stockFld = new JTextField();
		stockFld.setFont(new Font("微软雅黑", Font.BOLD, 14));
		stockFld.setBounds(dialogWidth * 68 / 100, dialogHeight * 3 / 100,
				dialogWidth * 15 / 100, dialogHeight * 5 / 100);
		this.add(stockFld);
		// -------------------userLbl------------------------------------------
		userLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		String userLblText = "操作员 : 李四";
		userLbl.setText(userLblText);
		userLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		userLbl.setBounds(dialogWidth * 51 / 100, dialogHeight * 3 / 100,
				dialogWidth * 40 / 100, dialogHeight * 5 / 100);
		this.add(userLbl);
		// ----------------------itemPnl----------------------------------
		itemPnl = new JPanel();
		itemPnl.setLayout(null);
		itemPnl.setBounds(dialogWidth * 5 / 100, dialogHeight * 16 / 100,
				dialogWidth * 90 / 100, dialogHeight * 68 / 100);
		itemPnl.setBackground(Color.white);
		itemPnl.setBorder(BorderFactory.createTitledBorder("进货商品列表"));
		this.add(itemPnl);
		// -------------------totalLbl-------------------------------
		totalLbl = new JLabel();
		// !!!!!!!!!!!BL获取user信息
		String totalString = "总计 : 2000000元";
		totalLbl.setText(totalString);
		totalLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		totalLbl.setBounds(dialogWidth * 72 / 100, dialogHeight * 3 / 100,
				dialogWidth * 20 / 100, dialogHeight * 5 / 100);
		itemPnl.add(totalLbl);
		// -----------------purchaseItemTbl-----------------------------------
		purchaseItemTbl = new JTable();
		purchaseItemTbl.setBounds(dialogWidth * 2 / 100,
				dialogHeight * 10/ 100, dialogWidth * 86/ 100,
				dialogHeight * 55 / 100);
		purchaseItemTbl.setBackground(Color.GRAY);
		itemPnl.add(purchaseItemTbl);
		// -----------------addItemBtn---------------------------------------
		addItemBtn = new JButton("增加");
		addItemBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		addItemBtn.setBounds(dialogWidth * 50 / 100, dialogHeight * 3 / 100,
				dialogWidth * 8 / 100, dialogHeight * 6 / 100);
		addItemBtn.setFocusPainted(false);
		addItemBtn.addActionListener(new AddItemBtnListener());
		itemPnl.add(addItemBtn);
		// -----------------delItemBtn---------------------------------------
		delItemBtn = new JButton("删除");
		delItemBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		delItemBtn.setBounds(dialogWidth * 60 / 100, dialogHeight * 3 / 100,
				dialogWidth * 8 / 100, dialogHeight * 6 / 100);
		delItemBtn.setFocusPainted(false);
		delItemBtn.addActionListener(new DelItemBtnListener());
		itemPnl.add(delItemBtn);
		// -------------------remarkLbl------------------------------------------
		remarkLbl = new JLabel("备注:");
		remarkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		remarkLbl.setBounds(dialogWidth * 3 / 100, dialogHeight * 10 / 100,
				dialogWidth * 10 / 100, dialogHeight * 5 / 100);
		this.add(remarkLbl);
		// -----------------remarkFld---------------------------------------
		remarkFld = new JTextField();
		remarkFld.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		remarkFld.setFont(new Font("楷体", Font.PLAIN, 13));
		remarkFld.setBounds(dialogWidth * 8 / 100, dialogHeight * 10 / 100,
				dialogWidth * 35 / 100, dialogHeight * 6 / 100);
		this.add(remarkFld);
		// -----------------submitBtn------------------------------------------
		submitBtn = new JButton("提  交");
		submitBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		submitBtn.setBounds(dialogWidth * 40 / 100, dialogHeight * 85 / 100,
				dialogWidth * 20 / 100, dialogHeight * 6 / 100);
		submitBtn.setFocusPainted(false);
		this.add(submitBtn);
		// ------------------------------------------------------------------
		this.setBorder(new outBorder("创建进货单"));
		this.setVisible(true);

	}

	class AddItemBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			//JDialog addItemDlg = new AddPurchaseItemDialog();
		}

	}

	class DelItemBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
