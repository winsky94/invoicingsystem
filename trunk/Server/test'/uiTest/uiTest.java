package uiTest;

import Server.tt;
import junit.framework.TestCase;

public class uiTest extends TestCase{
	public void testtt(){
		tt t=new tt();
		assertEquals("ha ",t.say());
	}

}
