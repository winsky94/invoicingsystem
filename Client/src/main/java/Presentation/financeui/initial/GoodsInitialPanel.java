package Presentation.financeui.initial;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import vo.GoodsVO;
import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;
import Presentation.stockui.ChooseGoodsDialog;

public class GoodsInitialPanel extends ChooseGoodsFatherPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	GoodsModel gm;
	JTable goodsTable;
	JScrollPane jsp;
	JButton addBtn, delBtn;
	AddInitialPanel subparent; 
	MainFrame parent;
	ArrayList<ArrayList<String>> goodsC = new ArrayList<ArrayList<String>>();

	public GoodsInitialPanel(MainFrame frame) {
		super.parent=frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 40, 5, 40);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		c.fill = GridBagConstraints.BOTH;
		// --------表格-------------
		gm = new GoodsModel();
		goodsTable = new JTable(gm);
		goodsTable.getTableHeader().setReorderingAllowed(false);
		// table 渲染器，设置文字内容居中显示，设置背景色等
		DefaultTableCellRenderer tcr = new MyTableCellRenderer();
		for (int i = 0; i < goodsTable.getColumnCount(); i++) {
			goodsTable.getColumn(goodsTable.getColumnName(i)).setCellRenderer(
					tcr);
		}
		jsp = new JScrollPane(goodsTable);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		// ------商品增删处-----------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
		//
		addBtn = new JButton("添加商品");
		addBtn.setFont(font);
		addBtn.setBackground(new Color(204, 242, 239));
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final ChooseGoodsDialog addGoodsDlg = new ChooseGoodsDialog(GoodsInitialPanel.this);
				addGoodsDlg.submitBtn.removeActionListener(addGoodsDlg.add);
				addGoodsDlg.submitBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (addGoodsDlg.rightTblMessage.size() > 0) {
							ArrayList<Object> good = new ArrayList<Object>();
							try {
								for (int i = 0; i <addGoodsDlg. rightTblMessage.size(); i++) {
									String id = addGoodsDlg.rightTblMessage.get(i).get(0);

									good.add(addGoodsDlg.service.findByID(id));
								}

							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							GoodsInitialPanel.this.RefreshCTable(good);
							parent.setRightComponent(GoodsInitialPanel.this.subparent);
							GoodsInitialPanel.this.subparent.setFocus(0);
					
						}

						addGoodsDlg.dispose();
			        }
		        });
			}
		});
		btnPnl.add(addBtn);
		delBtn = new JButton("删除选中");
		delBtn.setFont(font);
		delBtn.setBackground(new Color(204, 242, 239));
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 监听！！！！！！！
			}
		});
		btnPnl.add(delBtn);
	}

	class GoodsModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "商品编号", "商品名称", "分类", "型号", "默认进价", "默认售价" };

		public int getRowCount() {
			return 0;
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return null;
		}

		public String getColumnName(int col) {
			return head[col];
		}

		public void addRow(ArrayList<String> v) {

		}

		public void removeRow(int row) {

		}

	}
	
	public String getNewID(String id){
		     String[] buffer=id.split("-");
		     String front=buffer[0]+'-'+buffer[1];
		     double d=goodsC.size()+1;
			 NumberFormat nf = NumberFormat.getInstance();
		     nf.setMinimumIntegerDigits(4); 
		     nf.setGroupingUsed(false);
		     return front+"-"+nf.format(d);
		
	}
	
	 public void RefreshCTable(ArrayList<Object> VO){
			for(Object oo:VO){
				GoodsVO vo=(GoodsVO)oo;
				ArrayList<String> line=new ArrayList<String>();
				line.add(getNewID(vo.getGoodsID()));
				line.add(vo.getName());
				line.add(vo.getGoodsClass());
				line.add(0+"");
				line.add(0+"");
				goodsC.add(line);	
			}
	 }
	
	public void RefreshCTable(GoodsVO vo){
		ArrayList<String> line=new ArrayList<String>();
		line.add(getNewID(vo.getGoodsID()));
		line.add(vo.getName());
		line.add(vo.getGoodsClass());
		line.add(0+"");
		line.add(0+"");
		goodsC.add(line);			
	}
	
	public void setParent(AddInitialPanel pane){
		this.subparent=pane;
	}
}
