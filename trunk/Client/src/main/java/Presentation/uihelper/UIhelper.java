package Presentation.uihelper;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

public class UIhelper {
	static Toolkit kit = Toolkit.getDefaultToolkit();
	//获取屏幕高度
	public static int getScreenHeight(){
		Dimension screenSize =kit.getScreenSize();
		int screenHeight=screenSize.height;
		return screenHeight;
	}
	//获取屏幕宽度
	public static int getScreenWidth(){
		Dimension screenSize =kit.getScreenSize();
		int screenWidth=screenSize.width;
		return screenWidth;
	}
	public static Image getImage(String filename){
		Image image=kit.getImage(filename);
		return image;
	}
}
