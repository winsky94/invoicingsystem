package Presentation.mainui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
//rightPane 的顶上部分基本窗口操作按钮
public class functionPane extends JPanel{
	JPanel parent;
	JLabel close,min,max,skin,help;
	JFrame mainFrame;
	int fsize;
	Border border;
	
	Color color;//需要get
	public functionPane(JFrame frame){
		//parent=panel;
		mainFrame=frame;
		color=((MainFrame)frame).getTheme()[0];
		buttonListener listen=new buttonListener();
		close=new JLabel(new ImageIcon("img/mainFrame/close.png"));
		min=new JLabel(new ImageIcon("img/mainFrame/min.png"));
		max=new JLabel(new ImageIcon("img/mainFrame/max.png"));//最大后后图标变化
		skin=new JLabel(new ImageIcon("img/mainFrame/skin.png"));
		help=new JLabel(new ImageIcon("img/mainFrame/help.png"));
		 border=BorderFactory.createLineBorder(new Color(0,0,0,0f));
		
		skin.setBorder(border);
		max.setBorder(border);
		min.setBorder(border);
		close.setBorder(border);
		help.setBorder(border);
		
		
		close.addMouseListener(listen);
		min.addMouseListener(listen);
		max.addMouseListener(listen);
		skin.addMouseListener(listen);
		help.addMouseListener(listen);	
		//parent=panel;
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
		//this.setBackground(Color.WHITE);
		flow.setAlignment(FlowLayout.RIGHT);
		this.setLayout(flow);
		//this.setBackground(Color.WHITE);
		this.setSize(100,30);
		
		add(skin);
		add(help);
		add(min);add(max);add(close);
	
	
		
		
		
		
	}

	
	
	
	class buttonListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
    		if(e.getSource()==min){
    			//打开后恢复默认大小 为保证当前状态
    			
    		//state=mainFrame.getExtendedState();
			  mainFrame.setExtendedState(JFrame.HIDE_ON_CLOSE);}
    		else if(e.getSource()==close)
    			System.exit(0);
    		else if(e.getSource()==max){
    			if(mainFrame.getExtendedState()!=JFrame.MAXIMIZED_BOTH)
    				{
    				
    				mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
			((JLabel)e.getSource()).setBorder(border);
			
		}
    
	}	
	
	

}


