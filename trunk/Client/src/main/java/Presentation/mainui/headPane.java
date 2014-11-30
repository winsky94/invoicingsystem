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

import vo.UserVO;
import Presentation.userui.userSet;
import businesslogic.userbl.User;

//根据 暂时处理  user构造left 头像Pane
public class headPane extends JPanel{
	JLabel head,info,name,job,grade;
	int width,height;
	 JFrame rame;
	 Color[] theme=new Color[2];
	//选哟user构造啊
	public headPane( MainFrame frame,JPanel parent,UserVO user){
		//--------------userInfo Pane构造
		rame=frame;
		theme=frame.getTheme();
		Color color=theme[0];
		this.setBackground(color);
		width=parent.getWidth();
		height=parent.getHeight();
		this.setLayout(new FlowLayout());
		name=new JLabel(user.getName());
		grade=new JLabel("业绩点："+user.getGrades());
		switch(user.getJob()){
		case MANAGER:
			head=new JLabel(new ImageIcon("img/promotion/head.png"));
			job=new JLabel("总经理");	
			break;
			
		case FINANCE:
			head=new JLabel(new ImageIcon("img/finance/xxh.png"));
			job=new JLabel("财务人员");	
			break;
		case STOCK:
			head=new JLabel(new ImageIcon("img/stock/ysk.png"));
			job=new JLabel("库存人员");	
			break;
		case ADMINSTRATOR:
			head=new JLabel(new ImageIcon("img/login/admin.png"));
			job=new JLabel("系统管理员");
		
			break;
		case SALE:
			head=new JLabel(new ImageIcon("img/sales/wn.png"));
			job=new JLabel("销售人员");
			break;
			
			
		}
		
		name.setForeground(Color.WHITE);
		job.setForeground(Color.WHITE);
		grade.setForeground(Color.white);
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
		
		JPanel userInfo=new JPanel();
		userInfo.setBackground(this.getBackground());
		userInfo.setLayout(new GridLayout(3,1));
		userInfo.add(name);userInfo.add(job);userInfo.add(grade);
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
		
		
		
		
	}
}
