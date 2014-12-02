package businesslogic.stockbl.stockManage;


public class StockOverOrLowManage {
	String goodName;
	String size;
	int num;
	int exactNum;
	double gap;

	public StockOverOrLowManage() {

	}

	public StockOverOrLowManage(String goodsName, String size, int num,
			int exactNum) {
		this.goodName = goodsName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = num - exactNum;
	}

	public double getGap() {
		return gap;
	}

	//库存报溢单
	public int addStockOverReceipt(String id, String memberName,
			String memberID, String userID, int hurry, String info) {
		StockOverReceipt receipt = new StockOverReceipt(id, memberName,
				memberID, userID, hurry, info, goodName, size, num,
				exactNum);
		return receipt.add();
	}

	//库存报损单
	public int addStockLowReceipt(String id, String memberName,
			String memberID, String userID, int hurry, String info) {
		StockLowReceipt receipt = new StockLowReceipt(id, memberName,
				memberID, userID, hurry, info, goodName, size, num,
				exactNum);
		return receipt.add();
	}
	
	//库存报警（未实现）===
	public int addStockErrorReceipt(){
		System.out.println("StockOverOrLowManage.addStockErrorReceipt():尚未实现！");
		return 0;
	}

}
