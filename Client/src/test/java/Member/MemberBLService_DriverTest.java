package Member;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.Test;

import vo.MemberVO;
import businesslogicservice.memberblservice.MemberBLService;
import businesslogicservice.memberblservice.MemberBLService_stub;

public class MemberBLService_DriverTest extends TestCase {
	private MemberBLService m;
	String line = System.getProperty("line.separator");
	PrintStream console = null;
	ByteArrayOutputStream beos = null;

	// --------------------------------------------
	public void setUp() {
		m = new MemberBLService_stub();
		beos = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(beos));
	}

	public void tearDown() {
		System.setOut(console);
	}

	@Test
	public void test() {
		MemberVO vo = new MemberVO(line, null, null, line, line, line, line,
				line, line, 0, 0, 0);
		String message = "";
		int resultAdd = m.addMember(vo);
		int resultDel = m.deleteMember(vo);
		int resultMod = m.modifyMember(vo);
		m.findMember(message);
		m.showMembers();
		assertEquals(0, resultAdd);
		assertEquals(0, resultDel);
		assertEquals(0, resultMod);
		assertEquals("Add Member Successfully!" + line
				+ "Delete Member Successfully!" + line
				+ "Modify Member Successfully!" + line
				+ "Find Member Successfully!" + line
				+ "Show Members Successfully!"+line,beos.toString());
	}

}
