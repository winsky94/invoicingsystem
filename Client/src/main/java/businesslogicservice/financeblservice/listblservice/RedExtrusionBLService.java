package businesslogicservice.financeblservice.listblservice;

import vo.ReceiptVO;

public interface RedExtrusionBLService {
	public int createRedExtrusion(ReceiptVO vo);
    public int createRedExtrusionAndCopy(ReceiptVO vo);
}
