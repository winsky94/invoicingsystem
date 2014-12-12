package Presentation.financeui.initial;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import po.MemberPO.MemberType;
import vo.AccountVO;
import vo.LogVO;
import vo.MemberVO;
import Presentation.financeui.account.AddAccountPanel;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;
import Presentation.memberui.AddMemberPanel;

public class addAccountInitial extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AddAccountPanel p;
	AccountInitialPanel tab;
	MainFrame parent;
	public addAccountInitial(MainFrame pa,final AccountInitialPanel tab ){
		try {
			p=new AddAccountPanel(pa);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		parent=pa;
		this.tab=tab;
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.CENTER);
		
		p.submitBtn.removeActionListener(p.add);
		p.exitBtn.removeActionListener(p.add);
		p.submitBtn.addActionListener(this);
		p.exitBtn.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==p.submitBtn){
			if (p.name.equals("")||p.money.equals("")) {
				JOptionPane.showMessageDialog(null, "请输入完整信息！", "提示",JOptionPane.CLOSED_OPTION);
			} else {
				AccountVO vo = new AccountVO(p.name,Double.parseDouble(p.money));
				tab.RefreshTable(vo);
				parent.setRightComponent(tab.subparent);
				tab.subparent.setFocus(2);
				tab.subparent.memberInitialPanel.haveSelected.add(-1);
				// 改
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "添加账户成功！", "提示",
							JOptionPane.CLOSED_OPTION);
					log.addLog(new LogVO(log.getdate(),parent.getUser().getID(),parent.getUser().getName(),
							"添加了一个新账户"+nameFld.getText(),3));
					try {
						headPane.RefreshGrades();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "添加账户失败！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				Update();
			}
			if (p.ID == null ||p. ID.equals("")) {
				JOptionPane.showMessageDialog(null, "请选择用户类型，并输入信息！", "提示",
						JOptionPane.CLOSED_OPTION);}
			else{
				MemberVO vo=p.getMemberVO();
				tab.RefreshTable(vo);
				parent.setRightComponent(tab.subparent);
				tab.subparent.setFocus(1);
				tab.subparent.memberInitialPanel.haveSelected.add(-1);
			}
		    }else if(e.getSource()==p.cancelBtn){
				parent.setRightComponent(tab.subparent);
				tab.subparent.setFocus(1);
				
			}
		}
		
	

}
	
	
	



