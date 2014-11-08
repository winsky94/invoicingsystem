package User;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import vo.UserVO;
import businesslogicservice.userblservice.UserBLService;
import businesslogicservice.userblservice.UserBLService_stub;

public class UserBLService_DriverTest extends TestCase {
	private UserBLService userBLService;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream bytes = null;

	public void setUp() {
		UserBLService userbl_stub = new UserBLService_stub();
		userBLService = userbl_stub;
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	public void tearDown() {
		System.setOut(console);
	}

	public void testStockGoodsBLDrive() {
		UserVO vo = new UserVO(null, null, null, null);
		int resultAdd = userBLService.addUser(vo);
		int resultMod = userBLService.modifyUser(vo);
		int resultDel = userBLService.deleteUser(vo);
		int resultLog = userBLService.login(null, null);
		userBLService.showUser(null);

		assertEquals(0, resultAdd);
		assertEquals(0, resultMod);
		assertEquals(0, resultDel);
		assertEquals(0, resultLog);

		assertEquals("Add user succeed!" + line
				+ "Modify user succeed!" + line
				+ "delete user succeed!" + line
				+ "Login succeed!" + line
				+ "Show users succeed!" + line,bytes.toString());

	}
}
