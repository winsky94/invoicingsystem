package Presentation.stockui.stockmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import Presentation.mainui.MainFrame;
import Presentation.uihelper.DateChooser;

public class StockPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color stockColor = new Color(51, 125, 86);
	JTabbedPane jtp;
	JPanel stockPnl, overflowPnl, lossPnl;
	JTable stockTbl, overflowTbl, lossTbl;
	JButton overflowBtn, lossBtn, inventoryBtn, exportBtn;
	JPanel fromDateChooser, toDateChooser;
	MainFrame frame;
	Color[] color;

	public StockPanel(/*MainFrame myframe,Color mycolor[]*/) {
	/*	frame=myframe;
		color=mycolor;
	*/	
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(3, 3, 3, 3);
		//
		// ---------overflowBtn----------------------------------
		overflowBtn = new JButton("创建库存报溢单", new ImageIcon(
				"img/stock/overflow.png"));
		overflowBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		overflowBtn.setForeground(stockColor);
		overflowBtn.setBorderPainted(false);
		overflowBtn.setBackground(Color.white);
		overflowBtn.setHorizontalAlignment(SwingConstants.LEFT);
		overflowBtn.setFocusPainted(false);
		overflowBtn.addActionListener(new OverflowBtnListener());
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.1;
		c.weighty = 0.1;
		gbl.setConstraints(overflowBtn, c);
		this.add(overflowBtn);
		// -------------lossBtn-----------------------------------
		lossBtn = new JButton("创建库存报损单", new ImageIcon("img/stock/delete.png"));
		lossBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lossBtn.setForeground(stockColor);
		lossBtn.setBorderPainted(false);
		lossBtn.setBackground(Color.white);
		lossBtn.setHorizontalAlignment(SwingConstants.LEFT);
		lossBtn.setFocusPainted(false);
		lossBtn.addActionListener(new LossBtnListener());		
		c.gridx = 1;
		gbl.setConstraints(lossBtn, c);
		this.add(lossBtn);
		// -----------inventoryBtn---------------------------------
		inventoryBtn = new JButton("库存盘点", new ImageIcon(
				"img/stock/inventory.png"));
		inventoryBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		inventoryBtn.setForeground(stockColor);
		inventoryBtn.setBorderPainted(false);
		inventoryBtn.setBackground(Color.white);
		inventoryBtn.setHorizontalAlignment(SwingConstants.LEFT);
		inventoryBtn.setFocusPainted(false);
		inventoryBtn.addActionListener(new InventoryBtnListener());
		c.gridx = 2;
		gbl.setConstraints(inventoryBtn, c);
		this.add(inventoryBtn);
		// ----------------fromDateChooser----------------------
		fromDateChooser = new DateChooser();
		JLabel fromLbl = new JLabel("(起始日期)");
		fromLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		fromDateChooser.add(fromLbl);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.0001;
		c.weighty = 1;
		gbl.setConstraints(fromDateChooser, c);
		this.add(fromDateChooser);
		// ----------------toDateChooser----------------------
		toDateChooser = new DateChooser();
		JLabel toLbl = new JLabel("(截止日期)");
		toLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		toDateChooser.add(toLbl);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.0001;
		c.weighty = 1;
		gbl.setConstraints(toDateChooser, c);
		this.add(toDateChooser);
		// -----------JTabbedPane----------------------------
		jtp = new JTabbedPane();
		jtp.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 2;
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 100;
		gbl.setConstraints(jtp, c);
		this.add(jtp);
		// ---------------stockPnl---------------------------
		stockPnl = new JPanel();
		stockPnl.setLayout(new GridLayout(1, 1));
		stockTbl = new JTable();
		stockTbl.setBackground(Color.black);
		stockPnl.add(stockTbl);
		jtp.addTab("库存查看", stockPnl);
		// --------------overflowPnl--------------------------------
		overflowPnl = new JPanel();
		overflowPnl.setLayout(new GridLayout(1, 1));
		overflowTbl = new JTable();
		overflowTbl.setBackground(Color.blue);
		overflowPnl.add(overflowTbl);
		jtp.addTab("库存报溢表", overflowPnl);
		// --------------lossPnl--------------------------------
		lossPnl = new JPanel();
		lossPnl.setLayout(new GridLayout(1, 1));
		lossTbl = new JTable();
		lossTbl.setBackground(Color.yellow);
		lossPnl.add(lossTbl);
		jtp.addTab("库存报损表", lossPnl);
	}
	class OverflowBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			frame.setRightComponent(new OverflowPanel(frame,color));
			
		}
		
	}
	class LossBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class InventoryBtnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 800, 500);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StockPanel gp = new StockPanel();
		gp.setBounds(0, 0, 1000, 700);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
