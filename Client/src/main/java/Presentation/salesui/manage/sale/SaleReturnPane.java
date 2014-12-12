package Presentation.salesui.manage.sale;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;
import Presentation.salesui.manage.CommodityTableModel;
import Presentation.salesui.manage.SaleMgrPanel;

public class SaleReturnPane extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainFrame father;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JScrollPane jsp;
	CommodityTableModel cm;
	JTable table;
	JCheckBox hurryBox;
	JTextField remarkFld;
	JButton submitBtn, exitBtn;
	JLabel IDLbl, memberLbl, clerkLbl, userLbl, stockLbl, totalOriginLbl,
			totalProDiscountLbl, totalFinDiscountLbl, totalToPayLbl;

	public SaleReturnPane(MainFrame frame) {
		father = frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建销售退货单");
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
		// -----中间----------------
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
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		midPnl.add(p1);
		midPnl.add(p2);
		midPnl.add(p3);
		// --------ID----------------

		IDLbl = new JLabel("ID：嗷嗷嗷嗷嗷");
		IDLbl.setFont(font);
		p1.add(IDLbl);
		p1.add(new JLabel("      "));
		// --------客户---------------
		JLabel memberLbl = new JLabel("客户：嗷嗷嗷");
		memberLbl.setFont(font);
		p1.add(memberLbl);
		p1.add(new JLabel("      "));
		// -------业务员---------------
		JLabel clerkLbl = new JLabel("业务员：嗷嗷嗷");
		clerkLbl.setFont(font);
		p1.add(clerkLbl);
		p1.add(new JLabel("      "));
		// -------仓库----------------
		JLabel stockLbl = new JLabel("仓库：嗷嗷嗷嗷");
		stockLbl.setFont(font);
		p1.add(stockLbl);
		p1.add(new JLabel("      "));
		// ------操作员----------------
		userLbl = new JLabel("操作员：" + frame.getUser().getName());
		userLbl.setFont(font);
		p1.add(userLbl);
		p1.add(new JLabel("      "));
		// ------备注------------------
		JLabel remarkLbl = new JLabel("备注：");
		remarkLbl.setFont(font);
		p2.add(remarkLbl);
		remarkFld = new JTextField(12);
		remarkFld.setFont(font);
		p2.add(remarkFld);
		// -------加急----------------
		hurryBox = new JCheckBox("加急");
		hurryBox.setFont(font);
		hurryBox.setBackground(Color.white);
		p2.add(hurryBox);
		// ------原初总价（不带任何折扣的单价*数量之和）-----------------
		totalOriginLbl = new JLabel("原初总价：嗷嗷嗷嗷");
		totalOriginLbl.setFont(font);
		p3.add(totalOriginLbl);
		p3.add(new JLabel("      "));
		// ------促销折后总价（商品1单价*促销商品1折扣*商品1数量+商品2单价*促销商品2折扣*商品2数量+……）--
		totalProDiscountLbl = new JLabel("促销折后总价：嗷嗷嗷嗷");
		totalProDiscountLbl.setFont(font);
		p3.add(totalProDiscountLbl);
		p3.add(new JLabel("      "));
		// -----最终折后总价（最终折后总价=促销折后总价*等级折扣-折让）-------
		totalFinDiscountLbl = new JLabel("最终折后总价：嗷嗷嗷嗷");
		totalFinDiscountLbl.setFont(font);
		p3.add(totalFinDiscountLbl);
		p3.add(new JLabel("      "));
		// ------客户应付总价（经过各种打折并且减去代金券）-----------------
		totalToPayLbl = new JLabel("客户应付总价：嗷嗷嗷嗷");
		totalToPayLbl.setFont(font);
		p3.add(totalToPayLbl);
		// ------table--------------
		table = new JTable(cm);
		// table 渲染器，设置文字内容居中显示，设置背景色等
				DefaultTableCellRenderer tcr = new MyTableCellRenderer();
				for (int i = 0; i < table.getColumnCount(); i++) {
					table.getColumn(table.getColumnName(i)).setCellRenderer(
							tcr);
				}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitBtn)
			try {
				father.setRightComponent(new SaleMgrPanel(father));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

}
