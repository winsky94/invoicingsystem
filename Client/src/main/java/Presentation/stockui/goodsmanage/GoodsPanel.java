package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.security.Provider.Service;

import javax.swing.BorderFactory;
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
import Presentation.mainui.MainFrame;
import businesslogic.stockbl.goodsClass.GoodsClassController;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class GoodsPanel extends JPanel implements MouseListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addGoodsBtn, delGoodsBtn, modGoodsBtn, searchBtn;
	JButton addGCBtn, delGCBtn, modGCBtn;
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

	GoodsClassNode newNode = null;
	MainFrame parent;
	public GoodsPanel(MainFrame frame) {
		parent=frame;
		CreateGoodsClass();// yan
		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		// -----------upPnl--------------------------------------------------------
		JPanel upPnl = new JPanel();
		upPnl.setBackground(Color.white);
		GridBagLayout upGbl = new GridBagLayout();
		GridBagConstraints uc = new GridBagConstraints();
		upPnl.setLayout(upGbl);
		uc.insets = new Insets(3, 3, 3, 3);
		uc.fill = GridBagConstraints.HORIZONTAL;
		addGoodsBtn = new JButton("添加商品", new ImageIcon("img/stock/add.png"));
		addGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		addGoodsBtn.setForeground(stockColor);
		addGoodsBtn.setBorderPainted(false);
		addGoodsBtn.setBackground(Color.white);
		addGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		addGoodsBtn.setFocusPainted(false);
		addGoodsBtn.addActionListener(new AddGoodsBtnListener());
		uc.gridx = 0;
		uc.gridy = 0;
		uc.weightx = 0.05;
		uc.weighty = 0.05;
		upGbl.setConstraints(addGoodsBtn, uc);
		upPnl.add(addGoodsBtn);
		//
		delGoodsBtn = new JButton("删除商品", new ImageIcon("img/stock/delete.png"));
		delGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		delGoodsBtn.setForeground(stockColor);
		delGoodsBtn.setBorderPainted(false);
		delGoodsBtn.setBackground(Color.white);
		delGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		delGoodsBtn.setFocusPainted(false);
		delGoodsBtn.addActionListener(new DelGoodsBtnListener());
		uc.gridx = 1;
		upGbl.setConstraints(delGoodsBtn, uc);
		upPnl.add(delGoodsBtn);
		//
		modGoodsBtn = new JButton("修改商品信息", new ImageIcon(
				"img/stock/modify.png"));
		modGoodsBtn.setFont(new Font("微软雅黑", Font.BOLD, 14));
		modGoodsBtn.setForeground(stockColor);
		modGoodsBtn.setBorderPainted(false);
		modGoodsBtn.setBackground(Color.white);
		modGoodsBtn.setHorizontalAlignment(SwingConstants.LEFT);
		modGoodsBtn.setFocusPainted(false);
		modGoodsBtn.addActionListener(new ModGoodsBtnListener());
		uc.gridx = 2;
		uc.insets = new Insets(3, 3, 3, 150);
		upGbl.setConstraints(modGoodsBtn, uc);
		upPnl.add(modGoodsBtn);
		// ------------------------------------------
		// 搜索框
		searchFld = new JTextField();
		searchFld.setFont(new Font("楷体", Font.BOLD, 13));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		uc.gridx = 3;
		uc.gridwidth = 4;
		uc.weightx = 0.8;
		uc.insets = new Insets(3, 3, 3, 3);
		upGbl.setConstraints(searchFld, uc);
		upPnl.add(searchFld);
		// 查找按钮
		searchBtn = new JButton(new ImageIcon("img/stock/find.png"));
		searchBtn.setForeground(stockColor);
		searchBtn.setBorderPainted(false);
		searchBtn.setBackground(Color.white);
		searchBtn.setHorizontalAlignment(SwingConstants.LEFT);
		searchBtn.setFocusPainted(false);
		searchBtn.addActionListener(new SearchBtnListener());
		uc.gridx = 7;
		uc.gridwidth = 1;
		uc.weightx = 0.05;
		upGbl.setConstraints(searchBtn, uc);
		upPnl.add(searchBtn);
		// -------------------------------------
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(upPnl, c);
		this.add(upPnl);

		// ---------goodsClassTree-------------------
		CreateGoodsClass();
		jtree.setBackground(Color.white);
		jtree.setBorder(BorderFactory.createLineBorder(Color.gray));
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(3, 3, 3, 3);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 5;
		c.gridwidth = 2;// 由2改为1，将树的panel调小、、、、yan
		c.weightx = 0.05;
		c.weighty = 50;
		gbl.setConstraints(jtree, c);
		this.add(jtree);

		// ---------------------button---------------------
		JPanel downPnl = new JPanel();
		downPnl.setLayout(new GridLayout(1, 3));
		// ------------------------------------------------
		addGCBtn = new JButton("添加分类");
		addGCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		addGCBtn.setForeground(stockColor);
		addGCBtn.setBackground(Color.white);
		addGCBtn.setFocusPainted(false);
		addGCBtn.addActionListener(new AddGCBtnListener());
		downPnl.add(addGCBtn);
		// ------------------------------------------------
		delGCBtn = new JButton("删除分类");
		delGCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		delGCBtn.setForeground(stockColor);
		delGCBtn.setBackground(Color.white);
		delGCBtn.setFocusPainted(false);
		delGCBtn.addActionListener(new DelGCBtnListener());
		downPnl.add(delGCBtn);
		// ------------------------------------------------
		modGCBtn = new JButton("修改分类");
		modGCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		modGCBtn.setForeground(stockColor);
		modGCBtn.setBackground(Color.white);
		modGCBtn.setFocusPainted(false);
		modGCBtn.addActionListener(new ModGCBtnListener());
		downPnl.add(modGCBtn);
		c.insets = new Insets(1, 1, 1, 1);
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weightx = 0.05;
		c.weighty = 0.05;
		gbl.setConstraints(downPnl, c);
		this.add(downPnl);

		// ----------goodsTable------------------
		goodsTable = new JTable();
		goodsTable.setBackground(Color.blue);
		c.gridx = 3;
		c.gridy = 1;
		c.gridheight = 7;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0.6;
		c.weighty = 55;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(goodsTable, c);
		this.add(goodsTable);
	}

	class AddGoodsBtnListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			parent.setRightComponent(new AddGoodsPanel(parent));

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
	// ------------tree_button_listener--------------------------------------------------
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

	// ------------tree---------------------------------------------------------
	// 创建界面根节点
	private DefaultMutableTreeNode createGoodsClassNode(GoodsClassNode root) {
		DefaultMutableTreeNode Troot = null;
		if (root != null)
			Troot = new DefaultMutableTreeNode(root.getName());
		else
			return null;
		for (int i = 0; i < root.getChildren().size(); i++) {
			DefaultMutableTreeNode Tnode = createGoodsClassNode(root
					.getChildren().get(i));
			Troot.add(Tnode);
		}
		return Troot;
	}

	// 创建逻辑根节点--yan
	private GoodsClassNode CreateTree() {
		// GoodsClassNode root = new GoodsClassNode("商品分类", "001");
		// GoodsClassNode node1 = new GoodsClassNode("食品", "001001");
		// GoodsClassNode node2 = new GoodsClassNode("日用品", "001002");
		// GoodsClassNode node3 = new GoodsClassNode("电器", "001003");
		// GoodsClassNode node4 = new GoodsClassNode("服装", "001004");
		//
		// root.children.add(node1);
		// root.children.add(node2);
		// root.children.add(node3);
		// root.children.add(node4);
		// GoodsClassNode node1_1 = new GoodsClassNode("肉食", "001001001");
		// GoodsClassNode node1_2 = new GoodsClassNode("蔬菜", "001001002");
		// GoodsClassNode node1_3 = new GoodsClassNode("水果", "001001003");
		// node1.children.add(node1_1);
		// node1.children.add(node1_2);
		// node1.children.add(node1_3);
		GoodsClassNode root = new GoodsClassNode("灯具", "001");

		return root;
	}

	private void CreateGoodsClass() {
		// 商品分类
		StockGoodsClassBLService controller = new GoodsClassController();
		jtree = controller.getClassTree();
		if (jtree == null) {
			// GoodsClassNode root = CreateTree();
			GoodsClassNode root = new GoodsClassNode("灯具", "001");
			DefaultMutableTreeNode Troot = createGoodsClassNode(root);
			jtree = new JTree(Troot);
		}
		treeModel = (DefaultTreeModel) jtree.getModel();
		// 渲染器，调整树背景色及文字背景色
		DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) jtree
				.getCellRenderer();
		// cellRenderer.setLeafIcon(new ImageIcon(GoodsPanel.class
		// .getResource("/mainImage/next.png")));
		// cellRenderer.setOpenIcon(new ImageIcon(GoodsPanel.class
		// .getResource("/mainImage/next.png")));
		// cellRenderer.setClosedIcon(new ImageIcon(GoodsPanel.class
		// .getResource("/mainImage/next.png")));

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
		new AddGoodsClassDialog(this);
		if (addNode == null)
			return;
		// rmi通信
		StockGoodsClassBLService controller = new GoodsClassController();
		GoodsClassVO vo = new GoodsClassVO(newNode.getName(),
				newNode.getUpClass());
		int addResult = controller.addGoodsClass(vo);

		if (addResult == 0) {
			DefaultMutableTreeNode treeNode = getSelectedNode();
			treeModel.insertNodeInto(addNode, treeNode,
					treeNode.getChildCount());
			try {
				controller.recordClassTree(jtree);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
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
		GoodsClassVO vo = new GoodsClassVO(null, null);
		// int delResult = controller.addGoodsClass(vo);
		int delResult = 0;
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
		new UpdateGoodsClassDialog(this);

		if (updateNode == null)
			return;
		StockGoodsClassBLService controller = new GoodsClassController();
		GoodsClassVO vo = new GoodsClassVO(null, null);
		// int molResult = controller.addGoodsClass(vo);
		int molResult = 0;
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
		if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
			// 根据分类显示商品信息
			// this.UpdateGoodsListByClass(getSelectedClass());
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

	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	class AddGoodsClassDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		JLabel fatherClassjl = null;
		JLabel classjl = null;
		JTextField fatherClassjtf = null;
		JTextField classjtf = null;
		JButton okjb = null;
		JButton canceljb = null;

		GoodsPanel father = null;

		public AddGoodsClassDialog(GoodsPanel father) {
			this.father = father;

			Font font = new Font("仿宋", Font.BOLD, 16);
			fatherClassjl = new JLabel("父分类");
			fatherClassjl.setFont(font);
			fatherClassjl.setBounds(15, 20, 60, 30);
			this.add(fatherClassjl);

			classjl = new JLabel("分类名");
			classjl.setFont(font);
			classjl.setBounds(15, 60, 60, 30);
			this.add(classjl);

			fatherClassjtf = new JTextField();
			fatherClassjtf.setFont(font);
			fatherClassjtf.setText(getSelectedClass());
			fatherClassjtf.setEditable(false);
			fatherClassjtf.setBounds(85, 20, 180, 30);
			this.add(fatherClassjtf);

			classjtf = new JTextField();
			classjtf.setFont(font);
			classjtf.setBounds(85, 60, 180, 30);
			this.add(classjtf);

			okjb = new JButton("确定");
			okjb.setBounds(50, 110, 60, 30);
			okjb.addActionListener(this);
			okjb.setVisible(true);
			this.add(okjb);

			canceljb = new JButton("取消");
			canceljb.setBounds(170, 110, 60, 30);
			canceljb.addActionListener(this);
			canceljb.setVisible(true);
			this.add(canceljb);

			this.setSize(300, 200);
			this.setLayout(null);
			this.setTitle("添加商品分类");
			this.setResizable(false);
			this.setLocation(father.getX() + father.getWidth() / 2,
					father.getY() + father.getHeight() / 3);
			this.setModal(true);
			this.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okjb) {
				if (fatherClassjtf.getText().trim().equals("")
						|| classjtf.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "请填写全部信息！", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				father.newNode = new GoodsClassNode(classjtf.getText().trim(),
						fatherClassjtf.getText().trim());
				father.addNode = new DefaultMutableTreeNode(classjtf.getText()
						.trim());
				this.dispose();
			} else if (e.getSource() == canceljb) {
				father.addNode = null;
				this.dispose();
			}
		}

	}

	class UpdateGoodsClassDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID = 1L;
		JLabel oldClassDjl = null;
		JLabel classDjl = null;
		JTextField oldClassDjtf = null;
		JTextField classDjtf = null;
		JButton okDjb = null;
		JButton cancelDjb = null;

		GoodsPanel father = null;

		public UpdateGoodsClassDialog(GoodsPanel father) {
			this.father = father;

			Font font = new Font("����", Font.BOLD, 16);
			oldClassDjl = new JLabel("ԭ����");
			oldClassDjl.setFont(font);
			oldClassDjl.setBounds(15, 20, 60, 30);
			this.add(oldClassDjl);

			classDjl = new JLabel("������");
			classDjl.setFont(font);
			classDjl.setBounds(15, 60, 60, 30);
			// balanceDjl.setEnabled(false);
			this.add(classDjl);

			oldClassDjtf = new JTextField();
			oldClassDjtf.setFont(font);
			oldClassDjtf.setText(getSelectedClass());
			oldClassDjtf.setEditable(false);
			oldClassDjtf.setBounds(85, 20, 180, 30);
			this.add(oldClassDjtf);

			classDjtf = new JTextField();
			classDjtf.setFont(font);
			classDjtf.setBounds(85, 60, 180, 30);
			this.add(classDjtf);

			okDjb = new JButton("ȷ��");
			// okDjb.setFont(font);
			okDjb.setBounds(50, 110, 60, 30);
			okDjb.addActionListener(this);
			okDjb.setVisible(true);
			this.add(okDjb);

			cancelDjb = new JButton("ȡ��");
			// cancelDjb.setFont(font);
			cancelDjb.setBounds(170, 110, 60, 30);
			cancelDjb.addActionListener(this);
			cancelDjb.setVisible(true);
			this.add(cancelDjb);

			this.setSize(300, 200);
			this.setLayout(null);
			this.setTitle("�޸���Ʒ����");
			this.setResizable(false);
			this.setLocation(father.getX() + father.getWidth() / 2,
					father.getY() + father.getHeight() / 3);
			this.setModal(true);
			// this.setType(Type.UTILITY);
			this.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okDjb) {
				if (oldClassDjtf.getText().trim().equals("")
						|| classDjtf.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "����дȫ����Ϣ��",
							"Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				father.updateNode = new DefaultMutableTreeNode(classDjtf
						.getText().trim());
				this.dispose();
			} else if (e.getSource() == cancelDjb) {
				father.updateNode = null;
				this.dispose();
			}
		}

	}

	// end_yan-----------------------------------------------------------

	/*public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 800, 500);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GoodsPanel gp = new GoodsPanel(parent);
		gp.setBounds(0, 0, 800, 500);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}*/

}
