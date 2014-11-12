package po;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;


public class ReceiptPO {
	private String id;
	private MemberPO member;
	private UserPO user;
	private ReceiptType type;
	private Date createDate;
	private int status;
	private int hurry;
	private String info;
	private String stockid;
	public ReceiptPO(String id, MemberPO member, UserPO user, ReceiptType type,
			Date createDate, int status, int hurry,String info, String stockid) {
	
		this.id = id;
		this.member = member;
		this.user = user;
		this.type = type;
		this.createDate = createDate;
		this.status = status;
		this.hurry=hurry;
		this.info = info;
		this.stockid = stockid;
	}
}
