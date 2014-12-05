package vo;

import java.util.ArrayList;

import po.BSLPO;
import po.ReceiptPO.ReceiptType;

public class CollectionVO extends ReceiptVO{
	 String supplier;
     String seller;
     ArrayList<TransferItemVO> transferlist=new ArrayList<TransferItemVO>();
     double totalMoney;
     BSLPO vo;
        
     
     public CollectionVO(String id,String su,String se,String user,ArrayList<TransferItemVO> d,double e,int istatus,int ihurry){
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

     public ArrayList<TransferItemVO> getTransferlist(){
    	 return transferlist;
     }
     
     public double getTotalMoney(){
    	 return totalMoney;
     }
     
     
  
}

