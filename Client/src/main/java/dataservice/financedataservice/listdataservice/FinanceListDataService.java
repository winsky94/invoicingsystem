package dataservice.financedataservice.listdataservice;

import po.CashlistPO;
import po.CollectionPO;
import po.PaymentPO;
import vo.ReceiptVO;

public interface FinanceListDataService {
	public int createCollection (CollectionPO po);
    public int createPayment(PaymentPO po);
    public int createCashlist (CashlistPO po) ;
    public int createRedExtrusion(ReceiptVO vo);
    public int createRedExtrusionAndCopy(ReceiptVO vo);
}
