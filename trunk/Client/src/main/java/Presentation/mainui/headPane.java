package Presentation.mainui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentation.userui.userSet;
import businesslogic.userbl.User;

//根据  user构造left 头像Pane
public class headPane extends JPanel{
	JLabel head,info,name,job,point;
	int width,height;
	 JFrame rame;
	//选哟user构造啊
	public headPane( JFrame frame,JPanel parent,User user){
		//--------------userInfo Pane构造
		rame=frame;
		this.setBackground(new Color(115,46,126));
		width=parent.getWidth();
		height=parent.getHeight();
		this.setLayout(new FlowLayout());
		head=new JLabel(new ImageIcon("img/promotion/head.png"));
		head.setSize(width/3, height/5);
		head.setLocation(0, 0);
		head.setToolTipText("修改头像");
		head.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		head.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				head.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			public void mouseExited(MouseEvent e){
				head.setBorder(BorderFactory.createEmptyBorder());
			}
		});
		info=new JLabel(new ImageIcon("img/promotion/infoicon.png"));
		info.setToolTipText("用户设置");
		ImageIcon icon=(ImageIcon) info.getIcon();
		info.setSize(icon.getIconWidth(),icon.getIconHeight());
		info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		name=new JLabel("小金金");
		job=new JLabel("总经理");
		point=new JLabel("业绩点:0.01");
		JPanel userInfo=new JPanel();
		userInfo.setBackground(this.getBackground());
		userInfo.setLayout(new GridLayout(3,1));
		userInfo.add(name);userInfo.add(job);userInfo.add(point);
		userInfo.setSize(width/2, height/5);
		this.add(head);
		this.add(info);
		this.add(userInfo);
		this.setSize(width,height/5);
		this.setVisible(true);
		info.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				 
				userSet set=new userSet(rame,headPane.this);
				set.show(info,e.getX(),e.getY());
				//System.out.println("我被点击了");
				
			}
		});
		
		
		
		//-----------headPane构造
	}
}
