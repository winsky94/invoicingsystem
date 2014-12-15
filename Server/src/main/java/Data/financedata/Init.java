package Data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.memberdata.Member;
import Data.serutility.JXCFile;
import Data.stockdata.goods.Goods;
import po.AccountPO;
import po.BeginInfoPO;
import po.GoodsPO;
import po.MemberPO;
import dataservice.financedataservice.initdataservice.FinanceInitDataService;

public class Init extends UnicastRemoteObject implements FinanceInitDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int num=0;
	public Init() throws RemoteException{
		super();
	}
	public int initInfo(String time,BeginInfoPO po) {
		JXCFile.init(time);
		ArrayList<MemberPO> member=po.getMember();
		if(member!=null)
		try {
			Member m=new Member();
			for(MemberPO p:member){
				m.add(p);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<GoodsPO> goods=po.getGoods();
		if(goods!=null){
			Goods g;
			try {
				g = new Goods();
				for(GoodsPO p:goods){
					g.addGoods(p);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<AccountPO> account=po.getAccount();
		if(account!=null){
			try {
				Account a=new Account();
				for(AccountPO p:account){
					a.addAccount(p);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}
	public BeginInfoPO getInfo(String time) {
		// TODO Auto-generated method stub
		return null;
	}
}
