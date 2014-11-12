package businesslogic.receiptbl;

import java.util.ArrayList;

import vo.ReceiptVO;

//关键类 单据的增 改 查
public class Receipt {
	
	//属性有哪些
	public Receipt(){
		
	}

	//保存 可以再编辑？
	public int Add(ReceiptVO vo){
	
		return 0;
	}
	//修改
	public int Modify(String id){
		
		return 0;
	}
	
	public int Batch(String[] id){
		
		return 0;
	}
	//传送单据
	public void Send(ReceiptVO vo){
		
	
	}
	
	public void Reply(String userID){
		
	}
	//经营历程表
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
}
