package VO;

public class BeginInfoVO {
    GoodsVO goods;
    MemberVO member;
    AccountVO account;
    String time;
    
    public BeginInfoVO(){
    	goods=null;
    	member=null;
    	account=null;
    }
    
    public BeginInfoVO(GoodsVO a,MemberVO b,AccountVO c){
    	goods=a;
    	member=b;
    	account=c;
    }
    
    public GoodsVO getGoods(BeginInfoVO vo){
    	return goods;
    }
    
    public MemberVO getMember(BeginInfoVO vo){
    	return member;
    }
    
    public AccountVO getAccount(AccountVO vo){
    	return account;
    }

}
