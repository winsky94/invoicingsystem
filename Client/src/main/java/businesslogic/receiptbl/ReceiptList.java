package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import vo.ReceiptVO;

public class ReceiptList {
	ReceiptDataService service;
	public ReceiptList() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/receiptService";
	
		service=(ReceiptDataService)Naming.lookup(url);
	}
	
	
	public ArrayList<ReceiptPO> showAllReceipt(){
		
			return service.showAll();
		
	}

	
	
	
	
}
