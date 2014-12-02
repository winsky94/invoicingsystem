package Presentation.stockui.giftmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.mainui.MainFrame;
import Presentation.stockui.ChooseGoodsDialog;
import Presentation.uihelper.UIhelper;

public class CreateGiftPanel extends JPanel{
	/**
	 * 问题：无法使goodsText动态改变
	 */
	private static final long serialVersionUID = 1L;
	String IDtext, goodsText;
	int num;
	JLabel IDLbl, goodsLbl, numLbl;
	JTextField numFld;
	JComboBox<String> memberBox;
	JButton submitBtn, goodsBtn,cancelBtn;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dlgWidth = screenWidth * 28 / 100;
	int dlgHeight = screenHeight * 60 / 100;
	ChooseGoodsFatherPane pnl;
//	MainFrame parent;
//
//	public CreateGiftPanel(MainFrame frame) {
	
	JFrame parent;
	public CreateGiftPanel(JFrame frame){
		parent=frame;
	
		pnl = new ChooseGoodsFatherPane();
		this.add(pnl);
		pnl.setBackground(Color.white);
		pnl.setLayout(null);
		pnl.setVisible(true);
		// --------------------------------------------------
		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		IDtext = "编号：XXXX-XXX-XXXX";
		IDLbl.setText(IDtext);
		IDLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 3 / 100,
				dlgWidth * 60 / 100, dlgHeight * 6 / 100);
		pnl.add(IDLbl);
		// ----------------member------------------------------------
		JLabel memberLbl = new JLabel("客户：");
		memberLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		memberLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 13 / 100,
				dlgWidth * 30 / 100, dlgHeight * 6 / 100);
		pnl.add(memberLbl);
		//
		memberBox = new JComboBox<String>();
		memberBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		memberBox.setBackground(Color.white);
		memberBox.setBounds(dlgWidth * 18 / 100, dlgHeight * 13 / 100,
				dlgWidth * 49 / 100, dlgHeight * 5 / 100);
		pnl.add(memberBox);
		// ---------------goods----------------------------------------
		JLabel gLbl = new JLabel("赠送商品：");
		gLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		gLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 23 / 100,
				dlgWidth * 20 / 100, dlgHeight * 6 / 100);
		pnl.add(gLbl);
		goodsLbl = new JLabel();
//		goodsText = pnl.content.get(0).get(0) + " " + pnl.content.get(0).get(1)
//				+ " " + pnl.content.get(0).get(2);
		goodsLbl.setText(goodsText);
		goodsLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		goodsLbl.setBounds(dlgWidth * 15 / 100, dlgHeight * 23 / 100,
				dlgWidth * 85 / 100, dlgHeight * 6 / 100);
		pnl.add(goodsLbl);
		// ----------------num--------------------------------
		JLabel numLbl = new JLabel("数量：");
		numLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		numLbl.setBounds(dlgWidth * 3 / 100, dlgHeight * 33 / 100,
				dlgWidth * 20 / 100, dlgHeight * 6 / 100);
		pnl.add(numLbl);
		numFld = new JTextField();
		numFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		numFld.setBounds(dlgWidth * 15 / 100, dlgHeight * 33 / 100,
				dlgWidth * 20 / 100, dlgHeight * 5 / 100);
		numFld.getDocument().addDocumentListener(new NumFldListener());
		// 这个listener已经写好了，直接获取number就行
		pnl.add(numFld);
		// -------------------buttons-----------------------
		goodsBtn = new JButton("选择商品");
		goodsBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		goodsBtn.setBounds(dlgWidth * 20 / 100, dlgHeight * 80 / 100,
				dlgWidth * 25 / 100, dlgHeight * 8 / 100);
		goodsBtn.setFocusPainted(false);
		goodsBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JDialog adlg = new ChooseGoodsDialog(pnl);
			}
		});
		pnl.add(goodsBtn);
		submitBtn = new JButton("确  定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setBounds(dlgWidth * 55 / 100, dlgHeight * 80 / 100,
				dlgWidth * 25 / 100, dlgHeight * 8 / 100);
		submitBtn.setFocusPainted(false);
		pnl.add(submitBtn);
		
		cancelBtn = new JButton("取 消");
		cancelBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cancelBtn.setBounds(dlgWidth * 55 / 100, dlgHeight * 80 / 100,
				dlgWidth * 25 / 100, dlgHeight * 8 / 100);
		cancelBtn.setFocusPainted(false);
		pnl.add(cancelBtn);
		// --------------------------------------------------
	}

	class NumFldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			num = new Integer(numFld.getText());
		}

		public void removeUpdate(DocumentEvent e) {
			num = new Integer(numFld.getText());
		}

		public void changedUpdate(DocumentEvent e) {
			num = new Integer(numFld.getText());
		}

	}
	
	
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 920, 600);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CreateGiftPanel gp = new CreateGiftPanel(testFrame);
		gp.setBounds(0, 0, 920, 600);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}

}
