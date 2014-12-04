package Presentation.stockui.stockmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import Presentation.uihelper.DateChooser;

//库存查看
public class StockShowPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DateChooser from, to;
	JButton submitBtn, exitBtn;
	JScrollPane jsp;
	JTable table;
	StockShowTableModel sstm;

	public StockShowPanel() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("库存查看");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// -----------时间段--------------
		c.fill=GridBagConstraints.BOTH;
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
		//
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(timePnl, c);
		this.add(timePnl);
		//------table---------------
		sstm=new StockShowTableModel();
		table=new JTable(sstm);
		jsp=new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
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
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel());
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StockShowPanel gp = new StockShowPanel();
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
	class StockShowTableModel extends AbstractTableModel{

		/**
		 * 没实现
		 */
		private static final long serialVersionUID = 1L;

		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
