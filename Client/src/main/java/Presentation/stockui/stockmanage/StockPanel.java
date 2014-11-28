package Presentation.stockui.stockmanage;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class StockPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String keyWord;
	Color stockColor = new Color(51, 125, 86);
	JTable stockTbl;
	JButton overflowBtn,lossBtn,inventoryBtn;
}
