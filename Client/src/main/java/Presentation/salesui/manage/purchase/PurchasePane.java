package Presentation.salesui.manage.purchase;

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
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import po.MemberPO.MemberType;
import po.ReceiptPO.ReceiptType;
import vo.CommodityVO;
import vo.GoodsVO;
import vo.MemberVO;
import vo.PurchaseVO;
import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.salesui.manage.CommodityTableModel;
import Presentation.salesui.manage.PurchaseMgrPanel;
import Presentation.salesui.manage.SaleMgrPanel;
import Presentation.stockui.ChooseGoodsDialog;
import businesslogic.memberbl.Member;
import businesslogic.salesbl.SaleList;
import businesslogic.salesbl.SalesController;
import businesslogicservice.memberblservice.MemberBLService;
import businesslogicservice.salesblservice.PurchaseBLService;
import businesslogicservice.salesblservice.SaleListBLService;
import businesslogicservice.salesblservice.SalesBLService;

public class PurchasePane extends ChooseGoodsFatherPane implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JLabel IDLbl, userLbl, totalLbl,title;
	JTextField stockFld, remarkFld;
	JButton submitBtn, exitBtn, addGoodsBtn, delGoodsBtn;
	JScrollPane jsp;
	JTable table;
	double totalMoney;
	CommodityTableModel ctm;
	ArrayList<ArrayList<String>> cmContent;
	JComboBox<String> JHSBox;
	String[] idtxt;//客户id
	PurchaseBLService service;
	purchaseSubmitListener psl;
	String id;
	ArrayList<Double> last_bid=new ArrayList<Double>();
	public PurchasePane(MainFrame frame) throws Exception {
		service=new SalesController();
		parent = frame;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		 title = new JLabel("创建进货单");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titlePnl.add(title);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.1;
		gbl.setConstraints(titlePnl, c);
		this.add(titlePnl);
		// ------midPnl-------------
		c.fill=GridBagConstraints.BOTH;
		JPanel midPnl=new JPanel();
		midPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.3;
		gbl.setConstraints(midPnl, c);
		this.add(midPnl);
		//--------------------------
		midPnl.setLayout(new GridLayout(3, 1));
		JPanel p1=new JPanel();
		p1.setBackground(Color.white);
		midPnl.add(p1);
		JPanel p2=new JPanel();
		p2.setBackground(Color.white);
		midPnl.add(p2);
		JPanel p3=new JPanel();
		p3.setBackground(Color.white);
		midPnl.add(p3);
		//-------ID-----------------
		 id=service.getNewID(ReceiptType.PURCHASE);
		IDLbl=new JLabel("编号："+id);
		IDLbl.setFont(font);
		p1.add(IDLbl);
		p1.add(new JLabel("     "));
		//------供应商---------------
		JLabel JHSLbl=new JLabel("进货商：");
		JHSLbl.setFont(font);
		p1.add(JHSLbl);
		MemberBLService mem=new Member();
		ArrayList<MemberVO> mvo=mem.showMembers();
		String boxText[]=new String[mvo.size()+1];
		idtxt=new String[mvo.size()];
		boxText[0]="选择交易客户";int j=0;
		for(int i=0;i<mvo.size();i++)
			if(mvo.get(i).getmType()==MemberType.JHS)
			{boxText[j+1]=mvo.get(i).getName();idtxt[j]=mvo.get(i).getMemberID();j++;}
			
		JHSBox=new JComboBox<String>(boxText);
		JHSBox.setBackground(Color.white);
		JHSBox.setFont(font);
		p1.add(JHSBox);
		p1.add(new JLabel("     "));
		//------操作员----------------
		userLbl=new JLabel("操作员："+frame.getUser().getName());
		userLbl.setFont(font);
		p1.add(userLbl);
		//-------仓库----------------
		JLabel stockLbl=new JLabel("仓库：");
		stockLbl.setFont(font);
		p2.add(stockLbl);
		stockFld=new JTextField(6);
		stockFld.setFont(font);
		p2.add(stockFld);
		p2.add(new JLabel("     "));
		//-------备注-----------------
		JLabel remarkLbl=new JLabel("备注：");
		remarkLbl.setFont(font);
		p2.add(remarkLbl);
		remarkFld=new JTextField(25);
		remarkFld.setFont(font);
		p2.add(remarkFld);
		//-------table标题-----------
		JLabel tableLbl=new JLabel("进货商品列表       ");
		tableLbl.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		p3.add(tableLbl);
		//-------合计----------------
		totalLbl=new JLabel("总计:___________");
		totalLbl.setFont(font);
		p3.add(totalLbl);

		// ------table--------------
		ctm=new CommodityTableModel();
		table=new JTable(ctm);
		cmContent=ctm.getContent();
		jsp=new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		
		
		// -------buttons-----------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 9;
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
				JDialog addGoodsDlg = new ChooseGoodsDialog(PurchasePane.this);
			}
		});
		btnPnl.add(addGoodsBtn);
		delGoodsBtn = new JButton("删除商品");
		delGoodsBtn.setFont(font);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row=table.getSelectedRows();
				if(row.length>0){
					for(int i=0;i<row.length;i++)
						{totalMoney-=Double.parseDouble(cmContent.get(row[i]).get(5));
						totalLbl.setText("总计："+totalMoney+"元");
						cmContent.remove(row[i]);last_bid.remove(i);
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
		psl=new purchaseSubmitListener();
		submitBtn.addActionListener(psl);
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
		exitBtn.addActionListener(this);
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		ctm.addTableModelListener(new TableModelListener(){

			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				
				
				int i=e.getLastRow();
				
				int j=e.getColumn();
				int num=0;double price=0;
				if(j!=6){
				if(j==3){
					 num=Integer.parseInt((String) table.getValueAt(i, j));
					 price=Double.parseDouble(cmContent.get(i).get(j+1));
				}else if(j==4){
					price=Double.parseDouble(cmContent.get(i).get(j));
					num=Integer.parseInt((String)table.getValueAt(i, j-1));
				}
				totalMoney-=Double.parseDouble((String) table.getValueAt(i, j+2));
				totalMoney+=price*num;
				totalLbl.setText("总计:"+totalMoney+"元");
				table.setValueAt(price*num+"", i, j+2);
				table.revalidate();
				
				
				}
				
			}
			
		});
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		if(e.getSource()==exitBtn){
			
			PurchaseMgrPanel sp = new PurchaseMgrPanel(parent);
		
			parent.setRightComponent(sp);
		
				sp.RefreshPanel();}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	}
	
	 public void RefreshCTable(ArrayList<Object> VO){
			if(VO.get(0) instanceof GoodsVO)
				{for(int i=0;i<VO.size();i++){
					ArrayList<String> line=new ArrayList<String>();
					GoodsVO vo=(GoodsVO)VO.get(i);
					int exist=findExistLine(vo.getGoodsID());
					if(exist<0){
					line.add(vo.getGoodsID());
					line.add(vo.getName());
					line.add(vo.getSize());
					line.add("1");//可改动
					String p;
					p=Double.toString(vo.getPurchasePrice());
					line.add(p);line.add(p);
					line.add("");
					last_bid.add(vo.getLastPurchasePrice());
					cmContent.add(line);
					}
					else{
						String newNum=cmContent.get(exist).get(3);
						int num=Integer.parseInt(newNum)+1;
						String price=cmContent.get(exist).get(4);
						Double toal=num*Double.parseDouble(price);
						cmContent.get(exist).set(3,num+"" );
						cmContent.get(exist).set(5,toal+"");
					}
					
				}}else{
					for(int i=0;i<VO.size();i++){
						 ArrayList<String> line=new ArrayList<String>();
						CommodityVO vo=(CommodityVO)VO.get(i);
						line.add(vo.getID());
						line.add(vo.getName());
						line.add(vo.getType());
						line.add(Double.toString(vo.getNum()));
						line.add(Double.toString(vo.getPrice()));
						line.add(Double.toString(vo.getTotal()));
						line.add(vo.getTip());
						
						cmContent.add(line);
					}
				}
			totalMoney=0;
			for(int i=0;i<cmContent.size();i++)
				totalMoney+=Double.parseDouble(cmContent.get(i).get(5));
			totalLbl.setText("总计："+totalMoney+"元");
			
	 }
	 
	 class purchaseSubmitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<CommodityVO> cmlist=new ArrayList<CommodityVO>();
			for(int j=0;j<table.getRowCount();j++){
				ArrayList<String> line=cmContent.get(j);
				double cost=Double.parseDouble(line.get(4))*last_bid.get(j);
				CommodityVO cv=new CommodityVO(line.get(0),line.get(1),
						line.get(2),Double.parseDouble(line.get(4)),last_bid.get(j),
						Integer.parseInt(line.get(3)),
						Double.parseDouble(line.get(5)),cost,line.get(6));
				cmlist.add(cv);
			}
			int i=JHSBox.getSelectedIndex();
			String mem=JHSBox.getSelectedItem().toString();
			PurchaseVO vo=new PurchaseVO(id,idtxt[i],mem,stockFld.getText(),parent.getUser().getID(),
					cmlist,remarkFld.getText(),totalMoney,0,1);
			int result=service.addPurchase(vo);
			if(result==0)
				{JOptionPane.showMessageDialog(null, "进货单创建成功");
					PurchaseMgrPanel pmg;
					try {
						pmg = new PurchaseMgrPanel(parent);
					
					parent.setRightComponent(pmg);
					pmg.RefreshPanel();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else
					JOptionPane.showMessageDialog(null, "创建失败！","提示",JOptionPane.WARNING_MESSAGE);
		}
		 
	 }
	 
	 
	 
	 private int findExistLine(String id){
		 for(int i=0;i<cmContent.size();i++){
			 if(id.equals(cmContent.get(i).get(0)))
					 return i;
		 }
		 return -1;
	 }

}
