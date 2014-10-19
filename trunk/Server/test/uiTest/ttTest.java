package uiTest;

import Server.tt;
import junit.framework.TestCase;

public class ttTest extends TestCase{
	public void testsay(){
		tt t=new tt();
		assertEquals("  ha ",t.say());
	}

}
