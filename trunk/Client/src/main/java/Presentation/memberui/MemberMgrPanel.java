package Presentation.memberui;

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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;

import po.MemberPO.MemberType;
import vo.MemberVO;
import Presentation.mainui.MainFrame;

public class MemberMgrPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyButton addBtn, delBtn, modBtn, refreshBtn, searchBtn;
	JTextField searchFld;
	JTable memberTable;
	MemberTableModel utm;
	ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
	JScrollPane jsp;
	String keyWord;
	MainFrame parent;

	public MemberMgrPanel(MainFrame frame) {
		parent = frame;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.BOTH;
		// -----------------------------
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
		//------增-----------------------
		addBtn = new MyButton("添加客户", new ImageIcon(
				"img/sales/addMember-blue.png"));
		addBtn.addActionListener(new AddBtnListener());
		btnPnl.add(addBtn);
		//-----删------------------------
		delBtn = new MyButton("删除客户", new ImageIcon(
				"img/sales/delMember-blue.png"));
		delBtn.addActionListener(new DelBtnListener());
		btnPnl.add(delBtn);
		//-------改----------------------
		modBtn = new MyButton("修改客户",
				new ImageIcon("img/sales/modify-blue.png"));
		modBtn.addActionListener(new ModBtnListener());
		btnPnl.add(modBtn);
		//-------刷新---------------------
		refreshBtn = new MyButton("刷新列表", new ImageIcon(
				"img/sales/refresh-blue.png"));
		refreshBtn.addActionListener(new RefreshBtnListener());
		btnPnl.add(refreshBtn);
		//---------搜索--------------------
		searchFld = new JTextField(10);
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		btnPnl.add(searchFld);
		//--------查找按钮-------------------
		searchBtn = new MyButton(new ImageIcon("img/sales/find-blue.png"));
		searchBtn.addActionListener(new SearchBtnListener());
		btnPnl.add(searchBtn);
		// ======表格

		utm = new MemberTableModel();
		memberTable = new JTable(utm);
		jsp = new JScrollPane(memberTable);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}

	class MemberTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// String head[] = { "商品编号","名称", "型号","数量","单价","金额","备注" };
		String head[] = { "编号", "分类", "级别", "姓名", "电话", "地址", "邮编", "电子邮箱",
				"应收额度", "应收", "应付", "默认业务员" };

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
	}

	public void RefreshMemberTable(ArrayList<MemberVO> vo) {

		for (MemberVO VO : vo) {
			ArrayList<String> lineInfo = new ArrayList<String>();
			lineInfo.add(VO.getMemberID());
			if (VO.getmType() == MemberType.JHS)
				lineInfo.add("进货商");
			else
				lineInfo.add("销售商");
			lineInfo.add(VO.getmLevel().toString());
			lineInfo.add(VO.getName());
			lineInfo.add(VO.getTel());
			lineInfo.add(VO.getAddress());
			lineInfo.add(VO.getPostcode());
			lineInfo.add(VO.getEMail());
			lineInfo.add(Double.toString(VO.getMaxOwe()));
			lineInfo.add(Double.toString(VO.getToReceive()));
			lineInfo.add(Double.toString(VO.getToPay()));
			lineInfo.add(VO.getDefaultClerk());
			c.add(lineInfo);

		}

	}

	class AddBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				parent.setRightComponent(new AddMemberPanel(parent));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	class DelBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// -----应当传入客户编号-----------------------

			int[] i = memberTable.getSelectedRows();
			ArrayList<String> Id = new ArrayList<String>();
			if (i.length > 0) {
				for (int j = 0; j < i.length; j++)
					Id.add((String) memberTable.getValueAt(i[j], 0));

				JDialog delDlg = new DelMemberDialog(Id, parent);
			} else {
				JOptionPane.showMessageDialog(null, "请选择用户", "提示",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	class ModBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// -----应当传入客户信息-----------------------
			int i = memberTable.getSelectedRow();
			if (i >= 0) {
				String id = (String) memberTable.getValueAt(i, 0);

				try {

					parent.setRightComponent(new ModMemberPane(id,parent));

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "请选择用户", "提示",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}

	class RefreshBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

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

	class MyButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			this.setForeground(new Color(47, 73, 136));
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
}
