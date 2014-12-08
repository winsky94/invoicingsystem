package Presentation.promotionui.DiscountPromotion;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import po.MemberPO.MemberLevel;
import po.PromotionPO.PromotionType;
import vo.CommodityVO;
import vo.DiscountProVO;
import vo.GoodsVO;
import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.promotionui.PromotionPanel;
import Presentation.uihelper.DateChooser;
import businesslogic.promotionbl.promotionController;
import businesslogicservice.promotionblservice.PromotionBLService;

public class AddDiscountPanel extends ChooseGoodsFatherPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JComboBox<String> memberGradeBox;
	DateChooser from, to;
	JButton submitBtn, exitBtn, addGoodsBtn, delGoodsBtn;
	JScrollPane jsp;
	JTable table;
	AddDiscountModel btm;
	ArrayList<Double> discount=new ArrayList<Double>();
	ArrayList<Double> last_bid=new ArrayList<Double>();
	PromotionBLService service;
	submitListener slisten;
	public AddDiscountPanel(MainFrame myFather) throws Exception {
		parent = myFather;
		service=new promotionController();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 45, 5, 45);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// -----------title------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("制定打折促销策略");
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
		// --------起止时间与等级限制-----------------
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
		JLabel gradeLbl = new JLabel("客户等级限制：");
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
		// -------表格-------------------
		c.fill=GridBagConstraints.BOTH;
		btm=new AddDiscountModel();
		table=new JTable(btm);
		jsp=new JScrollPane(table);
		c.gridx=0;
		c.gridy=3;
		c.gridheight=5;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.weightx=10;
		c.weighty=10;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		btm.addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int i=e.getLastRow();
				int j=e.getColumn();
				if(j==4){
				
				double d=Double.parseDouble((String) table.getValueAt(i, j-1));
			
				double p=Double.parseDouble((String) table.getValueAt(i, j));
				
				table.setValueAt(d*p+"", i, j+1);}
				
			}
			
		});
		
		
		//-------buttons-----------------
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
		addGoodsBtn =new JButton("添加商品");
		addGoodsBtn.setFont(font);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog addGoodsDlg=new DiscountDialog(AddDiscountPanel.this);
			}
		});
		btnPnl.add(addGoodsBtn);
		delGoodsBtn=new JButton("删除商品");
		delGoodsBtn.setFont(font);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row=table.getSelectedRows();
				if(row.length>0){
					for(int i=0;i<row.length;i++)
						{//totalMoney-=Double.parseDouble(cmContent.get(row[i]).get(5));
						//defaultTotalLbl.setText("原价："+totalMoney+"元");
						cmContent.remove(row[i]);last_bid.remove(row[i]);
					//	parent.setRightComponent(PurchasePane.this);
						table.revalidate();
						}
				}
				else 
					JOptionPane.showMessageDialog(null, "请选择要删除的商品","提示",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnPnl.add(delGoodsBtn);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		btnPnl.add(submitBtn);
		slisten=new submitListener();
		submitBtn.addActionListener(slisten);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
		exitBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					update();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}

	class submitListener implements ActionListener{
//= { "商品编号", "商品名", "型号", "单价", "折扣", "折后单价" }
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<CommodityVO> cmlist=new ArrayList<CommodityVO>();
			for(int j=0;j<table.getRowCount();j++){
				ArrayList<String> line=cmContent.get(j);
			//商品价为原价
				CommodityVO cv=new CommodityVO(line.get(0),line.get(1),
						line.get(2),Double.parseDouble(line.get(3)),last_bid.get(j),
						1,Double.parseDouble(line.get(3)),last_bid.get(j),"");
				discount.add(Double.parseDouble(line.get(4)));
				cmlist.add(cv);
			}
			String startDate=from.getDate();
			String endDate=to.getDate();
			MemberLevel level= MemberLevel.valueOf((String) memberGradeBox.getSelectedItem());
			String id=service.getNewID(PromotionType.DISCOUNT);
			
			DiscountProVO vo=new DiscountProVO(id,startDate,endDate,level,discount,cmlist);
			if(service.Add(vo)==0)
				{JOptionPane.showMessageDialog(null, "策略添加成功","提示",JOptionPane.WARNING_MESSAGE);
			try {
				update();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			else
				JOptionPane.showMessageDialog(null, "添加失败","提示",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	class AddDiscountModel extends AbstractTableModel {
		/**
		 * 
		 */
	 
		private static final long serialVersionUID = 1L;
		String head[] = { "商品编号", "商品名", "型号", "单价", "折扣", "折后单价" };

		public int getRowCount() {
			return cmContent.size();
		}

		public int getColumnCount() {
			return head.length;
		}
		
		public boolean isCellEditable(int row,int column){
			if(column==4)
				return true;
			else return false;
		}
		
		public void setValueAt(Object value,int row,int column){
			
			try{ 
				double n=Double.parseDouble((String) value);
		 if(n<=0)
				 JOptionPane.showMessageDialog(null, "请输入合法数值");
		 else
			 { cmContent.get(row).set(column,(String)value);
				fireTableCellUpdated(row, column);
			 }
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "请输入折扣");
			}
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

	//"商品编号", "商品名", "型号", "单价", "折扣", "折后单价" 
	
	public void RefreshCTable(ArrayList<Object> vo,double dis){
		for(int i=0;i<vo.size();i++){
			GoodsVO gvo=(GoodsVO)vo.get(i);
			ArrayList<String> line=new ArrayList<String>();
			int exist=find(gvo.getGoodsID());
			if(exist<0){
				line.add(gvo.getGoodsID());
				line.add(gvo.getName());
				line.add(gvo.getSize());
				line.add(gvo.getPrice()+"");
				line.add(dis+"");
				line.add(gvo.getPrice()*dis+"");
				last_bid.add(gvo.getLastPurchasePrice());
				cmContent.add(line);
			}else{
				//int num=Integer.parseInt(cmContent.get(exist).get(3))+1;
				//double p=Double.parseDouble(cmContent.get(exist).get(5));
				cmContent.get(exist).set(4, dis+"");
				cmContent.get(exist).set(5,dis*gvo.getPrice()+"");
			}
			
			
		}
		
	
	}
	
	
	private int find(String id){
		 for(int i=0;i<cmContent.size();i++){
			 if(id.equals(cmContent.get(i).get(0)))
					 return i;
		 }
		 return -1;
	}
	public void update() throws Exception{
		PromotionPanel proPanel=new PromotionPanel((MainFrame)parent);
		((MainFrame)parent).setRightComponent(proPanel);
		service=new promotionController();
		if(service.Show()!=null)
			proPanel.RefreshProTable(service.Show());
	}
}