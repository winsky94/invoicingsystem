package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import vo.GoodsClassVO;
import businesslogic.stockbl.goodsClass.GoodsClassController;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class GoodsPanel extends JPanel implements MouseListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addGoodsBtn, delGoodsBtn, modGoodsBtn, searchBtn;
	JButton addGCBtn,delGCBtn,modGCBtn;
	JTextField searchFld;
	JTree goodsClassTree;
	JTable goodsTable;
	Color stockColor = new Color(51, 125, 86);
	String keyWord;

	JScrollPane jtreeJsp = null;
	JTree jtree = null;
	TreePath selectedPath = null;
	DefaultTreeModel treeModel = null;
	DefaultMutableTreeNode addNode = null;
	DefaultMutableTreeNode updateNode = null;

	public GoodsPanel() {
		CreateGoodsClass();// yan
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(3, 3, 3, 3);
		//
		addGoodsBtn = new JButton("添加商品", new ImageIcon(
				"img/sales/memberMgr.png"));
		addGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addGoodsBtn.setForeground(stockColor);
		addGoodsBtn.setBorderPainted(false);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new AddGoodsBtnListener());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		c.weightx = 0.05;
		c.weighty = 0.05;
		c.fill=GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(addGoodsBtn, c);
		this.add(addGoodsBtn);
		//
		delGoodsBtn = new JButton("删除商品", new ImageIcon(
				"img/sales/memberMgr.png"));
		delGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delGoodsBtn.setForeground(stockColor);
		delGoodsBtn.setBorderPainted(false);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new DelGoodsBtnListener());
		c.gridx = 1;
		c.fill=GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(delGoodsBtn, c);
		this.add(delGoodsBtn);
		//
		modGoodsBtn = new JButton("修改商品信息", new ImageIcon(
				"img/sales/memberMgr.png"));
		modGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		modGoodsBtn.setForeground(stockColor);
		modGoodsBtn.setBorderPainted(false);
		modGoodsBtn.setBackground(Color.white);
		modGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		modGoodsBtn.setFocusPainted(false);
		modGoodsBtn.addActionListener(new ModGoodsBtnListener());
		c.gridx = 2;
		gbl.setConstraints(modGoodsBtn, c);
		this.add(modGoodsBtn);
		//
		// 搜索框
		searchFld = new JTextField();
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));

		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		c.gridx = 3;
		c.gridwidth = 2;
		c.weightx = 0.6;
		c.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(searchFld, c);
		this.add(searchFld);
		// 查找按钮
		searchBtn = new JButton(new ImageIcon("img/sales/find-blue.png"));
		searchBtn.setForeground(stockColor);
		searchBtn.setBorderPainted(false);
		searchBtn.setBackground(Color.white);
		searchBtn.setHorizontalAlignment(SwingConstants.LEFT);
		searchBtn.setFocusPainted(false);
		searchBtn.addActionListener(new SearchBtnListener());
		c.gridx = 5;
		c.weightx = 0.05;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(searchBtn, c);
		this.add(searchBtn);
		// -------blank-----------------------
		JLabel blankLbl = new JLabel();
		c.gridx = 6;
		c.weightx = 0.2;
		gbl.setConstraints(blankLbl, c);
		this.add(blankLbl);
		// ---------goodsClassTree-------------------
		CreateGoodsClass();
		jtree.setBackground(Color.green);
		c.insets = new Insets(10, 3, 10, 3);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 5;
		c.gridwidth = 1;//由2改为1，将树的panel调小、、、、yan
		c.weightx = 0.1;
		c.weighty = 50;
		gbl.setConstraints(jtree, c);
