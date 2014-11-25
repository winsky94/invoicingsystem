package businesslogic.salesbl;
//部分信息取自用户商品选择商品的goods
public class SaleItem {
	private String id,name,type;
	private double price,last_bid;//售价,最后一次进价,销售成本不显示
	private int num;//数量
	private double total,cost;
	private String tip;
	public SaleItem(String id, String name, String type, double price, double last_bid,int num,
			String tip) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.num = num;
		this.tip = tip;
		this.total=price*num;
		this.cost=price*num;
	}
	
	public void updateData(){
		total=price*num;
		cost=last_bid*num;
	}
		
	public double getTotal(){
		return total;
	}
	public double getCost(){
		return cost;
	}
	
	public void setNum(int num){
		this.num=num;
		updateData();
	}
	public int getNum(){
		return num;
	}
	public void setPrice(double price){
		this.price=price;
		updateData();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
}
