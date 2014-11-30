package Presentation.mainui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

public class dragListener extends MouseAdapter implements MouseMotionListener{
	MainFrame frame;
	int xOld,yOld;
	
	public dragListener(MainFrame frame){
		this.frame=frame;
	}
	 public void mousePressed(MouseEvent e) {  
         xOld = e.getX();  
         yOld = e.getY();  
     }  
  
 
     public void mouseDragged(MouseEvent e) {  
         int xOnScreen = e.getXOnScreen();  
         int yOnScreen = e.getYOnScreen();  
         int xx = xOnScreen - xOld;  
         int yy = yOnScreen - yOld;  
         frame.setLocation(xx, yy);  
     }  
  
}
