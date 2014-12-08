package businesslogic.receiptbl;

import java.util.ArrayList;

import po.ReceiptPO;
import vo.ReceiptVO;
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
		ReceiptVO vo=new ReceiptVO(po.getId(),po.getMemberName(),
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
