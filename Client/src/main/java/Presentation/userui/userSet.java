package Presentation.userui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


public class userSet extends JPopupMenu implements ActionListener{
	
	JMenuItem caccount,cpass;
	public  userSet(JFrame frame,JPanel pane){
			ImageIcon account=new ImageIcon("img/mainFrame/close.png");
			caccount=new JMenuItem("切换帐号",account);
			ImageIcon pass=new ImageIcon("img/mainFrame/min.png");
			cpass=new JMenuItem("修改密码",pass);
			this.setBorder(BorderFactory.createLineBorder(new Color(115,46,126)));
			add(caccount);
			add(cpass);
	}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	

}
