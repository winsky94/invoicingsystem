package po;

import java.io.Serializable;
import java.util.ArrayList;

import vo.AccountVO;
import vo.UserVO;

public class CashlistPO extends ReceiptPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 String ID;
     UserVO user;
     AccountVO account;
     ArrayList<ClauseItem> clauselist=new ArrayList<ClauseItem>();
     double totalMoney;
     
     public CashlistPO(){
    	 this(null,null,null,null,0);
     }
     
     public CashlistPO(String a,UserVO b,AccountVO c,ArrayList<ClauseItem> d,double e){
    	 ID=a;
    	 user=b;
    	 account=c;
    	 clauselist=d;
    	 totalMoney=e;
     }
     
     public String getID(){
    	 return ID;
     }
     
     public UserVO getUser(){
    	 return user;
     }
     
     public AccountVO getAccount(){
    	 return account;
     }
     
     public ArrayList<ClauseItem> getClauselist(){
    	 return clauselist;
     }
     
     public double getTotalMoney(){
    	 return totalMoney;
     }
     
     
     class ClauseItem{
    	 String name;
    	 double money;
    	 String info;
     }

}
