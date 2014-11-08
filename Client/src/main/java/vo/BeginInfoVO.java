package vo;

import java.util.ArrayList;

public class BeginInfoVO {
	 ArrayList<GoodsVO> goodsList;
	    ArrayList<MemberVO> memberList;
	    ArrayList<AccountVO> accountList;
	    String time;
	    
	    public BeginInfoVO(){
	    	goodsList=null;
	    	memberList=null;
	    	accountList=null;
	    }
	    
	    public BeginInfoVO(ArrayList<GoodsVO> a,ArrayList<MemberVO> b,ArrayList<AccountVO> c){
	    	goodsList=a;
	    	memberList=b;
	    	accountList=c;
	    }
	    
	    public ArrayList<GoodsVO> getGoods(BeginInfoVO vo){
	    	return goodsList;
	    }
	    
	    public ArrayList<MemberVO> getMember(BeginInfoVO vo){
	    	return memberList;
	    }
	    
	    public ArrayList<AccountVO> getAccount(AccountVO vo){
	    	return accountList;
	    }
	    
	    public String getTime(){
	    	return time;
	    }


}
