package Presentation.mainui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import businesslogic.userbl.User;
import Presentation.financeui.LeftLongPanel;


public class MainFrame extends JFrame implements MouseListener,ActionListener{
	
	JSplitPane jsp;
	JPanel jp1,jp2;
	JLabel jlb;
	String type;
	User user;
	Color[] color=new Color[2];
		
	public MainFrame(User myuser){
		user=myuser;
//		if(user.getJob().equals(UserJob.FINANCE))
		   type="finance";
//		else if(user.getJob().equals(UserJob.SALE))
//			type="sales";
//		else if(user.getJob().equals(UserJob.STOCK))
//			type="stock";
//		else
//			type="manage";
	}
	
	public String getUser(){
		return "Lucy";
	//	return user.getName();
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
		else{
			color[0]=new Color(115,46,126);
			color[1]=new Color(95,26,106);
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
	
	public static void main(String[] args) {
		MainFrame c=new MainFrame(null);
		c.print();
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
}
