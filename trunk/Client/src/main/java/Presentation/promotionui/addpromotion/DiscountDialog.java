package Presentation.promotionui.addpromotion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.AbstractTableModel;

import Presentation.mainui.ChooseGoodsFatherPane;
import Presentation.uihelper.UIhelper;

public class DiscountDialog extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//
	JTextField discountFld;
	//
	ArrayList<ArrayList<String>> selected=new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> rightTblMessage=new ArrayList<ArrayList<String>>();
	ChosenTblModel ctm;
	GoodsTblModel gtm;
	ArrayList<ArrayList<String>> leftTblMessage=new ArrayList<ArrayList<String>>();
	ChooseGoodsFatherPane father;
	//
	JButton submitBtn, exitBtn, addBtn, delBtn;
	JTree classTree;
	JScrollPane jspLeft, jspRight;
	JTable goodsTbl, chosenTbl;
	Container pnl;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth * 2 / 3;
	int dialogHeight = screenHeight * 2 / 3;
	public DiscountDialog(ChooseGoodsFatherPane myFather) {
		father=myFather;
		pnl = this.getContentPane();
		pnl.setLayout(null);
		pnl.setBackground(Color.white);
		// ------------classTree------------------------------------------
		classTree = new JTree();
		classTree.setBorder(BorderFactory.createLineBorder(Color.gray));
		classTree.setBounds(dialogWidth * 2 / 100, dialogHeight * 5 / 100,
				dialogWidth * 18 / 100, dialogHeight * 85 / 100);
		pnl.add(classTree);
		// -----------goodsTbl-------------------------------------------
		gtm=new GoodsTblModel();
		goodsTbl = new JTable(gtm);
		goodsTbl.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent e) {
				selected.clear();
			}

			public void mouseReleased(MouseEvent e) {
				for (int i = 0; i < goodsTbl.getSelectedRows().length; i++) {
					ArrayList<String> temp=new ArrayList<String>();
					for(int j=0;j<3;j++){
						temp.add((String) goodsTbl.getValueAt(goodsTbl.getSelectedRows()[i], j));
					}
				selected.add(temp);
				}
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		jspLeft = new JScrollPane(goodsTbl);
		jspLeft.setBounds(dialogWidth * 20 / 100, dialogHeight * 5 / 100,
				dialogWidth * 35 / 100, dialogHeight * 85 / 100);
		pnl.add(jspLeft);
		// ---------chosenTbl------------------------------------------
		JLabel chosenLbl = new JLabel("当前已选商品");
		chosenLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		chosenLbl.setBounds(dialogWidth * 72 / 100, dialogHeight * 5 / 100,
				dialogWidth * 30 / 100, dialogHeight * 5 / 100);
		pnl.add(chosenLbl);
		ctm=new ChosenTblModel();
		chosenTbl = new JTable(ctm);
		jspRight = new JScrollPane(chosenTbl);
		jspRight.setBounds(dialogWidth * 60 / 100, dialogHeight * 10 / 100,
				dialogWidth * 35 / 100, dialogHeight * 60 / 100);
		pnl.add(jspRight);
		// -------addBtn-----------------------------------------------
		addBtn = new JButton(">");
		addBtn.setFont(new Font("宋体", Font.BOLD, 15));
		addBtn.setFocusPainted(false);
		addBtn.setBorderPainted(false);
		addBtn.setBackground(Color.white);
		addBtn.setBounds(dialogWidth * 55 / 100, dialogHeight * 20 / 100,
				dialogWidth * 5 / 100, dialogHeight * 5 / 100);
		addBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println(selected.get(0).get(1));
				for(int i=0;i<selected.size();i++){
					ctm.addRow(selected.get(i));			
				}
				
				chosenTbl.revalidate();
			}
		});
		pnl.add(addBtn);
		// -------delBtn-----------------------------------------------
		delBtn = new JButton("<");
		delBtn.setFont(new Font("宋体", Font.BOLD, 15));
		delBtn.setFocusPainted(false);
		delBtn.setBorderPainted(false);
		delBtn.setBackground(Color.white);
		delBtn.setBounds(dialogWidth * 55 / 100, dialogHeight * 35 / 100,
				dialogWidth * 5 / 100, dialogHeight * 5 / 100);
		delBtn.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ctm.removeRow(chosenTbl.getSelectedRow());
				chosenTbl.revalidate();
			}
			
		});
		pnl.add(delBtn);
		//------------discount-------------------------------------------
		JLabel discountLbl1=new JLabel("以上商品打");
		discountLbl1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		discountLbl1.setBounds(dialogWidth * 60/ 100, dialogHeight * 73 / 100,
				dialogWidth * 15/ 100, dialogHeight * 5 / 100);
		pnl.add(discountLbl1);
		discountFld=new JTextField();
		discountFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		discountFld.setBounds(dialogWidth * 68/ 100, dialogHeight * 73 / 100,
				dialogWidth * 7/ 100, dialogHeight * 5 / 100);
		pnl.add(discountFld);
		JLabel discountLbl=new JLabel("折。");
		discountLbl.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		discountLbl.setBounds(dialogWidth * 75/ 100, dialogHeight * 73 / 100,
				dialogWidth * 10/ 100, dialogHeight * 5 / 100);
		pnl.add(discountLbl);
		// -------submitBtn----------------------------------------------
		submitBtn = new JButton("完 成");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setFocusPainted(false);
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.setBounds(dialogWidth * 67 / 100, dialogHeight * 84 / 100,
				dialogWidth * 8 / 100, dialogHeight * 5 / 100);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiscountDialog.this.father.addContent(rightTblMessage);
				DiscountDialog.this.father.repaint();
				DiscountDialog.this.father.revalidate();
				DiscountDialog.this.dispose();
			}
		});
		pnl.add(submitBtn);
		// ----------exitBtn------------------------------------------------
		exitBtn = new JButton("放 弃");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setFocusPainted(false);
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.setBounds(dialogWidth * 80 / 100, dialogHeight * 84 / 100,
				dialogWidth * 8 / 100, dialogHeight * 5 / 100);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DiscountDialog.this.dispose();
			}
		});
		pnl.add(exitBtn);
		//
		this.setTitle("选择打折商品");
		this.setBounds((screenWidth - dialogWidth) / 2,
				(screenHeight - dialogHeight) / 2, dialogWidth, dialogHeight);

		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	class GoodsTblModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "商品编号", "商品名", "型号" };
		public int getRowCount() {
			return leftTblMessage.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return leftTblMessage.get(row).get(col);
		}

		public String getColumnName(int column) {
			return head[column];
		}
		public void addRow(ArrayList<String> v){
			leftTblMessage.add(v);
		}
		public void removeRow(int row){
			leftTblMessage.remove(row);
		}
	}

	class ChosenTblModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "商品编号", "商品名", "型号" };

		public int getRowCount() {
			return rightTblMessage.size();
		}
		public void addRow(ArrayList<String> v){
			rightTblMessage.add(v);
		}
		public void removeRow(int row){
			rightTblMessage.remove(row);
		}
		public int getColumnCount() {
			return head.length;
		}

		public Object getValueAt(int row, int col) {
			return rightTblMessage.get(row).get(col);
		}

		public String getColumnName(int column) {
			return head[column];
		}
	}
}
