package businesslogic.memberbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;

import po.MemberPO;
import po.MemberPO.MemberType;
import dataservice.memberdataservice.MemberDataService;
import vo.MemberVO;
import businesslogicservice.memberblservice.MemberBLService;

public class Member implements MemberBLService{
	 MemBaseInfo bInfo;
	 MemAccountInfo aInfo;
	 private MemContactInfo cInfo;
	 private MemberDataService service;
	
	
	public Member() throws MalformedURLException, RemoteException, NotBoundException{
		String host="localhost:1099";
		String url="rmi://"+host+"/memberService";
	
		service=(MemberDataService)Naming.lookup(url);
	
		
	}
	
	public int addMember(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberPO po=voToPo(vo);
		
		return  service.add(po);
		
	}

	public int deleteMember(String memID) {
		// TODO Auto-generated method stub
		return service.delete(memID);
	}

	public int modifyMember(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberPO po=voToPo(vo);
		return service.modify(po);
	}

	//可能返回为NULL
	public ArrayList<MemberVO> findMember(String message) {
		// TODO Auto-generated method stu
		ArrayList<MemberPO> po=service.find(message);
		ArrayList<MemberVO> vo=new ArrayList<MemberVO>();
		for(int i=0;i<po.size();i++){
			vo.add(poToVo(po.get(i)));
		}
		return vo;
	}

	public ArrayList<MemberVO> showMembers() {
		// TODO Auto-generated method stub
		ArrayList<MemberPO> po=service.showAll();
		ArrayList<MemberVO> vo=new ArrayList<MemberVO>();
		for(int i=0;i<po.size();i++)
			vo.add(poToVo(po.get(i)));
		return vo;
	}
	
	//一百元一个积分
	public void updatePoints(double price){
		bInfo.points+=(price/100);
		
	}
	public void updateToReceive(double data){
		aInfo.setToReceive(data);
		
	}
	public void updateToPay(double data){
		aInfo.setToPay(data);
	}
	
	public MemberPO voToPo(MemberVO vo){
		MemberPO po=new MemberPO(vo.getMemberID(),vo.getmType(),vo.getmLevel(),vo.getName(),
				vo.getTel(),vo.getAddress(),vo.getPostcode(),vo.getEMail(),vo.getDefaultClerk()
				,vo.getMaxOwe(),vo.getToReceive(),vo.getToPay(),vo.getPoints());
		
		return po;
	}
	
	public ArrayList<MemberPO> voToPo(ArrayList<MemberVO> vo){
		ArrayList<MemberPO> po=new ArrayList<MemberPO>();
		for(int i=0;i<vo.size();i++){
			MemberPO p=voToPo(vo.get(i));
			po.add(p);
		}
		return po;
	}
	
	public MemberVO poToVo(MemberPO po){
	   bInfo=new MemBaseInfo(po.getmType(),po.getmLevel(),po.getMemberID(),po.getName(),po.getPoints(),po.getDefaultClerk());
	   aInfo=new MemAccountInfo(po.getMaxOwe(),po.getToReceive(),po.getToPay());
	   cInfo=new MemContactInfo(po.getTel(),po.getAddress(),po.getPostcode(),po.getEMail());
	   MemberVO vo=new MemberVO(bInfo,aInfo,cInfo);
	   return vo;
		
	}
	
	public ArrayList<MemberVO> poToVo(ArrayList<MemberPO> po){
		ArrayList<MemberVO> vo=new ArrayList<MemberVO>();
		for(int i=0;i<po.size();i++){
			MemberVO v=poToVo(po.get(i));
			vo.add(v);
		}
		return vo;
	}
	
	public String getNewID(MemberType type) {
		// TODO Auto-generated method stub
		ArrayList<MemberPO> po=service.showAll();
		String lastID=null;
		for(int i=0;i<po.size();i++){
			if(po.get(i).getmType()==type)
				{lastID=po.get(i).getMemberID();}
		}
		if(lastID!=null)
		{	
			double d=Double.parseDouble(lastID.substring(4,11))+1;
		     NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(7); 
		     nf.setGroupingUsed(false);
		     lastID=nf.format(d);
		}
		
		else lastID="0000001";
		if(type==MemberType.JHS)
			return "JHS-"+lastID;
		else 
			return "XSS-"+lastID;
	}

	public MemberVO findById(String ID) {
		// TODO Auto-generated method stub
		return poToVo(service.findByID(ID));
	}

	
	

}
