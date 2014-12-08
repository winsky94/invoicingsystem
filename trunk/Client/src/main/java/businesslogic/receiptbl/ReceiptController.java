package businesslogic.receiptbl;

import java.util.ArrayList;

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
import vo.ReceiptVO;
import businesslogic.financebl.CashList;
import businesslogic.financebl.Collection;
import businesslogic.financebl.Payment;
import businesslogic.salesbl.Purchase;
import businesslogic.salesbl.PurchaseReturn;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SaleReturn;
import businesslogic.stockbl.gift.GiftManage;
import businesslogicservice.receiptblservice.ReceiptBLService;

public class ReceiptController implements ReceiptBLService{
	ReceiptList list;
	public ReceiptController() throws Exception{
		list=new ReceiptList();
		
	}

	
	
	public int Add(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Modify(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Batch(String[] id,int status) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void Send(ReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

	public void Reply(String userid) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ReceiptVO> View() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceiptVO> Refresh() {
		// TODO Auto-generated method stub
		return null;
	}

	public int Approve(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ReceiptVO View(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<ReceiptVO>  showAll(){
		try {
			list=new ReceiptList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ReceiptPO> po=list.showAllReceipt();
		if(po==null) return null;
		else{
			ArrayList<ReceiptVO> vo=new ArrayList<ReceiptVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	public int Batch(String[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ReceiptVO  poToVo(ReceiptPO po){
		ReceiptVO vo=null;
		if(po.getType()==ReceiptType.PAYMENT)
			vo=Payment.poToVo((PaymentPO)po);
		else if(po.getType()==ReceiptType.COLLECTION){
			vo=Collection.poToVo((CollectionPO)po);
		}else if(po.getType()==ReceiptType.SALE)
			vo=Sale.poToVo((SalePO)po);
		else if(po.getType()==ReceiptType.SALERETURN)
			vo=SaleReturn.poToVo((SaleReturnPO)po);
		else if(po.getType()==ReceiptType.PURCHASE)
			vo=Purchase.poToVo((PurchasePO)po);
		else if(po.getType()==ReceiptType.PURCHASERETURN)
			vo=PurchaseReturn.poToVo((PurchaseReturnPO)po);
		else if(po.getType()==ReceiptType.CASHLIST)
			vo=CashList.poToVo((CashlistPO)po);
		else if(po.getType()==ReceiptType.GIFT)
		{
			vo=GiftManage.giftPOToVO((GiftPO)po);
			}
		else  vo=new ReceiptVO(po.getId(),po.getMemberName(),
				po.getMemberID(),po.getUserID(),po.getType(),po.getStatus(),
				po.getHurry(),po.getInfo());
		
		return vo;
	}
	
	public ArrayList<ReceiptVO> poTVo(ArrayList<ReceiptPO> po){
		ArrayList<ReceiptVO> vo=new ArrayList<ReceiptVO>();
		for(int i=0;i<po.size();i++)
			vo.add(poToVo(po.get(i)));
		return vo;
	}



	public ArrayList<ReceiptVO> ToApprove() {
		// TODO Auto-generated method stub
		if(list.showToApprove()!=null)
			return poTVo(list.showToApprove()) ;
		else return null;
	}



	public ArrayList<ReceiptVO> Approved() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
