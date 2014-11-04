package Promotion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;



import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.promotionblservice.PromotionBLService_Stub;
import vo.GiftVO;
import vo.PromotionVO;
import vo.SaleVO;

public class PromotionBLService_DriverTest extends TestCase{
	private PromotionBLService promotionblservice;
	String line=System.getProperty("line.separator");
	PrintStream console=null;
	ByteArrayOutputStream bytes=null;
	public void setUp(){
		PromotionBLService promotionbl_stub=new PromotionBLService_Stub();
		promotionblservice=promotionbl_stub;
		bytes=new ByteArrayOutputStream();
		console=System.out;
		System.setOut(new PrintStream(bytes));
		
	}
	public void tearDown(){
		System.setOut(console);
	}
	
	public void testPromotionBLDrive(){
		PromotionVO vo=new PromotionVO();
		SaleVO salevo=new SaleVO();
		int resultAdd=promotionblservice.Add(vo);
		int resultMod=promotionblservice.Modify(vo);
		PromotionVO resultMat=promotionblservice.Match(salevo);
		GiftVO giftvo=promotionblservice.Present(vo);
		promotionblservice.Show();
		assertEquals(0,resultAdd);
		assertEquals(0,resultMod);
		assertEquals("Add Promotion Success!"+line
				+"Modify Promotion Success!"+line
				+"Match Promotion Success!"+line
				+"Give Present by Promotion Success!"+line
				+"Show Promotion Success!"+line,bytes.toString());
		
	}
	
}
