package businesslogic.receiptbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import businesslogic.financebl.CashList;
import businesslogic.financebl.Collection;
import businesslogic.financebl.MockAccount;
import businesslogic.financebl.MockCashList;
import businesslogic.financebl.Payment;
import businesslogic.salesbl.Purchase;
import businesslogic.salesbl.PurchaseReturn;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SaleReturn;
import vo.ReceiptVO;
//Reply 和Send 使用观察者模式，Reply之后单据类自己做善后处理
public class Review {
	ReceiptDataService service;
	public Review() throws Exception{
		String host="localhost:1099";
		String url="rmi://"+host+"/receiptService";
	
		service=(ReceiptDataService)Naming.lookup(url);
	}
	
public ArrayList<ReceiptVO> View(){
		
		return null;
	}
	

	public ReceiptPO View(String id){
		return service.findById(id);
		
	
	}
	
	
	//除库存但立即执行外  其他七种需审批， 自动库存赠送单需执行
	public  int Excute(ReceiptVO vo) throws Exception{
		Receipt receipt;
		switch(vo.getType()){
		case PURCHASE:
			receipt=new Purchase();break;
		case SALE:
			receipt=new Sale();break;
		case PURCHASERETURN:
			receipt=new PurchaseReturn();break;
		case SALERETURN:
			receipt=new SaleReturn();break;
		case CASHLIST:
			receipt=new CashList();break;
		case COLLECTION:
			receipt=new Collection();break;
		default:
			receipt=new Payment();
	}
		int i=receipt.excute(vo);
		return i;//0成功  1不成功  仅出现在销售
	}
	
	public ArrayList<ReceiptVO> Refresh(){
		return null;
	}
	//**传参数呢 还是id呢
	public int Approve(String id,int status){
	//	int i=service.Approve(id,status);
		int result=0;
		if(status==1){
			service.setStatus(id, status);
			return 0;
		}
		else{
		
			ReceiptVO vo=ReceiptController.poToVo(service.findById(id));
			try {
				 result=Excute(vo);
				 if(result==0){
					 service.setStatus(id, status);
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return result;
	}
	
	//红冲 i=0,仅红冲，i=1并复制
	public ReceiptVO RedExtru(Receipt receipt,int i){
		MockCashList cash=(MockCashList)receipt;
		MockAccount ac=(MockAccount)cash.getAccout();
		ac.updateBalance(-cash.getTotal());
		
		
		return null;
	} 
}
