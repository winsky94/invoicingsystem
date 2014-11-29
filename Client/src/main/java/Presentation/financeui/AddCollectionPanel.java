package Presentation.financeui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import vo.CollectionVO;
import vo.MemberVO;
import vo.TransferItemVO;
import Presentation.mainui.MainFrame;
import businesslogic.financebl.Collection;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;

public class AddCollectionPanel extends JPanel implements ActionListener{

	JLabel jlb,timeNow,jlb1,jlb2,jlb3,jlb4,jlb5;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	Timer t;
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10;
	JTable jt;
	ExchangeMoneyModel emm=new ExchangeMoneyModel();
	JButton jb1,jb2,jb3;
	JScrollPane jsp;
	ArrayList<TransferItemVO> transferItem=new ArrayList<TransferItemVO>();
	
	MainFrame frame;
	CollectionPanel panel;
	Color[] color;

    public AddCollectionPanel(MainFrame myframe,CollectionPanel mypanel,Color[] mycolor){
		
		frame=myframe;
		panel=mypanel;
		color=mycolor;
		
		this.setLayout(new BorderLayout());
		
		jlb=new JLabel("创建收款单");
		Font f1=new Font("宋体",Font.BOLD,22);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
		jlb.setFont(f1);
		jp1=new JPanel();
		jp1.add(jlb);
		this.add(jp1,BorderLayout.NORTH);
		
		jp2=new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		jp2.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(3, 3, 3, 3);
		jlb1=new JLabel("编号    ");
		jtf1=new JTextField(11);
		jtf1.setText("SKD-20140826-00002");
		jtf1.setEditable(false);
		jp4=new JPanel();
		jp4.add(jlb1);
		jp4.add(jtf1);
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.08;
		c.weighty = 0.08;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(jp4, c);
		jlb2=new JLabel("供应商");
		jtf2=new JTextField(11);
		jp5=new JPanel();
		jp5.add(jlb2);
		jp5.add(jtf2);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.08;
		c.weighty = 0.08;
		gbl.setConstraints(jp5, c);
		jlb3=new JLabel("销售商");
		jtf3=new JTextField(11);
		jp6=new JPanel();
		jp6.add(jlb3);
		jp6.add(jtf3);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.08;
		c.weighty = 0.08;
		gbl.setConstraints(jp6, c);
		jlb4=new JLabel("操作员");
		jtf4=new JTextField(11);		
		jtf4.setText(frame.getUser());
		jtf4.setEditable(false);
		jp7=new JPanel();
		jp7.add(jlb4);
		jp7.add(jtf4);	
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.08;
		c.weighty = 0.08;
		gbl.setConstraints(jp7, c);
		jt=new JTable(emm);
		jsp=new JScrollPane(jt);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		jt.setDefaultRenderer(Object.class, tcr);
		jb1=new JButton("添加");
		jb1.setIcon(new ImageIcon("add-golden.png"));
		jb1.setBorder(null);
		jb1.setContentAreaFilled(false);
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb1.addActionListener(this);
		jp8=new JPanel();
		jp8.setLayout(new BorderLayout());
		jp8.add(jsp);
		jp8.add(new JPanel(),BorderLayout.WEST);
		jp8.add(jb1,BorderLayout.EAST);
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth=5;
		c.gridheight=5;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1000;
		c.weighty = 1000;
		gbl.setConstraints(jp8, c);
		jlb5=new JLabel("总额汇总(元)");
		jtf5=new JTextField(10);
		jtf5.setText("0");
		jtf5.setEditable(false);
		jp9=new JPanel();
		jp9.add(jlb5);
		jp9.add(jtf5);
		c.gridx = 0;
		c.gridy = 33;
		c.gridwidth=1;
		c.gridheight=1;
		c.weightx = 0.08;
		c.weighty = 0.08;
		gbl.setConstraints(jp9, c);
		jb2=new JButton("确定");
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb2.setBackground(color[0]);
		jb2.addActionListener(this);
		jb3=new JButton("取消");
		jb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb3.setBackground(color[0]);
		jb3.addActionListener(this);
		jp10=new JPanel();
		jp10.add(jb2);
		jp10.add(jb3);
		c.gridx = 0;
		c.gridy = 34;
		c.weightx = 0.08;
		c.weighty = 0.08;
		gbl.setConstraints(jp10, c);
		jp2.add(jp4);
		jp2.add(jp5);
		jp2.add(jp6);
		jp2.add(jp7);
		jp2.add(jp8);
		jp2.add(jp9);
		jp2.add(jp10);
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
    
    public void addRow(String[] buffer){
    	emm.addRow(buffer);
    	jt.revalidate();
    	double money=Double.parseDouble(buffer[1]);
    	double init=Double.parseDouble(jtf5.getText());
    	init=init+money;
    	jtf5.setText(String.valueOf(init));
    	TransferItemVO item=new TransferItemVO(buffer[0],Double.parseDouble(buffer[1]),buffer[2]);
    	transferItem.add(item);
    }
    
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb1){
			new AddEXMoneyDialog(this,"添加转账条目",true);
		}
	    else if(e.getSource()==jb2){
	    	
            CollectionBLService service=new Collection();
            CollectionVO vo=new CollectionVO(jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),transferItem,Double.parseDouble(jtf5.getText()));
            service.createCollection(vo);
            String[] buffer={"等待审批",jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),"点击查看",jtf5.getText()};	    	
			frame.setRightComponent(panel);
			panel.addRow(buffer);
		}
		else if(e.getSource()==jb3){
			frame.setRightComponent(panel);
		}
		this.timeNow.setText(Calendar.getInstance().getTime().toLocaleString());
		
	}

}
