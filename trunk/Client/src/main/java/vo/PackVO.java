package vo;

import java.util.ArrayList;



public class PackVO {
	private String id;//系统自动生成
	private double totalValue;
	private double packValue;
	private ArrayList<Integer> num;
	private ArrayList<GoodsVO> combine;
	public PackVO(String id, double totalValue, double packValue,
			ArrayList<Integer> num, ArrayList<GoodsVO> combine) {
	
		this.id = id;
		this.totalValue = totalValue;
		this.packValue = packValue;
		this.num = num;
		this.combine = combine;
	}
	public String getId() {
		return id;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public double getPackValue() {
		return packValue;
	}
	public ArrayList<Integer> getNum() {
		return num;
	}
	public ArrayList<GoodsVO> getCombine() {
		return combine;
	}
}
