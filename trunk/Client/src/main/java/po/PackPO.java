package po;

import java.util.ArrayList;

public class PackPO {
	private String id;//系统自动生成
	private double totalValue;
	private double packValue;
	private ArrayList<Integer> num;
	private ArrayList<GoodsPO> combine;
	public PackPO(String id, double totalValue, double packValue,
			ArrayList<Integer> num, ArrayList<GoodsPO> combine) {
	
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
	public ArrayList<GoodsPO> getCombine() {
		return combine;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public void setPackValue(double packValue) {
		this.packValue = packValue;
	}
	public void setPack(ArrayList<Integer> num,ArrayList<GoodsPO> combine) {
		this.num = num;
		this.combine = combine;
	}
	
	
	

}