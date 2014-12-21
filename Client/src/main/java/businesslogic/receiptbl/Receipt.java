package businesslogic.receiptbl;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

import dataservice.financedataservice.listdataservice.CashlistDataService;
import dataservice.receiptdataservice.ReceiptDataService;
import vo.ReceiptMessageVO;
import vo.ReceiptVO;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.NumberFormat;

import po.ReceiptPO;
import po.ReceiptPO.ReceiptType;
import businesslogic.utilitybl.getDate;
import businesslogic.utilitybl.getServer;

//关键类 单据的增 改 查
public class Receipt {
	private String id;
	private String memberName;
	private String memberID;
	private String userID;
	private po.ReceiptPO.ReceiptType type;
	private Date createDate;
	private int status;
	private int hurry;
	private String info;

	ReceiptDataService service;

	public Receipt()throws Exception{
		 //   	System.setSecurityManager(new SecurityManager());
		 		String host=getServer.getServer();
		 		String url="rmi://"+host+"/receiptService";
		 		
		 		service=(ReceiptDataService)Naming.lookup(url);
		     }
	
	// 属性有哪些

	public Receipt(String id,String memberID,String memberName,
			String userID, po.ReceiptPO.ReceiptType type, int hurry, int status,
			String info) {
		this.id = id;
		this.memberName = memberName;
		this.memberID = memberID;
		this.userID = userID;
		this.type = type;
		this.hurry = hurry;
		this.status = status;
		this.info = info;
		
	}
	
	public int setStatus(String id,int st){
		return service.setStatus(id, st);
	}


	// 保存 可以再编辑？
	public int Add(ReceiptVO vo) {

		return 0;
	}

	// 修改
	public int Modify(String id) {

		return 0;
	}

	public void Send(String id) {
		ReceiptMessage message;
		try {
			message = new ReceiptMessage();
			message.addMessage(new ReceiptMessageVO(0,getDate.getAllDate()+"新单据"+id+"待审批！"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Reply(String id,ReceiptType type,int i){
		int tag=1;
		boolean isFinance=type==ReceiptType.CASHLIST||type==ReceiptType.COLLECTION
				||type==ReceiptType.PAYMENT;
		boolean isStock=type==ReceiptType.GIFT||
				type==ReceiptType.STOCKLOW||type==ReceiptType.STOCKOVER;
		if(isFinance)
			tag=2;
		else if(isStock) tag=3;
		String mess="审批通过！";
		if(i!=0)
			mess="审批不通过！";
		ReceiptMessage message;
		try {
			message = new ReceiptMessage();
			message.addMessage(new ReceiptMessageVO(tag,getDate.getAllDate()+"单据"+id+mess));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 

	// 经营历程表
	public ArrayList<ReceiptVO> View() {

		return null;
	}

	public ReceiptVO View(String id) {

		return null;
	}

	public int excute(ReceiptVO vo) {
		this.status = 5;
		return 0;
	}

	//

	public ArrayList<ReceiptVO> Refresh() {
		return null;
	}

	public String getId() {
		return id;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getUserID() {
		return userID;
	}

	public po.ReceiptPO.ReceiptType getType() {
		return type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getStatus() {
		String result = "";
		if (this.status == 0)
			result = "待审批";
		else if (this.status == 1)
			result = "审批不通过";
		else if (this.status == 2)
			result = "审批通过";
		else if(this.status==3)
			result="执行完毕";
		return result;
	}

	public void setStatus(int i) {
		this.status = i;
	}

	public int getHurry() {
		return hurry;
	}

	public String getInfo() {
		return info;
	}
	
	public ReceiptPO getRedReceipt(ReceiptPO po){
		return null;
	}

	// 11-27 yan
	

	// 11-30 yan
	public String getmemberName() {
		// TODO 自动生成的方法存根
		return memberName;
	}
}
