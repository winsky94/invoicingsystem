package Presentation.stockui.stockmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.stockui.ChooseGoodsDialog;

public class LossPanel extends ChooseGoodsFatherPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton submitBtn, exitBtn, addGoodsBtn;
	JTextField lossFld;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MainFrame father;
	JLabel IDLbl,nameLbl,sizeLbl,numLbl;
	public LossPanel(MainFrame frame){
		father=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("仓库报损");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.08;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// --------中间-------------------------
		c.fill = GridBagConstraints.BOTH;
		JPanel mid = new JPanel();
		mid.setBackground(Color.white);
		mid.setLayout(new GridLayout(7, 1));
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(mid, c);
		this.add(mid);
		mid.add(new JLabel());
		//---------商品编号-----------------
		JPanel IDPnl=new JPanel();
		IDPnl.setBackground(Color.white);
		mid.add(IDPnl);
		IDLbl=new JLabel("商品编号：____________");
		IDLbl.setFont(font);
		IDPnl.add(IDLbl);
		//--------商品名-------------------
		JPanel namePnl=new JPanel();
		namePnl.setBackground(Color.white);
		mid.add(namePnl);
		nameLbl=new JLabel("商品名：XXXXX");
		nameLbl.setFont(font);
		namePnl.add(nameLbl);
		//--------型号--------------------
		JPanel sizePnl=new JPanel();
		sizePnl.setBackground(Color.white);
		mid.add(sizePnl);
		sizeLbl=new JLabel("型号：XXXXX");
		sizeLbl.setFont(font);
		sizePnl.add(sizeLbl);
		//-------库存数量-------------------
		JPanel numPnl=new JPanel();
		numPnl.setBackground(Color.white);
		mid.add(numPnl);
		numLbl=new JLabel("库存数量：XXXX");
		numLbl.setFont(font);
		numPnl.add(numLbl);
		//--------报损数量-----------------
		JPanel lossPnl=new JPanel();
		lossPnl.setBackground(Color.white);
		mid.add(lossPnl);
		JLabel lossLbl=new JLabel("报损数量：");
		lossLbl.setFont(font);
		lossPnl.add(lossLbl);
		lossFld=new JTextField(6);
		lossFld.setFont(font);
		lossPnl.add(lossFld);
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//
		addGoodsBtn = new JButton("添加商品");
		addGoodsBtn.setFont(font);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog addGoodsDlg = new ChooseGoodsDialog(LossPanel.this);
			}
		});
		btnPnl.add(addGoodsBtn);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
	}
}