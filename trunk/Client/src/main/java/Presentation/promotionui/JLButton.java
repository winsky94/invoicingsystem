package Presentation.promotionui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JLButton extends JButton{
	//需要get
	Color color=new Color(115,46,126);
	
	public JLButton(){
		this.setForeground(Color.WHITE);
		this.setBackground(color);
		this.setFont(new Font("楷体", Font.PLAIN, 19));
		
	}
	
	public JLButton(String text,ImageIcon icon){
		this();
		this.setText(text);
		this.setIcon(icon);
	}

}
