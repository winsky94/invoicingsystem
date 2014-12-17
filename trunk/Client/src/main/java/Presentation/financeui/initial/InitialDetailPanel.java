package Presentation.financeui.initial;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Presentation.mainui.MainFrame;

public class InitialDetailPanel extends AddInitialPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel timeLbl,userLbl, remarkLbl;
	JPanel infoPnl;
	public InitialDetailPanel(MainFrame frame) {
		super(frame);
		title.setText("账套详情");
		exitBtn.setBackground(new Color(166, 210, 121));
		exitBtn.setText("返回");
		btnPnl.remove(submitBtn);
		//--------------------------------
		infoPnl=new JPanel();
		infoPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.08;
		gbl.setConstraints(infoPnl, c);
		this.add(infoPnl, c);
		//---------建账时间---------------
		timeLbl=new JLabel("建账时间：嗷嗷嗷嗷");
		timeLbl.setFont(font);
		infoPnl.add(timeLbl);
		//----------操作员------------------
		userLbl=new JLabel("操作员：嗷嗷嗷");
		userLbl.setFont(font);
		infoPnl.add(userLbl);
		//----------备注-------------------
		remarkLbl=new JLabel("备注：嗷嗷嗷嗷嗷嗷嗷嗷嗷嗷嗷嗷");
		remarkLbl.setFont(font);
		infoPnl.add(remarkLbl);
		//--------------------------------
		goodsInitialPanel.btnPnl.remove(goodsInitialPanel.addBtn);
		goodsInitialPanel.btnPnl.remove(goodsInitialPanel.delBtn);
		goodsInitialPanel.remove(goodsInitialPanel.btnPnl);
		//---------------------------
		memberInitialPanel.btnPnl.remove(memberInitialPanel.addBtn);
		memberInitialPanel.btnPnl.remove(memberInitialPanel.delBtn);
		memberInitialPanel.btnPnl.remove(memberInitialPanel.memberBox);
		memberInitialPanel.remove(memberInitialPanel.btnPnl);
		//----------------------------
		accountInitialPanel.btnPnl.remove(accountInitialPanel.addBtn);
		accountInitialPanel.btnPnl.remove(accountInitialPanel.delBtn);
		accountInitialPanel.btnPnl.remove(accountInitialPanel.accountBox);
		accountInitialPanel.remove(accountInitialPanel.btnPnl);
		//----------------------------
	}

}
