package Presentation.financeui.moneyreceipt;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class CollectionAndPaymentPanel extends JPanel{
	/**
	 * 创建付款单和收款单继承了此类
	 * 此类需要加监听
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JLabel IDLbl, userLbl, totalLbl;
	JTextField accountFld, moneyFld, remarkFld;
	JComboBox<String> supplierBox, sellerBox;
	JScrollPane jsp;
	JTable table;
	TransferListModel tlm;
	ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();
	JButton submitBtn, exitBtn, addBtn, delBtn;
	public CollectionAndPaymentPanel(){
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ---------------------------------
				c.fill = GridBagConstraints.BOTH;
				JPanel mPnl = new JPanel();
				mPnl.setBackground(Color.white);
				c.gridx = 0;
				c.gridy = 2;
				c.gridheight = 6;
				c.gridwidth = GridBagConstraints.REMAINDER;
				c.weightx = 1;
				c.weighty = 1;
				gbl.setConstraints(mPnl, c);
				this.add(mPnl);
				GridBagLayout mgbl = new GridBagLayout();
				GridBagConstraints mc = new GridBagConstraints();
				mPnl.setLayout(mgbl);
				mc.fill = GridBagConstraints.BOTH;
				// --------------------------------
				JPanel left = new JPanel();
				left.setBackground(Color.white);
				mc.gridx = 0;
				mc.gridy = 0;
				mc.gridheight = GridBagConstraints.REMAINDER;
				mc.gridwidth = 3;
				mc.weightx = 0.6;
				mc.weighty = 1;
				mgbl.setConstraints(left, mc);
				mPnl.add(left);
				JPanel right = new JPanel();
				right.setBackground(Color.white);
				mc.gridx = 3;
				mc.gridy = 0;
				mc.gridheight = GridBagConstraints.REMAINDER;
				mc.gridwidth = 2;
				mc.weightx = 0.4;
				mc.weighty = 1;
				mgbl.setConstraints(right, mc);
				mPnl.add(right);
				// ----------left-------------------
				GridBagLayout lgbl = new GridBagLayout();
				GridBagConstraints lc = new GridBagConstraints();
				lc.fill = GridBagConstraints.BOTH;
				left.setLayout(lgbl);
				tlm = new TransferListModel(content);
				table = new JTable(tlm);
				jsp = new JScrollPane(table);
				lc.gridx = 0;
				lc.gridy = 0;
				lc.gridheight = 5;
				lc.gridwidth = GridBagConstraints.REMAINDER;
				lc.weightx = 1;
				lc.weighty = 1;
				lgbl.setConstraints(jsp, lc);
				left.add(jsp);
				// --------itemPnl------------------
				JPanel itemPnl = new JPanel();
				itemPnl.setLayout(new GridLayout(2, 1));
				JPanel item1 = new JPanel();
				item1.setBackground(Color.white);
				itemPnl.add(item1);
				JPanel item2 = new JPanel();
				item2.setBackground(Color.white);
				itemPnl.add(item2);
				itemPnl.setBackground(Color.white);
				lc.gridx = 0;
				lc.gridy = 5;
				lc.gridheight = 1;
				lc.gridwidth = GridBagConstraints.REMAINDER;
				lc.weightx = 1;
				lc.weighty = 0.1;
				lgbl.setConstraints(itemPnl, lc);
				left.add(itemPnl);
				// ---account------
				JLabel accountLbl = new JLabel("银行账户：");
				accountLbl.setFont(font);
				item1.add(accountLbl);
				accountFld = new JTextField(10);
				accountFld.setFont(font);
				item1.add(accountFld);
				// ---money--------
				JLabel moneyLbl = new JLabel("转账金额：");
				moneyLbl.setFont(font);
				item1.add(moneyLbl);
				moneyFld = new JTextField(8);
				moneyFld.setFont(font);
				item1.add(moneyFld);
				// ---remark-------
				JLabel remarkLbl = new JLabel("备注：");
				remarkLbl.setFont(font);
				item2.add(remarkLbl);
				remarkFld = new JTextField(12);
				remarkFld.setFont(font);
				item2.add(remarkFld);
				addBtn = new JButton("加入列表");
				addBtn.setFont(font);
				addBtn.setBackground(new Color(204, 242, 239));
				addBtn.setFocusPainted(false);
				addBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 监听！！！！
					}
				});
				item2.add(addBtn);
				delBtn = new JButton("从表中删除");
				delBtn.setFont(font);
				delBtn.setBackground(new Color(204, 242, 239));
				delBtn.setFocusPainted(false);
				delBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 监听！！！！！！！
					}
				});
				item2.add(delBtn);
				// ----------right--------------------
				right.setLayout(new GridLayout(8, 1));
				// -----------ID---------------------
				JPanel IDPnl = new JPanel();
				IDPnl.setBackground(Color.white);
				IDLbl = new JLabel("ID:嗷嗷嗷嗷嗷");
				IDLbl.setFont(font);
				IDPnl.add(IDLbl);
				right.add(IDPnl);
				// -----------user---------------------
				JPanel userPnl = new JPanel();
				userPnl.setBackground(Color.white);
				userLbl = new JLabel("操作员:嗷嗷嗷嗷");
				userLbl.setFont(font);
				userPnl.add(userLbl);
				right.add(userPnl);
				// ---------supplier-----------------
				JPanel supplierPnl = new JPanel();
				supplierPnl.setBackground(Color.white);
				right.add(supplierPnl);
				JLabel supplierLbl = new JLabel("供应商：");
				supplierLbl.setFont(font);
				supplierPnl.add(supplierLbl);
				String supplierText[] = { "请给我加上监听" };
				supplierBox = new JComboBox<String>(supplierText);
				supplierBox.setFont(font);
				supplierBox.setBackground(Color.white);
				supplierPnl.add(supplierBox);
				// ---------seller-----------------
				JPanel sellerPnl = new JPanel();
				sellerPnl.setBackground(Color.white);
				right.add(sellerPnl);
				JLabel sellerLbl = new JLabel("销售商：");
				sellerLbl.setFont(font);
				sellerPnl.add(sellerLbl);
				String sellerText[] = { "请给我加上监听" };
				sellerBox = new JComboBox<String>(sellerText);
				sellerBox.setFont(font);
				sellerBox.setBackground(Color.white);
				sellerPnl.add(sellerBox);
				//--------总额汇总------------------
				JPanel moneyPnl = new JPanel();
				moneyPnl.setBackground(Color.white);
				totalLbl = new JLabel("总额汇总:嗷嗷嗷嗷");
				totalLbl.setFont(font);
				moneyPnl.add(totalLbl);
				right.add(moneyPnl);
				// -------buttons-----------------
				JPanel btnPnl = new JPanel();
				btnPnl.setBackground(Color.white);
				c.gridx = 0;
				c.gridy = 8;
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
				btnPnl.add(exitBtn);
	}

	class TransferListModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
		String head[] = { "银行账户", "转账金额", "备注" };

		public TransferListModel(ArrayList<ArrayList<String>> content) {
			c = content;
		}

		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return c.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}

		public void addRow(ArrayList<String> v) {

			c.add(v);
		}

		public void removeRow(int row) {
			c.remove(row);
		}

	}
}
