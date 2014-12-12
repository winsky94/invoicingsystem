package Presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import businesslogic.utilitybl.logbl;
import businesslogicservice.userblservice.LogBLService;
import vo.LogVO;
import Presentation.uihelper.DateChooser;
import Presentation.uihelper.MyDateFormat;

//查看系统日志
public class SystemLogPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame father;
	DateChooser from,to;
	ArrayList<ArrayList<String>> cm=new ArrayList<ArrayList<String>>();
	JTable logTbl;
	JScrollPane jsp;
	LogModel lm;
	String date1,date2;
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
		date1=from.getDate();
		mPnl.add(from);
		
		to=new DateChooser();
		to.setBackground(Color.white);
		to.add(new JLabel("(截止日期)"));
		date2=from.getDate();
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
		c.weightx=1;
		c.weighty=1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		from.showDate.addPropertyChangeListener(new PropertyChangeListener(){

			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if(!from.getDate().equals(date1)){
					try {
						LogBLService logser=new logbl();
						ArrayList<LogVO> vo=logser.find(from.getDate(),date2);
						if(vo!=null)
							RefreshTable(vo);
						else{
							cm.clear();
						}
						date1=from.getDate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		} );
		to.showDate.addPropertyChangeListener(new PropertyChangeListener(){

			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if(!to.getDate().equals(date2)){
					try {
						LogBLService logser=new logbl();
						ArrayList<LogVO> vo=logser.find(date1,to.getDate());
						if(vo!=null)
							RefreshTable(vo);
						else{
							cm.clear();
						}
						date2=to.getDate();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		} );
	}
	class LogModel extends AbstractTableModel{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	String head[]={"日期","工号","用户名","操作","业绩点增量"};

	public int getRowCount() {
		return cm.size();
	}

	public int getColumnCount() {
		return head.length;
	}

	public Object getValueAt(int row, int col) {
		return cm.get(row).get(col);
	}
	public String getColumnName(int col){
		return head[col];
	}
	}
	public void RefreshTable(ArrayList<LogVO>  log){
		for(int i=0;i<log.size();i++){
			LogVO vo=log.get(i);
			ArrayList<String> line=new ArrayList<String>();
			line.add(MyDateFormat.FomatDate(vo.getDate()));
			line.add(vo.getUserID());
			line.add(vo.getUserName());
			line.add(vo.getInfo());
			line.add("+"+vo.getAddGrades());
			cm.add(line);
		}
	}
}
