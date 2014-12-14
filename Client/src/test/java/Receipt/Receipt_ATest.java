package Receipt;

import java.util.ArrayList;

import po.CollectionPO;
import po.TransferItemPO;
import businesslogic.financebl.Collection;
import businesslogic.receiptbl.Review;
import vo.CollectionVO;
import vo.TransferItemVO;
import junit.framework.TestCase;

/*
 * Author: jincui
 * Date:2014-12-13
 * Description:Receipt模块测试套件1
 * */
public class Receipt_ATest extends TestCase{
	CollectionPO cpo;
	Review view;
	
	public void setUp(){
		ArrayList<TransferItemPO> itemlist=new ArrayList<TransferItemPO>();
		itemlist.add(new TransferItemPO("马建国",200,"用例测试"));
		//有一个待审批收款单
		cpo=new CollectionPO("SKD-20141207-00001","马建国","金大大","CW-00001",
				itemlist,200,0,1);
		try {
			view=new Review();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TUS1-1  做界面测试  跳转测试
	public void test_1(){
		
	}
	
	//TUS1-2  无法测试   弃用
	public void test_2(){
			
	}
	
	
	//TUS1-3  需求变更 总经理不能更改金额 放弃
	public void test_3(){
		try {
			TransferItemPO ip=cpo.getTransferlist().get(0);
			
			//cpo.set
			//Collection collect=new Collection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	//TUS1-4
	public void test_4(){
		//改收款单通过审批
			view.Approve(cpo.getId(), 0);
		
	}
	
	
	//TUS1-5
	public void test_5(){
			
	}

}
