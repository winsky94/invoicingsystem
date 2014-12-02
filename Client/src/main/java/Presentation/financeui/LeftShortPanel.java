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
	JLeftButton accountBtn,receiptBtn,showReportBtn,initialBtn,aboutBtn,backBtn;
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
		
		
		accountBtn=new JLeftButton(new ImageIcon("img/finance/accountMgr.png")
		,color[0]);
		
		accountBtn.addMouseListener(this);
		accountBtn.addActionListener(this);
		receiptBtn=new JLeftButton(new ImageIcon("img/finance/receiptMgr.png"),
				color[0]);
		receiptBtn.addActionListener(this);
		receiptBtn.addMouseListener(this);
		
		showReportBtn=new JLeftButton(new ImageIcon("img/finance/showReport.png"),color[0]);
	
		showReportBtn.addMouseListener(this);
		
		
		initialBtn=new JLeftButton(new ImageIcon("img/finance/initialAccount.png"),color[0]);
		initialBtn.addActionListener(this);
		initialBtn.addMouseListener(this);
		
		down.add(accountBtn);down.add(receiptBtn);
		down.add(showReportBtn);down.add(initialBtn);
		aboutBtn = new JLeftButton(new ImageIcon("img/icon-about.png"),
				color[0]);
	
		aboutBtn.addActionListener(this);
		down.add(aboutBtn);
		
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
		if(arg0.getSource()==accountBtn){
			frame.setRightComponent(new AccountPanel(frame));		
		}
		else if(arg0.getSource()==receiptBtn){
			frame.setRightComponent(new CollectionPanel(frame));	
		}
		else if(arg0.getSource()==aboutBtn){			
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
		if(e.getSource()==accountBtn)
			accountBtn.setBackground(color[1]);
		else if(e.getSource()==receiptBtn)
			receiptBtn.setBackground(color[1]);
		else if(e.getSource()==showReportBtn)
			showReportBtn.setBackground(color[1]);
		else if(e.getSource()==initialBtn)
			initialBtn.setBackground(color[1]);
		
	}

	public void mouseExited(MouseEvent e) {
		if(e.getSource()==accountBtn)
			accountBtn.setBackground(color[0]);
		else if(e.getSource()==receiptBtn)
			receiptBtn.setBackground(color[0]);
		else if(e.getSource()==showReportBtn)
			showReportBtn.setBackground(color[0]);
		else if(e.getSource()==initialBtn)
			initialBtn.setBackground(color[0]);
		
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}