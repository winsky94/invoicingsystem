package Presentation.salesui.manage;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import vo.CommodityVO;
import vo.GoodsVO;
//名称（从商品选择界面进行选择），型号，数量（手动输入），单价（默认为商品信息中的进价），金额，备注（手动输入）
public class CommodityTableModel extends AbstractTableModel{
	
	 ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	
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
		//添加商品   进货销售有GoodsVO构造   退货有CommodityVO构造
		//"商品编号","名称", "型号",数量,单价(默认),"金额",备注 
		//tag=0 销售   tag=1 进货
		public void RefreshCTable(ArrayList<Object> VO,int tag){
			if(VO.get(0) instanceof GoodsVO)
				{for(int i=0;i<VO.size();i++){
					 ArrayList<String> line=new ArrayList<String>();
					GoodsVO vo=(GoodsVO)VO.get(i);
					line.add(vo.getGoodsID());
					line.add(vo.getName());
					line.add(vo.getSize());
					line.add("1");//可改动
					if(tag==0)
						line.add(Double.toString(vo.getPrice()));
					else 
						line.add(Double.toString(vo.getLastPurchasePrice()));
					c.add(line);
				}}else{
					for(int i=0;i<VO.size();i++){
						 ArrayList<String> line=new ArrayList<String>();
						CommodityVO vo=(CommodityVO)VO.get(i);
						line.add(vo.getID());
						line.add(vo.getN)
					}
				}
		}
		
		
		
	
	
}
