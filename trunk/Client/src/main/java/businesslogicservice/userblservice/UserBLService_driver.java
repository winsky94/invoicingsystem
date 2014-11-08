package businesslogicservice.userblservice;

import vo.UserVO;

public class UserBLService_driver {
	public void drive(UserBLService_stub userBLService) {
		userBLService.login("00001", "123456");
		userBLService.addUser(new UserVO("小赵", "00001", "123456", "库存管理员"));
		userBLService.deleteUser(new UserVO("小赵", "00001", "123456", "库存管理员"));
		userBLService.modifyUser(new UserVO("小赵", "00001", "123456", "库存管理员"));
		userBLService.showUser("00001");
	}

	public static void main(String[] args) {
		UserBLService_stub userBLService = new UserBLService_stub();
		UserBLService_driver driver = new UserBLService_driver();
		driver.drive(userBLService);
	}
}
