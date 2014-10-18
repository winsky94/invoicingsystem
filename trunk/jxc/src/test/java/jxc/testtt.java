package jxc;

import junit.framework.TestCase;

public class testtt extends TestCase{
	 public testtt( String testName )
	    {
	        super( testName );
	    }
	 
	 public void testgive() {
         tt hi = new tt();
          assertEquals("Hello World!", hi.give());

      }

      public static void main(String[] args) {

          junit.textui.TestRunner.run(testtt.class);

      }
}
