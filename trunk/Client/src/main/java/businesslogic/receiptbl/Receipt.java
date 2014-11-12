package businesslogic.receiptbl;



import java.util.ArrayList;
import java.util.Date;

import vo.ReceiptVO;

//关键类 单据的增 改 查
public class Receipt {
	String id;
	String memberName;
	String userID;//用Id还是name,name 重名如何
	ReceiptType type;
	Date createDate;
	int status;//草稿，提交待审批，审批失败/审批待执行；执行完毕
	int hurry;
	String info;
	String stockID;
	
	//属性有哪些
	public Receipt(String id,String memberName,String userID,ReceiptType type,
			Date date,int hurry,int status,String info,String sid){
		this.id=id;
		this.memberName=memberName;
		this.userID=userID;
		this.type=type;
		this.createDate=date;
		this.hurry=hurry;
		this.status=status;
		this.info=info;
		this.stockID=sid;
		
		
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
