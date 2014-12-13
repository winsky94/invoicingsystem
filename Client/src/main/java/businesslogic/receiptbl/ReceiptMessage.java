package businesslogic.receiptbl;

import java.rmi.Naming;
import java.util.ArrayList;

import vo.ReceiptMessageVO;
import businesslogicservice.receiptblservice.ReceiptTipService;
import dataservice.receiptdataservice.ReceiptDataService;

public class ReceiptMessage implements ReceiptTipService{
	ReceiptDataService service;
	public ReceiptMessage() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/receiptService";
	
		service=(ReceiptDataService)Naming.lookup(url);
	}
	@Override
	public ArrayList<ReceiptMessageVO> getToApprove() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReceiptMessageVO> getSaleApproved() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<ReceiptMessageVO> getFinanceApproved() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addMessage(ReceiptMessageVO vo) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteessage(ReceiptMessageVO vo) {
		// TODO Auto-generated method stub
		
	}
}
