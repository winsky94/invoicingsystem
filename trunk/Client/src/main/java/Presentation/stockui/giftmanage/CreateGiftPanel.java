package Presentation.stockui.giftmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.promotionui.addpromotion.AddBarginPanel;
import Presentation.stockui.ChooseGoodsDialog;

public class CreateGiftPanel extends ChooseGoodsFatherPane implements ActionListener{

	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JScrollPane jsp;
	JTable table;
	// GiftTableModel gtm;
	JComboBox<String> memberBox;
	JButton submitBtn, addBtn, delBtn, exitBtn;
	MainFrame father;

	public CreateGiftPanel(MainFrame myFather) {
		father = myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		cons.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建库存赠送单");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridheight = 2;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.weightx = 1;
		cons.weighty = 0.1;
		gbl.setConstraints(titlePnl, cons);
		this.add(titlePnl);
		// ------------------------------------
		cons.fill=GridBagConstraints.BOTH;
		JPanel memberPnl = new JPanel();
		memberPnl.setBackground(Color.white);
		JLabel memberLbl = new JLabel("客户：");
		memberLbl.setFont(font);
		memberPnl.add(memberLbl);
		String boxText[]={"我要加监听"};
		memberBox=new JComboBox<String>(boxText);
		memberBox.setBackground(Color.white);
		memberBox.setFont(font);
		memberPnl.add(memberBox);
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridheight = 1;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.weightx = 1;
		cons.weighty = 0.1;
		gbl.setConstraints(memberPnl, cons);
		this.add(memberPnl);
		//---------table--------------------------
		table=new JTable();
		jsp=new JScrollPane(table);
		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridheight = 5;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.weightx = 1;
		cons.weighty = 1;
		gbl.setConstraints(jsp, cons);
		this.add(jsp);
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		cons.gridx = 0;
		cons.gridy = 9;
		cons.gridheight = 2;
		cons.gridwidth = GridBagConstraints.REMAINDER;
		cons.weightx = 1;
		cons.weighty = 0.1;
		gbl.setConstraints(btnPnl, cons);
		this.add(btnPnl);
		//
		addBtn = new JButton("添加商品");
		addBtn.setFont(font);
		addBtn.setBackground(Color.white);
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(this);
		btnPnl.add(addBtn);
		delBtn = new JButton("删除商品");
		delBtn.setFont(font);
		delBtn.setBackground(Color.white);
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(this);
		btnPnl.add(delBtn);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.addActionListener(this);
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.addActionListener(this);
		btnPnl.add(exitBtn);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exitBtn){
			father.setRightComponent(new GiftPanel(father));
		}
		
	}

	// class GiftTableModel extends AbstractTableModel {
	//
	// /**
	// *
	// */
	// private static final long serialVersionUID = 1L;
	// String head[] = { "商品编号", "商品名", "型号", "库存数量", "赠送数量" };
	//
	// public int getRowCount() {
	// return c.size();
	// }
	//
	// public int getColumnCount() {
	// return head.length;
	// }
	//
	// public String getValueAt(int row, int col) {
	// return c.get(row).get(col);
	// }
	//
	// public String getColumnName(int col) {
	// return head[col];
	// }
	//
	// public void addRow(ArrayList<String> v) {
	//
	// c.add(v);
	// }
	//
	// public void removeRow(int row) {
	// c.remove(row);
	// }
	//
	// public boolean isCellEditable(int row, int col) {
	// if (col == 4)
	// return true;
	// else
	// return false;
	// }
	//
	// public void setValueAt(String value, int row, int col) {
	// c = value;
	// fireTableCellUpdated(row, col);
	// }
	// }
	
}
