package Data.promotiondata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.serutility.JXCFile;
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
		file=new JXCFile("src/main/java/user.ser");
	}
	
	public int Add(PromotionPO po) throws RemoteException {
		if(po.getType()==PromotionType.DISCOUNT){
			
		}
		return 0;
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

}
