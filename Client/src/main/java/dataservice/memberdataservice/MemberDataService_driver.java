package dataservice.memberdataservice;

public class MemberDataService_driver {
	public void drive(MemberDataService memberDataService){
		memberDataService.add(new MemberPO());
		memberDataService.delete(new MemberPO());
		memberDataService.modify(new MemberPO());
		memberDataService.find(new String());
	}
	public static void main(String[] args){
		MemberDataService_driver driver=new MemberDataService_driver();
		driver.drive(new MemberDataService_stub());
	}
}
