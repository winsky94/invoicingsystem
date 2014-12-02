package Data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;

import Data.datafactory.SequenceOfPromotionPO;
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

	public PromotionPO find(String id,PromotionType type) throws RemoteException {
		if(type==PromotionType.PACK){
			ArrayList<PackProPO> al=getPackPro();
			if(al!=null){
			   for(PackProPO po:al){
				  if(po.getID().equals(id)){
				    	return po;
				  }
			   }	
			}
		}
		else if(type==PromotionType.GIFTCOUPON){
			ArrayList<GiftCouponProPO> al=getGiftCouponPro();
			if(al!=null){
			  for(GiftCouponProPO po:al){
				  if(po.getID().equals(id)){
					  return po;
				  }
			  }
			}
		}
		else if(type==PromotionType.DISCOUNT){
			ArrayList<DiscountProPO> al=getDiscountPro();
			if(al!=null){
			  for(DiscountProPO po:al){
			 	  if(po.getID().equals(id)){
					  return po;
				  }
			  }	
			}
		}
		else if(type==PromotionType.GIFTGOODS){
			ArrayList<GiftGoodProPO> al=getGiftGoodPro();
			if(al!=null){
			  for(GiftGoodProPO po:al){
				  if(po.getID().equals(id)){
					  return po;
				  }
			  }	
		    }
		}
		return null;
	}

	public int Modify(PromotionPO po) throws RemoteException {
		if(po.getType()==PromotionType.PACK){
			PackProPO it=(PackProPO)po;
			ArrayList<PackProPO> al=getPackPro();
			if(al==null)
				return 1;
			for(int i=0;i<al.size();i++){
				PackProPO p=al.get(i);
				if(p.equals(it.getID())){
					p.setStartDate(it.getStartDate());
					p.setEndDate(it.getEndDate());
					p.setLevel(it.getLevel());
					p.setPackList(it.getPackList());
					p.setPackValue(it.getPackValue());
					break;
				}
			}
			file=new JXCFile("src/main/java/pack.ser");
			file.writeM(al);
		}
		else if(po.getType()==PromotionType.DISCOUNT){
			DiscountProPO it=(DiscountProPO)po;
			ArrayList<DiscountProPO> al=getDiscountPro();
			if(al==null)
				return 1;
			
			for(int i=0;i<al.size();i++){
				DiscountProPO p=al.get(i);
				if(p.equals(it.getID())){
					p.setStartDate(it.getStartDate());
					p.setEndDate(it.getEndDate());
					p.setLevel(it.getLevel());
					p.setDiscount(it.getCountList(),it.getGoodsList());
					p.setDiscountValue(it.getDiscountValue());
					p.setTotalValue(it.getTotalValue());
					break;
				}
			}
			file=new JXCFile("src/main/java/discount.ser");
			file.writeM(al);
		}
		else if(po.getType()==PromotionType.GIFTCOUPON){
			GiftCouponProPO it=(GiftCouponProPO)po;
			ArrayList<GiftCouponProPO> al=getGiftCouponPro();
			if(al==null)
				return 1;
			for(int i=0;i<al.size();i++){
				GiftCouponProPO p=al.get(i);
				if(p.equals(it.getID())){
					p.setStartDate(it.getStartDate());
					p.setEndDate(it.getEndDate());
					p.setLevel(it.getLevel());
					p.setCouponList(it.getCouponList());
					p.setTotalValue(it.getTotalValue());
					break;
				}
			}
			file=new JXCFile("src/main/java/giftcoupon.ser");
			file.writeM(al);
		}
		else if(po.getType()==PromotionType.GIFTGOODS){
			GiftGoodProPO it=(GiftGoodProPO)po;
			ArrayList<GiftGoodProPO> al=getGiftGoodPro();
			if(al==null)
				return 1;
			for(int i=0;i<al.size();i++){
				GiftGoodProPO p=al.get(i);
				if(p.equals(it.getID())){
					p.setStartDate(it.getStartDate());
					p.setEndDate(it.getEndDate());
					p.setLevel(it.getLevel());
					p.setGiftList(it.getGiftList());
					p.setTotalValue(it.getTotalValue());
					break;
				}
			}
			file=new JXCFile("src/main/java/giftgoods.ser");
			file.writeM(al);
		}
		else{
			return 1;
		}
		return 0;
	}

	public ArrayList<PromotionPO> show() throws RemoteException {
		ArrayList<PromotionPO> all=new ArrayList<PromotionPO>();
		ArrayList<PackProPO> a1=getPackPro();
		if(a1!=null){
		    for(PackProPO po:a1){
			  all.add(po);
		    }
		}
		ArrayList<GiftCouponProPO> a2=getGiftCouponPro();
		if(a2!=null){
		  for(GiftCouponProPO po:a2){
			  all.add(po);
		  }
		}
		
		ArrayList<DiscountProPO> a3=getDiscountPro();
		if(a3!=null){
		  for(DiscountProPO po:a3){
			  all.add(po);
		  }
		}
		
		ArrayList<GiftGoodProPO> a4=getGiftGoodPro();
		if(a4!=null){
		  for(GiftGoodProPO po:a4){
			  all.add(po);
		  }
		}
		
		if(all.size()==0)
			return null;
		
		  Collections.sort(all,new SequenceOfPromotionPO());
		  
		  return all;
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

	public int Delete(String id, PromotionType type) throws RemoteException {
		if(type==PromotionType.PACK){
			ArrayList<PackProPO> al=getPackPro();
			if(al==null)
				return 1;
			for(int i=0;i<al.size();i++){
				PackProPO p=al.get(i);
				if(p.equals(id)){
					al.remove(i);
					break;
				}
			}
			file=new JXCFile("src/main/java/pack.ser");
			file.writeM(al);
		}
		else if(type==PromotionType.DISCOUNT){
			ArrayList<DiscountProPO> al=getDiscountPro();
			if(al==null)
				return 1;
			
			for(int i=0;i<al.size();i++){
				DiscountProPO p=al.get(i);
				if(p.equals(id)){
					al.remove(i);
					break;
				}
			}
			file=new JXCFile("src/main/java/discount.ser");
			file.writeM(al);
		}
		else if(type==PromotionType.GIFTCOUPON){
			ArrayList<GiftCouponProPO> al=getGiftCouponPro();
			if(al==null)
				return 1;
			for(int i=0;i<al.size();i++){
				GiftCouponProPO p=al.get(i);
				if(p.equals(id)){
					al.remove(i);
					break;
				}
			}
			file=new JXCFile("src/main/java/giftcoupon.ser");
			file.writeM(al);
		}
		else if(type==PromotionType.GIFTGOODS){
			ArrayList<GiftGoodProPO> al=getGiftGoodPro();
			if(al==null)
				return 1;
			for(int i=0;i<al.size();i++){
				GiftGoodProPO p=al.get(i);
				if(p.equals(id)){
				    al.remove(i);
					break;
				}
			}
			file=new JXCFile("src/main/java/giftgoods.ser");
			file.writeM(al);
		}
		else{
			return 1;
		}
		return 0;
	}
	

}
