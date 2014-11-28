package Presentation.promotionui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class headPane extends JPanel{
	JLabel head,info,name,job,point;
	int width,height;
	//选哟user构造啊
	public headPane(JPanel parent){
		//--------------userInfo Pane构造
		width=parent.getWidth();
		height=parent.getHeight();
		this.setLayout(new FlowLayout());
		head=new JLabel(new ImageIcon("img/promotion/head.png"));
		head.setSize(width/2-15, height/5);
		info=new JLabel(new ImageIcon("img/promotion/infoicon.png"));
		ImageIcon icon=(ImageIcon) info.getIcon();
		info.setSize(icon.getIconWidth(),icon.getIconHeight());
		name=new JLabel("小金金");
		job=new JLabel("总经理");
		point=new JLabel("业绩点:0.01");
		JPanel userInfo=new JPanel();
		userInfo.setLayout(new GridLayout(3,1));
		userInfo.add(name);userInfo.add(job);userInfo.add(job);
		userInfo.setSize(width/2, height/5);
		this.add(head);
		this.add(info);
		this.add(userInfo);
		
		
		
		//-----------headPane构造
	}
}
