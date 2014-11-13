package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;

public class ReceiptVO {
	private String id;
	private String memberName;
	private String memberID;
	private String user;
	private ReceiptType type;
	private Date createDate;
	private int status;
	private int hurry;
	private String info;
	private String stockid;

	public ReceiptVO(){
		
	}
	
	public ReceiptVO(String id, String memberName, String memberID,
			String user, ReceiptType type, Date createDate, int status,
			int hurry, String info, String stockid) {

		this.id = id;
		this.memberName = memberName;
		this.memberID = memberID;
		this.user = user;
		this.type = type;
		this.createDate = createDate;
		this.status = status;
		this.hurry = hurry;
		this.info = info;
		this.stockid = stockid;
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

	public String getUser() {
		return user;
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

	public String getStockid() {
		return stockid;
	}

}