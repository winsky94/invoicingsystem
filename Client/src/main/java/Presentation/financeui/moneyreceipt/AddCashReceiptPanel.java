package Presentation.financeui.moneyreceipt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import vo.AccountVO;
import vo.TransferItemVO;
import businesslogic.financebl.Account;
import businesslogic.financebl.CashList;
import businesslogic.financebl.Collection;
import businesslogic.financebl.Payment;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService;
import businesslogicservice.financeblservice.listblservice.CashlistBLService;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;
import businesslogicservice.financeblservice.listblservice.PaymentBLService;
import Presentation.financeui.CollectionPanel;
import Presentation.mainui.MainFrame;

public class AddCashReceiptPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
	JScrollPane jsp;
	JTable table;
	CashReceiptModel crm;
	JComboBox<String> accountBox;
	JLabel IDLbl, userLbl, totalLbl;
	JButton submitBtn, exitBtn, addBtn, delBtn;
	JTextField nameFld, moneyFld, remarkFld;
	MainFrame parent;
	JCheckBox hurryBox;
	CashlistBLService service;
	String ID;
	String user;
	String totalMoney;
	public AddCashReceiptPanel(MainFrame frame) {
		parent=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建现金费用单");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.08;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// ------table---------------------
		c.fill = GridBagConstraints.BOTH;
		crm = new CashReceiptModel();
		table = new JTable(crm);
		jsp = new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.6;
		gbl.setConstraints(jsp, c);
		this.add(jsp);

		// ------infoPnl--------------------
		JPanel infoPnl = new JPanel();
		infoPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.2;
		gbl.setConstraints(infoPnl, c);
		this.add(infoPnl);
		infoPnl.setLayout(new GridLayout(2, 1));
		JPanel up = new JPanel();
		up.setBackground(Color.white);
		infoPnl.add(up);
		JPanel down = new JPanel();
		down.setBackground(Color.white);
		infoPnl.add(down);
		//------加急---------------
		hurryBox=new JCheckBox("加急");
		hurryBox.setFont(font);
		hurryBox.setFocusPainted(false);
		hurryBox.setBackground(Color.white);
		up.add(hurryBox);
		up.add(new JLabel("     "));
		// ------ID----------------
		IDLbl = new JLabel("ID: "+ID);
		IDLbl.setFont(font);
		up.add(IDLbl);
		up.add(new JLabel("     "));
		// ------user---------------
		user=parent.getUser().getName();
		userLbl = new JLabel("操作员: "+user);
		userLbl.setFont(font);
		up.add(userLbl);
		up.add(new JLabel("     "));
		// ------account---------
		JLabel accLbl = new JLabel("账户：");
		accLbl.setFont(font);
		up.add(accLbl);
		//---------------------------
		ArrayList<String> st=new ArrayList<String>();
		FinanceAccountBLService fin=null;
		try {
			fin=new Account();
			
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (NotBoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ArrayList<AccountVO> account=fin.showAll();
		if(account==null){
			String accountText[] = { "当前无账户可选" };
			accountBox = new JComboBox<String>(accountText);
			accountBox.setEditable(false);
		}
		else{
			for(AccountVO vo:account){
			    st.add(vo.getName());
		    }
		    String accountText[] =new String[st.size()]; 
		    for(int i=0;i<st.size();i++){
		    	accountText[i]=st.get(i);
		    }
		    accountBox = new JComboBox<String>(accountText);
		}
		//---------------------------
		accountBox.setFont(font);
		accountBox.setBackground(Color.white);
		up.add(accountBox);
		up.add(new JLabel("     "));
		// -----总额-------------------
		totalLbl = new JLabel("总额: "+totalMoney);
		totalLbl.setFont(font);
		up.add(totalLbl);
		//-------条目清单---------------
		JLabel itemLbl=new JLabel("条目项：");
		itemLbl.setFont(font);
		down.add(itemLbl);
		down.add(new JLabel("      "));
		//-------条目名--------------
		JLabel nameLbl=new JLabel("条目名：");
		nameLbl.setFont(font);
		down.add(nameLbl);
		nameFld=new JTextField(5);
		nameFld.setFont(font);
		down.add(nameFld);
		down.add(new JLabel("      "));
		//-------金额-----------------
		JLabel moneyLbl=new JLabel("金额：");
		moneyLbl.setFont(font);
		down.add(moneyLbl);
		moneyFld=new JTextField(3);
		moneyFld.setFont(font);
		down.add(moneyFld);
		down.add(new JLabel("      "));
		//------备注------------------
		JLabel remarkLbl=new JLabel("备注：");
		remarkLbl.setFont(font);
		down.add(remarkLbl);
		remarkFld=new JTextField(15);
		remarkFld.setFont(font);
		down.add(remarkFld);
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
		addBtn = new JButton("添加条目");
		addBtn.setFont(font);
		addBtn.setBackground(Color.white);
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(addBtn);
		delBtn = new JButton("删除选中");
		delBtn.setFont(font);
		delBtn.setBackground(Color.white);
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delBtn);
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

	class CashReceiptModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "条目名", "金额", "备注" };

		public int getRowCount() {
			return content.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return content.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}

		public void addRow(ArrayList<String> v) {

			content.add(v);
		}

		public void removeRow(int row) {
			content.remove(row);
		}
	}
	
	public void Update() {
		CollectionPanel mgr = new CollectionPanel(parent);
		parent.setRightComponent(mgr);
		try {
			service=new CashList();
			CollectionBLService bb=new Collection();
			PaymentBLService pp=new Payment();
			if (bb.getCollection()!=null)
				mgr.RefreshCollectionTable(bb.getCollection());
			if(service.getCashlist()!= null)
				mgr.RefreshCashlistTable(service.getCashlist());
			if(pp.getPayment()!=null)
			    mgr.RefreshPaymentTable(pp.getPayment());
				
			mgr.setSelectedTab(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) {
			if (moneyFld.getText().equals("")
					|| remarkFld.getText().equals(""))
				JOptionPane.showMessageDialog(null, "请输入信息", "提示",
						JOptionPane.WARNING_MESSAGE);
			else {
				TransferItemVO item;
			try{
				item= new TransferItemVO(
						(String) accountBox.getSelectedItem(), Double
								.parseDouble(moneyFld.getText()),
						remarkFld.getText());
				tra.add(item);
				ArrayList<String> buffer = new ArrayList<String>();
				buffer.add((String) accountBox.getSelectedItem());
				buffer.add(moneyFld.getText());
				buffer.add(remarkFld.getText());
				tlm.addRow(buffer);
				table.revalidate();
				accountBox.setSelectedIndex(0);
				totalMoney += Double.parseDouble(moneyFld.getText());
				totalLbl.setText("总额汇总:" + totalMoney);
				moneyFld.setText("");
				remarkFld.setText("");
			}catch(NumberFormatException e11){
				JOptionPane.showMessageDialog(null, "转账金额输入有误", "提示",
						JOptionPane.WARNING_MESSAGE);
				moneyFld.setText("");
			}
		
	}

}
