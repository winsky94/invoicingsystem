package Presentation.uihelper;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel portraitPnl;
	UserInfoWindow userInfoWin;
	JLabel nameLbl,typeLbl;
	/*---------！！！BL编写者看这里！！！--------
	 * 下面的构造器应当有参数来获取User信息
	 */
	public UserInfoPanel(){
		this.setBackground(Color.black);
		this.setOpaque(false);
		this.addMouseListener(new UserInfoPnlMouseListener());
		this.setVisible(true);
	}
	class UserInfoPnlMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			userInfoWin =new UserInfoWindow(e.getXOnScreen()-10,e.getYOnScreen()+20);
			userInfoWin.setVisible(true);
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}
