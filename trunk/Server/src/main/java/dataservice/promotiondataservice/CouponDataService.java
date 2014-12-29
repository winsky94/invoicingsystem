package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CouponPO;

public interface CouponDataService extends Remote{
	public ArrayList<CouponPO> getAllCoupon()throws RemoteException;
	public void addCoupon(ArrayList<CouponPO> po)throws RemoteException;
	public void deleteCoupon(String id)throws RemoteException;
	

}
