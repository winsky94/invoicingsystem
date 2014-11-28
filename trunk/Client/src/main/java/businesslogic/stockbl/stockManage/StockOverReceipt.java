package businesslogic.stockbl.stockManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import po.StockOverOrLowPO;
import dataservice.stockdataservice.controldataservice.StockControlDataService;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;

public class StockOverReceipt extends Receipt {
	private String goodName;
	private String size;
	private int num;
	private int exactNum;
	private int gap;
	private StockControlDataService service;
	private String host;
	private String url;

	public StockOverReceipt() {
		host = "localhost:1099";
		url = "rmi://" + host + "/userService";
		try {
			service = (StockControlDataService) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public StockOverReceipt(String id, String memberID, String userID,
			Date date, int hurry, int status, String info, String sid,
			String goodName, String size, int num, int exactNum) {
		super(id, memberID, userID, ReceiptType.STOCKOVER, date, hurry, status,
				info, sid);
		host = "localhost:1099";
		url = "rmi://" + host + "/userService";
		try {
			service = (StockControlDataService) Naming.lookup(url);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		this.goodName = goodName;
		this.size = size;
		this.num = num;
		this.exactNum = exactNum;
		this.gap = exactNum - num;
	}

	public int add() {
		StockOverOrLowPO po = new StockOverOrLowPO(super.getId(),super.getMemberName(),
				super.getMemberID(), super.getUserID(), super.getCreateDate(),
				super.getStatus(), super.getHurry(), super.getInfo(),
				super.getStockID(), goodName, size, num, exactNum);
	}
}
