package Presentation.receiptui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Presentation.mainui.MainFrame;
import Presentation.mainui.XLSFilter;
import Presentation.receiptui.tablemodels.OperationHistoryTableModel;
import Presentation.receiptui.tablemodels.OperationStatementTableModel;
import Presentation.receiptui.tablemodels.SaleDetailTableModel;
import Presentation.uihelper.DateChooser;

//查看三表
public class ReportMgrPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String keyword;// 注意：搜索框的监听已经写好，需要获取搜索框内容时直接用这个字符串就行！
	Color color = new Color(115, 46, 126);
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	MyButton refreshBtn, exportBtn, findBtn, filterBtn;
	JTextField findFld,nameFld,stockFld;
	MainFrame father;
	//
	DateChooser from, to;
	MyCheckBox nameBox, memberBox, clerkBox, stockBox;
	JComboBox<String> receiptTypeBox,memberCbox,clerkCbox;
	//
	JTabbedPane tab,toptab;
	SaleDetailTableModel sdtm;// 销售明细表
	OperationHistoryTableModel ohtm;// 经验历程表
	OperationStatementTableModel ostm;// 经营情况表
	JTable t1, t2, t3;// 销售明细表；经营历程表；经营情况表
	JScrollPane jsp1, jsp2, jsp3;// 销售明细表；经营历程表；经营情况表

	public ReportMgrPanel(MainFrame frame) {
		father = frame;
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(1, 10, 1, 10);
		c.fill = GridBagConstraints.BOTH;
		//------toptab------------------
		toptab=new JTabbedPane();
		
		//toptab.setUI(ui);
		toptab.setBackground(Color.white);
		toptab.setFont(font);
		toptab.setForeground(color);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(toptab, c);
		this.add(toptab);
		// -----------------------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		toptab.add("主页",btnPnl);
		
		// ------刷新按钮------------
		refreshBtn = new MyButton("刷新", new ImageIcon(
				"img/promotion/refresh.png"));
		refreshBtn.addActionListener(this);
		btnPnl.add(refreshBtn);
		// -----导出按钮-------------
		exportBtn = new MyButton("导出",
				new ImageIcon("img/promotion/export.png"));
		exportBtn.addActionListener(this);
		btnPnl.add(exportBtn);
		// -----搜索框---------------
		findFld = new JTextField(13);
		findFld.setFont(font);
		findFld.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e) {
				keyword = findFld.getText();

			}

			public void insertUpdate(DocumentEvent e) {
				keyword = findFld.getText();

			}

			public void changedUpdate(DocumentEvent e) {
				keyword = findFld.getText();

			}
		});
		btnPnl.add(findFld);
		// -----搜索按钮-------------
		findBtn = new MyButton(new ImageIcon("img/promotion/find.png"));
		btnPnl.add(findBtn);
		// ----日期--------------
		JLabel fromLbl = new JLabel("起始时间：");
		fromLbl.setFont(font);
		fromLbl.setForeground(color);
		from = new DateChooser();
		btnPnl.add(fromLbl);
		btnPnl.add(from);
		JLabel toLbl = new JLabel("截止时间：");
		toLbl.setFont(font);
		toLbl.setForeground(color);
		to = new DateChooser();
		btnPnl.add(toLbl);
		btnPnl.add(to);
		// -----筛选按钮-------------
		JPanel filterPnl=new JPanel();
		filterPnl.setBackground(Color.white);
		toptab.add("进一步筛选",filterPnl);
		filterPnl.setLayout(new GridLayout(2,1));
		JPanel f1=new JPanel();
		f1.setBackground(Color.white);
		filterPnl.add(f1);
		JPanel f2=new JPanel();
		f2.setBackground(Color.white);
		filterPnl.add(f2);
		// -----四大复选框-----------
		//-----按商品名筛选-------------
		nameBox = new MyCheckBox("按商品名");
		f1.add(nameBox);
		nameFld=new JTextField(5);
		nameFld.setFont(font);
		f1.add(nameFld);
		//------按客户------------------
		memberBox = new MyCheckBox("按客户");
		f1.add(memberBox);
		String memberCboxText[]={"XSS-023589 监小听"};
		memberCbox=new JComboBox<String>(memberCboxText);
		memberCbox.setBackground(Color.white);
		memberCbox.setForeground(color);
		memberCbox.setFont(font);
		f1.add(memberCbox);
		//------按业务员-----------------
		clerkBox = new MyCheckBox("按业务员");
		f1.add(clerkBox);
		String clerkCboxText[]={"XS-00004 大黄"};
		clerkCbox=new JComboBox<String>(clerkCboxText);
		clerkCbox.setBackground(Color.white);
		clerkCbox.setForeground(color);
		clerkCbox.setFont(font);
		f1.add(clerkCbox);
		//--------按仓库--------------------
		stockBox = new MyCheckBox("按仓库");
		f2.add(stockBox);
		stockFld=new JTextField(5);
		stockFld.setFont(font);
		f2.add(stockFld);
		// -----单据类型------------
		JLabel typeLbl = new JLabel("筛选指定类型的单据：");
		typeLbl.setFont(font);
		typeLbl.setForeground(color);
		f2.add(typeLbl);
		String typeText[] = { "全部", "销售类", "进货类", "财务类", "库存类" };
		receiptTypeBox = new JComboBox<String>(typeText);
		receiptTypeBox.setBackground(Color.white);
		receiptTypeBox.setFont(font);
		receiptTypeBox.setForeground(color);
		f2.add(receiptTypeBox);
		f2.add(new JLabel());
		//-------筛选按钮----------------
		JButton filterBtn=new JButton("开始筛选");
		filterBtn.setBackground(Color.white);
		filterBtn.setFocusPainted(false);
		filterBtn.setFont(font);
		filterBtn.setForeground(color);
		f2.add(filterBtn);
		// -----tab-----------------
		
		tab = new JTabbedPane();
		tab.setBackground(Color.white);
		tab.setForeground(color);
		tab.setFont(font);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1.5;
		gbl.setConstraints(tab, c);
		this.add(tab);
		// ------销售明细表--------------
		sdtm = new SaleDetailTableModel();
		t1 = new JTable(sdtm);
		jsp1 = new JScrollPane(t1);
		tab.add("销售明细表", jsp1);
		// ------经营历程表--------------
		ohtm = new OperationHistoryTableModel();
		t2 = new JTable(sdtm);
		jsp2 = new JScrollPane(t2);
		tab.add("经营历程表", jsp2);
		// -------经营情况表--------------
		ostm = new OperationStatementTableModel();
		t3 = new JTable(ostm);
		jsp3 = new JScrollPane(t3);
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

		MyButton(String text) {
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

	class MyCheckBox extends JCheckBox {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyCheckBox(String text) {
			super(text);
			setBackground(Color.white);
			setForeground(color);
			setFocusPainted(false);
			setFont(font);
		}

	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exportBtn) {
			JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));
			jfc.setFileFilter(new XLSFilter());
			jfc.setDialogTitle("导出");
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				// saveXLSContents(jfc.getSelectedFile().getAbsolutePath());
			}
		}
	}

}