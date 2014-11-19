package Presentation.salesui;

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
		this.setLayout(null);
		//设置图标
        this.setIconImage(UIhelper.getImage("img/icon.jpg"));
        leftPnl=new SalesLeftPanel(frameWidth, frameHeight);
        leftPnl.setLocation(0, 0);
        this.add(leftPnl);
        this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args){
		SalesMainFrame smf=new SalesMainFrame();
	}
}
