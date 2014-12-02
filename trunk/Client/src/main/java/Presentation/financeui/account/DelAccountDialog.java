package Presentation.financeui.account;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import Presentation.mainui.MainFrame;
import Presentation.uihelper.UIhelper;

public class DelAccountDialog extends JDialog{
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
	public DelAccountDialog(final ArrayList<String> ID,MainFrame frame){
		Container pnl=this.getContentPane();
		pnl.setBackground(Color.white);
		pnl.setLayout(null);
		//---------------sureLbl-----------------------------------
		sureLbl=new JLabel("确定要删除所选账户吗？");
		sureLbl.setBounds(dialogWidth*25/100,
				dialogHeight*10/100, dialogWidth*60/100, dialogHeight*30/100);
		sureLbl.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		pnl.add(sureLbl);
		//---------------sureBtn-----------------------------------
		sureBtn=new JButton("我确定要删除");
		sureBtn.setBounds(dialogWidth*25/100,
				dialogHeight*50/100, dialogWidth*50/100, dialogHeight*15/100);
		sureBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		sureBtn.setFocusPainted(false);
		sureBtn.setBackground(new Color(251, 147, 121));
		pnl.add(sureBtn);
		
		//---------------------------------------------------------
		this.setTitle("删除确认");
		this.setBounds((screenWidth - dialogWidth) / 2,
				(screenHeight - dialogHeight) / 2, dialogWidth, dialogHeight);
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args){
//		JDialog Del=new DelAccountDialog();
	}
}
