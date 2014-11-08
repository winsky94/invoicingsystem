package vo;

import java.util.Date;

import businesslogic.receiptbl.ReceiptType;
import vo.MemberVO;
import vo.UserVO;




public class ReceiptVO{
	String id;
	MemberVO member;
	UserVO user;
	ReceiptType type;
	Date createDate;
	int status;
	int hurry;
	String info;
	String stockid;
	public  ReceiptVO(){

	}
	public ReceiptVO(String id, MemberVO member, UserVO user, ReceiptType type,
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
	public String getId() {
		return id;
	}
	public MemberVO getMember() {
		return member;
	}
	public UserVO getUser() {
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