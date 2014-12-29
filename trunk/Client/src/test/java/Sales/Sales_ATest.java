package Sales;

import java.util.ArrayList;

import junit.framework.TestCase;
import po.ReceiptPO.ReceiptType;
import vo.CommodityVO;
import vo.SaleReturnVO;
import vo.SaleVO;
import businesslogic.salesbl.SalesController;

public class Sales_ATest extends TestCase{
		SalesController controller;
		ArrayList<CommodityVO> cmlist;
		public void setUp() throws Exception{
			controller=new SalesController();
			cmlist=new ArrayList<CommodityVO>();
			ArrayList<CommodityVO> commodity=new ArrayList<CommodityVO>();
			CommodityVO com=new CommodityVO("0001-SR01-0001","蓝之恋吊灯","SR01",1000,800,1,1000,800
					,"在做测试");
			commodity.add(com);
			double[] total=new double[]{100,120,110,0,110};
			double[] discount=new double[]{0,0,0,0};
			SaleVO sale=new SaleVO("金金",commodity,"XSD-20141205-00001","马建国","XSS-00001",
					"XS-00001",0,0,"","1","","",total,discount);
			controller.addSale(sale);
			
		}
	
	//String id,String user,SaleVO s,int status,
		//String info,int hurry)
	//根据进货单 创建一条销售退货单
		public void test_1(){
			SaleVO sale=controller.SFindByID("XSD-20141205-00001");
			String id=controller.getNewID(ReceiptType.SALERETURN);
			SaleReturnVO saleReturn =new SaleReturnVO(id,"JL-00001",sale,
					0,"",1);
			int addReturnResult=controller.addSaleReturn(saleReturn);
			assertEquals(0,addReturnResult);
			SaleReturnVO saler=controller.SRFindByID(saleReturn.getId());
			if(saler!=null)
			{
				assertEquals(saleReturn.getUser(),saler.getClerk());
				assertEquals(saleReturn.getClerk(),saler.getClerk());
			}
			
			
		}
		
		//根据type找销售单
		public void test_2(){
			String message="金大大";
			String type="客户";
			ArrayList<SaleVO> salelist=controller.findSale(message, type);
			for(SaleVO vo:salelist){
				assertEquals(message,vo.getMemberName());
			}
			type="业务员";
			salelist=controller.findSale(message, type);
			for(SaleVO vo:salelist){
				assertEquals(message,vo.getClerk());
			}
			
			
		}
		
		//修改一个销售单
		public void test_3(){
			SaleVO sale=controller.SFindByID("XSD-20141205-00001");
			ArrayList<CommodityVO> clist=sale.getSalesList();
			CommodityVO com=new CommodityVO("0001-SR01-0002","蓝之恋吊灯","SR01",1000,800,1,1000,800
					,"在做测试");
			clist.add(com);
			sale.setSaleList(clist);
			int result=controller.modifySale(sale);
			assertEquals(0,result);
			sale=controller.SFindByID("XSD-20141205-00001");
			boolean isExist=false;
			for(CommodityVO v:sale.getSalesList())
				if(v.getID().equals("0001-SR01-00002"))
				{
					isExist=true;break;
				}
			assertEquals(true,isExist);
			
			
			
			
		}
}