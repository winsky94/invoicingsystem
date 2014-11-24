package Presentation.salesui.managerPanel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MemberMgrPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addBtn,delBtn,modBtn;
	JTable memberTable;
	public MemberMgrPanel(){
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		addBtn=new JButton(new ImageIcon("img/sales/memberMgr.png"));
		addBtn.setBounds(50,50,50,50);
		this.add(addBtn);
	}
}
