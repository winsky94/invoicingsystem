package yanTest;

import java.util.ArrayList;

import vo.GoodsVO;
import businesslogic.stockbl.goods.GoodsController;

public class myTest {
	public static void main(String[] args) {
//商品--------------------------------------------------------------------	
		GoodsController c = new GoodsController();	
//		System.out.println("---------添加測試------------");
//		GoodsVO vo1=new GoodsVO("", "飞利浦日光灯", "SR01", 10, 100, 200, 100, 200, "飞利浦");
//		GoodsVO vo2=new GoodsVO("", "飞利浦日光灯", "SR02", 10, 100, 200, 100, 200, "飞利浦");
//		GoodsVO vo3=new GoodsVO("", "飞利浦日光灯", "SR03", 10, 100, 200, 100, 200, "飞利浦");
//		
//		int a = c.addGoods(vo1);
//		int b = c.addGoods (vo2);
//		int d = c.addGoods(vo3);
//		System.out.println("添加测试结果："+a);
//		System.out.println("添加测试结果："+b);
//		System.out.println("添加测试结果："+d);
//		System.out.println("---------添加測試结束------------");
//		
//		ArrayList<GoodsVO> list = c.showGoods();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getGoodsID()+":"+list.get(i).getName());
//		}
		

//删除商品--------------------------------------------------------------------		
		//--------------------------------------------------------------------			
//				System.out.println("---------删除測試------------");
//				GoodsVO vo4=new GoodsVO("0001-SR01-0000", "飞利浦日光灯", "SR01", 10, 100, 200, 100, 200, "飞利浦");
//				GoodsVO vo5=new GoodsVO("0001-SR02-0001", "东芝日光灯", "SR02", 10, 100, 200, 100, 200, "飞利浦");
//				GoodsVO vo6=new GoodsVO("0001-SR02-0002", "东芝日光灯11", "SR02", 10, 100, 200, 100, 200, "飞利浦");
//				int a1 = c.deleteGoods(vo4);
//				int b1 = c.deleteGoods (vo5);
//				int c1 = c.deleteGoods(vo6);
//				System.out.println("删除测试结果："+a1);
//				System.out.println("删除测试结果："+b1);
				
//				System.out.println("---------删除測試结束------------");
		
		
		ArrayList<GoodsVO> list1 = c.showGoods();
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).getGoodsID()+":"+list1.get(i).getName());
		}
		
//修改商品--------------------------------------------------------------------			
//		System.out.println("---------修改測試------------");
//		GoodsVO vo4=new GoodsVO("0001-SR01-0000", "飞利浦日光灯21", "SR01", 10, 100, 200, 100, 200, "飞利浦");
//		GoodsVO vo5=new GoodsVO("0001-SR02-0001", "东芝日光灯22", "SR02", 10, 100, 200, 100, 200, "飞利浦");
//		GoodsVO vo6=new GoodsVO("0001-SR02-0002", "东芝日光灯23", "SR02", 10, 100, 200, 100, 200, "飞利浦");
//		int a2 = c.modifyGoods(vo4);
//		int b2 = c.modifyGoods (vo5);
//		int c2 = c.modifyGoods(vo6);
//		System.out.println("修改测试结果："+a2);
//		System.out.println("修改测试结果："+b2);
//		System.out.println("修改测试结果："+c2);
//		System.out.println("---------修改測試结束------------");
//
//		ArrayList<GoodsVO> list2 = c.showGoods();
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i).getGoodsID()+":"+list2.get(i).getName());
//		}
		
////分类--------------------------------------------------------------------
//		GoodsClassController c = new GoodsClassController();
//		GoodsClassVO vo1 = new GoodsClassVO("飞利浦", "灯具");
//		GoodsClassVO vo2 = new GoodsClassVO("飞利浦日光灯", "飞利浦");
//		GoodsClassVO vo3 = new GoodsClassVO("东芝", "灯具");
//		GoodsClassVO vo4 = new GoodsClassVO("利物浦", "灯具");
//添加分类--------------------------------------------------------------------			
//		System.out.println("---------添加測試------------");
//		GoodsClass gc=new GoodsClass(vo1.getName(),vo1.getUpClassName());
//		try {
//			gc.addGoodsClass();
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		int a = c.addGoodsClass(vo1);
//		System.out.println("添加测试结果："+a);
//		int b = c.addGoodsClass(vo2);
//		System.out.println("添加测试结果："+b);
//		int d = c.addGoodsClass(vo3);
//		System.out.println("添加测试结果："+d);
//		int e = c.addGoodsClass(vo4);
//		System.out.println("添加测试结果："+e);
//		JTree my_treeJTree=new JTree();
//		c.recordClassTree(my_treeJTree);
//		System.out.println("---------添加測試结束------------");
//删除分类--------------------------------------------------------------------			
//		System.out.println("---------刪除測試------------");
//		ArrayList<GoodsClassVO> list = c.show();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getName());
//		}
//		System.out.println("----------删除前-----------");
//		GoodsClassController control = new GoodsClassController();
//		ArrayList<GoodsClassVO> l = control.show();
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i).getName());
//		}
//
//		int b1 = c.deleteGoodsClass(vo1);
//		System.out.println("删除测试结果："+b1);
//		System.out.println("-----------删除后----------");
//		
//		ArrayList<GoodsClassVO> list1 = c.show();
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i).getName());
//		}
//		System.out.println("-----------刪除測試結束----------");
//修改分类--------------------------------------------------------------------		
//		System.out.println("---------修改測試------------");
//		GoodsClassVO newVO = new GoodsClassVO("飞利浦日光灯", "飞利浦");
//		System.out.println("----------修改前-----------");
//		ArrayList<GoodsClassVO> l = c.show();
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i).getName());
//		}
//
//		int d=c.modifyGoodsClass(newVO);
//		System.out.println("修改测试结果："+d);
//		System.out.println("-----------修改后----------");
//		
//		ArrayList<GoodsClassVO> list2 = c.show();
//		for (int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i).getName()+":"+list2.get(i).getUpClassName());
//		}
//		//--------------------------------------------------------------------	
		
		
		
	}

}
