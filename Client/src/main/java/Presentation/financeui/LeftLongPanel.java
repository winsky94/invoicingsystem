package Presentation.financeui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import businesslogic.userbl.User;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
public class LeftLongPanel extends JPanel implements ActionListener,MouseListener{
	JPanel jp1,jp3,jp4,jp5,jp6,headPane;
	ImageIcon ii1,iiw;
	JButton jb1,jb2,jb3,jb4,jb5;
	JLabel jlb1,jlb2;
	MainFrame frame;
	Color[] color;
	
	public LeftLongPanel(MainFrame myframe,Color[] mycolor){
		
		frame=myframe;
		color=mycolor;
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		User user=frame.getUser();
		this.setLayout(grid);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(frame,this,user);
		grid.setConstraints(headPane, c);
		this.add(headPane);
		
		//=======功能键构造
		JPanel down=new JPanel();
		c.weightx=0.3;c.weighty=0.4;
		c.gridx=0;c.gridy=2;
		c.gridheight=6;
		c.gridwidth=1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(color[0]);
		down.setLayout(new GridLayout(6,1));
		
		//
		jb1=new JButton("账户管理");
		Font f=new Font("宋体",Font.BOLD,18);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		jb1.setFont(f);
		jb1.setIcon(new ImageIcon("img/finance/commodity-golden.png"));
		jb1.setBackground(color[0]);
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb1.setFocusPainted(false);
		jb1.addMouseListener(this);
		jb1.addActionListener(this);
		jb2=new JButton("制定单据");
		jb2.setFont(f);
		jb2.setIcon(new ImageIcon("img/finance/account-golden.png"));
		jb2.setBackground(color[0]);
		jb2.setFocusPainted(false);
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb2.addActionListener(this);
		jb2.addMouseListener(this);
		jb3=new JButton("查看报表");
		jb3.setFont(f);
		jb3.setIcon(new ImageIcon("img/finance/manage-golden.png"));
		jb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb3.setBackground(color[0]);
		jb3.setFocusPainted(false);
		jb3.addMouseListener(this);
		jb4=new JButton("期初建账");
		jb4.setFont(f);
		jb4.setIcon(new ImageIcon("img/finance/manage2-golden.png"));
		jb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb4.setBackground(color[0]);
		jb4.setFocusPainted(false);
		jb4.addMouseListener(this);
		
		//jp4=new JPanel();
		//jp4.setLayout(new GridLayout(4,1));
		down.add(jb1);
		down.add(jb2);
		down.add(jb3);
		down.add(jb4);
		
		jb5=new JButton("收起菜单",new ImageIcon("img/mainFrame/back.png"));
		jb5.setFont(new Font("楷体", Font.PLAIN, 19));
		jb5.setForeground(Color.white);
		jb5.setBackground(color[0]);
		jb5.setHorizontalAlignment(SwingConstants.CENTER);
		jb5.setFocusPainted(false);
		jb5.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(jb5, c);
		this.add(jb5);
		this.setBackground(color[0]);
		
      /*  jp5=new JPanel();
        ImageIcon image1 = new ImageIcon("img/finance/left-blue.png"); 
		jb5=new JButton(image1);
		jb5.setText("收起");
		Font f1=new Font("宋体",Font.BOLD,15);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		jb5.setFont(f1);
		jb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb5.addActionListener(this);
		jb5.setBackground(color[0]);
		jb5.setBorderPainted(false);
		jb5.setFocusPainted(false);
		jp5.add(jb5);
		jp5.setBackground(color[0]);
		

		this.setLayout(new BorderLayout());
		this.add(jp3,BorderLayout.NORTH);
		this.add(jp4);
		this.add(jp5,BorderLayout.SOUTH);*/

		
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

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1){
			frame.setRightComponent(new AccountPanel());		
		}
		else if(arg0.getSource()==jb2){
			frame.setRightComponent(new CollectionPanel(frame,color));	
		}
		else if(arg0.getSource()==jb5){			
			frame.setLeftComponent(new LeftShortPanel(frame,color));
			frame.setDividerLocation("short");
		}
		
	}
		
}
