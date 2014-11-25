package businesslogic.memberbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;
import dataservice.memberdataservice.MemberDataService;
import dataservice.userdataservice.UserDataService;
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
	public Member(MemBaseInfo bInfo,MemAccountInfo aInfo,MemContactInfo cInfo) throws MalformedURLException, RemoteException, NotBoundException{
		this();
		this.bInfo=bInfo;
		this.aInfo=aInfo;
		this.cInfo=cInfo;	
	}
	public int addMember(MemberVO vo) {
		// TODO Auto-generated method stub
		MemberPO po=voToPo(vo);
		return service.add(po);
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
	public MemberVO findMember(String message) {
		// TODO Auto-generated method stu
		return poToVo(service.find(message));
	}

	public ArrayList<MemberVO> showMembers() {
		// TODO Auto-generated method stub
		ArrayList<MemberPO> po=service.showAll();
		ArrayList<MemberVO> vo=new ArrayList<MemberVO>();
		for(int i=0;i<po.size();i++)
			vo.add(poToVo(po.get(i)));
		return vo;
	}
	public void updatePoints(double pointsToAdd){
		bInfo.points+=pointsToAdd;
		
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
				,vo.getMaxOwe(),vo.getToReceive(),vo.getToPay());
		po.setPoints(vo.getPoints());
		return po;
	}
	public MemberVO poToVo(MemberPO po){
	   bInfo=new MemBaseInfo(po.getmType(),po.getmLevel(),po.getMemberID(),po.getName(),po.getPoints());
	   aInfo=new MemAccountInfo(po.getMaxOwe(),po.getToReceive(),po.getToPay());
	   cInfo=new MemContactInfo(po.getTel(),po.getAddress(),po.getPostcode(),po.getEMail());
	   MemberVO vo=new MemberVO(bInfo,aInfo,cInfo);
	   return vo;
		
	}
	

}
