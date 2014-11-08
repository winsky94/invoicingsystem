package businesslogic.financebl;

import java.util.ArrayList;

import vo.AccountVO;
import vo.CollectionVO;
import businesslogic.memberbl.MockMember;
import businesslogic.receiptbl.Receipt;


public class Collection extends Receipt {
	 String ID;
     MockMember supplier;
     MockMember seller;
     String user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     double totalMoney;
	
    public Collection(){
    	 this(null,null,null,null,null,0);
     }
    
    public Collection(MockMember b,MockMember c,double m){
   	 this(null,b,c,null,null,m);
    }  
    
    public Collection(String a,MockMember b,MockMember j,String c,ArrayList<TransferItem> d,double e){
   	 ID=a;
   	 supplier=b;
   	 seller=j;
   	 user=c;
   	 transferlist=d;
   	 totalMoney=e;
    }
    
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
