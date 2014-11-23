package Presentation.salesui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Presentation.uihelper.UIhelper;

/*进货销售人员主界面
 * by wn,2014.11.19
 */
public class SalesMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel leftPnl, rightPnl;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int frameWidth = screenWidth * 85 / 100;
	int frameHeight = screenHeight * 85 / 100;

	public SalesMainFrame() {
		// ---------------界面实现区，功能实现请勿写在区域内-------------------------------------------
		this.setBounds((screenWidth - frameWidth) / 2,
				(screenHeight - frameHeight) / 2, frameWidth, frameHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		//左侧菜单Panel
		leftPnl = new SalesLeftPanel(frameWidth, frameHeight);
		c.gridx = 0; // x grid position
		c.gridy = 0; // y grid position
		c.weightx=0.05;
		c.weighty=1;
		gbl.setConstraints(leftPnl, c);
		this.add(leftPnl);
		//右侧欢迎Panel
		rightPnl=new JPanel(){
			/**
			 * 
			 */
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		ImageIcon icon = new ImageIcon("img/sales/welcome.jpg");
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, icon.getIconWidth(),
				icon.getIconHeight(), icon.getImageObserver());
	}
		};
		c.gridx=1;
		c.gridy=0;
		c.weightx=0.82;
		c.weighty=1;
		gbl.setConstraints(rightPnl, c);
		rightPnl.setBackground(Color.black);
		this.add(rightPnl);
		// 设置图标和可见性
		this.setIconImage(UIhelper.getImage("img/icon.png"));	
		this.setVisible(true);
	}

	public static void main(String[] args) {
		SalesMainFrame smf = new SalesMainFrame();
	}
}
