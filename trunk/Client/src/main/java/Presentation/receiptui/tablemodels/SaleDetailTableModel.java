package Presentation.receiptui.tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class SaleDetailTableModel extends AbstractTableModel{
	/**
	 * 没加监听（方法没有全部实现）
	 */
	private static final long serialVersionUID = 1L;
	String head[]={};

	public int getRowCount() {
		//还没实现
		return 0;
	}

	public int getColumnCount() {
		return head.length;
	}
	public void addRow(ArrayList<String> v) {
		//还没实现
	}

	public void removeRow(int row) {
		//还没实现
	}
	public String getValueAt(int row, int col) {
		//还没实现
		return null;
	}
	public String getColumnName(int col) {
		return head[col];
	}
}
