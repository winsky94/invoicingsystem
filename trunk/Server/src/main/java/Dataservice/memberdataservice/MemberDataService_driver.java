package Dataservice.memberdataservice;

import po.MemberPO;

public class MemberDataService_driver {
	public void drive(MemberDataService memberDataService){
		memberDataService.add(new MemberPO(null, null, null, null, null, null, null, null, null, 0, 0, 0));
		memberDataService.delete(new MemberPO(null, null, null, null, null, null, null, null, null, 0, 0, 0));
		memberDataService.modify(new MemberPO(null, null, null, null, null, null, null, null, null, 0, 0, 0));
		memberDataService.find(new String());
	}
	public static void main(String[] args){
		MemberDataService_driver driver=new MemberDataService_driver();
		driver.drive(new MemberDataService_stub());
	}
}
