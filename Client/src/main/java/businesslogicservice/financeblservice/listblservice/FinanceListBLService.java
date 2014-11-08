package businesslogicservice.financeblservice.listblservice;

import vo.CashlistVO;
import vo.CollectionVO;
import vo.PaymentVO;
import vo.ReceiptVO;

public interface FinanceListBLService {
	public int createCollection(CollectionVO vo);
    public int createPayment(PaymentVO vo);
    public int createCashlist(CashlistVO vo);
    public int createRedExtrusion(ReceiptVO vo);
    public int createRedExtrusionAndCopy(ReceiptVO vo);
}
