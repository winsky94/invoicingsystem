package vo;

import java.util.ArrayList;

public class PaymentVO extends ReceiptVO{
	String ID;
    MemberVO member;
    UserVO user;
    ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
    double totalMoney;
       
    public PaymentVO(){
   	 this(null,null,null,null,0);
    }
    
    public PaymentVO(String a,MemberVO b,UserVO c,ArrayList<TransferItem> d,double e){
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
