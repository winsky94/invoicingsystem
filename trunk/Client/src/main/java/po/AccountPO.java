package po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	      String name;
	      double money;
	      
	      public AccountPO(){
	    	  this(null,0);
	      }
	      
	      public AccountPO(String a,double b){
	    	  name=a;
	    	  money=b;
	      }
	      
	      public String getName(){
	    	  return name;
	      }
	      
	      public double getMoney(){
	    	  return money;
	      }
	

}
