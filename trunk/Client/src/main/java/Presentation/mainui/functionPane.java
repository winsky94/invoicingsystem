package Presentation.mainui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//rightPane 的顶上部分基本窗口操作按钮
public class functionPane extends JPanel{
	JPanel parent;
	JLabel close,min,max,skin,help;
	JFrame mainFrame;
	int state;
	Color color=new Color(115,46,126);//需要get
	public functionPane(JPanel panel,JFrame frame){
		mainFrame=frame;
		buttonListener listen=new buttonListener();
		close=new JLabel(new ImageIcon("img/mainFrame/close.png"));
		min=new JLabel(new ImageIcon("img/mainFrame/min.png"));
		max=new JLabel(new ImageIcon("img/mainFrame/max.png"));//最大后后图标变化
		skin=new JLabel(new ImageIcon("img/mainFrame/skin.png"));
		help=new JLabel(new ImageIcon("img/mainFrame/help.png"));
		
		close.addMouseListener(listen);
		min.addMouseListener(listen);
		max.addMouseListener(listen);
		skin.addMouseListener(listen);
		help.addMouseListener(listen);	
		parent=panel;
		skin.setToolTipText("皮肤");
		help.setToolTipText("帮助");
		min.setToolTipText("最小化");
		close.setToolTipText("关闭");
		skin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		help.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		min.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		max.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FlowLayout flow=new FlowLayout();
		flow.setAlignment(FlowLayout.RIGHT);
		this.setLayout(flow);
		int width=panel.getWidth();
		add(skin);
		add(help);
		add(min);add(max);add(close);
		skin.setLocation(width-100,0);
		help.setLocation(width-80,0);
		min.setLocation(width-60,0);
		max.setLocation(width-40,0);
		close.setLocation(width-20,0);
	
		
		
		
		
	}
	
	
	
	class buttonListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
    		if(e.getSource()==min){
    			//打开后恢复默认大小 为保证当前状态
    			
    		state=mainFrame.getExtendedState();
			  mainFrame.setExtendedState(JFrame.HIDE_ON_CLOSE);}
    		else if(e.getSource()==close)
    			System.exit(0);
    		else if(e.getSource()==max){
    			if(mainFrame.getExtendedState()!=JFrame.MAXIMIZED_BOTH)
    				{mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    				 max.setIcon(new ImageIcon("img/mainFrame/small.png"));
    				}else
    				{mainFrame.setExtendedState(JFrame.NORMAL);
   				 max.setIcon(new ImageIcon("img/mainFrame/max.png"));
    					
    				}
    				}
    				
    			
   }
    				
    
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			((JLabel)e.getSource()).setBorder(BorderFactory.createLineBorder(color));
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			((JLabel)e.getSource()).setBorder(BorderFactory.createEmptyBorder());
			
		}
    
	}	
	
	

}


