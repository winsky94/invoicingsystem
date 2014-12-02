package Presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentation.uihelper.DateChooser;

//查看系统日志
public class SystemLogPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame father;
	DateChooser from,to;
	ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	JTable logTbl;
	JScrollPane jsp;
	LogModel lm;
	public SystemLogPanel(JFrame myFather){
		father=myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("查看系统日志");
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
		//--------------------------------
		c.fill=GridBagConstraints.BOTH;
		JPanel mPnl=new JPanel();
		mPnl.setBackground(Color.white);
		mPnl.setLayout(new GridLayout(1,2));
		//--------------------------------
		from=new DateChooser();
		from.setBackground(Color.white);
		from.add(new JLabel("(起始日期)"));
		mPnl.add(from);
		
		to=new DateChooser();
		to.setBackground(Color.white);
		to.add(new JLabel("(截止日期)"));
		mPnl.add(to);
		//---------------------------------
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=2;
		gbl.setConstraints(mPnl, c);
		this.add(mPnl);
		//--------------------------------
		lm=new LogModel();
		logTbl=new JTable(lm);
		jsp=new JScrollPane(logTbl);
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=GridBagConstraints.REMAINDER;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}
	class LogModel extends AbstractTableModel{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	String head[]={"日期","工号","用户名","操作","业绩点增量"};

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
	}
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SystemLogPanel gp = new SystemLogPanel(testFrame);
		gp.setBounds(0, 0,  920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