//		this.add(jtree);
		
		//---------------------button---------------------
		//------------------------------------------------
		addGCBtn = new JButton("添加分类", new ImageIcon(
				"img/sales/memberMgr.png"));
		addGCBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addGCBtn.setForeground(stockColor);
		addGCBtn.setBorderPainted(false);
		addGCBtn.setBackground(Color.white);
		addGCBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addGCBtn.setFocusPainted(false);
		addGCBtn.addActionListener(new AddGCBtnListener());
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight=1;
		c.gridwidth=1;
		c.weightx = 0.05;
		c.weighty = 0.05;
		c.fill=GridBagConstraints.SOUTHWEST;
		gbl.setConstraints(addGCBtn, c);
		this.add(addGCBtn);
		
		// ----------goodsTable------------------
		goodsTable = new JTable();
		goodsTable.setBackground(Color.blue);
		c.gridx = 1;//2->1 、、yan
		c.gridy = 1;
		c.gridheight=6;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0.6;
		c.weighty = 0.92;
		c.fill=GridBagConstraints.BOTH;
		gbl.setConstraints(goodsTable, c);
		this.add(goodsTable);
	}

	class AddGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JDialog addGoodsDlg = new AddGoodsDialog();

		}

	}

	class DelGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JDialog delGoodsDlg = new DelGoodsDialog();

		}

	}

	class ModGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JDialog modGoodsDlg = new ModGoodsDialog();

		}

	}

	class SearchFldListener implements DocumentListener {

		public void insertUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void removeUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

		public void changedUpdate(DocumentEvent e) {
			keyWord = searchFld.getText();
		}

	}

	class SearchBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	
	// yan---------------------------------------------------------------------
	//------------tree_button--------------------------------------------------
	class AddGCBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			addGoodsClass();

		}

	}

	class DelGCBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			delGoodsClass();

		}

	}
	
	class ModGCBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			modGoodsClass();

		}

	}

	//------------tree---------------------------------------------------------
	// 创建界面根节点
	private DefaultMutableTreeNode createGoodsClassNode(GoodsClassNode root) {
		DefaultMutableTreeNode Troot = null;
		if (root != null)
			Troot = new DefaultMutableTreeNode(root.name);
		else
			return null;
		for (int i = 0; i < root.children.size(); i++) {
			DefaultMutableTreeNode Tnode = createGoodsClassNode(root.children
					.get(i));
			Troot.add(Tnode);
		}
		return Troot;
	}

	// 创建逻辑根节点--yan
	private GoodsClassNode CreateTree() {
		GoodsClassNode root = new GoodsClassNode("商品分类", "001");
		GoodsClassNode node1 = new GoodsClassNode("食品", "001001");
		GoodsClassNode node2 = new GoodsClassNode("日用品", "001002");
		GoodsClassNode node3 = new GoodsClassNode("电器", "001003");
		GoodsClassNode node4 = new GoodsClassNode("服装", "001004");
//		root.children.add(node1);
//		root.children.add(node1);
//		root.children.add(node1);
//		root.children.add(node1);
//		root.children.add(node1);
//		root.children.add(node1);
//		root.children.add(node1);
//		root.children.add(node1);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		root.children.add(node4);
		GoodsClassNode node1_1 = new GoodsClassNode("肉食", "001001001");
		GoodsClassNode node1_2 = new GoodsClassNode("蔬菜", "001001002");
		GoodsClassNode node1_3 = new GoodsClassNode("水果", "001001003");
		node1.children.add(node1_1);
		node1.children.add(node1_2);
		node1.children.add(node1_3);

		return root;
	}

	private void CreateGoodsClass() {
		// 商品分类
		GoodsClassNode root = CreateTree();
		DefaultMutableTreeNode Troot = createGoodsClassNode(root);
		jtree = new JTree(Troot);
		treeModel = (DefaultTreeModel) jtree.getModel();
		// 渲染器，调整树背景色及文字背景色
		DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) jtree
				.getCellRenderer();
