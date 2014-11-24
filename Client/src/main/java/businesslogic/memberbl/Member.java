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
		return 0;
	}

	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifyMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemberVO findMember(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MemberVO> showMembers() {
		// TODO Auto-generated method stub
		return null;
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
		
	}
	public MemberVO poToVo(MemberPO po){
		
	}

}
