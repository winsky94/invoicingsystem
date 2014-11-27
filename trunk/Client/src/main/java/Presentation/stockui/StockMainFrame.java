package Presentation.stockui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Presentation.uihelper.UIhelper;

public class StockMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int frameWidth = screenWidth * 85 / 100;
	int frameHeight = screenHeight * 85 / 100;
	JPanel leftPnl, rightPnl;

	public StockMainFrame() {
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		//
		leftPnl=new StockLeftPanel();
		c.gridx = 0; // x grid position
		c.gridy = 0; // y grid position
		c.weightx = 0.05;
		c.weighty = 1;
		gbl.setConstraints(leftPnl, c);
		this.add(leftPnl);
		
		//
		rightPnl =new StockRightPanel();
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.95;
		c.weighty = 1;
		gbl.setConstraints(rightPnl, c);
		this.add(rightPnl);
		// 设置图标和可见性
		this.setIconImage(UIhelper.getImage("img/icon.png"));
		this.setTitle("进销存系统");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		StockMainFrame smf=new StockMainFrame();
	}

}
