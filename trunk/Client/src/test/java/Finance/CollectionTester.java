package Finance;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import businesslogic.financebl.Collection;
import businesslogic.memberbl.MockMember;
import junit.framework.TestCase;

public class CollectionTester extends TestCase{	
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	
	public void setUp(){
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));	
	}
	
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testCollectionDrive(){
		MockMember member1=new MockMember(100,200);
	    MockMember member2=new MockMember(300,400);
		Collection collection=new Collection(member1,member2,10);
		collection.createCollection();
	    assertEquals(210.0,member1.getToPay());
	    assertEquals(390.0,member2.getToPay());
		assertEquals("Create collection success!"+line,bytes.toString());		
	}
    
}
