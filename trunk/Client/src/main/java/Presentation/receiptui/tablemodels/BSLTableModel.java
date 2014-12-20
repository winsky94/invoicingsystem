package Presentation.receiptui.tablemodels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

//经营情况表
public class BSLTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<String>>  cm=new ArrayList<ArrayList<String>>();
	String[] head={"销售收入", "库存报溢收入", "成本调价收入", "进货收入", "代金券收入",
			"折让金额", "总收入","销售支出", "报损支出", "赠送支出", "总支出" ,"总利润"};
	
	public int getRowCount() {
		return cm.size();
	}

	public int getColumnCount() {
		return head.length;
	}

	public void addRow(ArrayList<String> v) {
		cm.add(v);
	}

	public void removeRow(int row) {
		cm.remove(row);
	}

	public String getValueAt(int row, int col) {
		return cm.get(row).get(col);
	}

	public String getColumnName(int col) {
		return head[col];
	}
	
	public boolean isCellEditable(int rowIndex,int columnIndex){
		return false;
	}
	
	public void RefreshTable(double[] data){
		cm.clear();
		ArrayList<String> st=new ArrayList<String>();
		for(int i=0;i<data.length;i++){
			st.add(String.valueOf(data[i]));
		}
		cm.add(st);
	}
	
	public void initial(){
		
	
	
		
	}
	
	public ArrayList<ArrayList<String>> getExportContent(){
		
		return cm;
	}
}
