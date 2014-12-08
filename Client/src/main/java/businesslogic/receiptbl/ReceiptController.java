package businesslogic.receiptbl;

import java.util.ArrayList;

import po.ReceiptPO;
import vo.ReceiptVO;
import businesslogicservice.receiptblservice.ReceiptBLService;

public class ReceiptController implements ReceiptBLService{
	ReceiptList list;
	public ReceiptController(){
		
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
		return list.showAllReceipt();
	}

	public int Batch(String[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ReceiptVO  poToVo(ReceiptPO po){
		ReceiptVO vo=new ReceiptVO(po.getId(),po.getType(),po.getUserID(),po.getStatus(),
				po.getHurry());
	}
}
