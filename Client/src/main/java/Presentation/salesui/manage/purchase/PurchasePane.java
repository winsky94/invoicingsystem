package Presentation.salesui.manage.purchase;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.mainui.outBorder;
import Presentation.promotionui.addpromotion.AddBarginPanel;
import Presentation.stockui.ChooseGoodsDialog;
import Presentation.uihelper.UIhelper;

public class PurchasePane extends ChooseGoodsFatherPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JLabel IDLbl, userLbl, totalLbl;
	JTextField stockFld, remarkFld;
	JButton submitBtn, exitBtn, addGoodsBtn, delGoodsBtn;
	JScrollPane jsp;
	JTable table;
	CommodityTableModel ctm;
	JComboBox<String> JHSBox;
	MainFrame parent;

	public PurchasePane(MainFrame frame) {
		parent = frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建进货单");
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
		c.fill=GridBagConstraints.BOTH;
		JPanel midPnl=new JPanel();
		midPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.3;
		gbl.setConstraints(midPnl, c);
		this.add(midPnl);
		//--------------------------
		midPnl.setLayout(new GridLayout(3, 1));
		JPanel p1=new JPanel();
		p1.setBackground(Color.white);
		midPnl.add(p1);
		JPanel p2=new JPanel();
		p2.setBackground(Color.white);
		midPnl.add(p2);
		JPanel p3=new JPanel();
		p3.setBackground(Color.white);
		midPnl.add(p3);
		//-------ID-----------------
		IDLbl=new JLabel("编号：JHD-嗷嗷嗷嗷嗷");
		IDLbl.setFont(font);
		p1.add(IDLbl);
		p1.add(new JLabel("     "));
		//------供应商---------------
		JLabel JHSLbl=new JLabel("进货商：");
		JHSLbl.setFont(font);
		p1.add(JHSLbl);
		String boxText[]={"请给我加监听"};
		JHSBox=new JComboBox<String>(boxText);
		JHSBox.setBackground(Color.white);
		JHSBox.setFont(font);
		p1.add(JHSBox);
		p1.add(new JLabel("     "));
		//------操作员----------------
		userLbl=new JLabel("操作员：我没有监听");
		userLbl.setFont(font);
		p1.add(userLbl);
		//-------仓库----------------
		JLabel stockLbl=new JLabel("仓库：");
		stockLbl.setFont(font);
		p2.add(stockLbl);
		stockFld=new JTextField(6);
		stockFld.setFont(font);
		p2.add(stockFld);
		p2.add(new JLabel("     "));
		//-------备注-----------------
		JLabel remarkLbl=new JLabel("备注：");
		remarkLbl.setFont(font);
		p2.add(remarkLbl);
		remarkFld=new JTextField(25);
		remarkFld.setFont(font);
		p2.add(remarkFld);
		//-------table标题-----------
		JLabel tableLbl=new JLabel("进货商品列表       ");
		tableLbl.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		p3.add(tableLbl);
		//-------合计----------------
		totalLbl=new JLabel("总计：加监听呀加监听");
		totalLbl.setFont(font);
		p3.add(totalLbl);
		// ------table--------------
		ctm=new CommodityTableModel();
		table=new JTable(ctm);
		jsp=new JScrollPane(table);
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
				JDialog addGoodsDlg = new ChooseGoodsDialog(PurchasePane.this);
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
		btnPnl.add(exitBtn);
	}

}
