package Presentation.promotionui.addpromotion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Presentation.uihelper.DateChooser;

public class AddCouponPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame father;
	DateChooser from, to;
	JTextField limitFld, priceFld, totalFld;
	JComboBox<String> memberGradeBox;
	JButton submitBtn, exitBtn;

	public AddCouponPanel(JFrame myFather) {
		father = myFather;
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		this.setBackground(Color.white);
		this.setLayout(gbl);
		// ----------------------------
		JPanel titlePnl=new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1,1));
		JLabel title = new JLabel("制定代金券赠送策略");
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
		c.fill=GridBagConstraints.BOTH;
		JPanel mPnl = new JPanel();
		mPnl.setBackground(Color.white);
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 6;
		c.gridwidth =GridBagConstraints.REMAINDER;
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
		btnPnl.add(submitBtn);
		btnPnl.add(new JLabel("          "));
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
		AddCouponPanel gp = new AddCouponPanel(testFrame);
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
}
