package vo;

import java.util.ArrayList;

public class CashlistVO extends ReceiptVO{
	 String ID;
     UserVO user;
     AccountVO account;
     ArrayList<ClauseItem> clauselist=new ArrayList<ClauseItem>();
     double totalMoney;
     
     public CashlistVO(){
    	 this(null,null,null,null,0);
     }
     
     public CashlistVO(String a,UserVO b,AccountVO c,ArrayList<ClauseItem> d,double e){
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
