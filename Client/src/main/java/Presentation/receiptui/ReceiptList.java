package Presentation.receiptui;
//单据列表   单据审批主界面  已审批，未审批
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ReceiptList extends ReceiptFrame{
	JTabbedPane  xxk;//选项卡
	JPanel approved,wait;
	JTable app=new JTable();
	JTable wai=new JTable();
	DefaultTableModel app1=null;
	DefaultTableModel wai1=null;
	static JPanel right=new JPanel();
	public ReceiptList(){
		
		super("单据审批",right);
		init();
		
		 	
	}
	public void init(){
		xxk=new JTabbedPane();
		String[] name1={"单据编号","创建日期","业务类型","交易客户","交易金额","业务员","备注"};
		 java.util.Vector vname = new java.util.Vector();
		 for (int i = 0 ; i < name1.length ; i++){
	            vname.addElement(name1[i]);
	        }
		 app1 = new DefaultTableModel(vname,0);
		 app.setModel(app1);
		 approved=new JPanel();
		 JScrollPane scroll=new JScrollPane(app);
		 approved=new JPanel();approved.add(app);
		 wait=new JPanel();wait.add(wai);
		 xxk.add("已审批", approved);
		 xxk.add("待审批",wait);
		 right.add(xxk);
		 
	}
	
	public static void main(String[] args) {
		
		ReceiptList f=new ReceiptList();
		
	}
	

}
