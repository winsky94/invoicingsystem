package vo;

import java.util.ArrayList;

public class PaymentVO extends ReceiptVO{
	String ID;
	String supplier;
    String seller;
    String user;
    ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
    double totalMoney;
       
    public PaymentVO(){
   	 this(null,null,null,null,null,0);
    }
    
    public PaymentVO(String a,String b,String c,String d,ArrayList<TransferItem> e,double f){
   	 ID=a;
   	 supplier=b;
   	 seller=c;
   	 user=d;
   	 transferlist=e;
   	 totalMoney=f;
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
