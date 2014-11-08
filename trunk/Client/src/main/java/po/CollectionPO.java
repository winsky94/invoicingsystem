package po;

import java.io.Serializable;
import java.util.ArrayList;

import vo.AccountVO;
import vo.BSLVO;
import vo.MemberVO;
import vo.UserVO;

public class CollectionPO extends ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 String ID;
     MemberVO member;
     UserVO user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     double totalMoney;
     BSLVO vo;
        
     public CollectionPO(){
    	 this(null,null,null,null,0);
     }
     
     public CollectionPO(String a,MemberVO b,UserVO c,ArrayList<TransferItem> d,double e){
    	 ID=a;
    	 member=b;
    	 user=c;
    	 transferlist=d;
    	 totalMoney=e;
     }
     
     public String getID(){
    	 return ID;
     }
     
     public MemberVO getMember(){
    	 return member;
     }
     
     public UserVO getUser(){
    	 return user;
     }
     
     public ArrayList<TransferItem> getTransferlist(){
    	 return transferlist;
     }
     
     public double getTotalMoney(){
    	 return totalMoney;
     }
     
     
   class TransferItem{
	AccountVO account;
	double money;
	String info;
  }
}
