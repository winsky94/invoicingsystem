package Data.stockdata.gift;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import po.GiftPO;
import po.ReceiptPO;
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
	//状态也不要改啦，直接生产的时候就是3——处理成功
	public int dealGift(GiftPO po) throws RemoteException {
		// TODO 自动生成的方法存根
//		ArrayList<Object> list = new ArrayList<Object>();
//		list = file.read();
//		for (int i = 0; i < list.size(); i++) {
//			GiftPO giftPO = (GiftPO) list.get(i);
//			if (giftPO.getId().equals(po.getId())) {
//				po.setStatus(3);
//				list.set(i, po);
//				break;
//			}
//		}
//
//		file.writeM(list);
		
		return 0;
	}
	
	public int modify(ReceiptPO po){
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	 
		int i;
		for(i=0;i<a.size();i++){
			ReceiptPO b=(ReceiptPO)a.get(i);
			if(b.getId().equals(po.getId())){
				b.setInfo(po.getInfo());
				break;
			}
		}
		
		if(i==a.size())      //不存在该用户
			return 1;
		
		file.writeM(a);
		return 0;
	}

	public ArrayList<GiftPO> getGiftList() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<Object> list = new ArrayList<Object>();
		list = file.read();
		ArrayList<GiftPO> result = new ArrayList<GiftPO>();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				GiftPO po = (GiftPO) list.get(i);
				result.add(po);
			}
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
			if ((beginDate.compareTo(po.getDate().replace("/", "")) <= 0)
					&& (endDate.compareTo(po.getDate().replace("/", "")) >= 0)) {
				result.add(po);
			}
		}
		return result;
	}

	public String getMaxID() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<GiftPO> list = getGiftList();
		String result = "";

		if (list.size() == 0) {
			return null;
		} else {
			String today = getDate();
			int index = -1;
			for (int i = list.size() - 1; i >= 0; i--) {
				String tpID = list.get(i).getId();
				String temID[] = tpID.split("-");
				if (today.equals(temID[1])) {
					index = i;
					break;
				}
			}
			if (index == -1) {
				return null;
			} else {
				String id = list.get(index).getId();
				String tempID[] = id.split("-");
				result = tempID[2];
				for (int i = 0; i < list.size(); i++) {

					String tpID = list.get(i).getId();
					String temID[] = tpID.split("-");

					if (today.equals(temID[1])
							&& result.compareTo(temID[2]) < 0) {
						result = temID[2];
					}

				}
				return result;
			}
		}
	}

	public GiftPO findByID(String id) throws RemoteException {
		GiftPO po = null;
		ArrayList<GiftPO> list = getGiftList();
		if (list != null) {
			for (GiftPO p : list) {
				if (p.getId().equals(id)) {
					po = p;
					break;
				}
			}
		}
		return po;
	}

	private String getDate() {
		Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		String sysDatetime = fmt.format(rightNow.getTime());

		return sysDatetime;
	}
}
