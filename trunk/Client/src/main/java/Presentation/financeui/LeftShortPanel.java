package Presentation.financeui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Presentation.mainui.MainFrame;
public class LeftShortPanel extends JPanel implements ActionListener,MouseListener{
    
	JPanel jp1,jp3,jp4,jp5,jp6;
	ImageIcon ii1,iiw;
	JButton jb1,jb2,jb3,jb4,jb5;
	JLabel jlb1,jlb2;
	MainFrame frame;
	Color[] color;
	
	public LeftShortPanel(MainFrame myframe,Color[] mycolor){
		frame=myframe;
		color=mycolor;
		
		jp1=new JPanel();		
		ImageIcon image = new ImageIcon("12.jpg"); 
		jlb1=new JLabel(image);
		jp3=new JPanel();
		jp3.add(jlb1);
		jp3.setBackground(color[0]);
		
		jb1=new JButton();
		jb1.setIcon(new ImageIcon("commodity-golden.png"));
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb1.setFocusPainted(false);
		jb1.setBackground(color[0]);
		jb1.addMouseListener(this);
		jb1.addActionListener(this);
		jb2=new JButton();
		jb2.setIcon(new ImageIcon("account-golden.png"));
		jb2.setFocusPainted(false);
		jb2.setBackground(color[0]);
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb2.addActionListener(this);
		jb2.addMouseListener(this);
		jb3=new JButton();
		jb3.setIcon(new ImageIcon("manage-golden.png"));
		jb3.setBackground(color[0]);
		jb3.setFocusPainted(false);
		jb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb3.addActionListener(this);
		jb3.addMouseListener(this);
		jb4=new JButton();
		jb4.setIcon(new ImageIcon("manage2-golden.png"));
		jb4.setFocusPainted(false);
		jb4.setBackground(color[0]);
		jb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb4.addActionListener(this);
		jb4.addMouseListener(this);
		
		jp4=new JPanel();
		jp4.setLayout(new GridLayout(4,1));
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb3);
		jp4.add(jb4);
		
        jp5=new JPanel();
        ImageIcon image1 = new ImageIcon("right-blue.png"); 
		jb5=new JButton(image1);
		jb5.setText("拉开");
		Font f1=new Font("宋体",Font.BOLD,15);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		jb5.setFont(f1);
		jb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb5.addActionListener(this);
		jb5.setBackground(color[0]);
		jb5.setFocusPainted(false);
		jb5.setBorderPainted(false);
		jp5.add(jb5);
		jp5.setBackground(color[0]);
		
		this.setLayout(new BorderLayout());
		this.add(jp3,BorderLayout.NORTH);
		this.add(jp4);
		this.add(jp5,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1){
			frame.setRightComponent(new AccountPanel());		
		}
		else if(arg0.getSource()==jb2){
			frame.setRightComponent(new CollectionPanel(frame,color));	
		}
		else if(arg0.getSource()==jb5){			
			frame.setLeftComponent(new LeftLongPanel(frame,color));
			frame.setDividerLocation("long");
		}
		
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==jb1)
			jb1.setBackground(color[1]);
		else if(e.getSource()==jb2)
			jb2.setBackground(color[1]);
		else if(e.getSource()==jb3)
			jb3.setBackground(color[1]);
		else if(e.getSource()==jb4)
			jb4.setBackground(color[1]);
		
	}

	public void mouseExited(MouseEvent e) {
		if(e.getSource()==jb1)
			jb1.setBackground(color[0]);
		else if(e.getSource()==jb2)
			jb2.setBackground(color[0]);
		else if(e.getSource()==jb3)
			jb3.setBackground(color[0]);
		else if(e.getSource()==jb4)
			jb4.setBackground(color[0]);
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
