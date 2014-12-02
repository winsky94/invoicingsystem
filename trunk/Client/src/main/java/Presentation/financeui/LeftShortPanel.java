package Presentation.financeui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.uihelper.AboutPanel;
public class LeftShortPanel extends JPanel implements ActionListener,MouseListener{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel headPane;
	JLeftButton jb1,jb2,jb3,jb4,jb5,backBtn;
	MainFrame frame;
	Color[] color;
	
	public LeftShortPanel(MainFrame myframe){
		frame=myframe;
		color=myframe.getTheme();
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
	
		UserVO user=frame.getUser();
		this.setLayout(grid);
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(frame,this,user,1);
		grid.setConstraints(headPane, c);
		this.add(headPane);
		
		
		JPanel down=new JPanel();
		c.weightx=3;c.weighty=4;
		c.gridx=0;c.gridy=2;
		c.gridheight=6;
		c.gridwidth=1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(color[0]);
		down.setLayout(new GridLayout(6,1));
		
		
		jb1=new JLeftButton(new ImageIcon("img/finance/accountMgr.png")
		,color[0]);
		
		jb1.addMouseListener(this);
		jb1.addActionListener(this);
		jb2=new JLeftButton(new ImageIcon("img/finance/receiptMgr.png"),
				color[0]);
		jb2.addActionListener(this);
		jb2.addMouseListener(this);
		
		jb3=new JLeftButton(new ImageIcon("img/finance/showReport.png"),color[0]);
	
		jb3.addMouseListener(this);
		
		
		jb4=new JLeftButton(new ImageIcon("img/finance/initialAccount.png"),color[0]);
		jb4.addActionListener(this);
		jb4.addMouseListener(this);
		
		down.add(jb1);down.add(jb2);
		down.add(jb3);down.add(jb4);
		jb5 = new JLeftButton(new ImageIcon("img/icon-about.png"),
				color[0]);
	
		jb5.addActionListener(this);
		down.add(jb5);
		
		backBtn = new JLeftButton(new ImageIcon("img/mainFrame/backLong.png"),
				color[0]);
	
		backBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
		//
		this.setBackground(color[0]);
		
		
		
      
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1){
			frame.setRightComponent(new AccountPanel(frame));		
		}
		else if(arg0.getSource()==jb2){
			frame.setRightComponent(new CollectionPanel(frame));	
		}
		else if(arg0.getSource()==jb5){			
			frame.setRightComponent(new AboutPanel());
		}
		else if(arg0.getSource()==backBtn){			
			frame.setLeftComponent(new LeftLongPanel(frame));
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
