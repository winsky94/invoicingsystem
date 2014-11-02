package Presentation.receiptui;
import java.awt.*;

import javax.swing.*;
/*Author:JIncui
 *Last Modified:2014-11-2
 *Decription:Receipt Model Base Frame
 *
 *
 * */

public class ReceiptFrame extends JFrame{
	JSplitPane sp;//拆分
	JPanel userInfo;
	JPanel left=new JPanel();
	JList menu;
	JPanel rPane;
	public ReceiptFrame(String title ,JPanel panel){
		this.rPane=panel;
		setTitle(title);
		String[] menuContent={"单据审批","策略制定","业绩查看"};
		menu=new JList(menuContent);
		
		JLabel name=new JLabel("用户:jc小金金");
		name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel identy=new JLabel("身份：总经理");
		userInfo=new JPanel();
		
		userInfo.add(name);userInfo.add(identy);
		left.setLayout(new BorderLayout());
		left.add(BorderLayout.NORTH,userInfo);
		left.add(menu);
		left.setBackground(Color.BLUE);
		sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,rPane);
		sp.setOneTouchExpandable(true);
		add(sp);
		this.setSize(750, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
