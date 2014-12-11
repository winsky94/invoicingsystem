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
	private po.ReceiptPO.ReceiptType type;
	private Date createDate;
	private int status;
	private int hurry;
	private String info;


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

	public Receipt() {

	}

	// 保存 可以再编辑？
	public int Add(ReceiptVO vo) {

		return 0;
	}

	// 修改
	public int Modify(String id) {

		return 0;
	}

	public void Reply(String userID) {

	}

	// 经营历程表
	public ArrayList<ReceiptVO> View() {

		return null;
	}

	public ReceiptVO View(String id) {

		return null;
	}

	public void excute(ReceiptVO vo) {
		this.status = 5;
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
		if (this.status == 3)
			result = "审批不通过";
		else if (this.status == 4)
			result = "审批通过待执行";
		else if (this.status == 5)
			result = "执行完毕";
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

	// 11-27 yan
	

	// 11-30 yan
	public String getmemberName() {
		// TODO 自动生成的方法存根
		return memberName;
	}
}
