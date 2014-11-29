package Presentation.stockui.goodsmanage;

import java.util.ArrayList;

public class GoodsClassNode {
	String name;
	String id;
	ArrayList<GoodsClassNode> children=new ArrayList<GoodsClassNode>();
	
	public GoodsClassNode(String name,String id){
		this.name=name;
		this.id=id;
	}
}
