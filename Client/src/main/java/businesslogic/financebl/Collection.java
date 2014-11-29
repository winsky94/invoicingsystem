package businesslogic.financebl;

import java.util.ArrayList;
import java.util.Date;

import po.CollectionPO;
import po.TransferItemPO;
import vo.CollectionVO;
import vo.TransferItemVO;
import businesslogic.memberbl.Member;
import businesslogic.receiptbl.Receipt;
import businesslogic.receiptbl.ReceiptType;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.financedataservice.listdataservice.CollectionDataService;


public class Collection extends Receipt implements CollectionBLService{

	 String ID;
     String supplier;
     String seller;
     String user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     CollectionDataService service;
     double totalMoney;
     public Collection()throws Exception{
    	System.setSecurityManager(new SecurityManager());
 		String host="localhost:1099";
 		String url="rmi://"+host+"/userService";
 	
 		service=(CollectionDataService)Naming.lookup(url);
     }
    
	 public Collection(String id,  String memberID,
			String userID,Date date, int hurry, int status,
			String info,String sid,double Money) throws Exception{
		super(id,memberID, userID, ReceiptType.COLLECTION, date, hurry, status, info,sid);
		// TODO Auto-generated constructor stub
		this.totalMoney=Money;
	}


	

    
  /*  public Collection(MockMember b,MockMember c,double m){
   	 this(null,b,c,null,null,m);
    }  */
    
   /* public Collection(String a,MockMember b,MockMember j,String c,ArrayList<TransferItem> d,double e){
   	 ID=a;
   	 supplier=b;
   	 seller=j;
   	 user=c;
   	 transferlist=d;
   	 totalMoney=e;
    }
    */
	
    public void excute(Member mb,MockAccount account){
    	MockCollection collect=(MockCollection)this;
    	double money=-collect.getMoneyByOrder(0);
    	mb.updateToReceive(money);
    	account.updateBalance(collect.getMoneyByOrder(0));
    	
    	this.setStatus(5);
    	
    }
	public int createCollection(CollectionVO vo) {
		 ArrayList<TransferItemVO> a=vo.getTransferlist();
		 ArrayList<TransferItemPO> b=new ArrayList<TransferItemPO>();
		 TransferItemPO po1;
		 for(int i=0;i<a.size();i++){
			 TransferItemVO vo1=a.get(i);
			 po1=new TransferItemPO(vo1.getAccount(),vo1.getMoney(),vo1.getInfo());
			 b.add(po1);
		 }
	
		CollectionPO po=new CollectionPO(vo.getID(),vo.getSupplier(),vo.getSeller(),vo.getUser(),b,vo.getTotalMoney());
		service.createCollection(po);
		System.out.println(vo.getID()+" "+vo.getSupplier()+" "+vo.getSeller()+" "+vo.getUser()+" "+b.get(0).getAccount()+" "+vo.getTotalMoney());
		
		return 0;
	}

}
