package po;

import java.io.Serializable;
import java.util.ArrayList;


public class CashlistPO extends ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 String ID;
	 String user;
     String account;
     ArrayList<ClauseItemPO> clauselist=new ArrayList<ClauseItemPO>();
     double totalMoney;
     
     public CashlistPO(){
    	 this(null,null,null,null,0);
     }
     
     public CashlistPO(String a,String b,String c,ArrayList<ClauseItemPO> d,double e){
    	 super(ReceiptType.CASHLIST);
    	 ID=a;
    	 user=b;
    	 account=c;
    	 clauselist=d;
    	 totalMoney=e;
     }
     
     public String getID(){
    	 return ID;
     }
     
     public String getUser(){
    	 return user;
     }
     
     public String getAccount(){
    	 return account;
     }
     
     public ArrayList<ClauseItemPO> getClauselist(){
    	 return clauselist;
     }
     
     public double getTotalMoney(){
    	 return totalMoney;
     }

}
