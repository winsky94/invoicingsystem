package dataservice.financedataservice.listdataservice;

import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import po.ReceiptPO;


public interface FinanceListDataService {
	public int createCollection (CollectionPO po);
    public int createPayment(PaymentPO po);
    public int createCashlist (CashlistPO po) ;
    public int createRedExtrusion(ReceiptPO vo);
    public int createRedExtrusionAndCopy(ReceiptPO vo);
}
