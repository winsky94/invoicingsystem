package vo;

import java.util.ArrayList;

public class CashlistVO extends ReceiptVO{
	 String ID;
     String user;
     String account;
     ArrayList<ClauseItem> clauselist=new ArrayList<ClauseItem>();
     double totalMoney;
     
     public CashlistVO(){
    	 this(null,null,null,null,0);
     }
     
     public CashlistVO(String a,String b,String c,ArrayList<ClauseItem> d,double e){
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
