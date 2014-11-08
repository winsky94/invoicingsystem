package businesslogicservice.memberblservice;

import vo.MemberVO;

public class MemberBLService_driver {
	public void drive(MemberBLService memberBLService){
		memberBLService.addMember(new MemberVO(null, null, null, null, null, null, null, null, null, 0, 0, 0));
		memberBLService.deleteMember(new MemberVO(null, null, null, null, null, null, null, null, null, 0, 0, 0));
		memberBLService.modifyMember(new MemberVO(null, null, null, null, null, null, null, null, null, 0, 0, 0));
		memberBLService.findMember(new String());
	}
	public static void main(String[] args){
		MemberBLService_driver driver=new MemberBLService_driver();
		driver.drive(new MemberBLService_stub());
	}
}
