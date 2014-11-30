package Presentation.promotionui.addpromotion;

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

public class AddBarginPanel extends ChooseGoodsFatherPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DateChooser from,to;
	JFrame father;
	JScrollPane jsp;
	JTable table;
	AddBarginModel btm;
	JButton submitBtn,exitBtn,addGoodsBtn,delGoodsBtn;
	//设置特价包价格
	JTextField priceFld;
	//选择用户等级限制
	JComboBox<String> memberGradeBox;
	//根据table中的商品信息计算出defaultTotal，通过defaultTotalLbl显示到界面上
	JLabel defaultTotalLbl;
	double defaultTotal;
	//---
	public AddBarginPanel(JFrame myFather){
		this.setBackground(Color.white);
		father =myFather;
		this.setLayout(new GridLayout(1,2));
		JPanel left=new JPanel();
		left.setBackground(Color.white);
		this.add(left);
		JPanel right=new JPanel();
		right.setBackground(Color.white);
		this.add(right);
		//--------left-----------------------
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,10,5,10);
		left.setLayout(gbl);
		JLabel title=new JLabel("创建特价包");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		c.gridx=0;
		c.gridy=0;
		c.gridheight=1;
		c.gridwidth=2;
		c.weightx=0.1;
		c.weighty=0.1;
		gbl.setConstraints(title, c);
		left.add(title);
		//--------表格------------------------
		btm=new AddBarginModel();
		table=new JTable(btm);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		jsp=new JScrollPane(table);
		c.gridx=0;
		c.gridy=1;
		c.gridheight=5;
		c.gridwidth=2;
		c.weightx=10;
		c.weighty=10;
		gbl.setConstraints(jsp, c);
		left.add(jsp);
		//---------增加商品和删除商品按钮---------
		JPanel gPnl=new JPanel();
		gPnl.setLayout(new GridLayout(1,2));
		addGoodsBtn =new JButton("添加商品");
		addGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog addGoodsDlg=new ChooseGoodsDialog(AddBarginPanel.this);
			}
		});
		gPnl.add(addGoodsBtn);
		delGoodsBtn=new JButton("删除商品");
		delGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btm.removeRow(table.getSelectedRow());
				table.revalidate();
			}
		});
		gPnl.add(delGoodsBtn);
		//-----------------------------------
		c.gridx=0;
		c.gridy=7;
		c.gridheight=1;
		c.gridwidth=2;
		c.weightx=0.1;
		c.weighty=0.1;
		gbl.setConstraints(gPnl, c);
		left.add(gPnl);
		//-----right-------------------------
		right.setLayout(new GridLayout(4,2));
		
		//---------选择日期--------------------
		
	}
	class AddBarginModel extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"商品编号","商品名","型号","数量","默认单价"};
		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return c.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		public void addRow(ArrayList<Object> v){
			c.add(v);
		}
		public void removeRow(int row){
			c.remove(row);
		}
	}
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AddBarginPanel gp = new AddBarginPanel(testFrame);
		gp.setBounds(0, 0,  920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
