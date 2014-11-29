package businesslogic.promotionbl;

import java.util.ArrayList;

import businesslogic.stockbl.goods.Goods;

public class pack {
	private String id;//系统自动生成
	private double totalValue;
	private double packValue;
	private ArrayList<Integer> num;
	private ArrayList<Goods> combine;
	public pack(String id){
		this.id=id;
		this.totalValue=0;
		this.packValue=0;
		combine=new ArrayList<Goods>();
		num=new ArrayList<Integer>();
	}
	
	
	public void AddPackItem(Goods good,int n){
	if(combine.indexOf(good)<0)
		{combine.add(good);
		num.add(n);
		this.totalValue+=n*good.getPrice();}
	else ModifyPackItem(good,n);
	}
	
	public void ModifyPackItem(Goods good,int n){
		int i=combine.indexOf(good);
		int numb=num.get(i);
		num.set(i, n);
		this.totalValue+=(n-numb)*good.getPrice();
	}
	
	public void DeletePackItem(Goods good){
		int i=combine.indexOf(good);
		combine.remove(i);
		int n=num.get(i);
		num.remove(i);
		this.totalValue-=n*good.getPrice();
	}
	
	
	public ArrayList<Goods>  getPackGoods(){
		return combine;
	}
	
	public ArrayList<Integer> getPackNum(){
		return num;
	}
	public double getTotal(){
		return totalValue;
	}
	public void setPackValue(double value){
		this.packValue=value;
	}
	
	public double getPackValue(){
		return packValue;
	}
	
	
	

}
