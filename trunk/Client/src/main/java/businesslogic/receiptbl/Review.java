package businesslogic.receiptbl;

import java.util.ArrayList;

import businesslogic.financebl.MockAccount;
import businesslogic.financebl.MockCashList;
import vo.ReceiptVO;
//Reply 和Send 使用观察者模式，Reply之后单据类自己做善后处理
public class Review {
	
	
public ArrayList<ReceiptVO> View(){
		
		return null;
	}
	public ReceiptVO View(String id){
		
		return null;
	}
	//
	
	public ArrayList<ReceiptVO> Refresh(){
		return null;
	}
	//**传参数呢 还是id呢
	public int Approve(Receipt receipt,int i){
		receipt.setStatus(i);
		receipt.Reply(receipt.getUserID());
		return 0;
		
		
	
	}
	
	//红冲 i=0,仅红冲，i=1并复制
	public ReceiptVO RedExtru(Receipt receipt,int i){
		MockCashList cash=(MockCashList)receipt;
		MockAccount ac=(MockAccount)cash.getAccout();
		ac.updateBalance(-cash.getTotal());
		
		
		return null;
	} 
}
