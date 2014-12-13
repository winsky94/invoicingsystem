package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import po.ReceiptPO.ReceiptType;
import vo.CollectionVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import Presentation.financeui.moneyreceipt.CashDetailPanel;
import Presentation.financeui.moneyreceipt.CollectionDetailPanel;
import Presentation.financeui.moneyreceipt.PaymentDetailPanel;
import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;
import Presentation.salesui.manage.purchase.PurchaseDetailPanel;
import Presentation.stockui.giftmanage.GiftDetailPanel;
import businesslogic.memberbl.Member;
import businesslogic.receiptbl.ReceiptController;
import businesslogic.userbl.User;
import businesslogicservice.memberblservice.MemberBLService;
import businesslogicservice.receiptblservice.ReceiptBLService;
import businesslogicservice.userblservice.UserViewService;

public class ReceiptMgrPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ReceiptBLService service;
	Color color = new Color(115, 46, 126);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MainFrame father;
	MyButton approvedBtn, disapprovedBtn, modBtn, refreshBtn, findBtn;
	JTextField findFld;
	JTabbedPane tab;
	JScrollPane jsp1, jsp2;
	JTable t1, t2;
	ReceiptTableModel rtm1, rtm2;
	ArrayList<ArrayList<Object>> c1 = new ArrayList<ArrayList<Object>>();
	ArrayList<ArrayList<Object>> c2 = new ArrayList<ArrayList<Object>>();
	// --------------
	String approvePath = "img/promotion/approved.png";
	String disapprovePath = "img/promotion/disapproved.png";
	String detailPath = "img/promotion/detail.png";
	String refreshPath = "img/promotion/refresh.png";
	String findPath = "img/promotion/find.png";

	// --------------
	public ReceiptMgrPanel(MainFrame myFather) throws Exception {
		service = new ReceiptController();
		father = myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		c.fill = GridBagConstraints.BOTH;
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		// --------通过-----------------
		approvedBtn = new MyButton("通过", new ImageIcon(approvePath));
		btnPnl.add(approvedBtn);
		approvedBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[] row = t1.getSelectedRows();
				if (row.length > 0) {
					for (int i = 0; i < row.length; i++) {
						String id = c1.get(row[i]).get(0).toString();
						if (service.Approve(id, 2) != 0)
							JOptionPane.showMessageDialog(null, "审批失败！", "提示",
									JOptionPane.WARNING_MESSAGE);
					}
					Refresh();

				} else
					JOptionPane.showMessageDialog(null, "请选择一条单据审批！", "提示",
							JOptionPane.WARNING_MESSAGE);
			}

		});
		// -------不通过------------------
		disapprovedBtn = new MyButton("不通过", new ImageIcon(disapprovePath));
		btnPnl.add(disapprovedBtn);
		disapprovedBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[] row = t1.getSelectedRows();
				if (row.length > 0) {
					for (int i = 0; i < row.length; i++) {
						String id = c1.get(row[i]).get(0).toString();
						if (service.Approve(id, 1) != 0)
							JOptionPane.showMessageDialog(null, "审批失败！", "提示",
									JOptionPane.WARNING_MESSAGE);
					}
					Refresh();
				} else
					JOptionPane.showMessageDialog(null, "请选择一条单据审批！", "提示",
							JOptionPane.WARNING_MESSAGE);
			}

		});
		// -------高级审批-----------------
		modBtn = new MyButton("高级审批", new ImageIcon(detailPath));
		modBtn.addActionListener(this);
		btnPnl.add(modBtn);
		// -------刷新--------------------
		refreshBtn = new MyButton("刷新", new ImageIcon(refreshPath));
		btnPnl.add(refreshBtn);
		// -------筛选--------------------
		findFld = new JTextField(10);
		btnPnl.add(findFld);
		findBtn = new MyButton(new ImageIcon(findPath));
		btnPnl.add(findBtn);
		// --------提示-------------------
		JPanel tipPnl = new JPanel();
		tipPnl.setBackground(Color.white);
		JLabel tip = new JLabel("提示：选中多项可进行批量审批。");
		tip.setFont(font);
		tip.setForeground(color);
		tipPnl.add(tip);
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(tipPnl, c);
		this.add(tipPnl);
		// ------------------------------
		tab = new JTabbedPane();
		tab.setFont(font);
		tab.setBackground(Color.white);
		tab.setForeground(color);
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 10;
		gbl.setConstraints(tab, c);
		this.add(tab);
		// -------待审批-------------------
		rtm1 = new ReceiptTableModel(c1);
		t1 = new JTable(rtm1);
		t1.getTableHeader().setReorderingAllowed(false);
		// table 渲染器，设置文字内容居中显示，设置背景色等
		// 加急显示的时候，传一个需要改变颜色的行数的Arraylist进去
		// 无参构造函数是不加急显示的
		DefaultTableCellRenderer tcr = new MyTableCellRenderer();
		for (int i = 0; i < t1.getColumnCount()-1; i++) {
			t1.getColumn(t1.getColumnName(i)).setCellRenderer(tcr);
			
		}
		
		jsp1 = new JScrollPane(t1);
