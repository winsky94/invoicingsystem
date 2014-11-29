package Presentation.mainui;

	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

	import javax.swing.*;

import po.UserPO.UserJob;
import businesslogic.userbl.User;
import Presentation.financeui.LeftLongPanel;
import Presentation.promotionui.leftPane;
import Presentation.promotionui.listPane;
import Presentation.uihelper.UIhelper;

	public class MockFrame extends JFrame implements MouseListener,ActionListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JSplitPane jsp,rsp;//rsp 右边的pane
		JPanel jp1,jp2;
		JLabel jlb;
		String userType;
		int xOld,yOld;
		Color[] color=new Color[2];
		int screenWidth = UIhelper.getScreenWidth();
		int screenHeight = UIhelper.getScreenHeight();
		int frameWidth = screenWidth * 85 / 100;
		int frameHeight = screenHeight * 85 / 100;	
		public MockFrame(User user){
			
			jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jp1,jp2);
			
			jsp.setOneTouchExpandable(true);
				
			this.add(jsp);
			this.setTitle("进销存系统");
			this.setIconImage(new ImageIcon("qq.PNG").getImage());
			this.setSize(1000, 600);
		       
	        this.setLocation(150, 100);
	        
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
				this.setLeftComponent(new leftPane(this));
				this.setRightComponent(new listPane(this));
			}
			
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
		                MockFrame.this.setLocation(xx, yy);  
		            }  
		        });  
			
		}
		
		public void setRightComponent(JPanel a){
			jsp.setRightComponent(a);
			
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
			if(userType.equals("finance")){
				color[0]=new Color(242,125,5);
				color[1]=new Color(222,105,5);
			}
			else if(userType.equals("sales")){
				color[0]=new Color(47,73,136);
				color[1]=new Color(27,53,116);
			}
			else if(userType.equals("stock")){
				color[0]=new Color(51,125,86);
				color[1]=new Color(31,105,66);
			}
			else{
				color[0]=new Color(115,46,126);
				color[1]=new Color(95,26,106);
			}
		}
		
	public void print(){
			setColor();
		//	jp1=new LeftLongPanel(this,color);
					
			jlb=new JLabel("Hello,财务人员~",JLabel.CENTER);
			Font f=new Font("宋体",Font.BOLD,50);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
			jlb.setFont(f);

			
			jp2=new JPanel();
			jp2.setLayout(new BorderLayout());
			jp2.add(jlb);
					
			
		}
		
		


		public void actionPerformed(ActionEvent arg0) {
			
			
		
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
		public static void main(String[] args) throws Exception {
			User user=new User(1);
			user.setJob(UserJob.MANAGER);
			new MockFrame(user);
		}
	}
