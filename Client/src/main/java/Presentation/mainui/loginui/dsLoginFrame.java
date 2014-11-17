package Presentation.mainui.loginui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


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
        idField=new JTextField();
        idField.setSize(frameWidth/2,frameHeight/10);
        idField.setLocation(frameWidth*2/7,frameHeight/5);
        idField.getDocument().addDocumentListener(new idFieldListener());
        idField.setVisible(true);
        //设置好了一个用户名文本域
        passwordField=new JPasswordField();
        passwordField.setSize(frameWidth/2,frameHeight/10);
        passwordField.setLocation(frameWidth*2/7,frameHeight*2/5);
        passwordField.addKeyListener(new passwordFieldListener());
        passwordField.setVisible(true);
        //设置好了一个密码域
        JButton loginButton=new JButton("登 录");
        Font buttonFont=new Font("登 录", Font.PLAIN, 13);
        loginButton.setFont(buttonFont);
        loginButton.setSize(frameWidth/5,frameHeight/10);
        loginButton.setLocation(frameWidth*2/9,frameHeight*3/5);
        loginButton.addActionListener(new LoginListener());
        loginButton.setVisible(true);
        //设置好了登录按钮
        JButton helpButton=new JButton("帮 助");
        Font helpButtonFont=new Font("帮 助", Font.PLAIN, 13);
        helpButton.setFont(helpButtonFont);
        helpButton.setSize(frameWidth/5,frameHeight/10);
        helpButton.setLocation(frameWidth*4/7,frameHeight*3/5);
        helpButton.addActionListener(new helpListener());
        helpButton.setVisible(true);
        //设置好了帮助按钮
        JLabel idLabel=new JLabel("用户名");
        Font idLabelFont=new Font("用户名", Font.BOLD, 14);
        idLabel.setFont(idLabelFont);
        idLabel.setSize(frameWidth/5,frameHeight/11);
        idLabel.setLocation(frameWidth/7,frameHeight/5);
        idLabel.setVisible(true);
        //设置了用户名标签
        JLabel passwordLabel=new JLabel("密码");
        Font passwordLabelFont=new Font("密码", Font.BOLD, 14);
        passwordLabel.setFont(passwordLabelFont);
        passwordLabel.setSize(frameWidth/5,frameHeight/11);
        passwordLabel.setLocation(frameWidth/7,frameHeight*2/5);
        passwordLabel.setVisible(true);
        panel.setVisible(true);
   
        //设置了我的标签
        panel.setLayout(null);
        panel.add(helpButton);
        panel.add(idLabel);
        panel.add(passwordLabel);
   
        panel.add(loginButton);
        panel.add(idField);
        panel.add(passwordField);
        //向LoginFrame添加组件
        this.add(panel);
        this.repaint();
        this.setResizable(false);//不允许调整窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时结束进程
        this.setVisible(true);//窗口可见
	}
	public static void main(String[] args){
		new dsLoginFrame();
	}
	
	//下面的类是用户名文本域的事件监听器
	class idFieldListener implements DocumentListener{

		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	//下面的类是密码域的事件监听器
	class passwordFieldListener implements KeyListener{

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	//下面的类是按钮的事件监听器
	class LoginListener implements ActionListener ,Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public void actionPerformed(ActionEvent e) {
			
			}
		}
	
	class helpListener implements ActionListener{		
		public void actionPerformed(ActionEvent arg0) {
		}
		}
}


