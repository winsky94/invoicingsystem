package Presentation.financeui.initial;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import po.MemberPO.MemberType;
import vo.MemberVO;
import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;

public class MemberInitialPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MemberModel mm;
	ArrayList<ArrayList<String>> memberC = new ArrayList<ArrayList<String>>();
	JTable memberTable;
	JScrollPane jsp;
	JButton addBtn,delBtn;
	JComboBox<String> memberBox;
	AddInitialPanel subparent; 
	MainFrame parent;
	public MemberInitialPanel(MainFrame frame){
		parent=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		c.fill=GridBagConstraints.BOTH;
		//--------表格-------------
		mm=new MemberModel();
		memberTable=new JTable(mm);
		// table 渲染器，设置文字内容居中显示，设置背景色等
				DefaultTableCellRenderer tcr = new MyTableCellRenderer();
				for (int i = 0; i < memberTable.getColumnCount(); i++) {
					memberTable.getColumn(memberTable.getColumnName(i)).setCellRenderer(
							tcr);
				}
		jsp=new JScrollPane(memberTable);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		//------客户增删处-----------
		JPanel btnPnl=new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		
		//小小黄加监听 id调用哪个本pane的getNewID
		String memberBoxText[]={"选择客户"};
		memberBox=new JComboBox<String>(memberBoxText);
		memberBox.setBackground(Color.white);
		memberBox.setFont(font);
		btnPnl.add(memberBox);
		//
		//
		addBtn = new JButton("添加客户");
		addBtn.setFont(font);
		addBtn.setBackground(new Color(204, 242, 239));
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setRightComponent(new addMemberInitial(parent,MemberInitialPanel.this));
			}
		});
		btnPnl.add(addBtn);
		delBtn = new JButton("删除选中");
		delBtn.setFont(font);
		delBtn.setBackground(new Color(204, 242, 239));
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delBtn);
	}
	class MemberModel extends AbstractTableModel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"客户编号","客户名","分类","电话","应收","应付"};
		public int getRowCount() {
			return memberC.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return memberC.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}
		public void addRow(ArrayList<String> v) {
			memberC.add(v);
		}

		public void removeRow(int row) {
			memberC.remove(row);
		}
		
	}
	public void RefreshTable(MemberVO vo){
		ArrayList<String> line=new ArrayList<String>();
		line.add(vo.getMemberID());
		line.add(vo.getName());
		if(vo.getmType()==MemberType.JHS)
			line.add("进货商");
		else line.add("销售商");
		line.add(vo.getTel());
		line.add(vo.getToReceive()+"");
		line.add(vo.getToPay()+"");
		memberC.add(line);
		
	
	}
	
	public String getNewID(MemberType type){
		String cop="销售商";
		if(type==MemberType.JHS)
			cop="进货商";
			
		for(int i=memberC.size()-1;i>=0;i--){
			String mtype=memberC.get(i).get(2);
			if(mtype.equals(cop))
			{ double d=Double.parseDouble(memberC.get(i).get(0).substring(4))+1;
			NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(7); 
		     nf.setGroupingUsed(false);
		     return type.toString()+"-"+nf.format(d);
		     }
			
		}
		return type.toString()+"-0000001";
		
	}
	public void setParent(AddInitialPanel pane){
		this.subparent=pane;
	}
}

