package po;

import java.io.Serializable;


public class ReceiptPO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String memberID;
	private String memberName;
	private String userID;
	private ReceiptType type;
	private int status;
	private int hurry;
	private String info;

	
	
	public ReceiptPO(String id,String memberID,String membername,String userID, ReceiptType type,String info,int status,int hurry) {

		this.id = id;
		this.memberID = memberID;
		this.memberName=membername;
		this.userID = userID;
		this.type = type;
		
		this.status = status;
		this.hurry = hurry;
		this.info = info;
	}
	

	public ReceiptPO(ReceiptType type) {
		this.type=type;

	}

	public String getId() {
		return id;
	}


	public String getMemberID() {
		return memberID;
	}
	
	public String getMemberName(){
		return memberName;
	}

	public String getUserID() {
		return userID;
	}

	public ReceiptType getType() {
		return type;
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

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setHurry(int hurry) {
		this.hurry = hurry;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getDate(){
		String[] buffer=id.split("-");
		String s=buffer[1];
		return s;
	}


	public enum ReceiptType implements Serializable{
		 SALE,SALERETURN,PURCHASE,PURCHASERETURN,COLLECTION,PAYMENT,CASHLIST,
		   GIFT,STOCKERROR,STOCKOVER,STOCKLOW
	}
}