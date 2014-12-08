package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import po.ReceiptPO.ReceiptType;
import Presentation.mainui.MainFrame;
import businesslogic.receiptbl.ReceiptController;
import businesslogic.userbl.User;
import businesslogicservice.receiptblservice.ReceiptBLService;
import businesslogicservice.userblservice.UserViewService;
import vo.CollectionVO;
import vo.PaymentVO;
import vo.ReceiptVO;

public class ReceiptMgrPanel extends JPanel {

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
	ArrayList<ArrayList<String>> c1 = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> c2 = new ArrayList<ArrayList<String>>();

	public ReceiptMgrPanel(JFrame myFather) throws Exception {
		service=new ReceiptController();
		father = (MainFrame)myFather;
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
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		// --------通过-----------------
		approvedBtn = new MyButton("通过", new ImageIcon(
				"img/promotion/approved.png"));
		btnPnl.add(approvedBtn);
		// -------不通过------------------
		disapprovedBtn = new MyButton("不通过", new ImageIcon(
				"img/promotion/disapproved.png"));
		btnPnl.add(disapprovedBtn);
		// -------高级审批-----------------
		modBtn = new MyButton("高级审批", new ImageIcon("img/promotion/detail.png"));
		btnPnl.add(modBtn);
		// -------刷新--------------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/promotion/refresh.png"));
		btnPnl.add(refreshBtn);
		// -------筛选--------------------
		findFld = new JTextField(10);
		btnPnl.add(findFld);
		findBtn = new MyButton(new ImageIcon("img/promotion/find.png"));
		btnPnl.add(findBtn);
		// ------------------------------
		tab = new JTabbedPane();
		tab.setFont(font);
		tab.setBackground(Color.white);
		tab.setForeground(color);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(tab, c);
		this.add(tab);
		// -------待审批-------------------
		rtm1 = new ReceiptTableModel(c1);
		t1 = new JTable(rtm1);
		jsp1 = new JScrollPane(t1);
		tab.add("待审批单据", jsp1);
		//---------已审批------------------
		rtm2=new ReceiptTableModel(c2);
		t2=new JTable(rtm2);
		jsp2=new JScrollPane(t2);
		tab.add("已审批单据",jsp2);
		
	}

	class ReceiptTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "单据编号", "创建日期", "业务类型", "交易客户", "交易金额", "操作员", "备注" };
		ArrayList<ArrayList<String>> cm;

		public ReceiptTableModel(ArrayList<ArrayList<String>> content) {
			cm = content;
		}

		public int getRowCount() {
			return cm.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public void addRow(ArrayList<String> v) {
			cm.add(v);
		}

		public void removeRow(int row) {
			cm.remove(row);
		}

		public String getValueAt(int row, int col) {
			return cm.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
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
	//{ "单据编号", "创建日期", "业务类型", "交易客户", "交易金额", "操作员", "备注" }
	//0待审批  1已审批
	public void RefreshTable(ArrayList<ReceiptVO> vo,int t) throws Exception{
		UserViewService user=new User();
		ArrayList<ArrayList<String>> tab;
		if(t==0){
			tab=c1;
		}else tab=c2;
		for(int i=0;i<vo.size();i++){
			ArrayList<String> line=new ArrayList<String>();
			ReceiptVO v=vo.get(i);
			line.add(v.getId());
			line.add(v.getDate());
			line.add(Total.getType(v.getType()));
			
			//销售/进货
			if(v.getType()==ReceiptType.PAYMENT)
			{
				PaymentVO pv=(PaymentVO)v;
				line.add(pv.getSeller()+"/"+pv.getSupplier());
				
			}else if(v.getType()==ReceiptType.COLLECTION)
			{
				CollectionVO cv=(CollectionVO)v;
				line.add(cv.getSeller()+"/"+cv.getSupplier());
			}
			else line.add(v.getMemberName());
		
			if(v.getType()==ReceiptType.STOCKOVER||v.getType()==ReceiptType.STOCKLOW)
				line.add("");
			else line.add(Total.getTotal(v));
			line.add(user.getName(v.getUser()));
			line.add(v.getInfo());
			tab.add(line);		
			
		}
	}


}
