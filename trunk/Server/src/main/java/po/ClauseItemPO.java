package po;

public class ClauseItemPO {
	 String name;
	 double money;
	 String info;
	 
	 public ClauseItemPO(){
		 this(null,0,null);
	 }
	 
	 public ClauseItemPO(String a,double b,String c){
		 name=a;
		 money=b;
		 info=c;
	 }
	 
	 public String getName(){
		 return name;
	 }
	 
	 public double getMoney(){
		 return money;
	 }
	 
	 public String getInfo(){
		 return info;
	 }
}
