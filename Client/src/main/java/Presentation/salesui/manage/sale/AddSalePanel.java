package Presentation.salesui.manage.sale;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.DefaultTableCellRenderer;

import po.MemberPO.MemberType;
import po.ReceiptPO.ReceiptType;
import po.UserPO.UserJob;
import vo.CommodityVO;
import vo.GoodsVO;
import vo.LogVO;
import vo.MemberVO;
import vo.SaleVO;
import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.mainui.MyTableCellRenderer;
import Presentation.mainui.headPane;
import Presentation.mainui.log;
import Presentation.salesui.manage.CommodityTableModel;
import Presentation.salesui.manage.SaleMgrPanel;
import Presentation.stockui.ChooseGoodsDialog;
import businesslogic.memberbl.Member;
import businesslogic.promotionbl.promotionController;
import businesslogic.salesbl.SalesController;
import businesslogicservice.memberblservice.MemberViewService;
import businesslogicservice.promotionblservice.PromotionMatchService;
import businesslogicservice.salesblservice.SalesBLService;

public class AddSalePanel extends ChooseGoodsFatherPane implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Font font = new Font("微软雅黑", Font.PLAIN, 15);
	JCheckBox hurryBox;
	JLabel title,IDLbl, userLbl, totalOriginLbl, totalProDiscountLbl,
			totalFinDiscountLbl, totalToPayLbl,memberLbl,clerkLbl, stockLbl, remarkLbl,
			 discountLbl;
	JComboBox<String> XSSBox;
	JTextField clerkFld, stockFld, discountMoneyFld, remarkFld;
	JScrollPane jsp;
	String id;
	CommodityTableModel ctm;
	JTable table;
	String[] idtxt, clerk;
	JButton submitBtn, couponBtn, addGoodsBtn, delGoodsBtn, exitBtn;
	SaleVO sale;
	ArrayList<Double> last_bid = new ArrayList<Double>();
	double[] total = new double[5];
	double[] discount = new double[4];
	String proid = "", couponid = "",memid="";
	double pre = 1, coupon = 0;
	// public MainFrame parent;
	SalesBLService service;
	JPanel btnPnl,p2,p1,p3;
	String UserID;

	public AddSalePanel(MainFrame frame) throws Exception {
		parent = frame;
		service = new SalesController();
		init();
		initialArray();
		UserID=frame.getUser().getID();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 10, 5, 10);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		title = new JLabel("创建销售单");
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
		c.fill = GridBagConstraints.BOTH;
		JPanel midPnl = new JPanel();
		midPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 3;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 0.3;
		gbl.setConstraints(midPnl, c);
		this.add(midPnl);
		midPnl.setLayout(new GridLayout(3, 1));
		 p1 = new JPanel();
		 p2 = new JPanel();
		p3 = new JPanel();
		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p3.setBackground(Color.white);
		midPnl.add(p1);
		midPnl.add(p2);
		midPnl.add(p3);

		// --------ID----------------
		id = service.getNewID(ReceiptType.SALE);
		IDLbl = new JLabel("ID：" + id);
		IDLbl.setFont(font);
		p1.add(IDLbl);
		p1.add(new JLabel("      "));
		// --------客户---------------
		memberLbl = new JLabel("客户：");
		memberLbl.setFont(font);
		p1.add(memberLbl);

		MemberViewService mem = new Member();
		ArrayList<MemberVO> mvo = mem.showMembers();
		int size = mem.getSaleNum();
		String boxText[] = new String[size + 1];
		idtxt = new String[size];
		clerk = new String[size];
		boxText[0] = "选择交易客户";
		int j = 0;
		for (int i = 0; i < mvo.size(); i++)
			if (mvo.get(i).getmType() == MemberType.XSS) {
				boxText[j + 1] = mvo.get(i).getName();
				idtxt[j] = mvo.get(i).getMemberID();
				clerk[j] = mvo.get(i).getDefaultClerk();
				j++;
			}

		XSSBox = new JComboBox<String>(boxText);
		XSSBox.setFont(font);
		XSSBox.setBackground(Color.white);
		p1.add(XSSBox);
		XSSBox.setEditable(false);
		// 万一用户自己输入怎么办？
		XSSBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (XSSBox.getSelectedIndex() != 0)
					{clerkFld.setText(clerk[XSSBox.getSelectedIndex() - 1]);
					pre = service.getPrivilege(idtxt[XSSBox.getSelectedIndex() - 1]);}
			}
		});
		p1.add(new JLabel("      "));
		// -------业务员---------------
		clerkLbl = new JLabel("业务员：");
		clerkLbl.setFont(font);
		p1.add(clerkLbl);
		clerkFld = new JTextField(4);
		clerkFld.setFont(font);
		p1.add(clerkFld);
		// -------仓库----------------
		 stockLbl = new JLabel("仓库：");
		stockLbl.setFont(font);
		p1.add(stockLbl);
		stockFld = new JTextField(4);
		clerkFld.setFont(font);
		p1.add(stockFld);
		p1.add(new JLabel("      "));
		// ------操作员----------------
		userLbl = new JLabel("操作员：" + frame.getUser().getName());
		userLbl.setFont(font);
		p1.add(userLbl);
		p1.add(new JLabel("      "));
		// ------备注------------------
		 remarkLbl = new JLabel("备注：");
		remarkLbl.setFont(font);
		p2.add(remarkLbl);
		remarkFld = new JTextField(12);
		remarkFld.setFont(font);
		p2.add(remarkFld);
		// -------加急----------------
		hurryBox = new JCheckBox("加急");
		hurryBox.setFont(font);
		hurryBox.setBackground(Color.white);
		p2.add(hurryBox);
		// ------折让-----------------
		 discountLbl = new JLabel("折让：");
		discountLbl.setFont(font);
		p2.add(discountLbl);
		discountMoneyFld = new JTextField(6);
		discountMoneyFld.setFont(font);
		discountMoneyFld.addActionListener(this);
		p2.add(discountMoneyFld);
		p2.add(new JLabel("      "));
		// ------代金券----------------
		couponBtn = new JButton("使用代金券");
		couponBtn.setBackground(new Color(206, 226, 236));
		couponBtn.setFont(font);
		couponBtn.setFocusPainted(false);
		couponBtn.addActionListener(this);
		p2.add(couponBtn);
		p2.add(new JLabel("      "));

		// ------原初总价（不带任何折扣的单价*数量之和）-----------------
		totalOriginLbl = new JLabel("原初总价:0元");
		totalOriginLbl.setFont(font);
		p3.add(totalOriginLbl);
		p3.add(new JLabel("      "));
		// ------折让金额（（原初总价-促销折让-人工折让）×(1-会员折扣)+促销折让+人工折让--
		totalProDiscountLbl = new JLabel("折让金额：0元");
		totalProDiscountLbl.setFont(font);
		p3.add(totalProDiscountLbl);
		p3.add(new JLabel("      "));
		// -----最终折后总价（最终折后总价=（原初总价-折让金额-------
		totalFinDiscountLbl = new JLabel("折后总价：0元");
		totalFinDiscountLbl.setFont(font);
		p3.add(totalFinDiscountLbl);
		p3.add(new JLabel("      "));
		// ------客户应付总价（最终折后减去代金券）-----------------
		totalToPayLbl = new JLabel("客户应付总价：0元");
		totalToPayLbl.setFont(font);
		p3.add(totalToPayLbl);
		// ------table--------------
		ctm = new CommodityTableModel();
		cmContent = ctm.getContent();
		table = new JTable(ctm);
		table.getTableHeader().setReorderingAllowed(false);
		// table 渲染器，设置文字内容居中显示，设置背景色等
		DefaultTableCellRenderer tcr = new MyTableCellRenderer();
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
		}
		jsp = new JScrollPane(table);
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 4;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		ctm.addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				int i = e.getLastRow();
				int j = e.getColumn();
				int num = 0;
				double price = 0;
				if (j != 6) {
					if (j == 3) {
						num = Integer.parseInt((String) table.getValueAt(i, j));
						price = Double.parseDouble(cmContent.get(i).get(j + 1));
						total[1] -= Double.parseDouble((String) table
								.getValueAt(i, j + 2));
						table.setValueAt(price * num + "", i, j + 2);

					} else if (j == 4) {
						price = Double.parseDouble(cmContent.get(i).get(j));
						num = Integer.parseInt((String) table.getValueAt(i,
								j - 1));
						total[1] -= Double.parseDouble((String) table
								.getValueAt(i, j + 1));
						table.setValueAt(price * num + "", i, j + 1);
					}

					total[1] += price * num;
					totalOriginLbl.setText("总计:" + total[1] + "元");

					table.revalidate();
					matchPromotion();
				}

			}

		});
		// -------buttons-----------------
		 btnPnl = new JPanel();
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
				JDialog addGoodsDlg = new ChooseGoodsDialog(AddSalePanel.this);
			}
		});
		btnPnl.add(addGoodsBtn);
		delGoodsBtn = new JButton("删除商品");
		delGoodsBtn.setFont(font);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] row = table.getSelectedRows();
				if (row.length > 0) {
					for (int i = 0; i < row.length; i++) {
						total[1] -= Double.parseDouble(cmContent.get(row[i])
								.get(5));
						totalOriginLbl.setText("原初总价:" + total[1] + "元");
						cmContent.remove(row[i]);
						last_bid.remove(row[i]);
						// parent.setRightComponent(PurchasePane.this);
						table.revalidate();
						matchPromotion();
					}
				} else
					JOptionPane.showMessageDialog(null, "请选择要删除的商品", "提示",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		btnPnl.add(delGoodsBtn);
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.addActionListener(this);
		btnPnl.add(submitBtn);
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.addActionListener(this);
		btnPnl.add(exitBtn);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			if (e.getSource() == exitBtn) {

				SaleMgrPanel sp = new SaleMgrPanel(parent);
				parent.setRightComponent(sp);
				sp.RefreshPanel();

			} else if (e.getSource() == discountMoneyFld) {
				double dis = 0;
				try {
					dis = Double.parseDouble(discountMoneyFld.getText());
					UserJob job = parent.getUser().getJob();
					if (dis >= 0)
						if (job == UserJob.SALEMANAGER && dis > 5000) {
							JOptionPane.showMessageDialog(null, "您最多可折让5000元！",
									"提示", JOptionPane.WARNING_MESSAGE);
							discountMoneyFld.setText("");
						} else if (job == UserJob.SALE && dis > 1000) {
							JOptionPane.showMessageDialog(null, "您最多可折让1000元！",
									"提示", JOptionPane.WARNING_MESSAGE);
							discountMoneyFld.setText("");
						} else {
							discount[2] = dis;
							matchPromotion();
						}
					else {
						JOptionPane.showMessageDialog(null, "请输入不小于0的合法数值！",
								"提示", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "请输入数字！", "提示",
							JOptionPane.WARNING_MESSAGE);
					discountMoneyFld.setText("");
				}
			} else if (e.getSource() == couponBtn) {
				UseCouponDialog dia = new UseCouponDialog(AddSalePanel.this);
			} else if (e.getSource() == submitBtn) {
				if(XSSBox.getSelectedIndex()==0)
					JOptionPane.showMessageDialog(null, "请选择客户！", "提示",
							JOptionPane.WARNING_MESSAGE);
				else{
				getSale();
				int result = service.addSale(sale);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "销售单创建成功！"
							);
					log.addLog(new LogVO(log.getdate(),parent.getUser()
							.getID(), parent.getUser().getName(), "创建一笔销售单", 6));
					headPane.RefreshGrades();
					SaleMgrPanel sp = new SaleMgrPanel(parent);
					parent.setRightComponent(sp);
					sp.RefreshPanel();

				} else
					JOptionPane.showMessageDialog(null, "销售单创建失败", "提示",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



	public void RefreshCTable(ArrayList<Object> VO) {
		if (VO.get(0) instanceof GoodsVO) {
			for (int i = 0; i < VO.size(); i++) {
				ArrayList<String> line = new ArrayList<String>();
				GoodsVO vo = (GoodsVO) VO.get(i);
				int exist = findExistLine(vo.getGoodsID());
				if (exist < 0) {
					line.add(vo.getGoodsID());
					line.add(vo.getName());
					line.add(vo.getSize());
					line.add("1");// 可改动
					String p;
					p = Double.toString(vo.getPrice());
					line.add(p);
					line.add(p);
					line.add("");
					cmContent.add(line);
					last_bid.add(vo.getLastPurchasePrice());
				} else {
					String newNum = cmContent.get(exist).get(3);
					int num = Integer.parseInt(newNum) + 1;
					String price = cmContent.get(exist).get(4);
					Double toal = num * Double.parseDouble(price);
					cmContent.get(exist).set(3, num + "");
					cmContent.get(exist).set(5, toal + "");

				}
				// total[0]+=vo.getLastPurchasePrice();
			}
			total[1] = 0;
			for (int i = 0; i < cmContent.size(); i++)
				total[1] += Double.parseDouble(cmContent.get(i).get(5));
			totalOriginLbl.setText("原初总价:" + total[1] + "元");
			matchPromotion();
		} else {
			for (int i = 0; i < VO.size(); i++) {
				ArrayList<String> line = new ArrayList<String>();
				CommodityVO vo = (CommodityVO) VO.get(i);
				line.add(vo.getID());
				line.add(vo.getName());
				line.add(vo.getType());
				line.add(vo.getNum()+"");
				line.add(vo.getPrice()+"");
				line.add(vo.getTotal()+"");
				line.add(vo.getTip());
				last_bid.add(vo.getCost()/vo.getPrice());
				cmContent.add(line);
			}
		}
		

	}

	private int findExistLine(String id) {
		for (int i = 0; i < cmContent.size(); i++) {
			if (id.equals(cmContent.get(i).get(0)))
				return i;
		}
		return -1;
	}

	public void getSale() {
		ArrayList<CommodityVO> cmlist = new ArrayList<CommodityVO>();
		for (int j = 0; j < table.getRowCount(); j++) {
			ArrayList<String> line = cmContent.get(j);
			double cost = Double.parseDouble(line.get(4)) * last_bid.get(j);
			CommodityVO cv = new CommodityVO(line.get(0), line.get(1),
					line.get(2), Double.parseDouble(line.get(4)),
					last_bid.get(j), Integer.parseInt(line.get(3)),
					Double.parseDouble(line.get(5)), cost, line.get(6));
			cmlist.add(cv);
		}
		getCost();
		 memid = "";
		int i = XSSBox.getSelectedIndex() - 1;
		if (i >= 0){
			memid = idtxt[i];}

		String mem = XSSBox.getSelectedItem().toString();
		int hurry = 1;
		if (hurryBox.isSelected())
			hurry = 0;
		sale = new SaleVO(clerkFld.getText(), cmlist, id, mem, memid, UserID
				, 0, hurry, remarkFld.getText(),
				stockFld.getText(), proid, couponid, total, discount);

	}

	public void initialArray() {
		for (int i = 0; i < discount.length; i++) {
			discount[i] = 0;
			total[i] = 0;
		}
		total[total.length - 1] = 0;
	}

	public double getCost() {
		total[0] = 0;
		for (int i = 0; i < cmContent.size(); i++)
			total[0] += Double.parseDouble(cmContent.get(i).get(3))
					* last_bid.get(i);
		total[0] += coupon;
		return total[0];
	}

	// bug 特价包只算了一次份的
	public void matchPromotion() {
		try {
			getSale();
			PromotionMatchService proservice = new promotionController();
			if (!sale.getMemberID().equals("")) {
				sale = proservice.Match(sale);}
				discount = sale.getDiscount();
				total = sale.getTotal();
				discount[1] = (total[1] - discount[0] - discount[2])
						* (1 - pre);
				discount[3] = discount[2] + discount[0] + discount[1];
				total[2] = total[1] - discount[3];// 总价
				total[4] = total[2] - coupon;
				if (total[4] < 0) {
					total[3] = -total[4];
					total[4] = 0;
				} else
					total[3] = 0;
			
				proid = sale.getProid();
				// sale.setDiscount(discount);
				// sale.setTotal(total);
			
				totalOriginLbl.setText("原初总价:" + sale.getTotalOrigin() + "元");
				totalProDiscountLbl.setText("折让金额:"
						+ (sale.getTotalOrigin() - sale.getTotalValue()) + "元");
				totalFinDiscountLbl.setText("折后总价:" + sale.getTotalValue()
						+ "元");
				totalToPayLbl.setText("客户应付总价:" + sale.getToPay() + "元");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void couponUse(String id) {
		PromotionMatchService proservice;
		try {
			proservice = new promotionController();
			coupon = proservice.getCouponValue(id);
			if (coupon == -1)
				JOptionPane.showMessageDialog(null, "该代金券编号不存在！", "提示",
						JOptionPane.WARNING_MESSAGE);
			else if (coupon == -2)
				JOptionPane.showMessageDialog(null, "该代金券编号不存在！", "提示",
						JOptionPane.WARNING_MESSAGE);
			else {
				couponid = id;
				total[4] = total[2] - coupon;
				sale.setCouponid(id);
				if (total[4] < 0) {
					total[3] = -total[4];
					total[4] = 0;
					couponBtn.setText("代金券抵消" + total[2] + "元");
				} else
					couponBtn.setText("代金券抵消" + coupon + "元");
				totalToPayLbl.setText("客户应付总价:" + total[4] + "元");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void init(){
		int i=0;
		for( i=0;i<4;i++){
			discount[i]=0;
			total[i]=0;
		}
		total[i]=0;
	}
}
