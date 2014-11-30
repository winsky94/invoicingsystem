package Data.memberdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Data.serutility.JXCFile;
import po.MemberPO;
import po.MemberPO.MemberType;
import dataservice.memberdataservice.MemberDataService;

public class Member extends UnicastRemoteObject implements MemberDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JXCFile file;

	public Member() throws RemoteException {
		super();
		file=new JXCFile("src/main/java/member.ser");
	}

	public int add(MemberPO po) {
		file.write(po);
		return 0;
	}

	public int delete(String id) {
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	  //不存在该用户	
		int i;
		for(i=0;i<a.size();i++){
			MemberPO b=(MemberPO)a.get(i);
			if(b.getMemberID().equals(id)){
				a.remove(i);
				break;
			}
		}
		
		if(i==a.size())      //不存在该用户
			return 1;
		
		file.writeM(a);
		return 0;
	}

	public int modify(MemberPO po) {
		ArrayList<Object> a=file.read();
		if(a==null)
			return 1;  	  //不存在该用户	
		int i;
		for(i=0;i<a.size();i++){
			MemberPO b=(MemberPO)a.get(i);
			if(b.getMemberID().equals(po.getMemberID())){
				b.setAddress(po.getAddress());
				b.setDefaultClerk(po.getDefaultClerk());
				b.setEMail(po.getEMail());
				b.setMaxOwe(po.getMaxOwe());
				b.setmLevel(po.getmLevel());
				b.setName(po.getName());
				b.setPoints(po.getPoints());
				b.setPostcode(po.getPostcode());
				b.setTel(po.getTel());
				b.setToPay(po.getToPay());
				b.setToReceive(po.getToReceive());
				break;
			}
		}
		
		if(i==a.size())      //不存在该用户
			return 1;
		
		file.writeM(a);
		return 0;
	}

	public ArrayList<MemberPO> find(String message) {
		ArrayList<MemberPO> buffer=new ArrayList<MemberPO>();
		ArrayList<Object> a=file.read();
		String s1="进货商";
		String s2="销售商";
		if(a==null)
			return null;
		for(Object b:a){
			MemberPO c=(MemberPO)b;
			if(c.getMemberID().contains(message))
				buffer.add(c);
			else if(s1.contains(message)){
				if(c.getmType()==MemberType.JHS)
				  buffer.add(c);
			}
			else if(s2.contains(message)){
				if(c.getmType()==MemberType.XSS)
					buffer.add(c);
			}
			else if(c.getName().contains(message)){
				buffer.add(c);
			}
			else if(c.getAddress().contains(message)){
				buffer.add(c);
			}
			else if(c.getTel().contains(message)){
				buffer.add(c);
			}
			else if(c.getEMail().contains(message)){
				buffer.add(c);
			}
			else if(c.getPostcode().contains(message)){
				buffer.add(c);
			}
			else if(c.getDefaultClerk().contains(message)){
				buffer.add(c);
			}
		}
		if(buffer.size()==0)
		    return null;
		return buffer;
	}

	public ArrayList<MemberPO> showAll() throws RemoteException {
		ArrayList<Object> a=file.read();
		if(a==null)
			return null;
		
		ArrayList<MemberPO> buffer=new ArrayList<MemberPO>();
		for(Object b:a){
			MemberPO c=(MemberPO)b;
			buffer.add(c);
		}
		
		  return buffer;
	}
	
	public int getNum(MemberType type){
		ArrayList<Object> a=file.read();
		int num=0;
		
		if(a==null)
			return 0;
		else{
			for(Object b:a){
				MemberPO c=(MemberPO)b;
				if(c.getmType()==type){
					num++;
				}
			}
		}
        return num;
	}

}
