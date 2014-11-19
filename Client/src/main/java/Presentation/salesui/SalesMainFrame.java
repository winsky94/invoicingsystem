package Presentation.salesui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*进货销售人员主界面
 * by wn,2014.11.19
 */
public class SalesMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel leftPnl, rightPnl;

	public SalesMainFrame() {
		// ---------------界面实现区，功能实现请勿写在区域内-------------------------------------------
		// 此处新建对象
		Container contentPane = getContentPane();
		// 定义布局管理器
		GridBagLayout gbl_main = new GridBagLayout();
		contentPane.setLayout(gbl_main);
		GridBagConstraints gbc_main = new GridBagConstraints();
		// 新建leftPanel
		leftPnl.setBackground(Color.black);
		gbc_main.fill = GridBagConstraints.BOTH;
		gbc_main.gridx = 0;
		gbc_main.gridy = 0;
		gbc_main.weightx = 0.2;
		gbc_main.weighty = 1;
		gbl_main.setConstraints(leftPnl, gbc_main);
		contentPane.add(leftPnl);
		// 新建rightPanel
		rightPnl = new JPanel();
		rightPnl.setBackground(Color.blue);
		gbc_main.gridx = 1;
		gbc_main.gridy = 0;
		gbc_main.weightx = 1;
		gbc_main.weighty = 1;
		gbl_main.setConstraints(rightPnl, gbc_main);
		contentPane.add(rightPnl);
		// 设置leftPanel

		this.setSize(1100, 630);
		this.setLocation(110, 60);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
