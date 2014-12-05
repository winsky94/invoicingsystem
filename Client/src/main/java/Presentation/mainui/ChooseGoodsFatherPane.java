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
	
	public MainFrame parent;
	private static final long serialVersionUID = 1L;
	
	//商品清单内容
	
	public double discount;
	
	
	
	
	protected ArrayList<ArrayList<String>> cmContent;
	//添加商品   进货销售有GoodsVO构造 (不需要 ！！！！待查看)  退货有CommodityVO构造
		//"商品编号","名称", "型号",数量,单价(默认),"金额",备注 
		//tag=0 销售  或其他  需要售价    tag=1 进货  需要进价 
	 public void RefreshCTable(ArrayList<Object> VO){
			
	 }
	 
	 
			
}
