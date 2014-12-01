package Presentation.mainui;

import java.util.ArrayList;

import javax.swing.JPanel;

public class ChooseGoodsFatherPane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<ArrayList<Object>> c=new ArrayList<ArrayList<Object>>();
	public double discount;
	public void addContent(ArrayList<ArrayList<Object>> toBeAdded){
		this.c.addAll(toBeAdded);
	}
	public void setDiscount(double d){
		this.discount=d;
	}
}
