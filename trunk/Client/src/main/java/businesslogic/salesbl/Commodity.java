package businesslogic.salesbl;

import po.CommodityPO;
import vo.CommodityVO;

public class Commodity {
	//String id, String name, String type, double price,
	//double last_bid, int num, double total, double cost, String tip)
	public static CommodityVO poToVO(CommodityPO po){
		CommodityVO vo=new CommodityVO(po.getID(),po.getName(),po.getType(),
				po.getPrice(),po.getLast_bid(),po.getNum(),po.getTotal(),po.getCost(),
				po.getTip());
		return vo;
	}
	
	//String id, String name, String type, double price,
//	double last_bid, int num, double total, double cost, String tip)
	public static CommodityPO voToPO(CommodityVO vo){
		CommodityPO po=new CommodityPO(vo.getID(),vo.getName(),vo.getType(),vo.getPrice(),
				vo.getLast_bid(), vo.getNum(),vo.getTotal(),vo.getCost(),vo.getTip());
		return po;
	}

}
