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
import Presentation.promotionui.addpromotion.AddBarginPanel.AddBarginModel;
import Presentation.stockui.ChooseGoodsDialog;
import Presentation.uihelper.DateChooser;

public class AddGiftPanel extends ChooseGoodsFatherPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font=new Font("微软雅黑", Font.BOLD, 15);
	JFrame father;
	JTextField limitFld;
	DateChooser from,to;
	JScrollPane jsp;
	JTable table;
	AddGiftModel btm;
	JComboBox<String> memberGradeBox;
	JButton submitBtn,exitBtn,addGoodsBtn,delGoodsBtn;
	public AddGiftPanel(JFrame myFather){
		father=myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,45,10,45);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		//-----------title------------------
		JPanel titlePnl=new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1,1));
		JLabel title = new JLabel("制定赠品赠送策略");
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
		//---------function---------------------
		JPanel mPnl = new JPanel();
		mPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth =GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		c.fill=GridBagConstraints.BOTH;
		gbl.setConstraints(mPnl, c);
		this.add(mPnl);
		GridBagLayout bl=new GridBagLayout();
		GridBagConstraints bc=new GridBagConstraints();
		mPnl.setLayout(bl);
		//--------------------------------------
		bc.fill=GridBagConstraints.BOTH;
		btm=new AddGiftModel();
		table=new JTable(btm);
		jsp=new JScrollPane(table);
		bc.gridx=0;
		bc.gridy=0;
		bc.gridheight=5;
		bc.gridwidth=2;
		bc.weightx=10;
		bc.weighty=10;
		bl.setConstraints(jsp, bc);
		mPnl.add(jsp);
		//---------增加商品和删除商品按钮---------
		JPanel gPnl=new JPanel();
		gPnl.setLayout(new GridLayout(1,2));
		addGoodsBtn =new JButton("添加商品");
		addGoodsBtn.setFont(font);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog addGoodsDlg=new ChooseGoodsDialog(AddGiftPanel.this);
			}
		});
		gPnl.add(addGoodsBtn);
		delGoodsBtn=new JButton("删除商品");
		delGoodsBtn.setFont(font);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//监听！！！！！！！！
			}
		});
		gPnl.add(delGoodsBtn);
		//-----------------------------------
		bc.gridx=0;
		bc.gridy=6;
		bc.gridheight=1;
		bc.gridwidth=2;
		bc.weightx=0.1;
		bc.weighty=0.1;
		bl.setConstraints(gPnl,bc);
		mPnl.add(gPnl);
		//--------right-----------------------
		JPanel rightPnl=new JPanel();
		rightPnl.setBackground(Color.white);
		bc.gridx=2;
		bc.gridy=0;
		bc.gridheight=8;
		bc.gridwidth=2;
		bc.weightx=30;
		bc.weighty=30;
		bl.setConstraints(rightPnl,bc);
		mPnl.add(rightPnl);
		rightPnl.setLayout(new GridLayout(6,1));
		//---------起止时间---------------------
		JPanel timePnl = new JPanel();
		timePnl.setBackground(Color.white);
		rightPnl.add(timePnl);
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
		//----------客户等级限制-----------------
		JPanel gradePnl=new JPanel();
		gradePnl.setBackground(Color.white);
		JLabel gradeLbl=new JLabel("客户等级限制：");
		gradeLbl.setFont(font);
		gradePnl.add(gradeLbl);
		String boxText[]={"ONE","TWO","THREE","FOUR","FIVE"};
		memberGradeBox=new JComboBox<String>(boxText);
		memberGradeBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		memberGradeBox.setBackground(Color.white);
		gradePnl.add(memberGradeBox);
		rightPnl.add(gradePnl);
		//---------满赠金额设置------------------
		JPanel limitPnl = new JPanel();
		limitPnl.setBackground(Color.white);
		rightPnl.add(limitPnl);
		JLabel limitLbl = new JLabel("满赠金额：");
		limitLbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		limitPnl.add(limitLbl);
		limitFld = new JTextField(11);
		limitFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		limitPnl.add(limitFld);
		//---------buttons--------------------
		rightPnl.add(new JLabel());
		rightPnl.add(new JLabel());
		JPanel btnPnl=new JPanel();
		btnPnl.setBackground(Color.white);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("           "));
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
		rightPnl.add(btnPnl);
	}
	class AddGiftModel extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[]={"商品编号","商品名","型号","默认单价"};
		public int getRowCount() {
			return cmContent.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return cmContent.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
		public void addRow(ArrayList<String> v){
			cmContent.add(v);
		}
		public void removeRow(int row){
			cmContent.remove(row);
		}
	}
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AddGiftPanel gp = new AddGiftPanel(testFrame);
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
