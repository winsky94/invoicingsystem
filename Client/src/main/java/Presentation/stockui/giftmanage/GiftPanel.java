package Presentation.stockui.giftmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentation.uihelper.DateChooser;

public class GiftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame father;
	JButton giftBtn;
	DateChooser fromDC,toDC;
	JScrollPane jsp;
	JTable giftTbl;
	GiftTblModel gtm;
	Vector<Vector<String>> c=new Vector<Vector<String>>();
	Color color = new Color(51, 125, 86);
	public GiftPanel(JFrame frame){
		father=frame;
		//
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(10,10,10,10);
		//---------------------------------------
		JPanel topPnl=new JPanel();
		topPnl.setLayout(new GridLayout(1,3));
		//----------------------------------------
		giftBtn=new JButton("创建库存赠送单", new ImageIcon(
				"img/stock/gift.png"));
		giftBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		giftBtn.setForeground(color);
		giftBtn.setBorderPainted(false);
		giftBtn.setBackground(Color.white);
		giftBtn.setFocusPainted(false);
		giftBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JDialog createPnl=new CreateGiftDialog();
			}
		});
		topPnl.add(giftBtn);
		//---------------------------------------------
		fromDC=new DateChooser();
		JLabel f=new JLabel("(起始日期)");
		f.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		fromDC.add(f);
		topPnl.add(fromDC);
		//---------------------------------------------
		toDC=new DateChooser();
		JLabel t=new JLabel("(截止日期)");
		t.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		toDC.add(t);
		topPnl.add(toDC);
		//---------------------------------------------
		c.gridx=0;
		c.gridy=0;
		c.weightx=1;
		c.weighty=0.1;
		c.gridwidth=GridBagConstraints.REMAINDER;
		gbl.setConstraints(topPnl, c);
		this.add(topPnl);
		//----------------------------------------------
		gtm=new GiftTblModel();
		giftTbl=new JTable(gtm);
		jsp=new JScrollPane(giftTbl);
		c.gridx=0;
		c.gridy=1;
		c.weightx=1;
		c.weighty=10;
		c.gridheight=c.gridwidth=GridBagConstraints.REMAINDER;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}
	public static void main(String[] args){
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 900, 550);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel gp = new GiftPanel(testFrame);
		gp.setBounds(0, 0, 1000, 700);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
	class GiftTblModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "赠送单编号", "日期", "审批状态", "商品编号", "商品名", "型号", "数量",
				"客户编号", "客户名" };

		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return c.get(row).get(col);
		}

		public String getColumnName(int col) {
			return head[col];
		}

	}
}
