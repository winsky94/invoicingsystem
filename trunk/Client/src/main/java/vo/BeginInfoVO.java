package vo;

import java.util.ArrayList;

public class BeginInfoVO {
	 ArrayList<GoodsVO> goods;
	    ArrayList<MemberVO> member;
	    ArrayList<AccountVO> account;
	    String time;
	    
	    public BeginInfoVO(){
	    	time=null;
	    	goods=null;
	    	member=null;
	    	account=null;
	    }
	    
	    public BeginInfoVO(String itime,ArrayList<GoodsVO> a,ArrayList<MemberVO> b,ArrayList<AccountVO> c){
            time=itime;
	    	goods=a;
	    	member=b;
	    	account=c;
	    }
	    
	    public ArrayList<GoodsVO> getGoods(){
	    	return goods;
	    }
	    
	    public ArrayList<MemberVO> getMember(){
	    	return member;
	    }
	    
	    public ArrayList<AccountVO> getAccount(){
	    	return account;
	    }
	    
	    public String getTime(){
	    	return time;
	    }


}
