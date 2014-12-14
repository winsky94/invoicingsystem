package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import vo.ReceiptVO;


//经营历程表

public interface ReceiptListService {
	public ArrayList<ReceiptVO> View();
	public ArrayList<ReceiptVO> getSale();
	public ArrayList<ReceiptVO> AccurateFind(String[] message);
}
