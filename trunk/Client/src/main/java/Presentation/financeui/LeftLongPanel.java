package Presentation.financeui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.receiptui.ReportMgrPanel;
import Presentation.uihelper.AboutPanel;
import businesslogic.financebl.Account;
import businesslogic.financebl.CashList;
import businesslogic.financebl.Collection;
import businesslogic.financebl.Payment;
import businesslogicservice.financeblservice.accountblservice.FinanceAccountBLService;
import businesslogicservice.financeblservice.listblservice.CashlistBLService;
import businesslogicservice.financeblservice.listblservice.CollectionBLService;
import businesslogicservice.financeblservice.listblservice.PaymentBLService;

public class LeftLongPanel extends JPanel implements ActionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel headPane;
	JLeftButton accountBtn,collectionBtn,reportBtn,initialBtn,foldBtn,aboutBtn;
	MainFrame frame;
	Color[] color;
	
	public LeftLongPanel(MainFrame myframe){
		
		frame=myframe;
		color=myframe.getTheme();
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		UserVO user=frame.getUser();
		this.setLayout(grid);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(frame,this,user,0);
		grid.setConstraints(headPane, c);
		this.add(headPane);
		
		//=======功能键构造
		JPanel down=new JPanel();
		c.weightx=3;c.weighty=4;
		c.gridx=0;c.gridy=2;
		c.gridheight=6;
		c.gridwidth=1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(color[0]);
		down.setLayout(new GridLayout(6,1));
		
		//
		accountBtn=new JLeftButton("账户管理",new ImageIcon("img/finance/accountMgr.png"),
				color[0]);
		accountBtn.addMouseListener(this);
		accountBtn.addActionListener(this);
		down.add(accountBtn);
		collectionBtn=new JLeftButton("制定单据",new ImageIcon("img/finance/receiptMgr.png"),
				color[0]);
		collectionBtn.addActionListener(this);
		collectionBtn.addMouseListener(this);
		down.add(collectionBtn);
		
		reportBtn=new JLeftButton("查看报表",new ImageIcon("img/finance/showReport.png"),
				color[0]);
		reportBtn.addActionListener(this);
		reportBtn.addMouseListener(this);
		down.add(reportBtn);
		
		initialBtn=new JLeftButton("期初建账",new ImageIcon("img/finance/initialAccount.png"),
				color[0]);
		initialBtn.addActionListener(this);
		initialBtn.addMouseListener(this);
		down.add(initialBtn);
		
		aboutBtn = new JLeftButton("关于系统", new ImageIcon("img/icon-about.png"),
				color[0]);
		aboutBtn.addActionListener(this);
		aboutBtn.addMouseListener(this);
		down.add(aboutBtn);
		
		
		
		
		
		foldBtn=new JLeftButton("收起菜单",new ImageIcon("img/mainFrame/back.png"),
				color[0]);
		foldBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(foldBtn, c);
		this.add(foldBtn);
		this.setBackground(color[0]);
		
    

		
	}


	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==accountBtn)
			accountBtn.setBackground(color[1]);
		else if(e.getSource()==collectionBtn)
			collectionBtn.setBackground(color[1]);
		else if(e.getSource()==reportBtn)
			reportBtn.setBackground(color[1]);
		else if(e.getSource()==initialBtn)
			initialBtn.setBackground(color[1]);
		else if(e.getSource()==aboutBtn)
			aboutBtn.setBackground(color[1]);
	}


	public void mouseExited(MouseEvent e) {
		if(e.getSource()==accountBtn)
			accountBtn.setBackground(color[0]);
		else if(e.getSource()==collectionBtn)
			collectionBtn.setBackground(color[0]);
		else if(e.getSource()==reportBtn)
			reportBtn.setBackground(color[0]);
		else if(e.getSource()==initialBtn)
			initialBtn.setBackground(color[0]);
		else if(e.getSource()==aboutBtn)
			aboutBtn.setBackground(color[0]);
	}
		


	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==accountBtn){
			AccountPanel mgr=new AccountPanel(frame);
			FinanceAccountBLService service;
			try {
				service = new Account();
				frame.setRightComponent(mgr);
				if( service.showAll()!=null)
					mgr.RefreshAccountTable(service.showAll());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==collectionBtn){
			CollectionPanel mgr = new CollectionPanel(frame);
      		frame.setRightComponent(mgr);
        	
			try {
				PaymentBLService pp=new Payment();
				CollectionBLService bb=new Collection();
	  			CashlistBLService cc=new CashList();
	  			if (pp.getPayment()!= null)
	  			    mgr.RefreshPaymentTable(pp.getPayment());
	  			if(bb.getCollection()!=null)
	  			    mgr.RefreshCollectionTable(bb.getCollection());
	  			if(cc.getCashlist()!=null)
	  				mgr.RefreshCashlistTable(cc.getCashlist());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  			

  				mgr.setSelectedTab(0);
		}
		else if(e.getSource()==reportBtn){
			ReportMgrPanel report;
			try {
				report = new ReportMgrPanel(frame);
				frame.setRightComponent(report);
				report.RefreshTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==initialBtn){
			InitialPanel alp=new InitialPanel(frame);
			frame.setRightComponent(alp);
		}
		else if(e.getSource()==foldBtn){			
			frame.setLeftComponent(new LeftShortPanel(frame));
		}
		else if(e.getSource()==aboutBtn)
			frame.setRightComponent(new AboutPanel());
		
	}
		
}
