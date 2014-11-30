package Presentation.userui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//查看系统日志
public class SystemLogPanel {
	JFrame father;
	ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	JTable logTbl;
	JScrollPane jsp;
	LogModel lm;
	public SystemLogPanel(JFrame myFather){
		father=myFather;
		
	}
	class LogModel extends AbstractTableModel{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	String head[]={"日期","工号","用户名","操作","业绩点增量"};

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	}
}
