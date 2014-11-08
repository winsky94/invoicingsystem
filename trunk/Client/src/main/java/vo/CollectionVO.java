package vo;

import java.util.ArrayList;

public class CollectionVO extends ReceiptVO{
	 String ID;
     String supplier;
     String seller;
     String user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     double totalMoney;
   //  BSLVO vo;
        
     public CollectionVO(){
    	 this(null,null,null,null,null,0);
     }
     
     public CollectionVO(String a,String b,String j,String c,ArrayList<TransferItem> d,double e){
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
     
     public String getSupplier(){
    	 return supplier;
     }
     
     public String getSeller(){
    	 return seller;
     }
     
     public String getUser(){
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


