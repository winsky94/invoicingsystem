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
import Data.stockdata.stockManage.StockControl;
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
import po.StockOverOrLowPO;
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
	
	public ReceiptPO findById(String id) throws RemoteException {

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
	        else if(s.equals("KCZSD")){
	        	Gift gift=new Gift();
	        	return gift.findByID(id);
	        	
	        }
	        else if(s.equals("KCBYD")||s.equals("KCBSD")){
	        	StockControl sc=new StockControl();
	        	return sc.findByID(id);	        	
	        }	       
	        else{
	        	return null;
	        }
	        
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
		
		StockControl sc=new StockControl();
		if(sc.getStockOverOrLowPO()!=null){
			for(StockOverOrLowPO pp:(sc.getStockOverOrLowPO())){
				al.add(pp);
			}
		}		
		
		if(al.size()==0)
			return null;
		
		return al;
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
			else if(type==ReceiptType.STOCKLOW||type==ReceiptType.STOCKOVER){
				StockControl sc=new StockControl();
				ArrayList<StockOverOrLowPO> pp=sc.getStockOverOrLowPO();
				if(pp==null)
					return null;
				ArrayList<StockOverOrLowPO> pp1=new ArrayList<StockOverOrLowPO>();
				ArrayList<StockOverOrLowPO> pp2=new ArrayList<StockOverOrLowPO>();
				for(StockOverOrLowPO p:pp){
					if(p.getType()==ReceiptType.STOCKLOW)
						pp1.add(p);
					else
						pp2.add(p);
				}
				if(type==ReceiptType.STOCKLOW){
					for(StockOverOrLowPO ppp:pp1){
						al.add(ppp);
					}
				}
				else{
					for(StockOverOrLowPO ppp:pp2){
						al.add(ppp);
					}
				}
			
			}
			else{
				return null;
			}
		}
		
		return null;
	}

	public int Batch(String[] id, int status) {
        for(int i=0;i<id.length;i++){
        	try {
				ReceiptPO p=findById(id[i]);
				p.setStatus(status);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

		return 0;
	}

	public int Approve(String id, int status) {
		ReceiptPO p;
		try {
			p = findById(id);
			p.setStatus(status);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<ReceiptPO> findByTime(String s) throws RemoteException{
		ArrayList<ReceiptPO> al;
		ArrayList<ReceiptPO> result=new ArrayList<ReceiptPO>();
			al = showAll();
			if(al==null)
				return null;
			String startDate=s.substring(0,8);
			String endDate=s.substring(8,16);
			for(ReceiptPO po:al){
				if(startDate.compareTo(po.myGetDate())<0&&po.myGetDate().compareTo(endDate)<0)
					result.add(po);	
			}
		     return result;
	}
	
	public ArrayList<ReceiptPO> findByMember(String s) throws RemoteException{
		ArrayList<ReceiptPO> result=new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> al=showAll();
		if(al==null)
			return null;
		for(ReceiptPO po:al){
			if(po.getType()==ReceiptType.COLLECTION){
				if(s.equals(((CollectionPO)po).getSupplier())||s.equals(((CollectionPO)po).getSeller()))
					result.add(po);
			}
			else if(po.getType()==ReceiptType.PAYMENT){
				if(s.equals(((PaymentPO)po).getSupplier())||s.equals(((PaymentPO)po).getSeller()))
					result.add(po);
			}
			else if(po.getType()==ReceiptType.CASHLIST){
				continue;
			}
			else{
				if(s.equals(po.getMemberID()))
					result.add(po);
			}
		}
		if(result.size()==0)
			return null;
					
		return result;	
	}
	
	public ArrayList<ReceiptPO> findByUser(String s) throws RemoteException{
		ArrayList<ReceiptPO> result=new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> al=showAll();
		if(al==null)
			return null;
		for(ReceiptPO po:al){
			if(po.getUserID().equals(s))
				result.add(po);
		}
		if(result.size()==0)
			return null;
	    return result;
	}
	
	
	public ArrayList<ReceiptPO> findByWarehouse(String s) throws RemoteException{
		ArrayList<ReceiptPO> result=new ArrayList<ReceiptPO>();
		ArrayList<ReceiptPO> al=showAll();
		if(al==null)
			return null;
		for(ReceiptPO po:al){
			if(po.getType()==ReceiptType.PURCHASE){
				if(((PurchasePO)po).getStockID().equals(s))
					result.add(po);
			}
			else if(po.getType()==ReceiptType.PURCHASERETURN){
				if(((PurchaseReturnPO)po).getStockID().equals(s))
					result.add(po);
			}
			else if(po.getType()==ReceiptType.SALE){
				if(((SalePO)po).getStockID().equals(s))
					result.add(po);
			}
			else if(po.getType()==ReceiptType.SALERETURN){
				if(((SaleReturnPO)po).getStockID().equals(s))
					result.add(po);
			}
		}
		if(al.size()==0)
			return null;
		return result;
	}
	
	public ArrayList<ReceiptPO> intersection(ArrayList<ReceiptPO> a1,ArrayList<ReceiptPO> a2){
		ArrayList<ReceiptPO> result=new ArrayList<ReceiptPO>();
		if(a1==null||a2==null)
			return null;
		for(int i=0;i<a1.size();i++)
			for(int j=0;j<a2.size();j++){
				if(a1.get(i).getId().equals(a2.get(j).getId())){
					result.add(a1.get(i));
					break;
				} 
			}
		if(result.size()==0)
			return null;
		return result;
	}
	
	public ArrayList<ReceiptPO> AccurateFind(String[] message)throws RemoteException {
		//时间区间,单据类型，客户，业务员，仓库
		ArrayList<ReceiptPO> a1;
		ArrayList<ReceiptPO> a2;
		ArrayList<ReceiptPO> a3;
		ArrayList<ReceiptPO> a4;
		ArrayList<ReceiptPO> a5;
		ArrayList<ReceiptPO> result;
		if(message[0]!=null)
			a1=findByTime(message[0]);
		else
			a1=null;
		
		if(message[1]!=null)
			a2=show(ReceiptType.valueOf(message[1]));
		else
			a2=null;
		
		if(message[2]!=null)
			a3=findByMember(message[2]);
		else
			a3=null;
		
		if(message[3]!=null)
			a4=findByUser(message[3]);
		else
			a4=null;
		
		if(message[4]!=null)
			a5=findByWarehouse(message[4]);
		else
			a5=null;
		
		result=intersection(a1,intersection(a2,intersection(a3,intersection(a4,a5))));
		
		return result;
			
	}
      
}
