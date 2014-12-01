package businesslogic.stockbl.goods;

//商品表格的model

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import vo.GoodsVO;

public class GoodsModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Vector<Vector<String>> rowData;
	Vector<String> columnNames;
	String result;

	// 做一个构造函数，用于初始化数据表模型
	public GoodsModel(ArrayList<GoodsVO> list) {
		// 中间
		columnNames = new Vector<String>();
		// 设置列名
		columnNames.add("编号");
		columnNames.add("名称");
		columnNames.add("型号");
		columnNames.add("数量");
		columnNames.add("进价");
		columnNames.add("售价");
		columnNames.add("最近进价");
		columnNames.add("最近售价");

		rowData = new Vector<Vector<String>>();
		Vector<String> hang = new Vector<String>();
		for (int i = 0; i < list.size(); i++) {
			GoodsVO vo = list.get(i);
			hang.add(vo.getGoodsID());
			hang.add(vo.getName());
			hang.add(vo.getSize());
			hang.add(String.valueOf(vo.getNumInStock()));
			hang.add(String.valueOf(vo.getPurchasePrice()));
			hang.add(String.valueOf(vo.getPrice()));
			hang.add(String.valueOf(vo.getLastPurchasePrice()));
			hang.add(String.valueOf(vo.getLastPrice()));
		}
		// 加入到rowData
		rowData.add(hang);
	}

	public GoodsModel() {
		// 中间
		columnNames = new Vector<String>();
		// 设置列名
		columnNames.add("编号");
		columnNames.add("名称");
		columnNames.add("型号");
		columnNames.add("数量");
		columnNames.add("进价");
		columnNames.add("售价");
		columnNames.add("最近进价");
		columnNames.add("最近售价");

		rowData = new Vector<Vector<String>>();

		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		GoodsController controller = new GoodsController();
		list = controller.showGoods();

		for (int i = 0; i < list.size(); i++) {
			Vector<String> hang = new Vector<String>();
			GoodsVO vo = list.get(i);
			hang.add(vo.getGoodsID());
			hang.add(vo.getName());
			hang.add(vo.getSize());
			hang.add(String.valueOf(vo.getNumInStock()));
			hang.add(String.valueOf(vo.getPurchasePrice()));
			hang.add(String.valueOf(vo.getPrice()));
			hang.add(String.valueOf(vo.getLastPurchasePrice()));
			hang.add(String.valueOf(vo.getLastPrice()));

			// 加入到rowData
			rowData.add(hang);
		}
	}

	// 得到共有多少行
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.rowData.size();
	}

	// 得到共有多少列
	public int getColumnCount() {
		// TODO 自动生成的方法存根
		return this.columnNames.size();
	}

	// 得到某行某列的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO 自动生成的方法存根
		return ((Vector<String>) this.rowData.get(rowIndex)).get(columnIndex);
	}

	public String getColumnName(int column) {
		// TODO 自动生成的方法存根
		return (String) this.columnNames.get(column);
	}

}