//		cellRenderer.setLeafIcon(new ImageIcon(GoodsPanel.class
//				.getResource("/mainImage/next.png")));
//		cellRenderer.setOpenIcon(new ImageIcon(GoodsPanel.class
//				.getResource("/mainImage/next.png")));
//		cellRenderer.setClosedIcon(new ImageIcon(GoodsPanel.class
//				.getResource("/mainImage/next.png")));
		
		cellRenderer.setFont(new Font("宋体", Font.PLAIN, 12));
		cellRenderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
		cellRenderer.setBackgroundSelectionColor(null);
		cellRenderer.setBorderSelectionColor(null);
		cellRenderer.setTextNonSelectionColor(Color.black);
		cellRenderer.setTextSelectionColor(Color.blue);
		// cellRenderer.setOpaque(false);

		jtree.setEditable(false);
		jtree.setBackground(Color.getHSBColor(20, 30, 40));
		jtree.addMouseListener(this);
	}

	private String getSelectedClass() {
		if (selectedPath != null)
			return selectedPath.getLastPathComponent().toString();
		return null;
	}

	private DefaultMutableTreeNode getSelectedNode() {
		if (selectedPath != null)
			return (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
		return null;
	}

	private void addGoodsClass() {
		String fatherClass = getSelectedClass();
		if (fatherClass == null) {
			JOptionPane.showMessageDialog(null, "请选择父分类", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// 如果选中的分类下面有商品，提示不能添加分类

		// 添加节点
//		new AddGoodsClassDialog(this);
		if (addNode == null)
			return;
		 StockGoodsClassBLService controller = new GoodsClassController();
		 GoodsClassVO vo=new GoodsClassVO(null, null);
		int addResult=controller.addGoodsClass(vo);
		if (addResult == 0) {
			DefaultMutableTreeNode treeNode = getSelectedNode();
			treeModel.insertNodeInto(addNode, treeNode,
					treeNode.getChildCount());
		} else
			JOptionPane.showMessageDialog(this, "添加失败", "Error",
					JOptionPane.ERROR_MESSAGE);

	}

	private void delGoodsClass() {
		if (selectedPath == null) {
			JOptionPane.showMessageDialog(this, "请选中一个分类！", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int a = JOptionPane.showConfirmDialog(this, "确定要删除？", "OK?",
				JOptionPane.YES_NO_OPTION);
		if (a == JOptionPane.NO_OPTION)
			return;

		StockGoodsClassBLService controller = new GoodsClassController();
		GoodsClassVO vo=new GoodsClassVO(null, null);
		int delResult=controller.addGoodsClass(vo);
		if (delResult == 0) {
			DefaultMutableTreeNode treeNode = getSelectedNode();
			treeModel.removeNodeFromParent(treeNode);
		} else
			JOptionPane.showMessageDialog(this, "删除失败", "Error",
					JOptionPane.ERROR_MESSAGE);
	}

	private void modGoodsClass() {
		if (selectedPath == null) {
			JOptionPane.showMessageDialog(this, "请选中一个分类！", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
//		new UpdateGoodsClassDialog(this);

		if (updateNode == null)
			return;
		StockGoodsClassBLService controller = new GoodsClassController();
		GoodsClassVO vo=new GoodsClassVO(null, null);
		int molResult=controller.addGoodsClass(vo);
		if (molResult == 0) {
			DefaultMutableTreeNode treeNode = getSelectedNode();
			treeNode.setUserObject(updateNode.getUserObject());
			jtree.repaint();
		} else
			JOptionPane.showMessageDialog(this, "修改失败", "Error",
					JOptionPane.ERROR_MESSAGE);

	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
	}

	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2){
			//根据分类显示商品信息
//			this.UpdateGoodsListByClass(getSelectedClass());
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (e.getButton() == MouseEvent.BUTTON1) {
			TreePath path = jtree.getPathForLocation(e.getX(), e.getY());
			if (path != null)
				selectedPath = path;
			if (selectedPath != null) {
				jtree.setSelectionPath(selectedPath);
			} else
				return;
		}
	}

	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	
	
	class AddGoodsClassDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		JLabel fatherClassDjl = null;
		JLabel classDjl = null;
		JTextField fatherClassDjtf = null;
		JTextField classDjtf = null;
		JButton okDjb = null;
		JButton cancelDjb = null;

		GoodsClassNode father = null;

		public AddGoodsClassDialog(GoodsClassNode father) {
			this.father = father;

			Font font = new Font("仿宋", Font.BOLD, 16);
			fatherClassDjl = new JLabel("父分类");
			fatherClassDjl.setFont(font);
			fatherClassDjl.setBounds(15, 20, 60, 30);
			this.add(fatherClassDjl);

			classDjl = new JLabel("分类名");
			classDjl.setFont(font);
			classDjl.setBounds(15, 60, 60, 30);
			this.add(classDjl);

			fatherClassDjtf = new JTextField();
			fatherClassDjtf.setFont(font);
			fatherClassDjtf.setText(getSelectedClass());
			fatherClassDjtf.setEditable(false);
			fatherClassDjtf.setBounds(85, 20, 180, 30);
			this.add(fatherClassDjtf);

			classDjtf = new JTextField();
			classDjtf.setFont(font);
			classDjtf.setBounds(85, 60, 180, 30);
			this.add(classDjtf);

			okDjb = new JButton("确定");
			// okDjb.setFont(font);
			okDjb.setBounds(50, 110, 60, 30);
			okDjb.addActionListener(this);
			okDjb.setVisible(true);
			this.add(okDjb);

			cancelDjb = new JButton("取消");
			// cancelDjb.setFont(font);
			cancelDjb.setBounds(170, 110, 60, 30);
			cancelDjb.addActionListener(this);
			cancelDjb.setVisible(true);
			this.add(cancelDjb);

			this.setSize(300, 200);
			this.setLayout(null);
			this.setTitle("添加商品分类");
			this.setResizable(false);
//			this.setLocation(father.getX() + father.getWidth() / 2,
//					father.getY() + father.getHeight() / 3);
			this.setModal(true);
			this.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okDjb) {
				if (fatherClassDjtf.getText().trim().equals("")
						|| classDjtf.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "请填写全部信息！", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
//				father.addNode = new DefaultMutableTreeNode(classDjtf.getText()
//						.trim());
				this.dispose();
			} else if (e.getSource() == cancelDjb) {
//				father.addNode = null;
				this.dispose();
			}
		}

	}

	//end_yan-----------------------------------------------------------

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 800, 500);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GoodsPanel gp = new GoodsPanel();
		gp.setBounds(0, 0, 800, 500);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}

	
}
