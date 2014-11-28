package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class GoodsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addGoodsBtn, delGoodsBtn, modGoodsBtn, searchBtn;
	JTextField searchFld;
	JTree goodsClassTree;
	JTable goodsTable;
	Color stockColor = new Color(51, 125, 86);
	String keyWord;

	public GoodsPanel() {
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(3, 3, 3, 3);
		//
		addGoodsBtn = new JButton("添加商品", new ImageIcon(
				"img/sales/memberMgr.png"));
		addGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addGoodsBtn.setForeground(stockColor);
		addGoodsBtn.setBorderPainted(false);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new AddGoodsBtnListener());
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.08;
		c.weighty = 0.08;
		gbl.setConstraints(addGoodsBtn, c);
		this.add(addGoodsBtn);
		//
		delGoodsBtn = new JButton("删除商品", new ImageIcon(
				"img/sales/memberMgr.png"));
		delGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delGoodsBtn.setForeground(stockColor);
		delGoodsBtn.setBorderPainted(false);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new DelGoodsBtnListener());
		c.gridx = 1;
		gbl.setConstraints(delGoodsBtn, c);
		this.add(delGoodsBtn);
		//
		modGoodsBtn = new JButton("修改商品信息", new ImageIcon(
				"img/sales/memberMgr.png"));
		modGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		modGoodsBtn.setForeground(stockColor);
		modGoodsBtn.setBorderPainted(false);
		modGoodsBtn.setBackground(Color.white);
		modGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		modGoodsBtn.setFocusPainted(false);
		modGoodsBtn.addActionListener(new ModGoodsBtnListener());
		c.gridx = 2;
		gbl.setConstraints(modGoodsBtn, c);
		this.add(modGoodsBtn);
		//
		// 搜索框
		searchFld = new JTextField();
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		c.gridx = 3;
		c.gridwidth=2;
		c.weightx = 0.6;
		c.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(searchFld, c);
		this.add(searchFld);
		// 查找按钮
		searchBtn = new JButton(new ImageIcon("img/sales/find-blue.png"));
		searchBtn.setForeground(stockColor);
		searchBtn.setBorderPainted(false);
		searchBtn.setBackground(Color.white);
		searchBtn.setHorizontalAlignment(SwingConstants.LEFT);
		searchBtn.setFocusPainted(false);
		searchBtn.addActionListener(new SearchBtnListener());
		c.gridx = 5;
		c.weightx = 0.08;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(searchBtn, c);
		this.add(searchBtn);
		// -------blank-----------------------
		JLabel blankLbl = new JLabel();
		c.gridx = 6;
		c.weightx = 0.2;
		gbl.setConstraints(blankLbl, c);
		this.add(blankLbl);
		// ---------goodsClassTree-------------------
		goodsClassTree=new JTree();
		goodsClassTree.setBackground(Color.black);
		c.insets = new Insets(10,3,10,3);
		c.gridx = 0;
		c.gridy=1;
		c.gridheight=GridBagConstraints.REMAINDER;
		c.gridwidth=2;
		c.weightx = 0.1;
		c.weighty=50;
		gbl.setConstraints(goodsClassTree, c);
		this.add(goodsClassTree);
		//----------goodsTable------------------
		goodsTable=new JTable();
		goodsTable.setBackground(Color.blue);
		c.gridx =2;
		c.gridy=1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.weightx = 0.6;
		c.weighty=0.92;
		gbl.setConstraints(goodsTable, c);
		this.add(goodsTable);
	}

	class AddGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			JDialog addGoodsDlg=new AddGoodsDialog();

		}

	}

	class DelGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JDialog delGoodsDlg=new DelGoodsDialog();

		}

	}

	class ModGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JDialog modGoodsDlg=new ModGoodsDialog();

		}

	}

	class SearchFldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void removeUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void changedUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

	}

	class SearchBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 800, 500);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GoodsPanel gp = new GoodsPanel();
		gp.setBounds(0, 0, 800, 500);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
