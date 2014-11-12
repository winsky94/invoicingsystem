package Member;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

import po.MemberPO;
import dataservice.memberdataservice.MemberDataService;
import dataservice.memberdataservice.MemberDataService_stub;

public class MemberDataService_DriverTest extends TestCase{
	private MemberDataService m;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream beos = null;

	// --------------------------------------------
	public void setUp() {
		m = new MemberDataService_stub();
		beos = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(beos));
	}

	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void test() {
		MemberPO po = new MemberPO(line, null, null, line, line, line, line,
				line, line, 0, 0, 0);
		String message = "";
		m.add(po);
		m.delete(po);
		m.modify(po);
		m.find(message);
		assertEquals("Add Successfully!" + line
				+ "Delete Successfully!" + line
				+ "Modify Successfully!" + line
				+ "Find Successfully!" + line,beos.toString());
	}

}
