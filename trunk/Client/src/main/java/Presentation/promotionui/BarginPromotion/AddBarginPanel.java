package Presentation.promotionui.BarginPromotion;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.stockui.ChooseGoodsDialog;
import Presentation.uihelper.DateChooser;

public class AddBarginPanel extends ChooseGoodsFatherPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JFrame father;
	JComboBox<String> memberGradeBox;
	DateChooser from, to;
	JButton submitBtn, exitBtn, addGoodsBtn, delGoodsBtn;
	JScrollPane jsp;
	JTable table;
	AddBarginModel btm;
	JLabel defaultTotalLbl;
	JTextField priceFld;

	public AddBarginPanel(JFrame myFather) {
		father = myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("创建特价包");
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
		// --------起止时间，等级限制，原价与现价-----------------
		JPanel timePnl = new JPanel();
		timePnl.setBackground(Color.white);
		JPanel fP = new JPanel();
		fP.setBackground(Color.white);
		fP.add(new JLabel("起始于"));
		from = new DateChooser();
		fP.add(from);
		timePnl.add(fP);
		JPanel tP = new JPanel();
		tP.setBackground(Color.white);
		tP.add(new JLabel("截止于"));
		to = new DateChooser();
		tP.add(to);
		timePnl.add(tP);
		JPanel gradePnl = new JPanel();
		gradePnl.setBackground(Color.white);
		timePnl.add(gradePnl);
		JLabel gradeLbl = new JLabel("等级限制：");
		gradeLbl.setFont(font);
		gradePnl.add(gradeLbl);
		String boxText[] = { "ONE", "TWO", "THREE", "FOUR", "FIVE" };
		memberGradeBox = new JComboBox<String>(boxText);
		memberGradeBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		memberGradeBox.setBackground(Color.white);
		gradePnl.add(memberGradeBox);

		//
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.04;
		gbl.setConstraints(timePnl, c);
		this.add(timePnl);
		// ---------------------------------
		JPanel moneyPnl = new JPanel();
		moneyPnl.setBackground(Color.white);
		moneyPnl.setLayout(new GridLayout(1,5));
		moneyPnl.add(new JLabel());
		defaultTotalLbl = new JLabel("原价：加监听");
		defaultTotalLbl.setFont(font);
		moneyPnl.add(defaultTotalLbl);
		
		// ---------------------------------
		JPanel nowPnl=new JPanel();
		nowPnl.setBackground(Color.white);
		JLabel priceLbl = new JLabel("定价：");
		priceLbl.setFont(font);
		nowPnl.add(priceLbl);
		priceFld = new JTextField(8);
		priceFld.setFont(font);
		nowPnl.add(priceFld);
		moneyPnl.add(nowPnl);
		moneyPnl.add(new JLabel());
		//
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.weightx = 0.000001;
		c.weighty = 0.04;
		gbl.setConstraints(moneyPnl, c);
		this.add(moneyPnl);
		// -------表格-------------------
		
		btm = new AddBarginModel();
		table = new JTable(btm);
		jsp = new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 10;
		c.weighty = 10;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
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
				JDialog addGoodsDlg = new ChooseGoodsDialog(AddBarginPanel.this);
			}
		});
		btnPnl.add(addGoodsBtn);
		delGoodsBtn = new JButton("删除商品");
		delGoodsBtn.setFont(font);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delGoodsBtn);
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

	class AddBarginModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "商品编号", "商品名", "型号", "数量", "默认单价" };

		public int getRowCount() {
			return cmContent.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return cmContent.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}

		public void addRow(ArrayList<String> v) {

			cmContent.add(v);
		}

		public void removeRow(int row) {
			cmContent.remove(row);
		}
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AddBarginPanel gp = new AddBarginPanel(testFrame);
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
