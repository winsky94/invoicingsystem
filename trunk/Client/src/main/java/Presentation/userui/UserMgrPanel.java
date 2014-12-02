package Presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import vo.UserVO;
import Presentation.mainui.MainFrame;
import Presentation.userui.usermanage.AddUserPanel;
import Presentation.userui.usermanage.DelUserDialog;
import Presentation.userui.usermanage.ModifyUserPanel;
import Presentation.userui.usermanage.getJobChange;

public class UserMgrPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color userColor=new Color(61,49,35);
	MainFrame father;
	JButton addBtn, delBtn, modBtn;
	UserTableModel utm;
	ArrayList<ArrayList<String>> c=new ArrayList<ArrayList<String>>();
	JScrollPane jsp;
	JTable userTbl;
	public UserMgrPanel(MainFrame myFather) {
		father = myFather;
		this.setBackground(Color.white);
		GridBagLayout gbl=new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 3, 5, 3);
		//--------------buttons-------------
		JPanel top=new JPanel();
		top.setBackground(Color.white);
		top.setLayout(new GridLayout(1,5));
		//
		addBtn=new JButton("增加用户",new ImageIcon("img/user/add.png"));
		addBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addBtn.setForeground(userColor);
		addBtn.setBorderPainted(false);
		addBtn.setBackground(Color.white);
		addBtn.setFocusPainted(false);
		addBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					father.setRightComponent(new AddUserPanel(father));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		top.add(addBtn);
		//
		delBtn=new JButton("删除用户",new ImageIcon("img/user/del.png"));
		delBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delBtn.setForeground(userColor);
		delBtn.setBorderPainted(false);
		delBtn.setBackground(Color.white);
		delBtn.setFocusPainted(false);
		delBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int[] i=userTbl.getSelectedRows();
				if(i.length>0){
					ArrayList<String> Id=new ArrayList<String>();
				for(int j=0;j<i.length;j++)
					Id.add((String)userTbl.getValueAt(i[j],0));
				
				JDialog delDlg=new DelUserDialog(Id,father);}
				else {
					 JOptionPane.showMessageDialog(null,"请选择用户","提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		top.add(delBtn);
		//
		modBtn=new JButton("修改用户信息",new ImageIcon("img/user/modify.png"));
		modBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		modBtn.setForeground(userColor);
		modBtn.setBorderPainted(false);
		modBtn.setBackground(Color.white);
		modBtn.setFocusPainted(false);
		modBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i=userTbl.getSelectedRow();
				if(i>=0){
				String Id=(String)userTbl.getValueAt(i,0);
				try {
					father.setRightComponent(new ModifyUserPanel(father,Id));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				else {
					 JOptionPane.showMessageDialog(null,"请选择用户","提示",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		top.add(modBtn);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		gbl.setConstraints(top, c);
		this.add(top);
		//--------------table------------------
		utm=new UserTableModel();
		userTbl=new JTable(utm);
		jsp=new JScrollPane(userTbl);
		c.gridy=1;
		gbl.setConstraints(jsp, c);
		this.add(jsp);
	}
	class UserTableModel extends AbstractTableModel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String head[] = { "用户账号","姓名", "身份","业绩点" };
		public int getRowCount() {
			return c.size();
		}

		public int getColumnCount() {
			return head.length;
		}

		public String getValueAt(int row, int col) {
			return c.get(row).get(col);
		}
		public String getColumnName(int col){
			return head[col];
		}
	}
	
	public void RefreshUserTable(ArrayList<UserVO> vo){
				  
				 for(UserVO VO:vo){
				 ArrayList<String> lineInfo=new ArrayList<String>();
				 lineInfo.add(VO.getID());lineInfo.add(VO.getName());
				 lineInfo.add(getJobChange.getJobString(VO.getJob()));
				lineInfo.add(Double.toString(VO.getGrades()));
				  c.add(lineInfo);
				   
				  }
				 
	}

	
}