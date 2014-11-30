package Presentation.promotionui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.UserVO;
import Presentation.mainui.JLeftButton;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.uihelper.AboutPanel;
public class ProLeftShortPanel extends JPanel implements ActionListener{
	JLabel head;
	JLeftButton receipt,promotion,view,backBtn,aboutBtn;
	Color color;
	headPane headPane;
	MainFrame parent;
	public ProLeftShortPanel(MainFrame frame){
		parent=frame;
		UserVO user=parent.getUser();
		color=parent.getTheme()[0];
		GridBagLayout grid=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
	
		this.setLayout(grid);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;c.gridy=0;
		c.gridheight=2;
		
		headPane=new headPane(parent,this,user,1);
		grid.setConstraints(headPane, c);
		this.add(headPane);
		
		JPanel down=new JPanel();
		c.weightx=3;c.weighty=4;
		c.gridx=0;c.gridy=2;
		c.gridheight=6;
		c.gridwidth=1;
		grid.setConstraints(down, c);
		this.add(down);
		down.setBackground(color);
		down.setLayout(new GridLayout(6,1));
		
		
		
		ImageIcon receiptImg=new ImageIcon("img/promotion/receiptView.png");
		receipt=new JLeftButton(receiptImg,color);
	
		ImageIcon proImg=new ImageIcon("img/promotion/promotion.png");
		promotion=new JLeftButton(proImg,color);
	
		ImageIcon viewImg=new ImageIcon("img/promotion/view.png");
		
		view=new JLeftButton(viewImg,color);
	
		
		receipt.addActionListener(this);
		promotion.addActionListener(this);
		view.addActionListener(this);
		
		aboutBtn = new JLeftButton( new ImageIcon("img/icon-about.png"),
				color);
		
		aboutBtn.addActionListener(this);
		
		

		
		down.add(receipt);
		down.add(promotion);
		down.add(view);
		down.add(aboutBtn);
		
		
		backBtn=new JLeftButton(new ImageIcon("img/mainFrame/backLong.png"),
				color);
		
		backBtn.addActionListener(this);
		c.gridx=0;c.gridy=8;
		grid.setConstraints(backBtn, c);
		this.add(backBtn);
		this.setBackground(color);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==promotion){
			//promotion.setBackground(parent.getTheme()[1]);;
			parent.setRightComponent(new PromotionPanel(parent));
		}else if(e.getSource()==backBtn){
			parent.setLeftComponent(new ProLeftPanel(parent));
		}else if(e.getSource()==view){
			
		}else if(e.getSource()==receipt){
			
		}else if(e.getSource()==aboutBtn){
			parent.setRightComponent(new AboutPanel());
		}
	}
	

}
