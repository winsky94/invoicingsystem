package businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import dataservice.financedataservice.accountdataservice.FinanceAccountDataService;
import vo.AccountVO;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService;

public class Account implements FinanceAccountBLService{

	private FinanceAccountDataService service;
	 
	public Account() throws MalformedURLException, RemoteException, NotBoundException{
		String host="localhost:1099";
		String url="rmi://"+host+"/accountService";
	
		service=(FinanceAccountDataService)Naming.lookup(url);
	
		
	}
	
	public int addAccount(AccountVO vo) {
        AccountPO po=voToPo(vo);		
	    return  service.addAccount(po);
		
	}

	public int deleteAccount(AccountVO vo) {
		AccountPO po=voToPo(vo);
		return service.deleteAccount(po);
	}

	public int modifyAccount(AccountVO vo,String name) {
		AccountPO po=voToPo(vo);
		return service.modifyAccount(po,name);
	}

	public ArrayList<AccountVO> findAccount(String s) {
		ArrayList<AccountPO> po=service.findAccount(s);
		ArrayList<AccountVO> vo=new ArrayList<AccountVO>();
		for(int i=0;i<po.size();i++){
			vo.add(poToVo(po.get(i)));
		}
		return vo;
	}
	
	public AccountVO findByName(String s) throws RemoteException {
		AccountPO po=service.findByName(s);
		AccountVO vo=poToVo(po);
		return vo;
	}

	public ArrayList<AccountVO> showAll() {
				ArrayList<AccountPO> po=service.showAll();
				if(po==null)
					return null;
				ArrayList<AccountVO> vo=new ArrayList<AccountVO>();
				for(int i=0;i<po.size();i++)
					vo.add(poToVo(po.get(i)));
				return vo;
	}

	public AccountPO voToPo(AccountVO vo){
		AccountPO po=new AccountPO(vo.getName(),vo.getMoney());		
		return po;
	}
	
	public ArrayList<AccountPO> voToPo(ArrayList<AccountVO> vo){
		ArrayList<AccountPO> po=new ArrayList<AccountPO>();
		for(int i=0;i<vo.size();i++){
			AccountPO p=voToPo(vo.get(i));
			po.add(p);
		}
		return po;
	}
	
	public AccountVO poToVo(AccountPO po){
	   AccountVO vo=new AccountVO(po.getName(),po.getMoney());
	   return vo;		
	}
	
	public ArrayList<AccountVO> poToVo(ArrayList<AccountPO> po){
		ArrayList<AccountVO> vo=new ArrayList<AccountVO>();
		for(int i=0;i<po.size();i++){
			AccountVO v=poToVo(po.get(i));
			vo.add(v);
		}
		return vo;
	}

	
}
