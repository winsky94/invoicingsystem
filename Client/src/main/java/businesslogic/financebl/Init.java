package businesslogic.financebl;

import java.rmi.Naming;
import java.util.ArrayList;

import po.AccountPO;
import po.BeginInfoPO;
import po.GoodsPO;
import po.MemberPO;
import dataservice.financedataservice.initdataservice.FinanceInitDataService;
import vo.AccountVO;
import vo.BeginInfoVO;
import vo.GoodsVO;
import vo.MemberVO;
import businesslogicservice.financeblservice.initblservice.FinanceInitBLService;

public class Init implements FinanceInitBLService{

	FinanceInitDataService service;
	 
	 public Init()throws Exception{
		 //   	System.setSecurityManager(new SecurityManager());
		 		String host="localhost:1099";
		 		String url="rmi://"+host+"/initService";
		 		
		 		service=(FinanceInitDataService)Naming.lookup(url);
		     }
	
	@Override
	public int initInfo(String time, BeginInfoVO vo) {
		BeginInfoPO po=voToPo(vo);
		return service.initInfo(time, po);
	}

	@Override
	public BeginInfoVO getInfo(String time) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public BeginInfoPO voToPo(BeginInfoVO vo){
		if(vo==null)
			return null;
		
		ArrayList<GoodsVO> goods=vo.getGoods();
		ArrayList<GoodsPO> a;
		if(goods==null)
			a=null;
		else{
			a=new ArrayList<GoodsPO>();
			for(GoodsVO g:goods){
				GoodsPO p=new GoodsPO(g.getGoodsID(),g.getName(),g.getSize(),g.getNumInStock(),g.getNumInStock(),g.getPurchasePrice(),g.getPrice(),g.getLastPurchasePrice(),g.getLastPrice(),g.getGoodsClass(),g.getManufactureDate(),g.getMinNumInstock());
                a.add(p);
			}
		}
		
		ArrayList<MemberVO> member=vo.getMember();
		ArrayList<MemberPO> b;
		if(member==null)
			b=null;
		else{
			b=new ArrayList<MemberPO>();
			for(MemberVO m:member){
				MemberPO p=new MemberPO(m.getMemberID(),m.getmType(),m.getmLevel(),m.getName(),m.getTel(),m.getAddress(),m.getPostcode(),m.getEMail(),m.getDefaultClerk(),m.getMaxOwe(),m.getToReceive(),m.getToPay(),m.getPoints());
                b.add(p);
			}
		}
		
		ArrayList<AccountVO> account=vo.getAccount();
		ArrayList<AccountPO> c;
		if(account==null)
			c=null;
		else{
			c=new ArrayList<AccountPO>();
			for(AccountVO m:account){
				AccountPO p=new AccountPO(m.getName(),m.getMoney());
                c.add(p);
			}
		}
		
	
		BeginInfoPO po=new BeginInfoPO(vo.getTime(),a,b,c);
		return po;
	}
	
	public ArrayList<BeginInfoPO> voToPo(ArrayList<BeginInfoVO> vo){
		if(vo==null)
			return null;
		ArrayList<BeginInfoPO> po=new ArrayList<BeginInfoPO>();
		for(BeginInfoVO v:vo){
			BeginInfoPO p=voToPo(v);
			po.add(p);
		}
		
		return po;
	}

	@Override
	public String getCurrentTime() {
		return service.getCurrentTime();
	}

}
