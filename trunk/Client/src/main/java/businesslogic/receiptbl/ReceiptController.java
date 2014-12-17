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
import po.StockOverOrLowPO;
import vo.ReceiptMessageVO;
import vo.ReceiptVO;
import vo.StockOverOrLowVO;
import businesslogic.financebl.CashList;
import businesslogic.financebl.Collection;
import businesslogic.financebl.Payment;
import businesslogic.salesbl.Purchase;
import businesslogic.salesbl.PurchaseReturn;
import businesslogic.salesbl.Sale;
import businesslogic.salesbl.SaleList;
import businesslogic.salesbl.SaleReturn;
import businesslogic.stockbl.gift.GiftManage;
import businesslogic.stockbl.stockManage.StockManage;
import businesslogicservice.receiptblservice.ReceiptBLService;
import businesslogicservice.receiptblservice.ReceiptListService;
import businesslogicservice.receiptblservice.ReceiptTipService;

public class ReceiptController implements ReceiptBLService,ReceiptListService{
	ReceiptList list;
	Review review;
	public ReceiptController() throws Exception{
		list=new ReceiptList();
		review=new Review();
		
	}

	
	
	

	public int Modify(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Batch(String[] id,int status) {
		// TODO Auto-generated method stub
		boolean tag=true;
		for(int i=0;i<id.length;i++)
			if(review.Approve(id[i], status)!=0)
				tag=false;
		if(tag)return 0;
		else return 1;
	}

	

	public ArrayList<ReceiptVO> View() {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> po=list.showAllReceipt();
		if(po==null) return null;
		else{
			ArrayList<ReceiptVO> vo=new ArrayList<ReceiptVO>();
			for(int i=0;i<po.size();i++)
				vo.add(poToVo(po.get(i)));
			return vo;
		}
	}

	public ArrayList<ReceiptVO> Refresh() {
		// TODO Auto-generated method stub
		return null;
	}

	public int Approve(String id,int status) {
		// TODO Auto-generated method stub
		
		return review.Approve(id, status);
	}

	public ReceiptVO View(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public ArrayList<ReceiptVO>  showAll(){
		try {
			list=new ReceiptList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/

	

	
	public static ReceiptVO  poToVo(ReceiptPO po){
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
		
		}else if(po.getType()==ReceiptType.STOCKLOW||po.getType()==ReceiptType.STOCKOVER){
			StockOverOrLowPO p=(StockOverOrLowPO)po;
			 vo = new StockOverOrLowVO(p.getId(),
						p.getUserID(), p.getType(), p.getStatus(),
						p.getHurry(), p.getInfo(), p.getGoodsName(),
						p.getSize(), p.getNum(), p.getExactNum());
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
		if(list.showApproved()!=null)
			return poTVo(list.showApproved());
		else return null;
	}

	@Override
	public ArrayList<ReceiptVO> getSale()  {
		// TODO Auto-generated method stub
		SaleList sale=null;
		try {
			sale = new SaleList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sale.getAllSale();
	}


	@Override
	public ArrayList<ReceiptVO> AccurateFind(String[] message) {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> po=list.AccurateFind(message);
		if(po==null) return null;
		else 
			return poTVo(po);
	}


	public ReceiptVO RedAndCopy(String id) {
		// TODO Auto-generated method stub
		ReceiptVO vo=null;
		ReceiptPO po=review.View(id);
		Red(id);
		if(po!=null)
			vo=poToVo(po);
		return vo;
	}


	public int Red(String id) {
		// TODO Auto-generated method stub
		ReceiptPO po=review.View(id);
		po=review.Red(po);
		int redResult=0;
		try {
			
			//红冲执行
			redResult = review.Excute(poToVo(po), 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//直接红冲执行入账
		return redResult;
	}

}
	
	
	

