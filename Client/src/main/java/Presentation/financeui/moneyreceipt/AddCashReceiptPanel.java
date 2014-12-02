package Presentation.financeui.moneyreceipt;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class AddCashReceiptPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
	JScrollPane jsp;
	JTable table;
	CashReceiptModel crm;
	JButton submitBtn,exitBtn,addBtn,delBtn;
	JTextField nameFld,moneyFld,remarkFld;
	public AddCashReceiptPanel(){
		
	}
	class CashReceiptModel extends AbstractTableModel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"条目名","金额","备注"};
		public int getRowCount() {
			return content.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return content.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		public void addRow(ArrayList<String> v) {

			content.add(v);
		}
		public void removeRow(int row) {
			content.remove(row);
		}
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AddCashReceiptPanel gp = new AddCashReceiptPanel();
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
