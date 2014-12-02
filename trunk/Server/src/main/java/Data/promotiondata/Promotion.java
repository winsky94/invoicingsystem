package Data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.serutility.JXCFile;
import po.DiscountProPO;
import po.GiftCouponProPO;
import po.GiftGoodProPO;
import po.PackProPO;
import po.PromotionPO;
import po.PromotionPO.PromotionType;
import dataservice.promotiondataservice.PromotionDataService;
/*
 * //促销有不同类型存储在不同的ser文件里  所以data层需要判断po的PromotionType  做不同的转换
			//存入 不同的文件   to小小黄
 */
public class Promotion extends UnicastRemoteObject implements PromotionDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;
	public Promotion() throws RemoteException {
		super();
		
	}
	
	public int Add(PromotionPO po) throws RemoteException {
		if(po.getType()==PromotionType.DISCOUNT){
			file=new JXCFile("src/main/java/discount.ser");
			file.write(po);
			return 0;
		}
		else if(po.getType()==PromotionType.GIFTCOUPON){
			file=new JXCFile("src/main/java/giftcoupon.ser");
			file.write(po);
			return 0;
		}
		else if(po.getType()==PromotionType.GIFTGOODS){
			file=new JXCFile("src/main/java/giftgoods.ser");
			file.write(po);
			return 0;
		}
		else if(po.getType()==PromotionType.PACK){
			file=new JXCFile("src/main/java/pack.ser");
			file.write(po);
			return 0;
		}
		return 1;
	}

	public PromotionPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int Modify(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PromotionPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public ArrayList<PackProPO> getPackPro() throws RemoteException{
		file=new JXCFile("src/main/java/pack.ser");
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<PackProPO> buffer=new ArrayList<PackProPO>();
		for(Object b:a){
			PackProPO po=(PackProPO)b;
			buffer.add(po);
		}
		
		return buffer;
	}
	
	public ArrayList<GiftCouponProPO> getGiftCouponPro() throws RemoteException{
		file=new JXCFile("src/main/java/giftcoupon.ser");
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<GiftCouponProPO> buffer=new ArrayList<GiftCouponProPO>();
		for(Object b:a){
			GiftCouponProPO po=(GiftCouponProPO)b;
			buffer.add(po);
		}
		
		return buffer;
	}
	
	public ArrayList<DiscountProPO> getDiscountPro() throws RemoteException{
		file=new JXCFile("src/main/java/discount.ser");
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<DiscountProPO> buffer=new ArrayList<DiscountProPO>();
		for(Object b:a){
			DiscountProPO po=(DiscountProPO)b;
			buffer.add(po);
		}
		
		return buffer;
	}
	
	public ArrayList<GiftGoodProPO> getGiftGoodPro() throws RemoteException{
		file=new JXCFile("src/main/java/giftgoods.ser");
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<GiftGoodProPO> buffer=new ArrayList<GiftGoodProPO>();
		for(Object b:a){
			GiftGoodProPO po=(GiftGoodProPO)b;
			buffer.add(po);
		}
		
		return buffer;
	}
	
	
	

}
