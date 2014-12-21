package businesslogic.stockbl.stockManage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import po.StockErrorPO;
import dataservice.stockdataservice.controldataservice.StockControlDataService;

public class StockErrorReceipt {
	private String goodName;
	private String size;
	private String date;
	private StockControlDataService service;
	private String host;
	private String url;

	public StockErrorReceipt() {

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

	public StockErrorReceipt(String goodName, String size) {
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
		this.date = getDate();
	}

	public int add() {
		// 生成编号
		String exactID = "KCBJD-" + getDate() + "-";
		String maxID = service.getMaxID();

		if (maxID == null) {
			exactID += "00001";
		} else {
			NumberFormat nf = new DecimalFormat("00000");
			int tp = Integer.parseInt(maxID);
			exactID += nf.format(tp + 1);
		}
		StockErrorPO po = new StockErrorPO(exactID, goodName, size, date);
		return service.addStockError(po);

	}

	private String getDate() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String sysDatetime = fmt.format(rightNow.getTime());

		return sysDatetime;
	}
}
