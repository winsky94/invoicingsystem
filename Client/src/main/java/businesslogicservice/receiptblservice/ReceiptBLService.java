package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import vo.ReceiptVO;

public interface ReceiptBLService {
	public int Add(ReceiptVO vo);
	public int Modify(String id);
	public int Batch(String[] id,int status);
	public void Send(ReceiptVO vo);
	public void Reply(String userid);
	
	public ReceiptVO View(String id);
	public ArrayList<ReceiptVO> Refresh();
	public int Approve(String id,int status);
	public ArrayList<ReceiptVO> ToApprove();
	public ArrayList<ReceiptVO> Approved();
//	public int Excute(String id);
 }
