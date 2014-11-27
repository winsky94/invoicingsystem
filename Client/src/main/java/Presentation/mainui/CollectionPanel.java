package Presentation.mainui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
public class CollectionPanel extends JPanel implements ActionListener{
	JLabel timeNow;
	JTable jt;
	String[] columnNames;
	String[][] rowData;
	DefaultTableModel dtf;
	JScrollPane jspp;
	Timer t;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3,jb4;
	JTextField jtf;
	JLabel jlb;
	
	MainFrame frame;
	Color[] color;
	
	public CollectionPanel(MainFrame myframe,Color[] mycolor){
		
		frame=myframe;
		color=mycolor;
		
		this.setLayout(new BorderLayout());
		
		jb1=new JButton("收款单");
		jb1.setIcon(new ImageIcon("account-golden.png"));
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb1.setFocusPainted(false);
		jb1.setContentAreaFilled(false);
		jb1.setBorder(null);
		jb1.setBackground(new Color(255,255,255));
		jb2=new JButton("付款单");
		jb2.setIcon(new ImageIcon("account-golden.png"));
		jb2.setBorder(null);
		jb2.setContentAreaFilled(false);
		jb2.setBackground(new Color(255,255,255));
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb3=new JButton("现金费用单");
		jb3.setIcon(new ImageIcon("account-golden.png"));
		jb3.setBorder(null);
		jb3.setContentAreaFilled(false);
		jb3.setBackground(new Color(255,255,255));
		jb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb4=new JButton("添加");
		jb4.setIcon(new ImageIcon("add-golden.png"));
		jb4.setBorder(null);
		jb4.setContentAreaFilled(false);
		jb4.setBackground(new Color(255,255,255));
		jb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jtf=new JTextField(6);
		ImageIcon image = new ImageIcon("find-golden.png"); 
		jlb=new JLabel(image);
		
		jp1=new JPanel();
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(new JPanel());
		jp1.add(jtf);		
		jp1.add(jlb);
		this.add(jp1,BorderLayout.NORTH);
		
		columnNames=new String[]{"姓名","学号","籍贯"};
		rowData=new String[][]{{"a","1","b"}};
		dtf=new DefaultTableModel(rowData,columnNames);		
		jt=new JTable(dtf);
		jspp=new JScrollPane(jt);
		jp2=new JPanel();
		jp2.add(jspp);
		this.add(jp2);
		
		jp3=new JPanel();
		t=new Timer(1000,this);//每隔一秒触发ActionEvent事件
		t.start();//启动计时器
//		timeNow=new JLabel(Calendar.getInstance().getTime().toString());
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString());
		jp3.add(timeNow);
		jp3.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        this.add(jp3,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent arg0) {
		this.timeNow.setText(Calendar.getInstance().getTime().toLocaleString());
		
	}
	
}
