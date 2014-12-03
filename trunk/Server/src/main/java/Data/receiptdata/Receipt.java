package Data.receiptdata;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.financedata.Cashlist;
import Data.financedata.Collection;
import Data.financedata.Payment;
import Data.salesdata.Sales;
import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import po.PurchasePO;
import po.PurchaseReturnPO;
import po.ReceiptPO;
import po.ReceiptPO.ReceiptType;
import po.SalePO;
import po.SaleReturnPO;
import dataservice.receiptdataservice.ReceiptDataservice;

public class Receipt extends UnicastRemoteObject implements ReceiptDataservice{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Receipt() throws RemoteException {
		super();
	}
	
	public int Add(ReceiptPO po) throws RemoteException {
        int result=0;
        if(po.getType()==ReceiptType.COLLECTION){
        	Collection c=new Collection();
        	result=c.createCollection((CollectionPO)po);
        }
        else if(po.getType()==ReceiptType.PAYMENT){
        	Payment p=new Payment();
        	result=p.createPayment((PaymentPO)po);
        }
        else if(po.getType()==ReceiptType.CASHLIST){
        	Cashlist c=new Cashlist();
        	result=c.createCashlist((CashlistPO)po);
        }
        else if(po.getType()==ReceiptType.PURCHASE||po.getType()==ReceiptType.PURCHASERETURN||po.getType()==ReceiptType.SALE||po.getType()==ReceiptType.SALERETURN){
        	Sales s=new Sales();
        	if(po.getType()==ReceiptType.PURCHASE)
        		result=s.createPurchase((PurchasePO)po);
        	else if(po.getType()==ReceiptType.PURCHASERETURN)
        		result=s.createPurchaseReturn((PurchaseReturnPO)po);
        	else if(po.getType()==ReceiptType.SALE)
        		result=s.createSale((SalePO)po);
        	else
        		result=s.createSaleReturn((SaleReturnPO)po);
        }
        else if(po.getType()==ReceiptType.STOCKERROR){
        	
        }
        else if(po.getType()==ReceiptType.STOCKLOW){
        	
        }
        else if(po.getType()==ReceiptType.STOCKOVER){
        	
        }
        else if(po.getType()==ReceiptType.GIFT){
        	
        }
        else{
        	return 1;
        }
        	
		return result;
	}

	public ReceiptPO find(String id) throws RemoteException {
            ReceiptPO result;
            String[] buffer=id.split("-");
            String s=buffer[0];
	        if(s.equals("SKD")){
	        	Collection c=new Collection();
	        	result=c.;
	        }
	        else if(po.getType()==ReceiptType.PAYMENT){
	        	Payment p=new Payment();
	        	result=p.createPayment((PaymentPO)po);
	        }
	        else if(po.getType()==ReceiptType.CASHLIST){
	        	Cashlist c=new Cashlist();
	        	result=c.createCashlist((CashlistPO)po);
	        }
	        else if(po.getType()==ReceiptType.PURCHASE||po.getType()==ReceiptType.PURCHASERETURN||po.getType()==ReceiptType.SALE||po.getType()==ReceiptType.SALERETURN){
	        	Sales s=new Sales();
	        	if(po.getType()==ReceiptType.PURCHASE)
	        		result=s.createPurchase((PurchasePO)po);
	        	else if(po.getType()==ReceiptType.PURCHASERETURN)
	        		result=s.createPurchaseReturn((PurchaseReturnPO)po);
	        	else if(po.getType()==ReceiptType.SALE)
	        		result=s.createSale((SalePO)po);
	        	else
	        		result=s.createSaleReturn((SaleReturnPO)po);
	        }
	        else if(po.getType()==ReceiptType.STOCKERROR){
	        	
	        }
	        else if(po.getType()==ReceiptType.STOCKLOW){
	        	
	        }
	        else if(po.getType()==ReceiptType.STOCKOVER){
	        	
	        }
	        else if(po.getType()==ReceiptType.GIFT){
	        	
	        }
	        else{
	        	return 1;
	        }
	        	
			return result;
	}

	public int Modify(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ReceiptPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public double getNum(ReceiptType type, String date) throws RemoteException {
		int num=0;
		if(type==ReceiptType.COLLECTION){
			Collection c=new Collection();
			ArrayList<CollectionPO> a=c.getCollection();
			for(CollectionPO po:a){
				String s=po.getID();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		else if(type==ReceiptType.PAYMENT){
			Payment c=new Payment();
			ArrayList<PaymentPO> a=c.getPayment();
			for(PaymentPO po:a){
				String s=po.getID();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		else if(type==ReceiptType.CASHLIST){
			Cashlist c=new Cashlist();
			ArrayList<CashlistPO> a=c.getCashlist();
			for(CashlistPO po:a){
				String s=po.getID();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		
		return num;
	}
      
}