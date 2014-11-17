package Presentation.mainui.loginui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class dsLoginFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id,key;
	JTextField idField;
	JPasswordField passwordField;
	int screenHeight,screenWidth,frameHeight,frameWidth;
	public dsLoginFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize =kit.getScreenSize();
		screenHeight=screenSize.height;
		screenWidth=screenSize.width;
		frameHeight=screenHeight*2/3;
		frameWidth=screenWidth*2/9;
		//获得了与分辨率匹配的大小
		this.setSize(frameWidth,frameHeight);
		this.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
		//设置好了窗口大小，位置
        this.setTitle("欢迎使用进销存系统");
//        Image image=kit.getImage("GUI/Login/icon.png");
//        this.setIconImage(image);
        //设置了图标
        
        //功能panel
        JPanel panel=new JPanel(){
        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {  
            ImageIcon icon = new ImageIcon("img/Login/background.jpg");  
            Image img = icon.getImage();  
            g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
        }
        };
        panel.setSize(frameWidth,frameHeight);
        panel.setLocation(0,0);
        //搞了一个和frame一样size的panel出来
        
        panel.setVisible(true);
       
        //向LoginFrame添加组件
        this.add(panel);
        this.repaint();
        this.setResizable(false);//不允许调整窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时结束进程
        this.setVisible(true);//窗口可见
	}
	public static void main(String[] args){
		dsLoginFrame l=new dsLoginFrame();
	}
}
