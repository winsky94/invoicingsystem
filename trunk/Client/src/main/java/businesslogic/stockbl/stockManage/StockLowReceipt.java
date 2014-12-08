package businesslogic.stockbl.stockManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import po.ReceiptPO.ReceiptType;
import po.StockOverOrLowPO;
import businesslogic.receiptbl.Receipt;
import dataservice.stockdataservice.controldataservice.StockControlDataService;

public class StockLowReceipt extends Receipt {
	private String goodName;
	private String size;
	private int num;
	private int exactNum;
	private int gap;
	private StockControlDataService service;
	private String host;
	private String url;

	public StockLowReceipt() {
		host = "localhost:1099";
		url = "rmi://" + host + "/stockManageService";
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

	public StockLowReceipt(String id, String memberName, String memberID,
			String userID, int hurry, String info, String goodName,
			String size, int num, int exactNum) {
		super(id, memberName, memberID, userID, ReceiptType.STOCKLOW, hurry, 2,
				info);
		host = "localhost:1099";
		url = "rmi://" + host + "/stockManageService";
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
		// 生成编号
		String exactID = "KCBYD-" + getDate() + "-";
		String maxID = service.getMaxID();

		if (maxID == null) {
			exactID += "00001";
		} else {
			NumberFormat nf = new DecimalFormat("00000");
			int tp = Integer.parseInt(maxID);
			exactID += nf.format(tp + 1);
		}
		StockOverOrLowPO po = new StockOverOrLowPO(exactID,
				super.getmemberName(), super.getMemberID(), super.getUserID(),
				ReceiptType.STOCKLOW, 3, super.getHurry(), super.getInfo(),
				goodName, size, num, exactNum);
		return service.addStockOverOrLow(po);
	}

	public String getGoodName() {
		return goodName;
	}

	public String getSize() {
		return size;
	}

	public int getNum() {
		return num;
	}

	public int getExactNum() {
		return exactNum;
	}

	public int getGap() {
		return gap;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setExactNum(int exactNum) {
		this.exactNum = exactNum;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	private String getDate() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String sysDatetime = fmt.format(rightNow.getTime());

		return sysDatetime;
	}
}
