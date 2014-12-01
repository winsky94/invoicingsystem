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
import po.ReceiptPO.ReceiptType;
import dataservice.salesdataservice.SalesDataService;

public class Sales extends UnicastRemoteObject implements SalesDataService{
	JXCFile file;
	public Sales() throws RemoteException{
		super();
	}
	public void getSaleList() {
		
		
	}

	public int purchase(PurchasePO po) {
		file=new JXCFile("src/main/java/purchase.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<PurchasePO> getPurchase(){
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

	public int purchaseReturn(PurchaseReturnPO po) {
		file=new JXCFile("src/main/java/purchasereturn.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<PurchaseReturnPO> getPurchaseReturn(){
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

	public int sale(SalePO po) {
		file=new JXCFile("src/main/java/sale.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<SalePO> getSale(){
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

	public int saleReturn(SaleReturnPO po) {
		file=new JXCFile("src/main/java/salereturn.ser");
		file.write(po);
		return 0;
	}
	
	public ArrayList<SaleReturnPO> getSaleReturn(){
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
	
	public static void main(String[] args){
		Sales a;
		try {
			a = new Sales();
			ArrayList<CommodityPO> al=new ArrayList<CommodityPO>();
			CommodityPO item =new CommodityPO("0001-001-0001","飞利浦日光灯","SRO1",100,158,100,198,98,"这是个灯");
			al.add(item);
			a.purchase(new PurchasePO("JHD-20141201-00001","JHS-0000001","02","XS-00001",al,"这是个进货单", 1000,0,1));	
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