//		rtm1.addTableModelListener(new TableModelListener() {
//			
//			@Override
//			public void tableChanged(TableModelEvent e) {
//				t1.repaint();
//				
//			}
//		});
		tab.add("待审批单据", jsp1);
		// ---------已审批------------------
		rtm2 = new ReceiptTableModel(c2);
		t2 = new JTable(rtm2);
		t2.getTableHeader().setReorderingAllowed(false);
		// table 渲染器，设置文字内容居中显示，设置背景色等
		for (int i = 0; i < t2.getColumnCount(); i++) {
			t2.getColumn(t2.getColumnName(i)).setCellRenderer(tcr);
		}
		jsp2 = new JScrollPane(t2);
		tab.add("已审批单据", jsp2);

	}

	class ReceiptTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "单据编号", "创建日期", "业务类型", "交易客户", "交易金额", "操作员", "备注",
				"选择" };
		ArrayList<ArrayList<Object>> cm;

		public ReceiptTableModel(ArrayList<ArrayList<Object>> content) {
			cm = content;
		}

		public int getRowCount() {
			return cm.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public void addRow(ArrayList<Object> v) {
			cm.add(v);
		}

		public void removeRow(int row) {
			cm.remove(row);
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public Object getValueAt(int row, int col) {
			return cm.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if (columnIndex == 7)
				return true;
			else
				return false;
		}

		public void setValueAt(Object value, int row, int col) {
			cm.get(row).set(col, value);
			fireTableCellUpdated(row, col);
		}

		public void mySetValueAt(Object value, int row, int col) {
			cm.get(row).set(col, value);
		}
	}

	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(font);
			this.setForeground(color);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}

		MyButton(Icon icon) {
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}

	public void Refresh() {

		try {
			if (service.ToApprove() != null)
				ReceiptMgrPanel.this.RefreshTable(service.ToApprove(), 0);
			if (service.Approved() != null)
				ReceiptMgrPanel.this.RefreshTable(service.Approved(), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// { "单据编号", "创建日期", "业务类型", "交易客户", "交易金额", "操作员", "备注" }
	// 0待审批 1已审批
	public void RefreshTable(ArrayList<ReceiptVO> vo, int t) throws Exception {
		UserViewService user = new User();
		ArrayList<ArrayList<Object>> tableContent;
		if (t == 0) {
			tableContent = c1;
		} else
			tableContent = c2;
		for (int i = 0; i < vo.size(); i++) {
			ArrayList<Object> line = new ArrayList<Object>();
			ReceiptVO v = vo.get(i);
			line.add(v.getId());
			line.add(v.getDate());
			line.add(Total.getType(v.getType()));

			// 销售/进货
			if (v.getType() == ReceiptType.PAYMENT) {
				PaymentVO pv = (PaymentVO) v;
				MemberBLService m = new Member();
				line.add(m.findById(pv.getSeller()).getName() + "/"
						+ m.findById(pv.getSeller()).getName());

			} else if (v.getType() == ReceiptType.COLLECTION) {
				CollectionVO cv = (CollectionVO) v;
				MemberBLService m = new Member();
				line.add(m.findById(cv.getSeller()).getName() + "/"
						+ m.findById(cv.getSeller()).getName());
			} else
				line.add(v.getMemberName());

			if (v.getType() == ReceiptType.STOCKOVER
					|| v.getType() == ReceiptType.STOCKLOW)
				line.add("");
			else
				line.add(Total.getTotal(v));
			line.add(user.getName(v.getUser()));
			line.add(v.getInfo());
			line.add(new Boolean(false));
			tableContent.add(line);

		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == modBtn) {
			if (t1.getSelectedRow() < 0)
				JOptionPane.showMessageDialog(null, "请选择一条待审批单据进行高级审批！", "提示",
						JOptionPane.WARNING_MESSAGE);
			else {
				int i = t1.getSelectedRow();
				String id = c1.get(i).get(0).toString();
				String type = c1.get(i).get(2).toString();
				ReceiptType rtype = Total.getsType(type);
				try {
					switch (rtype) {
					case PURCHASE:
						PurchaseDetailPanel pane = new PurchaseDetailPanel(
								father, id);
						pane.useToReceipt();
						father.setRightComponent(new AdvancedReceiptPanel(pane,
								father, id));
						break;
					case PAYMENT:
						PaymentDetailPanel paypane = new PaymentDetailPanel(
								father, findChosen(id, c1, 2));
						paypane.useToReceipt();
						father.setRightComponent(new AdvancedReceiptPanel(
								paypane, father, id));
						break;
					case COLLECTION:
						CollectionDetailPanel colpane = new CollectionDetailPanel(
								father, findChosen(id, c1, 1));
						colpane.useToReceipt();
						father.setRightComponent(new AdvancedReceiptPanel(
								colpane, father, id));
						break;
					case CASHLIST:
						CashDetailPanel cpane = new CashDetailPanel(father,
								findChosen(id, c1, 0));
						cpane.useToReceipt();
						father.setRightComponent(new AdvancedReceiptPanel(
								cpane, father, id));
						break;
					case GIFT:
						GiftDetailPanel gift = new GiftDetailPanel(father, id);
						gift.useToReceipt();
						father.setRightComponent(new AdvancedReceiptPanel(gift,
								father, id));
						/*
						 * case PURCHASERETURN: PurchaseReturnDetailPanel
						 * prpane=new
						 * PurchaseReturnDetailPanel(father,findChosen(
						 * id,c1,4)); prpane.useToReceipt();
						 * father.setRightComponent(new AdvancedReceiptPanel(
						 * prpane, father, id));
						 */

					}

				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		}

	}

	// 获取收付款位置 0收款单 1付款单 2现金费用单
	public int findChosen(String id, ArrayList<ArrayList<Object>> table,
			int sign) {
		String type = "现金费用单";
		if (sign == 1)
			type = "收款单";
		else if (sign == 2)
			type = "付款单";

		int count = -1;
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).get(2).equals(type)) {
				count++;
				if (table.get(i).get(0).equals(id))
					break;
			}
		}
		return count;

	}

}
