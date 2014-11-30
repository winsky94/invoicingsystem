package po;

import java.io.Serializable;
import java.util.ArrayList;


public class PaymentPO extends ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ID;
	String supplier;
    String seller;
    String user;
    ArrayList<TransferItemPO> transferlist=new ArrayList<TransferItemPO>();
    double totalMoney;
       
    public PaymentPO(){
   	 this(null,null,null,null,null,0);
    }
    
    public PaymentPO(String a,String b,String f,String c,ArrayList<TransferItemPO> d,double e){
   	 ID=a;
   	 supplier=b;
   	 seller=f;
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
    
    public String getSell(){
    	return seller;
    }
    
    public String getUser(){
   	 return user;
    }
    
    public ArrayList<TransferItemPO> getTransferlist(){
   	 return transferlist;
    }
    
    public double getTotalMoney(){
   	 return totalMoney;
    }
    
 
}
