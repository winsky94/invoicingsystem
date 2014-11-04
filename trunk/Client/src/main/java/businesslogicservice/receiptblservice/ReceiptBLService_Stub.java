package businesslogicservice.receiptblservice;

import java.util.ArrayList;

import vo.ReceiptVO;


public class ReceiptBLService_Stub implements ReceiptBLService{
	public int Add(ReceiptVO vo){
		//TODO Auto-generated method stub 
		System.out.println("Add Receipt Success!");
		return 0;
	}

	public int Modify(String id){
		//TODO Auto-generated method stub 
		if(id.equals("SKD-20141015-00001")) return 1;
		System.out.println("Modify Receipt (id="+id+") Success!");
		return 0;
	}

	public int Batch(String[] id){
		//TODO Auto-generated method stub
		for(int i=0;i<id.length;i++)
			System.out.println("Batch Receipt(id="+id[i]+") Success!");
        return 0;
	}

	public void Send(ReceiptVO vo){
		//TODO Auto-generated method stub
		System.out.println("Send Receipt Success!");
	}

	public void Reply(String Userid){
		//TODO Auto-generated method stub
		System.out.println("Reply to the User(id="+Userid+") Success!");
	}

	public ArrayList<ReceiptVO> View(){
		//TODO Auto-generated method stub
		ArrayList<ReceiptVO> receiptVO=new ArrayList<ReceiptVO>();
        System.out.println("View All Receipt Success!");
        return receiptVO;
	}

	public ArrayList<ReceiptVO> Refresh(){
		//TODO Auto-generated method stub
		ArrayList<ReceiptVO> receiptVO=new ArrayList<ReceiptVO>();
		System.out.println("Refresh Receipt Success!");
		return receiptVO;
	}

	public int Approve(String id){
		//TODO Auto-generated method stub
		System.out.println("Approve Receipt(id="+id+") Success!");
		return 0;
	}

	

	public ReceiptVO View(String id) {
		// TODO Auto-generated method stub
		return null;
	}





}