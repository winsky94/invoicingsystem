package Presentation.userui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddUserPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame father;
	JButton submitBtn,exitBtn;
	JLabel IDLbl;
	JComboBox<String> typeBox;
	JTextField nameFld,keyFld;
	String ID,name,key,type;
	String typeList[]={"请选择身份","总经理","库存人员","进货销售人员","销售经理","财务人员","财务经理","系统管理员"};
	public AddUserPanel(JFrame myFather){
		father=myFather;
		this.setBackground(Color.white);
		GridBagLayout gbl=new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		//---------title---------------------
		JLabel title=new JLabel("添加用户");
		title.setFont(new Font("微软雅黑", Font.BOLD, 30));
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=2;
		gbl.setConstraints(title, c);
		this.add(title);
		//------------------------------------
		JPanel midPnl=new JPanel();
		GridBagLayout mbl=new GridBagLayout();
		GridBagConstraints mc = new GridBagConstraints();
		midPnl.setLayout(mbl);
		mc.insets=new Insets(10,5,10,5);
		mc.fill=GridBagConstraints.HORIZONTAL;
		//midPnl.setLayout(new GridLayout(3,2,5,5));
		midPnl.setBackground(Color.white);
		//----------ID-----------------------
		JLabel IDLbl=new JLabel();
		IDLbl.setText("工号："+ID);
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=1;
		gbl.setConstraints(IDLbl, c);
		this.add(IDLbl);
		//----------name---------------------
		JLabel nameLbl=new JLabel("姓名：");
		nameLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		mc.gridx=0;
		mc.gridy=0;
		mc.gridwidth=1;
		mc.gridheight=1;
		mbl.setConstraints(nameLbl, mc);
		midPnl.add(nameLbl);
		
		nameFld=new JTextField();
		nameFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mc.gridx=1;
		mc.gridy=0;
		mc.gridwidth=3;
		mc.gridheight=1;
		mbl.setConstraints(nameFld, mc);
		midPnl.add(nameFld);
		//---------type----------------------
		JLabel typeLbl=new JLabel("工种：");
		typeLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		mc.gridx=0;
		mc.gridy=1;
		mc.gridwidth=1;
		mc.gridheight=1;
		mbl.setConstraints(typeLbl, mc);
		midPnl.add(typeLbl);
		typeBox=new JComboBox<String>(typeList);
		typeBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		typeBox.setBackground(Color.white);
		mc.gridx=1;
		mc.gridy=1;
		mc.gridwidth=3;
		mc.gridheight=1;
		mbl.setConstraints(typeBox, mc);
		midPnl.add(typeBox);
		//-------key--------------------------
		JLabel keyLbl=new JLabel("密码：");
		keyLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		mc.gridx=0;
		mc.gridy=2;
		mc.gridwidth=1;
		mc.gridheight=1;
		mbl.setConstraints(keyLbl, mc);
		midPnl.add(keyLbl);
		keyFld=new JTextField();
		keyFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		mc.gridx=1;
		mc.gridy=2;
		mc.gridwidth=3;
		mc.gridheight=1;
		mbl.setConstraints(keyFld, mc);
		midPnl.add(keyFld);
		//------------------------------------
		c.gridx=0;
		c.gridy=3;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=4;
		gbl.setConstraints(midPnl, c);
		this.add(midPnl);
		//-----------------------------------
		JPanel btnPnl=new JPanel();
		btnPnl.setBackground(Color.white);
		btnPnl.setLayout(new GridLayout(1,3));
		//-----submit------------------------
		submitBtn=new JButton("确定");
		submitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitBtn.setBackground(new Color(166, 210, 121));
		submitBtn.setFocusPainted(false);
		btnPnl.add(submitBtn);
		//---------------------------------
		JLabel blank=new JLabel();
		btnPnl.add(blank);
		//-------exit----------------------
		exitBtn=new JButton("取消");
		exitBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		exitBtn.setBackground(new Color(251, 147, 121));
		exitBtn.setFocusPainted(false);
		btnPnl.add(exitBtn);
		//--------------------------------
		c.gridx=0;
		c.gridy=7;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=2;
		JPanel blank2=new JPanel();
		blank2.setBackground(Color.white);
		gbl.setConstraints(blank2, c);
		this.add(blank2);
		c.gridx=0;
		c.gridy=9;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=2;
		JPanel blank3=new JPanel();
		blank3.setBackground(Color.white);
		gbl.setConstraints(blank3, c);
		this.add(blank3);
		c.gridx=0;
		c.gridy=11;
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.gridheight=2;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);
	}
	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 800, 500);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AddUserPanel gp = new AddUserPanel(testFrame);
		gp.setBounds(0, 0, 800, 500);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}
	
}
