package Presentation.salesui.manage;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CommodityTableModel extends AbstractTableModel{
	
	
	
	/**
 * 
 */
ArrayList<ArrayList<String>> cmContent=new ArrayList<ArrayList<String>>();
private static final long serialVersionUID = 1L;
	String head[] = { "商品编号","名称", "型号","数量","单价","金额","备注" };
	public int getRowCount() {
		return cmContent.size();
	}
	
	public boolean isCellEditable(int row,int column){
		if(column==3||column==4)
			return true;
		else
			return false;
	}
	public void addRow(ArrayList<String>  s) {
		cmContent.add(s);
	}
 

	public int getColumnCount() {
		return head.length;
	}

	public String getValueAt(int row, int col) {
		return cmContent.get(row).get(col);
	}
	public String getColumnName(int col){
		return head[col];
	}
	
	
	
	public ArrayList<ArrayList<String>> getContent(){
		return cmContent;
	}
	
}

