package Presentation.mainui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;

import vo.CommodityVO;
import vo.GoodsVO;

public class ChooseGoodsFatherPane extends JPanel{
	/**
	 * 
	 */
	int tag=0;
	private static final long serialVersionUID = 1L;
	public ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	public double discount;
	
	public void addContent(ArrayList<ArrayList<String>> toAdd){
		for(int i=0;i<toAdd.size();i++){
			c.add(toAdd.get(i));
		}
		
	}
	public void setDiscount(double d){
		this.discount=d;
	}
	
	 public class CommodityTableModel extends AbstractTableModel{
		
		
		
			/**
		 * 
		 */
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
			
			
			}
	//添加商品   进货销售有GoodsVO构造 (不需要 ！！！！待查看)  退货有CommodityVO构造
		//"商品编号","名称", "型号",数量,单价(默认),"金额",备注 
		//tag=0 销售  或其他  需要售价    tag=1 进货  需要进价 
	 public void RefreshCTable(ArrayList<Object> VO){
			if(VO.get(0) instanceof GoodsVO)
				{for(int i=0;i<VO.size();i++){
					 ArrayList<String> line=new ArrayList<String>();
					GoodsVO vo=(GoodsVO)VO.get(i);
					line.add(vo.getGoodsID());
					line.add(vo.getName());
					line.add(vo.getSize());
					line.add("1");//可改动
					String p;
					if(tag!=1)
						p=Double.toString(vo.getPrice());
					else 
						p=Double.toString(vo.getLastPurchasePrice());
					line.add(p);line.add(p);
					line.add("");
					c.add(line);
				}}else{
					for(int i=0;i<VO.size();i++){
						 ArrayList<String> line=new ArrayList<String>();
						CommodityVO vo=(CommodityVO)VO.get(i);
						line.add(vo.getID());
						line.add(vo.getName());
						line.add(vo.getType());
						line.add(Double.toString(vo.getNum()));
						line.add(Double.toString(vo.getTotal()));
						line.add(vo.getTip());
						c.add(line);
					}
				}
	 }
	 
	 public void setTag(int i){
		 this.tag=i;
	 }
			
}
