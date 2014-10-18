package jxc;

import junit.framework.TestCase;

public class ttTest extends TestCase{
	 public ttTest( String testName )
	    {
	        super( testName );
	    }
	 
	 public void testgive() {
         tt hi = new tt();
          assertEquals("hello!", hi.give());

      }

      public static void main(String[] args) {

          junit.textui.TestRunner.run(ttTest.class);

      }
}
