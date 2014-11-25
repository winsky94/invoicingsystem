package Presentation.salesui.manage.member;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Presentation.uihelper.UIhelper;

public class DelMemberDialog extends JDialog{
	/*
	 * !!!!!!这里的构造器应该传入一个String memberID，根据ID删除！
	 * 
	 * by wn,2014.11.26
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel sureLbl;
	JButton sureBtn;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth /4;
	int dialogHeight = screenHeight / 4;
	public DelMemberDialog(){
		Container pnl=this.getContentPane();
		pnl.setBackground(Color.white);
		pnl.setLayout(null);
		//---------------sureLbl-----------------------------------
		sureLbl=new JLabel("   确定要删除该客户吗？");
		sureLbl.setBounds(dialogWidth*25/100,
				dialogHeight*10/100, dialogWidth*60/100, dialogHeight*30/100);
		sureLbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		pnl.add(sureLbl);
		//---------------sureBtn-----------------------------------
		sureBtn=new JButton("我确定要删除");
		sureBtn.setBounds(dialogWidth*25/100,
				dialogHeight*50/100, dialogWidth*50/100, dialogHeight*15/100);
		sureBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sureBtn.setFocusPainted(false);
		pnl.add(sureBtn);
		//---------------------------------------------------------
		this.setTitle("删除确认");
		this.setBounds((screenWidth - dialogWidth) / 2,
				(screenHeight - dialogHeight) / 2, dialogWidth, dialogHeight);
		this.setResizable(false);
		this.setModal(true);
		this.setIconImage(UIhelper.getImage("img/sales/delMember-blue.png"));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
