package dataservice.userdataservice;

import java.rmi.RemoteException;

import businesslogic.userbl.UserType;
import po.UserPO;

public class UserDataService_driver {
	public void drive(UserDataService_stub userDataService)
			throws RemoteException {
		userDataService.login("00001", "123456");
		userDataService.add(new UserPO("小赵", "00001", "123456", UserType.STOCK));
		userDataService.delete(new UserPO("小赵", "00001", "123456", UserType.STOCK));
		userDataService.modify(new UserPO("小赵", "00001", "123456", UserType.STOCK));
		userDataService.showUserInfo("00001");
	}

	public static void main(String[] args) throws RemoteException {
		UserDataService_stub userDataService = new UserDataService_stub();
		UserDataService_driver driver = new UserDataService_driver();
		driver.drive(userDataService);
	}
}
