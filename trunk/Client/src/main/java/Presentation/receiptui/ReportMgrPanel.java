package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Presentation.mainui.MainFrame;
import Presentation.receiptui.tablemodels.OperationHistoryTableModel;
import Presentation.receiptui.tablemodels.OperationStatementTableModel;
import Presentation.receiptui.tablemodels.SaleDetailTableModel;

//查看三表
public class ReportMgrPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String keyword;//注意：搜索框的监听已经写好，需要获取搜索框内容时直接用这个字符串就行！
	Color color = new Color(115, 46, 126);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MyButton refreshBtn,exportBtn,findBtn,filterBtn;
	JTextField findFld;
	MainFrame father;
	JTabbedPane tab;
	SaleDetailTableModel sdtm;//销售明细表
	OperationHistoryTableModel ohtm;//经验历程表
	OperationStatementTableModel ostm;//经营情况表
	JTable t1,t2,t3;//销售明细表；经营历程表；经营情况表
	JScrollPane jsp1,jsp2,jsp3;//销售明细表；经营历程表；经营情况表
	public ReportMgrPanel(MainFrame frame){
		father=frame;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3,10, 3,10);
		c.fill = GridBagConstraints.BOTH;
		// -----------------------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//------刷新按钮------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/promotion/refresh.png"));
		refreshBtn.addActionListener(this);
		btnPnl.add(refreshBtn);
		//-----导出按钮-------------
		exportBtn=new MyButton("导出",new ImageIcon("img/promotion/export.png"));
		exportBtn.addActionListener(this);
		btnPnl.add(exportBtn);
		//-----搜索框---------------
		findFld=new JTextField(13);
		findFld.setFont(font);
		findFld.getDocument().addDocumentListener(new DocumentListener() {
			
			public void removeUpdate(DocumentEvent e) {
				keyword=findFld.getText();
				
			}
			
			public void insertUpdate(DocumentEvent e) {
				keyword=findFld.getText();
				
			}
			
			public void changedUpdate(DocumentEvent e) {
				keyword=findFld.getText();
				
			}
		});
		btnPnl.add(findFld);
		//-----搜索按钮-------------
		findBtn=new MyButton(new ImageIcon("img/promotion/find.png"));
		btnPnl.add(findBtn);
		//-----筛选按钮-------------
		filterBtn=new MyButton("展开筛选条件");
		btnPnl.add(filterBtn);
		//-----tab-----------------
		tab=new JTabbedPane();
		tab.setBackground(Color.white);
		tab.setForeground(color);
		tab.setFont(font);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight =5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(tab, c);
		this.add(tab);
		//------销售明细表--------------
		sdtm=new SaleDetailTableModel();
		t1=new JTable(sdtm);
		jsp1=new JScrollPane(t1);
		tab.add("销售明细表",jsp1);
		//------经营历程表--------------
		ohtm=new OperationHistoryTableModel();
		t2=new JTable(sdtm);
		jsp2=new JScrollPane(t2);
		tab.add("经营历程表",jsp2);
		//-------经营情况表--------------
		ostm=new OperationStatementTableModel();
		t3=new JTable(ostm);
		jsp3=new JScrollPane(t3);
		tab.add("经营情况表", jsp3);
		
		
	}
	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(font);
			this.setForeground(color);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
		MyButton(String text){
			super(text);
			this.setFont(font);
			this.setForeground(color);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
		MyButton(Icon icon) {
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
