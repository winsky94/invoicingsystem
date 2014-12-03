package Data.stockdata.gift;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.GiftPO;
import Data.serutility.JXCFile;
import dataservice.stockdataservice.giftdataservice.GiftDataService;

public class Gift extends UnicastRemoteObject implements GiftDataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JXCFile file;

	public Gift() throws RemoteException {
		file = new JXCFile("src/main/java/gift.ser");
	}

	public int addGift(GiftPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		file.write(po);
		return 0;
	}

	// 注：处理库存赠送单的时候只需要将单据状态改变就好了，修改库存操作已在bl层处理过
	public int dealGift(GiftPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> list = new ArrayList<Object>();
		list = file.read();
		for (int i = 0; i < list.size(); i++) {
			GiftPO giftPO = (GiftPO) list.get(i);
			if (giftPO.getId().equals(po.getId())) {
				po.setStatus(3);
				list.set(i, po);
				break;
			}
		}

		file.writeM(list);
		return 0;
	}

	public ArrayList<GiftPO> getGiftList() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> list = new ArrayList<Object>();
		list = file.read();
		ArrayList<GiftPO> result = new ArrayList<GiftPO>();
		for (int i = 0; i < result.size(); i++) {
			GiftPO po = (GiftPO) list.get(i);
			result.add(po);
		}

		return result;
	}

	public ArrayList<GiftPO> getGiftList(String beginDate, String endDate)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<GiftPO> list = new ArrayList<GiftPO>();
		ArrayList<GiftPO> result = new ArrayList<GiftPO>();
		list = getGiftList();

		for (GiftPO po : list) {
			if ((beginDate.compareTo(po.getDate()) <= 0)
					&& (endDate.compareTo(po.getDate()) >= 0)) {
				result.add(po);
			}
		}

		return result;
	}

	public String getMaxID() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<GiftPO> list = getGiftList();
		String result = "";
		if (list.size() != 0) {
			result = list.get(0).getId();

			for (int i = 0; i < list.size(); i++) {
				if (result.compareTo(list.get(i).getId()) < 0) {
					result = list.get(i).getId();
				}

			}
			return result;
		} else {
			return null;
		}
	}

}
