package Presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import Presentation.uihelper.UIhelper;

public class ChangeKeyDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 构造器里应当传来一个User
	 */
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 32 / 100;
	int dlgHeight = screenHeight * 40 / 100;
	JPanel pnl;
	JPasswordField oldKeyFld, newKeyFld, sureFld;
	JButton submitBtn;

	public ChangeKeyDialog() {
		pnl = new JPanel() {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("img/changekey.jpeg");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(),
						icon.getIconHeight(), icon.getImageObserver());
			}
		};
		;
		pnl.repaint();
		this.add(pnl);
		pnl.setLayout(null);
		// ------OldKey------------------
		JLabel oldLbl = new JLabel("原密码：");
		oldLbl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		oldLbl.setBounds(dlgWidth * 15 / 100, dlgHeight * 20 / 100,
				dlgWidth * 20 / 100, dlgHeight * 8 / 100);
		pnl.add(oldLbl);
		oldKeyFld = new JPasswordField();
		oldKeyFld.setBounds(dlgWidth * 31 / 100, dlgHeight * 20 / 100,
				dlgWidth * 51 / 100, dlgHeight * 8 / 100);
		pnl.add(oldKeyFld);
		// --------newKey----------------
		JLabel newLbl = new JLabel("新密码：");
		newLbl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		newLbl.setBounds(dlgWidth * 15 / 100, dlgHeight * 35 / 100,
				dlgWidth * 20 / 100, dlgHeight * 8 / 100);
		pnl.add(newLbl);
		newKeyFld = new JPasswordField();
		newKeyFld.setBounds(dlgWidth * 31 / 100, dlgHeight * 35 / 100,
				dlgWidth * 51 / 100, dlgHeight * 8 / 100);
		pnl.add(newKeyFld);
		// --------sureKey----------------
		JLabel sureLbl = new JLabel("新密码确认：");
		sureLbl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		sureLbl.setBounds(dlgWidth * 8 / 100, dlgHeight * 50 / 100,
				dlgWidth * 22 / 100, dlgHeight * 8 / 100);
		pnl.add(sureLbl);
		sureFld = new JPasswordField();
		sureFld.setBounds(dlgWidth * 31 / 100, dlgHeight * 50 / 100,
				dlgWidth * 51 / 100, dlgHeight * 8 / 100);
		pnl.add(sureFld);
		// -------submit-------------------
		submitBtn = new JButton("确认修改");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.setBounds(dlgWidth * 40 / 100, dlgHeight * 75 / 100,
				dlgWidth * 20 / 100, dlgHeight * 8 / 100);
		pnl.add(submitBtn);
		//
		this.setTitle("修改密码");
		this.setBounds((screenWidth - dlgWidth) / 2,
				(screenHeight - dlgHeight) / 2, dlgWidth, dlgHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		JDialog c = new ChangeKeyDialog();
	}
}
