package Presentation.memberui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import po.MemberPO.MemberLevel;
import po.MemberPO.MemberType;
import vo.MemberVO;
import Presentation.mainui.MainFrame;
import Presentation.uihelper.UIhelper;
import businesslogic.memberbl.MemAccountInfo;
import businesslogic.memberbl.MemBaseInfo;
import businesslogic.memberbl.MemContactInfo;
import businesslogic.memberbl.Member;
import businesslogicservice.memberblservice.MemberBLService;

public class AddMemberPanel extends JPanel {
	/**
	 * !!!!已写监听  
	 */
		
			
	private static final long serialVersionUID = 1L;
	int screenWidth = UIhelper.getScreenWidth();
	int screenHeight = UIhelper.getScreenHeight();
	int dialogWidth = screenWidth / 2;
	int dialogHeight = screenHeight / 2;
	MainFrame parent;
	JButton submitBtn;
	JComboBox<String> typeCbox;
	JTextField nameFld, phoneFld, addressFld, postcodeFld, EMailFld,
			defaultClerkFld;
	JLabel IDLbl, typeLbl, nameLbl, phoneLbl, addressLbl, postcodeLbl,
			EMailLbl, defaultClerkLbl;
	String nameText,phoneText,addressText,postcodeText,EMailText,clerkText;
	public AddMemberPanel(MainFrame frame) {
		parent=frame;
	
		
		this.setLayout(null);
		this.setBackground(Color.white);
		// ----------------------添加各个组件-----------------------------------

		// -----------------------IDLabel------------------------------------
		IDLbl = new JLabel();
		IDLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		// 这里要有一个方法来创建String，使得编号自动生成
		String text = "编号：JHS-0000001";
		IDLbl.setText(text);
		IDLbl.setBounds(dialogWidth * 5 / 100, dialogHeight * 5 / 100,
				dialogWidth * 40 / 100, dialogHeight * 7 / 100);
		this.add(IDLbl);
		// -----------------------typeLabel----------------------------------
		typeLbl = new JLabel("类型 ");
		typeLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		typeLbl.setBounds(dialogWidth * 5 / 100, dialogHeight * 20 / 100,
				dialogWidth * 5 / 100, dialogHeight * 7 / 100);
		this.add(typeLbl);
		// ----------------------typeComboBox--------------------------------
		String[] type = { "请选择类型", "进货商", "销售商" };
		typeCbox = new JComboBox<String>(type);
		typeCbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		typeCbox.setBackground(Color.white);
		typeCbox.setBounds(dialogWidth * 15 / 100, dialogHeight * 20 / 100,
				dialogWidth * 15 / 100, dialogHeight * 7 / 100);
		this.add(typeCbox);
		// ---------------------nameLabel------------------------------------
		nameLbl = new JLabel("姓名 ");
		nameLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		nameLbl.setBounds(dialogWidth * 50 / 100, dialogHeight * 20 / 100,
				dialogWidth * 5 / 100, dialogHeight * 7 / 100);
		this.add(nameLbl);
		// -----------------nameFld------------------------------------------
		nameFld = new JTextField();
		nameFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		nameFld.setBounds(dialogWidth * 60 / 100, dialogHeight * 20 / 100,
				dialogWidth * 20 / 100, dialogHeight * 7 / 100);
		nameFld.getDocument().addDocumentListener(new NameFieldListener());
		this.add(nameFld);
		// -----------------phoneLbl----------------------------------------
		phoneLbl = new JLabel("电话 ");
		phoneLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		phoneLbl.setBounds(dialogWidth * 5 / 100, dialogHeight * 35 / 100,
				dialogWidth * 5 / 100, dialogHeight * 7 / 100);
		this.add(phoneLbl);
		// -----------------phoneFld------------------------------------------
		phoneFld = new JTextField();
		phoneFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		phoneFld.setBounds(dialogWidth * 15 / 100, dialogHeight * 35 / 100,
				dialogWidth * 25 / 100, dialogHeight * 7 / 100);
		phoneFld.getDocument().addDocumentListener(new PhoneFieldListener());
		this.add(phoneFld);
		// -------------------EMailLbl---------------------------------------
		EMailLbl = new JLabel("电子邮箱 ");
		EMailLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		EMailLbl.setBounds(dialogWidth * 50 / 100, dialogHeight * 35 / 100,
				dialogWidth * 9 / 100, dialogHeight * 7 / 100);
		this.add(EMailLbl);
		// ----------------EMailFld------------------------------------------
		EMailFld = new JTextField();
		EMailFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		EMailFld.setBounds(dialogWidth * 60 / 100, dialogHeight * 35 / 100,
				dialogWidth * 30 / 100, dialogHeight * 7 / 100);
		EMailFld.getDocument().addDocumentListener(new EMailFieldListener());
		this.add(EMailFld);
		// ----------------addressLabel---------------------------------------
		addressLbl = new JLabel("地址 ");
		addressLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addressLbl.setBounds(dialogWidth * 5 / 100, dialogHeight * 50 / 100,
				dialogWidth * 5 / 100, dialogHeight * 7 / 100);
		this.add(addressLbl);
		// ---------------addressFld------------------------------------------
		addressFld = new JTextField();
		addressFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		addressFld.setBounds(dialogWidth * 15 / 100, dialogHeight * 50 / 100,
				dialogWidth * 50 / 100, dialogHeight * 7 / 100);
		addressFld.getDocument().addDocumentListener(new AddressFieldListener());
		this.add(addressFld);
		// ----------------postcodeLabel---------------------------------------
		postcodeLbl = new JLabel("邮编 ");
		postcodeLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		postcodeLbl.setBounds(dialogWidth * 5 / 100, dialogHeight * 65 / 100,
				dialogWidth * 5 / 100, dialogHeight * 7 / 100);
		this.add(postcodeLbl);
		// ---------------postcodeFld------------------------------------------
		postcodeFld = new JTextField();
		postcodeFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		postcodeFld.setBounds(dialogWidth * 15 / 100, dialogHeight * 65 / 100,
				dialogWidth * 25 / 100, dialogHeight * 7 / 100);
		postcodeFld.getDocument().addDocumentListener(new PostcodeFieldListener());
		this.add(postcodeFld);
		// -------------------defaultClerkLbl---------------------------------------
		defaultClerkLbl = new JLabel("默认业务员 ");
		defaultClerkLbl.setFont(new Font("微软雅黑", Font.BOLD, 14));
		defaultClerkLbl.setBounds(dialogWidth * 48 / 100, dialogHeight * 65 / 100,
				dialogWidth * 12 / 100, dialogHeight * 7 / 100);
		this.add(defaultClerkLbl);
		// ----------------defaultClerkFld------------------------------------------
		defaultClerkFld = new JTextField();
		defaultClerkFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		defaultClerkFld.setBounds(dialogWidth * 60 / 100, dialogHeight * 65 / 100,
				dialogWidth * 30 / 100, dialogHeight * 7 / 100);
		defaultClerkFld.getDocument().addDocumentListener(new ClerkFieldListener());
		this.add(defaultClerkFld);
		//-------------------submitBtn---------------------------------------------
		submitBtn=new JButton("确  定");
		submitBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		submitBtn.setBounds(dialogWidth * 40 / 100, dialogHeight * 80 / 100,
				dialogWidth * 20 / 100, dialogHeight * 8 / 100);
		submitBtn.setFocusPainted(false);
		this.add(submitBtn);
		
		submitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MemberBLService service;
				try {
					service = new Member();
					String id=service.getNewID();
					MemberType type;
					if(typeCbox.getSelectedItem()=="进货商")
						type=MemberType.JHS;
					else type=MemberType.XSS;
					
						
					MemBaseInfo bInfo=new MemBaseInfo(type,MemberLevel.ONE,id,nameFld.getText(),0,defaultClerkFld.getText());
					MemContactInfo cInfo=new MemContactInfo(phoneFld.getText(), addressFld.getText(),
							postcodeFld.getText(),  EMailFld.getText());
					MemAccountInfo aInfo=new MemAccountInfo(1000000,0,0);
				
					
					MemberVO vo=new MemberVO(bInfo,aInfo,cInfo);
					int result=service.addMember(vo);
					//改
					if(result==0){
						System.out.println("读入成功");
					}else{
						System.out.println("读入失败");
					}
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		// ------------------------------------------------------------------
	
	}
	class NameFieldListener implements DocumentListener{
		public void changedUpdate(DocumentEvent d) {
			nameText=nameFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			nameText=nameFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			nameText=nameFld.getText();
		}
	}
	class PhoneFieldListener implements DocumentListener{
		public void changedUpdate(DocumentEvent d) {
			phoneText=phoneFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			phoneText=phoneFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			phoneText=phoneFld.getText();
		}
	}
	class AddressFieldListener implements DocumentListener{
		public void changedUpdate(DocumentEvent d) {
			addressText=addressFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			addressText=addressFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			addressText=addressFld.getText();
		}
	}
	class EMailFieldListener implements DocumentListener{
		public void changedUpdate(DocumentEvent d) {
			EMailText=EMailFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			EMailText=EMailFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			EMailText=EMailFld.getText();
		}
	}
	class PostcodeFieldListener implements DocumentListener{
		public void changedUpdate(DocumentEvent d) {
			postcodeText=postcodeFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			postcodeText=postcodeFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			postcodeText=postcodeFld.getText();
		}
	}
	class ClerkFieldListener implements DocumentListener{
		public void changedUpdate(DocumentEvent d) {
			clerkText=defaultClerkFld.getText();
		}

		public void insertUpdate(DocumentEvent d) {
			clerkText=defaultClerkFld.getText();
		}

		public void removeUpdate(DocumentEvent d) {
			clerkText=defaultClerkFld.getText();
		}
	}
}
