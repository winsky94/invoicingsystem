package Presentation.promotionui.CouponPromotion;

import java.awt.BorderLayout;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.MemberPO.MemberLevel;
import po.PromotionPO.PromotionType;
import vo.CouponVO;
import vo.GiftCouponProVO;
import vo.LogVO;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;
import Presentation.promotionui.PromotionPanel;
import Presentation.uihelper.DateChooser;
import businesslogic.promotionbl.promotionController;
import businesslogicservice.promotionblservice.PromotionBLService;

public class AddCouponPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String startDate, endDate, id;
	MemberLevel level;
	double totalValue;
	MainFrame father;
	DateChooser from, to;
	JTextField limitFld, priceFld;
	JTextField totalFld;
	JLabel title;
	JComboBox<String> memberGradeBox;
	JButton submitBtn, exitBtn;
	PromotionBLService service;
	ArrayList<CouponVO> couponlist;

	public AddCouponPanel(MainFrame myFather) {
		father = myFather;
		couponlist = new ArrayList<CouponVO>();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		title = new JLabel("制定代金券赠送策略");
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
		// -----------------------------
		c.fill = GridBagConstraints.BOTH;
		JPanel mPnl = new JPanel();
		mPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		gbl.setConstraints(mPnl, c);
		this.add(mPnl);
		mPnl.setLayout(new BorderLayout(200, 200));
		mPnl.add(new JLabel(), BorderLayout.WEST);
		// -------------------------------
		JPanel funcPnl = new JPanel();
		funcPnl.setBackground(Color.white);
		funcPnl.setLayout(new GridLayout(6, 1));
		// --------起止时间-----------------
		JPanel timePnl = new JPanel();
		timePnl.setBackground(Color.white);
		funcPnl.add(timePnl);
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
		// ---------限制客户等级-------------
		JPanel gradePnl = new JPanel();
		gradePnl.setBackground(Color.white);
		funcPnl.add(gradePnl);
		JLabel gradeLbl = new JLabel("客户等级限制：");
		gradeLbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		gradePnl.add(gradeLbl);
		String boxText[] = { "ONE", "TWO", "THREE", "FOUR", "FIVE" };
		memberGradeBox = new JComboBox<String>(boxText);
		memberGradeBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		memberGradeBox.setBackground(Color.white);
		gradePnl.add(memberGradeBox);
		// -------设定满赠金额----------------
		JPanel limitPnl = new JPanel();
		limitPnl.setBackground(Color.white);
		funcPnl.add(limitPnl);
		JLabel limitLbl = new JLabel("满赠金额：");
		limitLbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		limitPnl.add(limitLbl);
		limitFld = new JTextField(11);
		limitFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		limitPnl.add(limitFld);
		// -------设定单张代金券面值----------------
		JPanel pricePnl = new JPanel();
		pricePnl.setBackground(Color.white);
		funcPnl.add(pricePnl);
		JLabel priceLbl = new JLabel("单张面值：");
		priceLbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		pricePnl.add(priceLbl);
		priceFld = new JTextField(11);
		priceFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		pricePnl.add(priceFld);
		// -------限制总额----------------
		JPanel totalPnl = new JPanel();
		totalPnl.setBackground(Color.white);
		funcPnl.add(totalPnl);
		JLabel totalLbl = new JLabel("数量：");
		totalLbl.setFont(new Font("微软雅黑", Font.BOLD, 15));
		totalPnl.add(totalLbl);
		totalFld = new JTextField(11);
		totalFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		totalPnl.add(totalFld);
		// -------------------------------
		mPnl.add(funcPnl, BorderLayout.CENTER);
		mPnl.add(new JLabel(), BorderLayout.EAST);
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
		// -------------------------------
		submitBtn = new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.addActionListener(this);
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("          "));
		exitBtn = new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		btnPnl.add(exitBtn);
		exitBtn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == exitBtn) {
			try {
				update();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == submitBtn) {
			try {
				startDate = from.getDate();
				endDate = to.getDate();
				level = MemberLevel.valueOf((String) memberGradeBox
						.getSelectedItem());
				service = new promotionController();
				totalValue = Double.parseDouble(limitFld.getText());
				double value = Double.parseDouble(priceFld.getText());
				for (int i = 0; i < Integer.parseInt(totalFld.getText()); i++)
					couponlist.add(new CouponVO("", value, false));
				id = service.getNewID(PromotionType.GIFTCOUPON);
				GiftCouponProVO vo = new GiftCouponProVO(id, startDate,
						endDate, level, couponlist, totalValue);
				if (service.Add(vo) == 0) {
					JOptionPane.showMessageDialog(null, "策略添加成功", "提示",
							JOptionPane.WARNING_MESSAGE);
					update();
					log.addLog(new LogVO(log.getdate(), father.getUser()
							.getID(), father.getUser().getName(),
							"创建一条代金券促销策略", 2));
					headPane.RefreshGrades();

				} else
					JOptionPane.showMessageDialog(null, "添加失败", "提示",
							JOptionPane.WARNING_MESSAGE);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void update() throws Exception {
		PromotionPanel proPanel = new PromotionPanel((MainFrame) father);
		((MainFrame) father).setRightComponent(proPanel);
		service = new promotionController();
		if (service.Show() != null)
			proPanel.RefreshProTable(service.Show());
	}
}