package po;

import java.io.Serializable;
import java.util.ArrayList;


public class PaymentPO extends ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String supplier;
    String seller;
    ArrayList<TransferItemPO> transferlist=new ArrayList<TransferItemPO>();
    double totalMoney;
       

    
    public PaymentPO(String id,String b,String f,String user,ArrayList<TransferItemPO> d,double e,int istatus,int ihurry){
   	 super(id,ReceiptType.PAYMENT,user,istatus,ihurry);
   	 supplier=b;
   	 seller=f;
   	 transferlist=d;
   	 totalMoney=e;
    }
  
    
   
    public String getSupplier(){
    	return supplier;
    }
    
    public String getSeller(){
    	return seller;
    }
    

    
    public ArrayList<TransferItemPO> getTransferlist(){
   	 return transferlist;
    }
    
    public double getTotalMoney(){
   	 return totalMoney;
    }
    
    public void setTransferlist(ArrayList<TransferItemPO> po){
   	 transferlist=po;
    }
 
}
