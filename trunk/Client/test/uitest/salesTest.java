package uitest;

import salesui.sales;
import junit.framework.TestCase;

public class salesTest extends TestCase{
	
	public void testSay(){
		assertEquals("哈",sales.say());
	}

}
