package Presentation.financeui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import stocksystem.AccountManagement;

public class AddEXMoneyDialog extends JDialog implements ActionListener{

	JLabel jl1,jl2,jl3;
	JTextField jtf1,jtf2,jtf3;
	JButton jb1,jb2;
	JPanel jp1,jp2,jp3;
	
	public AddEXMoneyDialog(AddCollectionPanel owner,String title,boolean modal){
		
		jl1=new JLabel("银行账户");
		jl2=new JLabel("转账金额");
		jl3=new JLabel("备注");
		
		
		jtf1=new JTextField(10);
		jtf2=new JTextField(10);
		jtf3=new JTextField(10);
		
		
		jb1=new JButton("确认");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.setLayout(new GridLayout(3,1));
		jp2.setLayout(new GridLayout(3,1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		
		
		jp2.add(jtf1);
		jp2.add(jtf2);
	    jp2.add(jtf3);
	    
	    jp3.add(jb1);
	    jp3.add(jb2);
	    
	    this.add(jp1,BorderLayout.WEST);
	    this.add(jp2);
	    this.add(jp3,BorderLayout.SOUTH);
	    
	    this.setSize(300,250);
//		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	    this.setLocation(300,250);
		this.setVisible(true);
	    	
		
	}
	



	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1){
			String[] buffer={jtf1.getText(),jtf2.getText(),jtf3.getText()};
	//		myFrame.jt.setBackground(Color.blue);
	//		myFrame.jt.setEnabled(true);
			owner.addDialog(buffer);
            
	//		myFrame.jt.getValueAt(row, column);
			this.dispose();
		}
		if(arg0.getSource()==jb2){
			this.dispose();
		}
		
	}

	
	

}
