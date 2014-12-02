package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionPO;
import po.PromotionPO.PromotionType;

public interface PromotionDataService extends Remote{
	
		public int Add(PromotionPO po)throws RemoteException;
		public PromotionPO find(String id,PromotionType type)throws RemoteException;
		public int Delete(String id,PromotionType type)throws RemoteException;;
		public int Modify(PromotionPO po)throws RemoteException;
		public ArrayList<PromotionPO>show()throws RemoteException;
		//促销有不同类型存储在不同的ser文件里  所以data层需要判断po的PromotionType  做不同的转换
		//存入 不同的文件   to小小黄

	
}
