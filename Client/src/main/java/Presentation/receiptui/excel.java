package Presentation.receiptui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

import javax.swing.JFrame;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class excel extends JFrame implements ActionListener{
		JTable jt=new JTable();
		
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(jt,v,h);
		
		JMenuBar menuBar=new JMenuBar();
		JMenu fileMenu=new JMenu("�ļ�");
		JMenuItem openExcelFile=new JMenuItem("��Excel�ĵ�");
		JMenuItem saveExcelFile=new JMenuItem("����Excel�ĵ�");
		
		String currentSheet=null;
		
		public excel(String title){
			super(title);
			//
			fileMenu.add(openExcelFile);
			fileMenu.add(saveExcelFile);
			menuBar.add(fileMenu);
			setJMenuBar(menuBar);
			
			add(jsp);
			openExcelFile.addActionListener(this);
			saveExcelFile.addActionListener(this);
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==openExcelFile){
				//???����
				JFileChooser jfc=new JFileChooser(System.getProperty("user.home"));
				jfc.setFileFilter(new XLSFilter());
				if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
					jt.setModel(getXLSContent(jfc.getSelectedFile().getAbsolutePath()));
					this.setTitle(currentSheet);
				}
			}else if(e.getSource()==saveExcelFile){
				JFileChooser jfc=new JFileChooser(System.getProperty("user.home"));
				jfc.setFileFilter(new XLSFilter());
				if(jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
					saveXLSContents(jfc.getSelectedFile().getAbsolutePath());
				}
			}
		}
		
		//
		public DefaultTableModel getXLSContent(String filename){
			DefaultTableModel dtm=null;
			//����
			Vector header=new Vector();
			try{
				InputStream is=new FileInputStream(filename);
				Workbook wb=Workbook.getWorkbook(is);
				//��ȡ��һ��������
				Sheet rs=wb.getSheet(0);
				currentSheet=rs.getName();
				for(int i=0;i<rs.getRows();i++){
					Vector vector=new Vector();
					for(int j=0;j<rs.getColumns();j++){
						if(i==0){
							header.add(rs.getCell(j,i).getContents());
						}else{
							vector.add(rs.getCell(j,i).getContents());
						}
					}
					if(i==0)
						//��һ�о������б���
						dtm=new DefaultTableModel(header,0);
					else
						dtm.addRow(vector);
					
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			return dtm;
		}
		
		//д��
		public void saveXLSContents(String fileName){
			try{
				OutputStream os=new FileOutputStream(fileName);
				
			    //new Excel �ļ�
				WritableWorkbook wwb=Workbook.createWorkbook(os);
				 
				//new ������
				WritableSheet ws=wwb.createSheet(currentSheet, 0);
				//�����б�
				for(int i=0;i<jt.getModel().getColumnCount();i++){
					Label label=new Label(i,0,jt.getModel().getColumnName(i));
					ws.addCell(label);
				}
				for(int i=0;i<jt.getRowCount();i++){
					for(int j=0;j<jt.getColumnCount();j++){
						Label label=new Label(j,i+1,(String)jt.getValueAt(i, j));
						ws.addCell(label);
					}
				}
				wwb.write();
				wwb.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	
		
	
}
