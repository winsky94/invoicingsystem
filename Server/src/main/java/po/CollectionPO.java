package po;

import java.io.Serializable;
import java.util.ArrayList;
import po.ReceiptPO;

public class CollectionPO extends ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     String supplier;
     String seller;
     ArrayList<TransferItemPO> transferlist=new ArrayList<TransferItemPO>();
     double totalMoney;
     BSLPO vo;
        
     
     public CollectionPO(String id,String su,String se,String user,ArrayList<TransferItemPO> d,double e,int istatus,int ihurry){
    	 super(id,ReceiptType.COLLECTION,user,istatus,ihurry);
    	 supplier=su;
    	 seller=se;
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
     
     
  
}
