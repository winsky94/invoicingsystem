package Presentation.promotionui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class listPane extends JPanel{
	
	public listPane(){
		ImageIcon skin=new ImageIcon("img/mainFrame/skin.png");
		JLabel skinbutton=new JLabel(skin);
		skinbutton.setSize(skin.getIconWidth(),skin.getIconHeight());
		skinbutton.setLocation(this.getWidth()*2, 0);
		this.add(skinbutton);
	}
	

}
