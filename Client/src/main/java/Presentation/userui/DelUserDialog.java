package Presentation.userui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Presentation.uihelper.UIhelper;

public class DelUserDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submitBtn;
	JLabel textLbl;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 25 / 100;
	int dlgHeight = screenHeight * 25 / 100;
	Container pnl;

	public DelUserDialog() {
		pnl = this.getContentPane();
		pnl.setBackground(Color.white);
		pnl.setLayout(null);
		//
		// ------------------textLbl------------------------------------
		textLbl = new JLabel("你确定要删除此用户吗？");
		textLbl.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		textLbl.setBounds(dlgWidth * 28 / 100, dlgHeight * 20 / 100,
				dlgWidth * 80 / 100, dlgHeight * 16 / 100);
		pnl.add(textLbl);
		// -------------------submitBtn---------------------------------------------
		submitBtn = new JButton("确定删除");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		submitBtn.setBounds(dlgWidth * 35 / 100, dlgHeight * 58 / 100,
				dlgWidth * 30 / 100, dlgHeight * 16 / 100);
		submitBtn.setFocusPainted(false);
		pnl.add(submitBtn);
		//
		this.setTitle("删除确认");
		this.setBounds((screenWidth - dlgWidth) / 2,
				(screenHeight - dlgHeight) / 2, dlgWidth, dlgHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
