package Presentation.financeui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Presentation.mainui.MainFrame;

public class CollectionPanel extends JPanel implements ActionListener{
	//JLabel timeNow;
	JTable jt;
	CollectionModel cm=new CollectionModel();
	JScrollPane jspp;
	//Timer t;
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JTextField jtf;
	
	MainFrame frame;
	Color[] color;
	
	public CollectionPanel(MainFrame myframe,Color[] mycolor){
		
		frame=myframe;
		color=mycolor;
		
		this.setLayout(new BorderLayout());
		
		jb1=new JButton("收款单");
		jb1.setIcon(new ImageIcon("img/finance/account-golden.png"));
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb1.setFocusPainted(false);
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb1.setBackground(new Color(255,255,255));
		jb1.addActionListener(this);
		jb2=new JButton("付款单");
		jb2.setIcon(new ImageIcon("img/finance/account-golden.png"));
		jb2.setBorder(null);
		jb2.setContentAreaFilled(false);
		jb2.setBackground(new Color(255,255,255));
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb3=new JButton("现金费用单");
		jb3.setIcon(new ImageIcon("img/finance/account-golden.png"));
		jb3.setBorder(null);
		jb3.setContentAreaFilled(false);
		jb3.setBackground(new Color(255,255,255));
		jb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb4=new JButton("添加");
		jb4.setIcon(new ImageIcon("img/finance/add-golden.png"));
		jb4.setBorder(null);
		jb4.setContentAreaFilled(false);
		jb4.setBackground(new Color(255,255,255));
		jb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb4.addActionListener(this);
		jb6=new JButton("查看");
		jb6.setIcon(new ImageIcon("img/finance/salelist-golden.png"));
		jb6.setBorder(null);
		jb6.setContentAreaFilled(false);
		jb6.setBackground(new Color(255,255,255));
		jb6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jtf=new JTextField(6);
		jb5=new JButton();
		jb5.setIcon(new ImageIcon("img/finance/find-golden.png"));
		jb5.setBorder(null);
		jb5.setContentAreaFilled(false);
		jb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jp1=new JPanel();
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jb6);
		jp1.add(new JPanel());
		jp1.add(jtf);		
		jp1.add(jb5);
		this.add(jp1,BorderLayout.NORTH);

		jt=new JTable(cm);
		jspp=new JScrollPane(jt);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		jt.setDefaultRenderer(Object.class, tcr);
		jt.getColumnModel().getColumn(0).setPreferredWidth(130);
		jt.getColumnModel().getColumn(1).setPreferredWidth(200);
		jp2=new JPanel();
		jp2.setLayout(new BorderLayout());
		jp2.add(jspp);
		jp2.add(new Panel(),BorderLayout.WEST);
		jp2.add(new Panel(),BorderLayout.EAST);
		this.add(jp2);
		
		/*jp3=new JPanel();
		t=new Timer(1000,this);//每隔一秒触发ActionEvent事件
		t.start();//启动计时器
//		timeNow=new JLabel(Calendar.getInstance().getTime().toString());
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
		jp3.add(timeNow);
		jp3.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        this.add(jp3,BorderLayout.SOUTH);*/
	}

	public void addRow(String[] buffer){
		cm.addRow(buffer);
    	jt.revalidate();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb4){
			frame.setRightComponent(new AddCollectionPanel(frame,this,color));
		}
		//this.timeNow.setText(Calendar.getInstance().getTime().toLocaleString());
		
	}
	
}

