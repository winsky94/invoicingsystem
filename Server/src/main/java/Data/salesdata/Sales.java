package Data.salesdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.serutility.JXCFile;
import po.CommodityPO;
import po.PurchasePO;
import po.PurchaseReturnPO;
import po.SalePO;
import po.SaleReturnPO;
import dataservice.salesdataservice.SalesDataService;

public class Sales extends UnicastRemoteObject implements SalesDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;
	public Sales() throws RemoteException{
		super();
	}

	public int createPurchase(PurchasePO po) throws RemoteException{
		file=new JXCFile("src/main/java/purchase.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<PurchasePO> showPurchase() throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<PurchasePO> buffer=new ArrayList<PurchasePO>();
		for(Object b:a){
			PurchasePO po=(PurchasePO)b;
			buffer.add(po);
		}
		
		return buffer;
	}

	public int createPurchaseReturn(PurchaseReturnPO po) throws RemoteException{
		file=new JXCFile("src/main/java/purchasereturn.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<PurchaseReturnPO> showPurchaseReturn()throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<PurchaseReturnPO> buffer=new ArrayList<PurchaseReturnPO>();
		for(Object b:a){
			PurchaseReturnPO po=(PurchaseReturnPO)b;
			buffer.add(po);
		}
		
		return buffer;
	}

	public int createSale(SalePO po) throws RemoteException{
		file=new JXCFile("src/main/java/sale.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<SalePO> showSale() throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<SalePO> buffer=new ArrayList<SalePO>();
		for(Object b:a){
			SalePO po=(SalePO)b;
			buffer.add(po);
		}
		
		return buffer;
	}

	public int createSaleReturn(SaleReturnPO po) throws RemoteException{
		file=new JXCFile("src/main/java/salereturn.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<SaleReturnPO> showSaleReturn() throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<SaleReturnPO> buffer=new ArrayList<SaleReturnPO>();
		for(Object b:a){
			SaleReturnPO po=(SaleReturnPO)b;
			buffer.add(po);
		}
		
		return buffer;
	}
	
	public int updatePurchase(PurchasePO po) throws RemoteException{
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	  //不存在该用户	
		int i;
		for(i=0;i<a.size();i++){
			PurchasePO p=(PurchasePO)a.get(i);
			if(p.getId().equals(po.getId())){
				p.setHurry(po.getHurry());
				p.setInfo(po.getInfo());
				p.setMemberID(po.getMemberID());
				p.setPurchaseList(po.getPurchaseList());
				p.setStatus(po.getStatus());
				p.setTotalInAll(po.getTotalInAll());
				break;
			}
		}
		if(i==a.size())      //不存在该收款单
			return 1;
		
		file.writeM(a);
		return 0;
	}
	public int updatePurchaseReturn(PurchaseReturnPO po) throws RemoteException {
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	  //不存在该用户	
		int i;
		for(i=0;i<a.size();i++){
			PurchaseReturnPO p=(PurchaseReturnPO)a.get(i);
			if(p.getId().equals(po.getId())){
				p.setHurry(po.getHurry());
				p.setInfo(po.getInfo());
				p.setMemberID(po.getMemberID());
				p.setStatus(po.getStatus());
				p.setTotalInAll(po.getTotalInAll());
				break;
			}
		}
		if(i==a.size())      //不存在该收款单
			return 1;
		
		file.writeM(a);
		return 0;
	}
	public int updateSale(SalePO po) throws RemoteException {
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	  //不存在该用户	
		int i;
		for(i=0;i<a.size();i++){
			SalePO p=(SalePO)a.get(i);
			if(p.getId().equals(po.getId())){
				p.setHurry(po.getHurry());
				p.setInfo(po.getInfo());
				p.setMemberID(po.getMemberID());
				p.setClerk(po.getClerk());
				p.setCost(po.getCost());
				p.setCouponPrice(po.getCouponPrice());
				p.setDiscount(po.getDiscountValue());
				p.setMoneyDiscount(po.getMoneyDiscount());
				p.setSalesList(po.getSalesList());
				p.setToPay(po.getToPay());
				p.setStatus(po.getStatus());
				p.setTotal(po.getTotalValue());
				p.setTotalOrigin(po.getTotalOrigin());
				break;
			}
		}
		if(i==a.size())      //不存在该收款单
			return 1;
		
		file.writeM(a);
		return 0;
	}
	public int updateSaleReturn(SaleReturnPO po) throws RemoteException {
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	  //不存在该用户	
		int i;
		for(i=0;i<a.size();i++){
			SaleReturnPO p=(SaleReturnPO)a.get(i);
			if(p.getId().equals(po.getId())){
				p.setHurry(po.getHurry());
				p.setInfo(po.getInfo());
				p.setMemberID(po.getMemberID());
				p.setClerk(po.getClerk());
				p.setCost(po.getCost());
				p.setCouponPrice(po.getCouponPrice());
				p.setDiscount(po.getDiscountValue());
				p.setMoneyDiscount(po.getMoneyDiscount());
				p.setSalesreturnList(po.getSalesreturnList());
				p.setToPay(po.getToPay());
				p.setStatus(po.getStatus());
				p.setTotal(po.getTotalValue());
				p.setTotalOrigin(po.getTotalOrigin());
				break;
			}
		}
		if(i==a.size())      //不存在该收款单
			return 1;
		
		file.writeM(a);
		return 0;
	}
	
	public ArrayList<PurchasePO> findPurchase(String message)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<PurchaseReturnPO> findPurchaseReturn(String message)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<SalePO> findSale(String message) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<SaleReturnPO> findSaleReturn(String message)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		Sales a;
		try {
			a = new Sales();
			ArrayList<CommodityPO> al=new ArrayList<CommodityPO>();
			CommodityPO item =new CommodityPO("0001-001-0001","飞利浦日光灯","SRO1",100,158,100,198,98,"这是个灯");
			al.add(item);
			a.createPurchase(new PurchasePO("JHD-20141201-00001","JHS-0000001","02","XS-00001",al,"这是个进货单", 1000,0,1));	
			System.out.println("Success!");
			ArrayList<PurchasePO> pl=a.getPurchase();
			for(PurchasePO po:pl){
				System.out.println(po.getId()+" "+po.getDate()+" "+po.getPurchaseList().get(0).getName());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
