package RunServer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Data.financedata.Account;
import Data.financedata.Cashlist;
import Data.financedata.Collection;
import Data.financedata.Init;
import Data.financedata.Payment;
import Data.memberdata.Member;
import Data.promotiondata.Coupon;
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
public class runServer extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Toolkit kit = Toolkit.getDefaultToolkit();
	int screenWidth = kit.getScreenSize().width;
	int screenHeight = kit.getScreenSize().height;
	int frameWidth = 380;
	int frameHeight = 250;
	int xOld, yOld;
	// ------------------------
	Font font = new Font("微软雅黑", Font.PLAIN, 14);
	JButton submitBtn, exitBtn;
	JComboBox<String> portBox;
	ArrayList<String> port;

	public runServer() {
		this.setTitle("进销存系统服务器界面");
		this.setIconImage(kit.getImage("img/icon.png"));
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		this.setLayout(new GridLayout(1, 1));
		// -------------------
		JPanel pnl = new JPanel() {
			private static final long serialVersionUID = 1L;

			// 给panel加上图片
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("img/net.png");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(),
						icon.getIconHeight(), icon.getImageObserver());
			}
		};
		this.add(pnl);
		// -------------------
		pnl.setLayout(new GridLayout(4, 1));
		JPanel titlePnl = new JPanel();
		titlePnl.setOpaque(false);
		pnl.add(titlePnl);
		JLabel title = new JLabel("欢迎使用进销存系统");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		title.setForeground(Color.white);
		titlePnl.add(title);
		// --------------------------
		JPanel top = new JPanel();
		top.setOpaque(false);
		pnl.add(top);
		JPanel mid = new JPanel();
		mid.setOpaque(false);
		pnl.add(mid);
		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		pnl.add(bottom);
		// -------Port-------------
		JLabel portLbl = new JLabel("端口：");
		portLbl.setFont(font);
		portLbl.setForeground(Color.white);
		mid.add(portLbl);
		port = new ArrayList<String>();
		portBox = new JComboBox<String>();
		portBox.setEditable(true);
		// 读取历史记录
		try {
			BufferedReader br = new BufferedReader(new FileReader("Port.txt"));
			String str = null;
			while ((str = br.readLine()) != null) {
				port.add(str);
			}
			br.close();
			// 最近一次记录存在最末行
			for (int i = port.size() - 1; i >= 0; i--)
				portBox.addItem(port.get(i));
			portBox.setSelectedIndex(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			portBox.setToolTipText("请输入端口号!");
		}
		portBox.setBackground(Color.white);
		mid.add(portBox);
		// --------buttons---------
		submitBtn = new JButton("确定");
		submitBtn.setFont(font);
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		bottom.add(submitBtn);
		submitBtn.addActionListener(this);
		this.getRootPane().setDefaultButton(submitBtn);
		bottom.add(new JLabel());
		exitBtn = new JButton("取消");
		exitBtn.setFont(font);
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		bottom.add(exitBtn);
		exitBtn.addActionListener(this);
		// -------------------
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
		// 处理窗口拖动
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();
				yOld = e.getY();
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				runServer.this.setLocation(xx, yy);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitBtn) {
			this.dispose();
		} else {
			this.dispose();
			String portNum = portBox.getSelectedItem().toString();
			// 初始化Server RMI
			init(portNum);
			// 存储历史记录
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(
						"Port.txt"));
				for (int i = 0; i < port.size(); i++)
					if (port.get(i).equals(portNum)) {
						port.remove(i);
						break;
					}
				port.add(portNum);
				int more = port.size() - 10;
				if (more > 0) {
					while (more > 0) {
						port.remove(0);
						more--;
					}
				}
				for (int i = 0; i < port.size(); i++)
					bw.write(port.get(i) + "\r\n");
				bw.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void init(String port) {
		try {

			String hostIP = InetAddress.getLocalHost().getHostAddress();
			int portNum = Integer.parseInt(port);
			LocateRegistry.createRegistry(portNum);// 客户端启用的注册端口号为1099 yan 11-18

			User user = new User();
			Member member = new Member();
			GoodsClass gc = new GoodsClass();
			Goods g = new Goods();
			Collection collection = new Collection();
			Sales sale = new Sales();
			Promotion pro = new Promotion();
			Account account = new Account();
			StockControl controller = new StockControl();
			Gift giftService = new Gift();
			Payment payment = new Payment();
			Receipt receipt = new Receipt();
			Cashlist cashlist = new Cashlist();
			Coupon coupon = new Coupon();
			Init init = new Init();
			Log log = new Log();

			Naming.rebind("promotionService", pro);
			Naming.rebind("couponService", coupon);
			Naming.rebind("salesService", sale);
			Naming.rebind("memberService", member);
			Naming.rebind("userService", user);
			Naming.rebind("goodsClassService", gc);
			Naming.rebind("goodsService", g);
			Naming.rebind("collectionService", collection);
			Naming.rebind("accountService", account);
			Naming.rebind("stockManageService", controller);
			Naming.rebind("giftService", giftService);// 加了由此向上的两个绑定——12.04_yan
			Naming.rebind("paymentService", payment);
			Naming.rebind("receiptService", receipt);
			Naming.rebind("cashlistService", cashlist);
			Naming.rebind("initService", init);
			Naming.rebind("logService", log);
			new ServerMainFrame(hostIP, port);

		} catch (Exception e) {
			System.out.println("错误" + e);
		}
	}

	public static void main(String[] args) {

		new runServer();
	}

}
