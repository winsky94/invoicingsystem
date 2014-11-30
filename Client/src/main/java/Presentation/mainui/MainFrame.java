package Presentation.mainui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import po.UserPO.UserJob;
import vo.UserVO;
import Presentation.financeui.LeftLongPanel;
import Presentation.promotionui.ProleftPane;
import Presentation.salesui.SalesLeftPanel;
import Presentation.stockui.StockLeftPanel;


public class MainFrame extends JFrame implements MouseListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xOld,yOld;
	JSplitPane jsp;
	JPanel jp1,jp2,welcomePanel;
	JLabel jlb;
	String type;
	UserVO user;
	JLabel timeNow;
	JPanel function;
	Color[] color=new Color[2];
		
	public MainFrame(UserVO myuser){
		this.setSize(1100, 600);
	       
        this.setLocation(150, 100);
        
		user=myuser;

		   
		   
		   JPanel welcomePanel = new JPanel() {
				private static final long serialVersionUID = 1L;

				// 给panel加上图片
				protected void paintComponent(Graphics g) {
					ImageIcon icon = new ImageIcon("img/mainFrame/welcome.png");
					Image img = icon.getImage();
					g.drawImage(img, 0, 0,getWidth(),
							getHeight(), icon.getImageObserver());
				}
			};
			
		
			
	
			
			
			jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp2);
			
			jsp.setOneTouchExpandable(true);
				
			this.add(jsp);
			this.setTitle("进销存系统");
			this.setIconImage(new ImageIcon("qq.PNG").getImage());
			
	     //   this.setResizable(false);
	     
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setUndecorated(true);
	        this.setVisible(true);
			jsp.setDividerSize(0);
	        setDividerLocation("long");
			jsp.setDividerSize(0);		
			UserJob job=user.getJob();
		
			switch(job){
			case MANAGER:
				type="manager";setColor();
				this.setLeftComponent(new ProleftPane(this));break;
			case FINANCE:
				type="finance";setColor();
				this.setLeftComponent(new LeftLongPanel(this,color));break;
			//	this.setLeftComponent(n);
			case ADMINSTRATOR:
				type="adminstrator";setColor();break;
			case STOCK:
				type="stock";setColor();
				this.setLeftComponent(new StockLeftPanel(this));break;
			case SALE:
				type="sales";setColor();
				this.setLeftComponent(new SalesLeftPanel(this));break;
			}
			this.setRightComponent(welcomePanel,0);
			//处理拖动事件
			  jsp.addMouseListener(new MouseAdapter() {  
		            public void mousePressed(MouseEvent e) {  
		                xOld = e.getX();  
		                yOld = e.getY();  
		            }  
		        });  
		        jsp.addMouseMotionListener(new MouseMotionAdapter() {  
		            @Override  
		            public void mouseDragged(MouseEvent e) {  
		                int xOnScreen = e.getXOnScreen();  
		                int yOnScreen = e.getYOnScreen();  
		                int xx = xOnScreen - xOld;  
		                int yy = yOnScreen - yOld;  
		                MainFrame.this.setLocation(xx, yy);  
		            }  
		        });  
		
	}
	
	public UserVO getUser(){
		return this.user;
	//	return user.getName();
	}
	public void setRightComponent(JPanel a,int i){
		
		a.setLayout(new BorderLayout());
		getFunction(i);
		a.add(function,BorderLayout.NORTH);
		jsp.setRightComponent(a);
		
	}
	
	public void getFunction(int i){
		JPanel button=new functionPane(this);
		JPanel pane=new JPanel();
		FlowLayout flow=new FlowLayout();
		flow.setAlignment(FlowLayout.RIGHT);
		pane.setLayout(flow);
		pane.add(button);
		if(i==0){
			button.setOpaque(false);
			pane.setOpaque(false);
		}else{
			button.setBackground(Color.white);
			pane.setBackground(Color.WHITE);
		}
		function= pane;
	}
	
	public JPanel getFootPanel(){
		JPanel jp3=new JPanel();
		jp3.setBackground(Color.white);
		Timer t=new Timer(1000,this);//每隔一秒触发ActionEvent事件
		t.start();//启动计时器
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
		jp3.add(timeNow);
		jp3.setBorder(new EtchedBorder(EtchedBorder.RAISED));
       return jp3;
	}
	public void setRightComponent(JPanel a){
		JPanel right=new JPanel();
		
		right.setLayout(new BorderLayout());
		getFunction(1);
		right.add(function,BorderLayout.NORTH);
		right.add(a,BorderLayout.CENTER);
		right.add(getFootPanel(),BorderLayout.SOUTH);
		
		jsp.setRightComponent(right);
		}
	
	public void setLeftComponent(JPanel a){
		jsp.setLeftComponent(a);
	}
	
	public void setDividerLocation(String s){
		if(s.equals("long"))
		  jsp.setDividerLocation(0.225);
		else
		  jsp.setDividerLocation(0.150);
	}
	
	public void setColor(){
		if(type.equals("finance")){
			color[0]=new Color(242,125,5);
			color[1]=new Color(222,105,5);
		}
		else if(type.equals("sales")){
			color[0]=new Color(47,73,136);
			color[1]=new Color(27,53,116);
		}
		else if(type.equals("stock")){
			color[0]=new Color(51,125,86);
			color[1]=new Color(31,105,66);
		}
		else if(type.equals("manager")){
			color[0]=new Color(115,46,126);
			color[1]=new Color(95,26,106);
		}else{
			color[0]=new Color(61,49,35);
			color[1]=new Color(220, 177 ,131);
		}
	}
	
	public void print(){
		setColor();
		jp1=new LeftLongPanel(this,color);
				
		jlb=new JLabel("Hello,财务人员~",JLabel.CENTER);
		Font f=new Font("宋体",Font.BOLD,50);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		jlb.setFont(f);

		
		jp2=new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2.add(jlb);
				
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp2);
		jsp.setOneTouchExpandable(true);
				
		this.add(jsp);
		this.setTitle("进销存系统");
		this.setIconImage(new ImageIcon("qq.PNG").getImage());
		this.setSize(800, 500);
	       
        this.setLocation(300, 100);
        
     //   this.setResizable(false);
     
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
		jsp.setDividerSize(0);
        setDividerLocation("long");
		jsp.setDividerSize(0);	
		
	
	}
	
	


	public void actionPerformed(ActionEvent e) {
		this.timeNow.setText(Calendar.getInstance().getTime().toLocaleString());
		
	
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		UserVO user=new UserVO("111111","王宁宁","3333",UserJob.FINANCE,129);
		//user.setJob(UserJob.SALE);
		MainFrame frame =new MainFrame(user);
		//frame.print();
		
	}
	
	public Color[] getTheme(){
		return this.color;
	}
}
