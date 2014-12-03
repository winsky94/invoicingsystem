package businesslogic.stockbl.stockManage;

//库存报溢单model

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.StockOverOrLowVO;
import businesslogicservice.stockblservice.controlblservice.StockControlBLService;

public class OverModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ArrayList<ArrayList<String>> rowData;
	String columnNames[] = { "编号", "名称", "型号", "差额", "创建者", "创建日期" };// 列名
	String result;

	// 做一个构造函数，用于初始化数据表模型
	public OverModel(ArrayList<StockOverOrLowVO> list) {
		rowData = new ArrayList<ArrayList<String>>();

		if (list.size() != 0) {
			ArrayList<String> hang = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				StockOverOrLowVO vo = list.get(i);
				hang.add(vo.getId());
				hang.add(vo.getGoodsName());
				hang.add(vo.getSize());
				hang.add(String.valueOf(vo.getGap()));
				hang.add(vo.getUser());
				hang.add(vo.getDate());
				// 加入到rowData
				rowData.add(hang);
			}

		}
	}

	public OverModel() {
		rowData = new ArrayList<ArrayList<String>>();

		ArrayList<StockOverOrLowVO> list = new ArrayList<StockOverOrLowVO>();
		StockControlBLService controller = new StockControlController();
		list = controller.showStockOverReceipt();

		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> hang = new ArrayList<String>();
			StockOverOrLowVO vo = list.get(i);
			hang.add(vo.getId());
			hang.add(vo.getGoodsName());
			hang.add(vo.getSize());
			hang.add(String.valueOf(vo.getGap()));
			hang.add(vo.getUser());
			hang.add(vo.getDate());

			// 加入到rowData
			rowData.add(hang);
		}
	}

	public void addRow(ArrayList<String> v) {
		rowData.add(v);
	}

	public void removeRow(int row) {
		rowData.remove(row);
	}

	// 得到共有多少行
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.rowData.size();
	}

	// 得到共有多少列
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return columnNames.length;
	}

	// 得到某行某列的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO 自动生成的方法存根
		return ((ArrayList<String>) this.rowData.get(rowIndex))
				.get(columnIndex);
	}

	// 得到列名称
	public String getColumnName(int column) {
		// TODO 自动生成的方法存根
		return columnNames[column];
	}
}
