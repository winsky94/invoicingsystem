package businesslogic.receiptbl;

import java.util.ArrayList;

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
	
	public int Approve(String id){
		
		return 0;
	}
	
	//红冲 i=0,仅红冲，i=1并复制
	public ReceiptVO RedExtru(String id,int i){
		
		return null;
	} 
}
