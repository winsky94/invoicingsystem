package RunServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;





import javax.swing.JOptionPane;





import Data.financedata.Account;
import Data.financedata.Collection;
import Data.memberdata.Member;
import Data.promotiondata.Promotion;
import Data.salesdata.Sales;
import Data.stockdata.gift.Gift;
import Data.stockdata.goods.Goods;
import Data.stockdata.goodsClass.GoodsClass;
import Data.stockdata.stockManage.StockControl;
import Data.userdata.User;


//rmi 启动 服务注册  11-17 By jin
public class runServer {
	public static void main(String[] args) {
		/**
		 * 加载安全机制
		 */
//	System.setSecurityManager(new SecurityManager());

		try {

			// 客户端启用的端口号为1099 yan 11-18
			

			LocateRegistry.createRegistry(1099);// 客户端启用的端口号为1099 yan 11-18

			System.out.println("已启动服务器");
			User user = new User();
			Member member=new Member();
			GoodsClass gc=new GoodsClass();
			Goods g=new Goods();
			Collection collection=new Collection();
			Sales sale=new Sales();
			Promotion pro=new Promotion();
			Account account=new Account();
			StockControl controller=new StockControl();
			Gift giftService=new Gift();
			Naming.rebind("promotionService",pro);
			Naming.rebind("salesService",sale);
			Naming.rebind("memberService",member);
			Naming.bind("userService", user);	
			Naming.rebind("goodsClassService", gc);
			Naming.rebind("goodsService", g);
			Naming.rebind("collectionService", collection);
			Naming.rebind("accountService",account);
			Naming.rebind("stockManageService",controller);
			Naming.rebind("giftService",giftService);//我加了由此向上的两个绑定——12.04_yan
			
			JOptionPane.showMessageDialog(null, "服务器已运行！","提示",JOptionPane.INFORMATION_MESSAGE);
			

		} catch (Exception e) {
			System.out.println("错误" + e);
		}
	}

}
