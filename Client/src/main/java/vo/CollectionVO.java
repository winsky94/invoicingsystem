package vo;

import java.util.ArrayList;

public class CollectionVO extends ReceiptVO{
	 String ID;
     MemberVO supplier;
     MemberVO seller;
     UserVO user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     double totalMoney;
   //  BSLVO vo;
        
     public CollectionVO(){
    	 this(null,null,null,null,null,0);
     }
     
     public CollectionVO(String a,MemberVO b,MemberVO j,UserVO c,ArrayList<TransferItem> d,double e){
    	 ID=a;
    	 supplier=b;
    	 seller=j;
    	 user=c;
    	 transferlist=d;
    	 totalMoney=e;
     }
     
     public String getID(){
    	 return ID;
     }
     
     public MemberVO getSupplier(){
    	 return supplier;
     }
     
     public MemberVO getSeller(){
    	 return seller;
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


