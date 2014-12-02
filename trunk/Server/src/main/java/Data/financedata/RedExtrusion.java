package Data.financedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.ReceiptPO.ReceiptType;
import dataservice.financedataservice.listdataservice.RedExtrusionDataService;

public class RedExtrusion extends UnicastRemoteObject implements RedExtrusionDataService{
	public RedExtrusion() throws RemoteException{
		super();
	}
	public int createRedExtrusion(ReceiptPO po) throws RemoteException {
		ReceiptType type=po.getType();
		if(type==ReceiptType.COLLECTION){
			Collection c=new Collection();
			CollectionPO p=(CollectionPO)po;
			CollectionPO p2=new CollectionPO(p.getID(),p.getSupplier(),p.getSeller(),p.getUser(),p.getTransferlist(),p.getTotalMoney()*(-1));
			c.createCollection(p2);			
		}
		else if(type==ReceiptType.PAYMENT){
			Payment p=new Payment();
			PaymentPO pp=(PaymentPO)po;
			PaymentPO pp2=new PaymentPO(pp.getID(),pp.getSupplier(),pp.getSeller(),pp.getUser(),pp.getTransferlist(),pp.getTotalMoney()*(-1));
            p.createPayment(pp2);
		}
		else if(type==ReceiptType.CASHLIST){
			Cashlist c=new Cashlist();
			CashlistPO p=(CashlistPO)po;
			CashlistPO p2=new CashlistPO(p.getID(),p.getUser(),p.getAccount(),p.getClauselist(),p.getTotalMoney()*(-1));
            c.createCashlist(p2);
		}
		return 0;
	}
	public ReceiptPO createRedExtrusionAndCopy(ReceiptPO po) throws RemoteException {
		ReceiptType type=po.getType();
		if(type==ReceiptType.COLLECTION){
			Collection c=new Collection();
			CollectionPO p=(CollectionPO)po;
			CollectionPO p2=new CollectionPO(p.getID(),p.getSupplier(),p.getSeller(),p.getUser(),p.getTransferlist(),p.getTotalMoney()*(-1));
			c.createCollection(p2);	
			return p;
		}
		else if(type==ReceiptType.PAYMENT){
			Payment p=new Payment();
			PaymentPO pp=(PaymentPO)po;
			PaymentPO pp2=new PaymentPO(pp.getID(),pp.getSupplier(),pp.getSeller(),pp.getUser(),pp.getTransferlist(),pp.getTotalMoney()*(-1));
            p.createPayment(pp2);
            return pp;
		}
		else if(type==ReceiptType.CASHLIST){
			Cashlist c=new Cashlist();
			CashlistPO p=(CashlistPO)po;
			CashlistPO p2=new CashlistPO(p.getID(),p.getUser(),p.getAccount(),p.getClauselist(),p.getTotalMoney()*(-1));
            c.createCashlist(p2);
            return p;
		}
		return null;
	}
	
}