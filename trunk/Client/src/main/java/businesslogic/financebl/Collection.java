package businesslogic.financebl;

import java.util.ArrayList;
import java.util.Date;

import vo.AccountVO;
import vo.CollectionVO;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;


public class Collection extends Receipt {

	 String ID;
     MockMember supplier;
     MockMember seller;
     String user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     double totalMoney;
     public Collection(){
    	 
     }
	 public Collection(String id,  String memberID,
			String userID,Date date, int hurry, int status,
			String info, double Money) {
		super(id,memberID, userID, ReceiptType.COLLECTION, date, hurry, status, info);
		// TODO Auto-generated constructor stub
		this.totalMoney=Money;
	}


	

    
  /*  public Collection(MockMember b,MockMember c,double m){
   	 this(null,b,c,null,null,m);
    }  */
    
   /* public Collection(String a,MockMember b,MockMember j,String c,ArrayList<TransferItem> d,double e){
   	 ID=a;
   	 supplier=b;
   	 seller=j;
   	 user=c;
   	 transferlist=d;
   	 totalMoney=e;
    }
    */
	public int createCollection() {
	    this.supplier.updateToPay(this.totalMoney);	
	    this.seller.updateToPay(this.totalMoney);
	    System.out.println("Create collection success!");
		return 0;
	}
  
	
	 class TransferItem{
			AccountVO account;
			double money;
			String info;
		  }
 

}
