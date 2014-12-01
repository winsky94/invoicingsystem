package Presentation.salesui.manage;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.CommodityVO;
import vo.GoodsVO;
//名称（从商品选择界面进行选择），型号，数量（手动输入），单价（默认为商品信息中的进价），金额，备注（手动输入）
public class CommodityTableModel extends AbstractTableModel{
	
	 ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	 ArrayList<String> line=new ArrayList<String>();
		private static final long serialVersionUID = 1L;
		String head[] = { "商品编号","名称", "型号","数量","单价","金额","备注" };
		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return c.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		//添加商品  注意
		public void RefreshCTable(ArrayList<GoodsVO> vo,int tag){
			for(){
				line.add()
				
			}
		}
		
		public void RefreshCTable(ArrayList<CommodityVO> vo){
			
		}
		
		
		
	
	
}
