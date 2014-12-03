package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Presentation.mainui.MainFrame;

//查看三表
public class ReportMgrPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color color = new Color(115, 46, 126);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MyButton refreshBtn,exportBtn,findBtn;
	JButton filterBtn;
	MainFrame father;
	JTabbedPane tab;
	JScrollPane jsp1,jsp2,jsp3;//销售明细表；经营历程表；经营情况表
	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(font);
			this.setForeground(color);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}

		MyButton(Icon icon) {
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}
}
