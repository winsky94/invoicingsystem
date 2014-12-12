package businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.CollectionPO;
import po.TransferItemPO;
import vo.CollectionVO;
import vo.ReceiptVO;
import vo.TransferItemVO;
import businesslogic.memberbl.Member;
import businesslogic.receiptbl.Receipt;
import businesslogic.utilitybl.getDate;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;
import dataservice.financedataservice.listdataservice.CollectionDataService;


public class Collection extends Receipt implements CollectionBLService{

	 String ID;
     String supplier;
     String seller;
     String user;
     ArrayList<TransferItem> transferlist=new ArrayList<TransferItem>();
     CollectionDataService service;
     double totalMoney;
     public Collection()throws Exception{
 //   	System.setSecurityManager(new SecurityManager());
 		String host="localhost:1099";
 		String url="rmi://"+host+"/collectionService";
 	
 		service=(CollectionDataService)Naming.lookup(url);
     }
    
/*	 public Collection(String id,  String memberID,
			String memberName,String userID,Date date, int hurry, int status,
			String info,String sid,double Money) throws Exception{
		super(id,memberID,memberName, userID, ReceiptType.COLLECTION, date, hurry, status, info,sid);
		// TODO Auto-generated constructor stub
		this.totalMoney=Money;
	}
*/

	

    
  /*  public Collection(MockMember b,MockMember c,double m){
   	 this(null,b,c,null,null,m);
    }  */
    
   /* public Collection(String a,MockMember b,MockMember j,String c,ArrayList<TransferItem> d,double e){
   	 ID=a;
   	 supplier=b;
   	 seller=j;
   	 user=c;
   	 transferlist=d;
   	 totalMoney=e;
    }
    */
	
     public String getNewID() {
    	 String id=null;
 		ArrayList<CollectionPO> po=service.getCollection();
 		if(po==null) id="00001";
 		else{
 			int i=po.size();
 			String date=po.get(i-1).getId().substring(4, 12);
			if(date.equals(getDate.getdate())){
 			Double d=Double.parseDouble(po.get(i-1).getId().substring(13))+1;
 			 NumberFormat nf = NumberFormat.getInstance();
 		     nf.setMinimumIntegerDigits(5); 
 		     nf.setGroupingUsed(false);
 		     id=nf.format(d);}
			else id="00001";
 			
 		}
 		return "SKD-"+getDate.getdate()+"-"+id;
 	}
     
    public int excute(ReceiptVO v){
    	CollectionVO vo=(CollectionVO)v;
    	try {
			Member m=new Member();
			m.changeToPay(vo.getSupplier(), vo.getTotalMoney());
			m.changeToPay(vo.getSeller(), (-1)*vo.getTotalMoney());
			Account a=new Account();
			ArrayList<TransferItemVO> ts=vo.getTransferlist();
			for(TransferItemVO vv:ts){
				a.addMoney(vv.getAccount(),vv.getMoney());
			}
			System.out.println("执行成功！");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	setStatus(v.getId(),3);
    	return 0;
    	
    }
    
  
	public int createCollection(CollectionVO vo) {
		
		CollectionPO po=voToPo(vo);
		return service.createCollection(po);
//		System.out.println(vo.getID()+" "+vo.getSupplier()+" "+vo.getSeller()+" "+vo.getUser()+" "+b.get(0).getAccount()+" "+vo.getTotalMoney());		
	}
	
	public ArrayList<CollectionVO> getCollection(){
		ArrayList<CollectionPO>	po = service.getCollection();
		if(po==null) return null;
		
		else return poToVo(po);
		
	}
	
	public CollectionVO findByID(String s){
		return poToVo(service.findByID(s));
	}
	
	public CollectionPO voToPo(CollectionVO vo){
		if(vo==null)
			return null;
		 ArrayList<TransferItemVO> a=vo.getTransferlist();
		 ArrayList<TransferItemPO> b=new ArrayList<TransferItemPO>();
		 TransferItemPO po1;
		 for(int i=0;i<a.size();i++){
			 TransferItemVO vo1=a.get(i);
			 po1=new TransferItemPO(vo1.getAccount(),vo1.getMoney(),vo1.getInfo());
			 b.add(po1);
		 }
	
		CollectionPO po=new CollectionPO(vo.getId(),vo.getSupplier(),vo.getSeller(),vo.getUser(),b,vo.getTotalMoney(),vo.getStatus(),vo.getHurry());
		return po;
	}

	
	public static  CollectionVO poToVo(CollectionPO po){
		if(po==null)
			return null;
		 ArrayList<TransferItemPO> a=po.getTransferlist();
		 ArrayList<TransferItemVO> b=new ArrayList<TransferItemVO>();
		 TransferItemVO vo1;
		 for(int i=0;i<a.size();i++){
			 TransferItemPO po1=a.get(i);
			 vo1=new TransferItemVO(po1.getAccount(),po1.getMoney(),po1.getInfo());
			 b.add(vo1);
		 }
	
		CollectionVO vo=new CollectionVO(po.getId(),po.getSupplier(),po.getSeller(),po.getUserID(),b,po.getTotalMoney(),po.getStatus(),po.getHurry());
		return vo;
	}
	
	public ArrayList<CollectionPO> voToPo(ArrayList<CollectionVO> vo){
		if(vo==null)
			return null;
		ArrayList<CollectionPO> po=new ArrayList<CollectionPO>();
		for(CollectionVO v:vo){
			CollectionPO p=voToPo(v);
			po.add(p);
		}
		return po;
	}

	public ArrayList<CollectionVO> poToVo(ArrayList<CollectionPO> po){
		if(po==null)
			return null;
		ArrayList<CollectionVO> vo=new ArrayList<CollectionVO>();
		for(CollectionPO p:po){
			CollectionVO v=poToVo(p);
			vo.add(v);
		}
		return vo;
	}
}
