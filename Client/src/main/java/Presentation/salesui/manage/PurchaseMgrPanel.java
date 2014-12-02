package Presentation.salesui.manage;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;

import businesslogic.receiptbl.ReceiptType;
import businesslogic.userbl.User;
import businesslogicservice.userblservice.UserBLService;
import vo.PurchaseReturnVO;
import vo.PurchaseVO;
import vo.ReceiptVO;
import Presentation.mainui.MainFrame;
import Presentation.salesui.manage.purchase.PurchasePane;
import Presentation.salesui.manage.purchase.PurchaseReturnPane;


public class PurchaseMgrPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyButton purchaseBtn, purchaseReturnBtn, searchBtn,refreshBtn,detailBtn;
	JTable table;
	JTextField searchFld;
	String keyWord;
	MainFrame parent;
	JTable purchaseTbl;
	JScrollPane jsp;
	PurchaseMgrModel pmm;
	ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	public PurchaseMgrPanel(MainFrame frame) {
		parent=frame;
		this.setBackground(Color.WHITE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.BOTH;
		//-----------------------------
		JPanel btnPnl=new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//---------创建进货单--------------
		purchaseBtn = new MyButton("创建进货单", new ImageIcon(
				"img/sales/purchase-blue.png"));
		purchaseBtn.addActionListener(this);
		btnPnl.add(purchaseBtn);
		//--------创建进货退货单-------------
		purchaseReturnBtn = new MyButton("创建进货退货单", new ImageIcon(
				"img/sales/disapproved-blue.png"));
		purchaseReturnBtn.addActionListener(this);
		btnPnl.add(purchaseReturnBtn);
		//---------refresh----------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/sales/refresh-blue.png"));
		refreshBtn.addActionListener(this);
		btnPnl.add(refreshBtn);
		//---------detail------------------
		detailBtn = new MyButton("查看详情", new ImageIcon(
				"img/sales/detail.png"));
		detailBtn.addActionListener(this);
		btnPnl.add(detailBtn);
		//--------搜索-------------------
		searchFld = new JTextField(15);
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		btnPnl.add(searchFld);
		//---------------------------------
		searchBtn = new MyButton(new ImageIcon("img/sales/find-blue.png"));
		searchBtn.addActionListener(new SearchBtnListener());
		btnPnl.add(searchBtn);
		//----------------------------------
		//
		/*
		 * 
		 * 
		 * 这个表格BL来搞一下~注入信息
		 */
		pmm=new PurchaseMgrModel();
		table = new JTable(pmm);
		jsp=new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight =6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}

//	public void RefreshPurchaseTabel(ArrayList<ReceiptVO> VO){
//		ArrayList<ArrayList<String>> c=ctm.getContent();
//		for(ReceiptVO vo:VO){
//			//if(Receipt)
//		}
//		
//	}

	class SearchFldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void removeUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void changedUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

	}

	class SearchBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==purchaseBtn)
			parent.setRightComponent(new PurchasePane(parent));
		else if(e.getSource()==purchaseReturnBtn)
			parent.setRightComponent(new PurchaseReturnPane(parent));;
	}
	class MyButton extends JButton{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		MyButton(String text,Icon icon){
			super(text,icon);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			this.setForeground(new Color(47, 73, 136));
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
		MyButton(Icon icon){
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}
	class PurchaseMgrModel extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"单据编号","日期","状态","类型","供应商","操作员","总额合计"};
		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return c.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		public void addRow(ArrayList<String> v){
			c.add(v);
		}
		public void removeRow(int row){
			c.remove(row);
		}
	}
	//加急置顶显示  显示图标
	//单据编号","日期","状态","类型","供应商","操作员","总额合计
	public void RefreshPurchaseList(ArrayList<ReceiptVO> vo) throws Exception{
		UserBLService user=new User();
		for(int i=0;i<vo.size();i++){
			ReceiptVO v=vo.get(i);
			ArrayList<String> line=new ArrayList<String>();
			line.add(v.getId());
			line.add(v.getDate());
			int s=v.getStatus();
			if(s==0){
				line.add("待审批");
			}else if(s==1)
				line.add("审批不通过");
			else if(s==2)
				line.add("待执行");
			else if(s==3)line.add("执行完毕");
			String name=user.showUser(v.getUser()).getName();
			if(v.getType()==ReceiptType.PURCHASE)
			{
				line.add("进货单");;
			PurchaseVO pv=(PurchaseVO)v;line.add(v.getMemberName());line.add(name);
				line.add(pv.getTotalInAll()+"");
			}else{
				line.add("进货退货单");
				PurchaseReturnVO prv=(PurchaseReturnVO)v;
				line.add(v.getMemberName());line.add(name);
				line.add(prv.getTotalInAll()+"");
			}
			
			c.add(line);
			
			
			
			
				
				
				
			
		}
	}
}
