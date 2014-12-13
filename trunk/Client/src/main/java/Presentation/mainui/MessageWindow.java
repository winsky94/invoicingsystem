package Presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JWindow;

import po.UserPO.UserJob;
import vo.ReceiptMessageVO;
import Presentation.uihelper.UIhelper;
import businesslogic.receiptbl.ReceiptMessage;
import businesslogicservice.receiptblservice.ReceiptTipService;

public class MessageWindow extends JWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int screenWidth = UIhelper.getScreenWidth();
	static int screenHeight = UIhelper.getScreenHeight();
	static int winWidth = screenWidth * 28 / 100;
	static int winHeight = screenHeight * 3 / 5;
	JList<String> list;
	JScrollPane jsp;
	UserJob type;
	Vector<String> message;
	static MessageWindow instance = null;

	private MessageWindow(MainFrame frame) {
		super(frame);
		type = frame.getUser().getJob();

		this.setBounds(20, 20, winWidth, winHeight);
		JPanel pnl = new JPanel();
		pnl.setBounds(0, 0, winWidth, winHeight);
		pnl.setBackground(Color.white);
		// ----------------------
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 10, 5, 10);
		pnl.setLayout(gbl);
		// ----------------------
		JPanel titlePnl = new JPanel();
		titlePnl.setBackground(Color.white);
		titlePnl.setLayout(new GridLayout(1, 1));
		JLabel title = new JLabel("消息中心");
		title.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		titlePnl.add(title);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 1;
		gbc.weighty = 0.08;
		gbl.setConstraints(titlePnl, gbc);
		pnl.add(titlePnl);
		// ----------------------
		gbc.fill = GridBagConstraints.BOTH;
		JPanel mPnl = new JPanel();
		mPnl.setBackground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbl.setConstraints(mPnl, gbc);
		pnl.add(mPnl);
		mPnl.setLayout(new GridLayout(1, 1));
		// -----JList-------------
		message = new Vector<String>();
		message.add("2014-12-02 08:05 :付款单FKD-0275546未通过审批");
		message.add("2014-12-01 13:05 :Your receipt has been examined");
		list = new JList<String>(message);
		list.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jsp = new JScrollPane(list);
		mPnl.add(jsp);
		// -----------------------
		this.add(pnl);
		
			
	
	}

	
	public void getNewMessage(){

		try {
			ReceiptTipService service = new ReceiptMessage();
			ArrayList<ReceiptMessageVO> vo = null;
			switch (type) {
			case SALE:
				vo = service.getSaleApproved();
				break;
			case MANAGER:
				vo = service.getToApprove();
				break;
			case FINANCE:
				vo = service.getFinanceApproved();
				break;
			case STOCK:

			}
			if (vo != null) {
				for (int i = 0; i < vo.size(); i++)
					message.add(vo.get(i).getInfo());
			}

			System.out.println("i love you");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static MessageWindow getInstance(MainFrame frame,int x,int y) {
		if (instance == null)
			instance = new MessageWindow(frame);
		instance.setLocation((x-winWidth),(y-winHeight));
		instance.setVisible(true);
		return instance;
	}

}
