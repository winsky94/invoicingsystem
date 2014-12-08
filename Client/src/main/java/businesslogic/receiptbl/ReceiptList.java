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

	
	public ArrayList<ReceiptPO>  showApproved(){
		ArrayList<ReceiptPO> po=showAllReceipt();
		ArrayList<ReceiptPO> approved=new ArrayList<ReceiptPO>();
		for(int i=0;i<po.size();i++){
			ReceiptPO p=po.get(i);
			if(p.getStatus()!=0)
				approved.add(p);
			
		}
		return approved;
	}
	
	public ArrayList<ReceiptPO> showToApprove(){
		ArrayList<ReceiptPO> po=showAllReceipt();
		ArrayList<ReceiptPO> toApprove=new ArrayList<ReceiptPO>();
		for(int i=0;i<po.size();i++){
			ReceiptPO p=po.get(i);
			if(p.getStatus()==0)
				toApprove.add(p);
			
		}
		return toApprove;
	}
	
	
	
	
}
