package RunServer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Data.financedata.Account;
import Data.financedata.Cashlist;
import Data.financedata.Collection;
import Data.financedata.Init;
import Data.financedata.Payment;
import Data.memberdata.Member;
import Data.promotiondata.Promotion;
import Data.receiptdata.Receipt;
import Data.salesdata.Sales;
import Data.stockdata.gift.Gift;
import Data.stockdata.goods.Goods;
import Data.stockdata.goodsClass.GoodsClass;
import Data.stockdata.stockManage.StockControl;
import Data.userdata.Log;
import Data.userdata.User;


//rmi 启动 服务注册  11-17 By jin
public class runServer extends JFrame implements ActionListener{
	Toolkit kit = Toolkit.getDefaultToolkit();
	int screenWidth =  kit.getScreenSize().width;
	int screenHeight = kit.getScreenSize().height;
	int frameWidth = screenWidth * 25 / 100;
	int frameHeight = screenHeight * 25 / 100;
	// ------------------------
	Font font = new Font("微软雅黑", Font.PLAIN, 14);
	JButton submitBtn,exitBtn;
	JComboBox portBox;
	ArrayList<String> port;
	public runServer() {
		port=new ArrayList<String>();
		//最近一次记录存在最末行
		portBox=new JComboBox<String>();
		portBox.setEditable(true);
		try {
			BufferedReader br=new BufferedReader(new FileReader("Port.txt"));
			String str=null;
				while((str=br.readLine())!=null){
					port.add(str);
				}
			br.close();
			for(int i=port.size()-1;i>=0;i--)
				portBox.addItem(port.get(i));
			portBox.setSelectedIndex(0);
		} catch (IOException e) {
				// TODO Auto-generated catch block
			portBox.setToolTipText("请输入端口号!");
		}
		JPanel pane=new JPanel();
		submitBtn = new JButton("确定");
		submitBtn.setFont(font);
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		pane.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(font);
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		pane.add(exitBtn);
		this.setLayout(new GridLayout(2,1));
		this.add(portBox);this.add(pane);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		submitBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
	
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exitBtn){
			this.dispose();
		}else{
			String portNum=portBox.getSelectedItem().toString();
		//	init(portNum);
			//存储历史记录
			try {
				BufferedWriter bw=new BufferedWriter(new FileWriter("Port.txt"));
				for(int i=0;i<port.size();i++)
					if(port.get(i).equals(portNum)){
						port.remove(i);
						break;
					}
				port.add(portNum);
				int more=port.size()-10;
				if(more>0){
					while(more>0){
						port.remove(0);
						more--;
					}
				}
				for(int i=0;i<port.size();i++)
					bw.write(port.get(i)+"\r\n");
				bw.close();
				this.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		/**
		 * 加载安全机制
		 */
		new runServer();
	}
	
	public void init(String port){
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
			Payment payment=new Payment();
			Receipt receipt=new Receipt();
			Cashlist cashlist=new Cashlist();
			Init init=new Init();
			Log log=new Log();
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
			Naming.rebind("paymentService",payment);
			Naming.rebind("receiptService", receipt);
			Naming.rebind("cashlistService", cashlist);
			Naming.rebind("initService", init);
			Naming.rebind("logService", log);
			
			JOptionPane.showMessageDialog(null, "服务器已运行！","提示",JOptionPane.INFORMATION_MESSAGE);
			

		} catch (Exception e) {
			System.out.println("错误" + e);
		}
	}



}
