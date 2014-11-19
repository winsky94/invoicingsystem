package Presentation.salesui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SalesLeftPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JButton purchaseBtn,saleBtn,memberBtn;
	JPanel UserInfoPnl;
	public SalesLeftPanel(int frameWidth,int frameHeight){
		this.setSize(frameWidth/5,frameHeight);
		this.setBackground(Color.black);
		
	}

}
