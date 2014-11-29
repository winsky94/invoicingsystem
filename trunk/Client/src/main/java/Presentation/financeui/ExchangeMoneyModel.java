package Presentation.financeui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
public class ExchangeMoneyModel extends AbstractTableModel{
	Vector<String> columnNames=new Vector<String>();
	Vector<String[]> rowData=new Vector<String[]>();
	 	 
	public ExchangeMoneyModel(){
		int i;
		String[] buffer;
		columnNames.add("银行账户");
		columnNames.add("转账金额");
		columnNames.add("备注");
		
//	    buffer=new String[]{"审批通过","SKD-20140826-00001","张三","02","Lucy","点击查看","15000"};
//		rowData.add(buffer);
		}		
	
	
	
//	得到共有多少列
	public int getColumnCount() {
		 int length=columnNames.size();
		return length;
	}
//得到共有多少行
	public int getRowCount() {
		//rowData=new Vector<String[]>();
		
		int length=rowData.size();
		return length;
	}
//得到某行某列的数据
	public String getValueAt(int rowIndex, int columnIndex) {
		String[] buffer=rowData.get(rowIndex);
		String it=buffer[columnIndex];
		return it;
	}
//得到某列的名字	
	public String getColumnName(int columnIndex){
		
		String columnName=columnNames.get(columnIndex);
		return columnName;
	}
	
	
	/**
	 * 让表格中每个值都可修改，但需要setValueAt(Object value, int row, int col)方法配合才能是修改生效
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex){
	
	   return false;
	}

	/**
	 * 使修改的内容生效
	 */
	public void setValueAt(String value, int row, int col){
	    String[] buffer=rowData.get(row);
		buffer[col]=value;
		
	    this.fireTableCellUpdated(row, col);
	}
	
//清除表格里所有的数据		
	public void clearAll(){
		rowData=new Vector<String[]>();
	}
}
