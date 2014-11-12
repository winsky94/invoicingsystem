package businesslogic.receiptbl;



import java.util.ArrayList;
import java.util.Date;

import vo.ReceiptVO;

//关键类 单据的增 改 查
public class Receipt {
	private String id;
	private String memberName;
	private String memberID;
	private String userID;
	private ReceiptType type;
	private Date createDate;
	private int status;
	private int hurry;
	private String info;
	private String stockID;
	
	//属性有哪些
	public Receipt(String id,String memberName,String memberID,String userID,ReceiptType type,
			Date date,int hurry,int status,String info,String sid){
		this.id=id;
		this.memberName=memberName;
		this.memberID=memberID;
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

	public String getId() {
		return id;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getUserID() {
		return userID;
	}

	public ReceiptType getType() {
		return type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getStatus() {
		return status;
	}

	public int getHurry() {
		return hurry;
	}

	public String getInfo() {
		return info;
	}

	public String getStockID() {
		return stockID;
	}
}
