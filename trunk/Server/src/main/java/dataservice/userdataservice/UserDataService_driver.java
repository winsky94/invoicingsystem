package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.*;

public class UserDataService_driver {
	public void drive(UserDataService_stub userDataService)
			throws RemoteException {
		userDataService.add(new UserPO("小赵", "00001", "123456", "库存管理员"));
		userDataService.delete(new UserPO("小赵", "00001", "123456", "库存管理员"));
		userDataService.modify(new UserPO("小赵", "00001", "123456", "库存管理员"));
		userDataService.showUserInfo("00001");
	}

	public static void main(String[] args) throws RemoteException {
		UserDataService_stub userDataService = new UserDataService_stub();
		UserDataService_driver driver = new UserDataService_driver();
		driver.drive(userDataService);
	}
}
