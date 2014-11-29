package po;

import java.util.Date;

import Data.receiptdata.ReceiptType;


public class ReceiptPO {
	private String id;
	private String memberName;
	private String memberID;
	private String userID;
	private ReceiptType type;
	private int status;
	private int hurry;
	private String info;
	private String stockid;

	public ReceiptPO(String id, String memberName, String memberID,
			String userID, ReceiptType type,  int status,
			int hurry, String info, String stockid) {

		this.id = id;
		this.memberName = memberName;
		this.memberID = memberID;
		this.userID = userID;
		this.type = type;
		
		this.status = status;
		this.hurry = hurry;
		this.info = info;
		this.stockid = stockid;
	}

	public ReceiptPO() {

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



	public int getStatus() {
		return status;
	}

	public int getHurry() {
		return hurry;
	}

	public String getInfo() {
		return info;
	}

	public String getStockid() {
		return stockid;
	}
}
