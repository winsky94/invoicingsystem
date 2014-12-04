package Data.receiptdata;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Data.financedata.Cashlist;
import Data.financedata.Collection;
import Data.financedata.Payment;
import Data.financedata.RedExtrusion;
import Data.salesdata.Sales;
import Data.stockdata.gift.Gift;
import po.CashlistPO;
import po.CollectionPO;
import po.GiftPO;
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
       RedExtrusion r=new RedExtrusion();
       return r.createRedExtrusion(po);
	}

	public ReceiptPO addAndCopy(ReceiptPO po) throws RemoteException{
		RedExtrusion r=new RedExtrusion();
		return r.createRedExtrusionAndCopy(po);
	}
	
	public ReceiptPO find(String id) throws RemoteException {

            String[] buffer=id.split("-");
            String s=buffer[0];
	        if(s.equals("SKD")){
	        	Collection c=new Collection();
	        	return c.findByID(id);
	        }
	        else if(s.equals("FKD")){
	        	Payment p=new Payment();
	        	return p.findByID(id);
	        }
	        else if(s.equals("XJFYD")){
	        	Cashlist c=new Cashlist();
	        	return c.findByID(id);
	        }
	        else if(s.equals("JHD")||s.equals("JHTHD")||s.equals("XSD")||s.equals("XSTHD")){
	        	Sales sale=new Sales();
	        		return sale.findReceiptByID(id);
	        }
	        else if(s.equals("")){
	        	
	        }
	        else if(s.equals("")){
	        	
	        }
	        else if(s.equals("")){
	        	
	        }
	        else if(s.equals("")){
	        	
	        }
	        else{
	        	return null;
	        }
	        
	       return null;
	}

	public int Modify(ReceiptPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ReceiptPO> showAll() throws RemoteException {
		ArrayList<ReceiptPO> al=new ArrayList<ReceiptPO>();
		Collection c=new Collection();
		if(c.getCollection()!=null)
			for(CollectionPO p:(c.getCollection())){
				al.add(p);
			}
		Payment p=new Payment();
		if(p.getPayment()!=null)
			for(PaymentPO pp:(p.getPayment())){
				al.add(pp);
			}
		Cashlist cc=new Cashlist();
		if(cc.getCashlist()!=null)
			for(CashlistPO pp:(cc.getCashlist())){
				al.add(pp);
			}
		Sales sa=new Sales();
		if(sa.getAllPurchase()!=null){
			for(ReceiptPO pp:(sa.getAllPurchase())){
				al.add(pp);
			}
		}
		if(sa.getAllSale()!=null){
			for(ReceiptPO pp:(sa.getAllSale())){
				al.add(pp);
			}
		}
		Gift g=new Gift();
		if(g.getGiftList()!=null){
			for(GiftPO pp:(g.getGiftList())){
				al.add(pp);
			}
		}
		
		
		
		
		
		
		if(al.size()==0)
			return null;
		
		return al;
	}


	public double getNum(ReceiptType type, String date) throws RemoteException {
		int num=0;
		if(type==ReceiptType.COLLECTION){
			Collection c=new Collection();
			ArrayList<CollectionPO> a=c.getCollection();
			for(CollectionPO po:a){
				String s=po.getId();
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
				String s=po.getId();
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
				String s=po.getId();
				String[] buffer=s.split("-");
				String d=buffer[1];
				if(d.equals(date));
				   num++;
			}			
		}
		
		return num;
	}

	public ArrayList<ReceiptPO> show(ReceiptType type) throws RemoteException {
		ArrayList<ReceiptPO> al=new ArrayList<ReceiptPO>();
		if(type==ReceiptType.COLLECTION){
			Collection c=new Collection();
			ArrayList<CollectionPO> cc=c.getCollection();
			if(cc==null)
				return null;
			for(CollectionPO p:cc){
				al.add(p);
			}
			return al;
		}
		else if(type==ReceiptType.PAYMENT){
			Payment c=new Payment();
			ArrayList<PaymentPO> pp=c.getPayment();
			if(pp==null)
				return null;
			for(PaymentPO p:pp){
				al.add(p);
			}
			return al;
		}
		else if(type==ReceiptType.CASHLIST){
			Cashlist c=new Cashlist();
			ArrayList<CashlistPO> pp=c.getCashlist();
			if(pp==null)
				return null;
			for(CashlistPO p:pp){
				al.add(p);
			}
			return al;
		}
		else if(type==ReceiptType.GIFT){
			Gift c=new Gift();
			ArrayList<GiftPO> pp=c.getGiftList();
			if(pp==null)
				return null;
			for(GiftPO p:pp){
				al.add(p);
			}
			return al;
		}
		else if(type==ReceiptType.PURCHASE||type==ReceiptType.PURCHASERETURN||type==ReceiptType.SALE||type==ReceiptType.SALERETURN){
			Sales s=new Sales();
			if(type==ReceiptType.PURCHASE){
				ArrayList<PurchasePO> pp=s.showPurchase();
				if(pp==null)
					return null;
				for(PurchasePO p:pp){
					al.add(p);
				}
			}
			else if(type==ReceiptType.PURCHASERETURN){
				ArrayList<PurchaseReturnPO> pp=s.showPurchaseReturn();
				if(pp==null)
					return null;
				for(PurchaseReturnPO p:pp){
					al.add(p);
				}
			}
			else if(type==ReceiptType.SALE){
				ArrayList<SalePO> pp=s.showSale();
				if(pp==null)
					return null;
				for(SalePO p:pp){
					al.add(p);
				}
			}
			else if(type==ReceiptType.SALERETURN){
				ArrayList<SaleReturnPO> pp=s.showSaleReturn();
				if(pp==null)
					return null;
				for(SaleReturnPO p:pp){
					al.add(p);
				}
			}
			else if(type==ReceiptType.STOCKERROR){
				
			}
			else if(type==ReceiptType.STOCKLOW){
				
			}
			else if(type==ReceiptType.STOCKOVER){
				
			}
			else{
				return null;
			}
		}
		
		return null;
	}
      
}
