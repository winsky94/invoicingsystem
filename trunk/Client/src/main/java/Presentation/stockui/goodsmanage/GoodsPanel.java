package Presentation.stockui.goodsmanage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import vo.GoodsClassVO;
import vo.GoodsVO;
import Presentation.mainui.MainFrame;
import businesslogic.stockbl.goods.GoodsController;
import businesslogic.stockbl.goods.GoodsModel;
import businesslogic.stockbl.goodsClass.GoodsClassController;
import businesslogicservice.stockblservice.goodsblservice.StockGoodsBLService;
import businesslogicservice.stockblservice.goodsclassblservice.StockGoodsClassBLService;

public class GoodsPanel extends JPanel implements ActionListener,
		TreeModelListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyButton addGoodsBtn, delGoodsBtn, modGoodsBtn, searchBtn, refreshBtn;
	JButton addGCBtn, delGCBtn, modGCBtn;
	JTextField searchFld;
	JTable goodsTable;
	GoodsModel goodsModel;
	JScrollPane jspTable = null;
	Color stockColor = new Color(51, 125, 86);
	String keyWord;

	JScrollPane treeJsp = null;
	JTree tree = null;
	StockGoodsClassBLService controller;
	StockGoodsBLService goodsController;
	DefaultTreeModel treeModel = null;
	String nodeName = null;// 原有节点名称

	GoodsClassNode newNode = null;
	DefaultMutableTreeNode addNode = null;
	public DefaultMutableTreeNode updateNode = null;

	static MainFrame parent;

	public GoodsPanel(MainFrame frame) {
		parent = frame;
		controller = new GoodsClassController();
		goodsController = new GoodsController();

		this.setBackground(Color.white);
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		// -----------upPnl--------------------------------------------------------
		JPanel btnPnl = new JPanel();
		btnPnl.setBackground(Color.white);
		addGoodsBtn = new MyButton("添加商品", new ImageIcon("img/stock/add.png"));
		addGoodsBtn.addActionListener(new AddGoodsBtnListener());
		btnPnl.add(addGoodsBtn);
		//
		delGoodsBtn = new MyButton("删除商品",
				new ImageIcon("img/stock/delete.png"));
		delGoodsBtn.addActionListener(new DelGoodsBtnListener());
		btnPnl.add(delGoodsBtn);
		//
		modGoodsBtn = new MyButton("修改商品信息", new ImageIcon(
				"img/stock/modify.png"));
		modGoodsBtn.addActionListener(new ModGoodsBtnListener());
		btnPnl.add(modGoodsBtn);
		// --------------------------
		refreshBtn = new MyButton("刷新", new ImageIcon("img/stock/refresh.png"));
		btnPnl.add(refreshBtn);
		// 搜索框
		searchFld = new JTextField(6);
		searchFld.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		searchFld.getDocument().addDocumentListener(new SearchFldListener());
		btnPnl.add(searchFld);
		// 查找按钮
		searchBtn = new MyButton(new ImageIcon("img/stock/find.png"));
		searchBtn.addActionListener(new SearchBtnListener());
		btnPnl.add(searchBtn);
		// -------------------------------------
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		gbl.setConstraints(btnPnl, c);
		this.add(btnPnl);

		// ---------goodsClassTree-------------------
		createGoodsClass(getTreeData());
		tree.setBackground(Color.white);
		tree.setBorder(BorderFactory.createLineBorder(Color.gray));
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(3, 3, 3, 3);
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 5;
		c.gridwidth = 2;// 由2改为1，将树的panel调小、、、、yan
		c.weightx = 0.05;
		c.weighty = 50;
		gbl.setConstraints(tree, c);
		this.add(tree);

		// ---------------------button---------------------
		JPanel downPnl = new JPanel();
		downPnl.setLayout(new GridLayout(1, 3));
		// ------------------------------------------------
		addGCBtn = new JButton("添加分类");
		addGCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		addGCBtn.setForeground(stockColor);
		addGCBtn.setBackground(Color.white);
		addGCBtn.setFocusPainted(false);
		addGCBtn.addActionListener(this);
		downPnl.add(addGCBtn);
		// ------------------------------------------------
		delGCBtn = new JButton("删除分类");
		delGCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		delGCBtn.setForeground(stockColor);
		delGCBtn.setBackground(Color.white);
		delGCBtn.setFocusPainted(false);
		delGCBtn.addActionListener(this);
		downPnl.add(delGCBtn);
		// ------------------------------------------------
		modGCBtn = new JButton("修改分类");
		modGCBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		modGCBtn.setForeground(stockColor);
		modGCBtn.setBackground(Color.white);
		modGCBtn.setFocusPainted(false);
		modGCBtn.addActionListener(this);
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
		goodsModel = new GoodsModel();
		goodsModel.addTableModelListener(new MyTableModelListener());
		goodsTable = new JTable(goodsModel);
		goodsTable.setBackground(Color.white);
		jspTable = new JScrollPane(goodsTable);
		c.gridx = 3;
		c.gridy = 1;
		c.gridheight = 7;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 0.6;
		c.weighty = 55;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(jspTable, c);
		this.add(jspTable);
	}

	class AddGoodsBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TreePath parentPath = tree.getSelectionPath();

			if (parentPath == null) {
				JOptionPane.showMessageDialog(null, "         请选择分类", null,
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 取得商品分类
			String GoodsClass = ((DefaultMutableTreeNode) (parentPath
					.getLastPathComponent())).toString();
			parent.setRightComponent(new AddGoodsPanel(parent, GoodsClass));

			// 重新再获得数据模型,刷新界面
			goodsModel = new GoodsModel();
			goodsTable.setModel(goodsModel);

		}

	}

	class DelGoodsBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int rownum = goodsTable.getSelectedRow();
			if (rownum == -1) {
				JOptionPane.showMessageDialog(null, "           请选择一行商品", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				String id = (String) goodsModel.getValueAt(rownum, 0);
				String name = (String) goodsModel.getValueAt(rownum, 1);
				String size = (String) goodsModel.getValueAt(rownum, 2);
				int num = Integer.parseInt((String) goodsModel.getValueAt(
						rownum, 3));
				double purchasePrice = Double.parseDouble((String) goodsModel
						.getValueAt(rownum, 4));
				double price = Double.parseDouble((String) goodsModel
						.getValueAt(rownum, 5));
				double lastPurchasePrice = Double
						.parseDouble((String) goodsModel.getValueAt(rownum, 6));
				double lastPrice = Double.parseDouble((String) goodsModel
						.getValueAt(rownum, 7));
				GoodsVO vo = new GoodsVO(id, name, size, num, purchasePrice,
						price, lastPurchasePrice, lastPrice, "", "");

				new DelGoodsDialog(vo);

				// 重新再获得数据模型,刷新界面
				goodsModel = new GoodsModel();
				goodsTable.setModel(goodsModel);
			}
		}

	}

	class ModGoodsBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int rownum = goodsTable.getSelectedRow();
			if (rownum == -1) {
				JOptionPane.showMessageDialog(null, "           请选择一行商品", null,
						JOptionPane.WARNING_MESSAGE);
			} else {
				String id = (String) goodsModel.getValueAt(rownum, 0);
				String name = (String) goodsModel.getValueAt(rownum, 1);
				String size = (String) goodsModel.getValueAt(rownum, 2);
				int num = Integer.parseInt((String) goodsModel.getValueAt(
						rownum, 3));
				double purchasePrice = Double.parseDouble((String) goodsModel
						.getValueAt(rownum, 4));
				double price = Double.parseDouble((String) goodsModel
						.getValueAt(rownum, 5));
				double lastPurchasePrice = Double
						.parseDouble((String) goodsModel.getValueAt(rownum, 6));
				double lastPrice = Double.parseDouble((String) goodsModel
						.getValueAt(rownum, 7));

				String goodsClass = null;
				String manufactoryDate = null;
				try {
					goodsClass = goodsController.findByID(id).getGoodsClass();
					manufactoryDate = goodsController.findByID(id)
							.getManufactureDate();
				} catch (RemoteException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				GoodsVO vo = new GoodsVO(id, name, size, num, purchasePrice,
						price, lastPurchasePrice, lastPrice, goodsClass,
						manufactoryDate);

				parent.setRightComponent(new ModGoodsPanel(parent, vo));

				// 重新再获得数据模型,刷新界面
				goodsModel = new GoodsModel();
				goodsTable.setModel(goodsModel);
			}
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
			ArrayList<GoodsVO> list = goodsController.findGoods(keyWord);

			goodsModel = new GoodsModel(list);
			goodsTable.setModel(goodsModel);
		}

	}

	// 对表格的监听，用于修改商品信息
	class MyTableModelListener implements TableModelListener {

		public void tableChanged(TableModelEvent arg0) {
			// TODO 自动生成的方法存根
			goodsModel = new GoodsModel();
			goodsTable.setModel(goodsModel);
		}

	}

	// tree---------------------------------------------------------------------
	private void createGoodsClass(ArrayList<GoodsClassVO> list) {
		GoodsClassNode root = createTreeRoot(list);
		DefaultMutableTreeNode Troot = createGoodsClassNode(root);
		tree = new JTree(Troot);
		treeModel = (DefaultTreeModel) tree.getModel();
		tree.setEditable(true);
		tree.addMouseListener(new MouseHandle());
		treeModel.addTreeModelListener(this);

		treeJsp = new JScrollPane(tree);
		treeJsp.setBorder(null);
		treeJsp.setLocation(0, 0);
		treeJsp.setSize(110, 400);
	}

	private DefaultMutableTreeNode createGoodsClassNode(GoodsClassNode root) {
		DefaultMutableTreeNode Troot = null;
		if (root != null)
			Troot = new DefaultMutableTreeNode(root.getName());
		else
			return null;
		for (int i = 0; i < root.children.size(); i++) {
			DefaultMutableTreeNode Tnode = createGoodsClassNode(root.children
					.get(i));
			Troot.add(Tnode);
		}
		return Troot;
	}

	private GoodsClassNode createTreeRoot(ArrayList<GoodsClassVO> list) {
		GoodsClassNode root = new GoodsClassNode("灯具", "根");
		makeTree(root, list);
		return root;
	}

	public ArrayList<GoodsClassVO> getTreeData() {
		ArrayList<GoodsClassVO> result = new ArrayList<GoodsClassVO>();
		StockGoodsClassBLService controller = new GoodsClassController();
		result = controller.show();
		return result;
	}

	public void makeTree(GoodsClassNode root, ArrayList<GoodsClassVO> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUpClassName().equals(root.getName())) {
				GoodsClassNode child = new GoodsClassNode(
						list.get(i).getName(), list.get(i).getUpClassName());
				root.children.add(child);
				list.remove(i);
				i--;
			}
		}

		for (int i = 0; i < root.children.size(); i++) {
			makeTree(root.children.get(i), list);
		}

	}

	// end_yan-----------------------------------------------------------

	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setBounds(100, 50, 800, 500);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GoodsPanel gp = new GoodsPanel(parent);
		gp.setBounds(0, 0, 800, 500);
		testFrame.add(gp);
		testFrame.setVisible(true);
	}

	public void treeNodesChanged(TreeModelEvent e) {
		// TODO 自动生成的方法存根
		TreePath treePath = e.getTreePath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath
				.getLastPathComponent();
		try {
			int[] index = e.getChildIndices();
			node = (DefaultMutableTreeNode) node.getChildAt(index[0]);
		} catch (NullPointerException exc) {
		}

		GoodsClassVO oldVO = controller.showGoodsClassInfo(nodeName);
		GoodsClassVO newVO = new GoodsClassVO((String) node.getUserObject(),
				oldVO.getUpClassName());
		int result = controller.modifyGoodsClass(oldVO, newVO);
		if (result != 0) {
			System.out.println("GoodsPanel.treeNodesChanged()修改不成功噢~");
		}

	}

	public void treeNodesInserted(TreeModelEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("监听插入节点");
	}

	public void treeNodesRemoved(TreeModelEvent e) {
		// TODO 自动生成的方法存根
		System.out.println("监听删除节点");
	}

	public void treeStructureChanged(TreeModelEvent e) {
		// TODO 自动生成的方法存根

	}

	// 关于分类的增加删除的监听
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getActionCommand().equals("添加分类")) {
			DefaultMutableTreeNode parentNode = null;
			TreePath parentPath = tree.getSelectionPath();

			if (parentPath == null) {
				JOptionPane.showMessageDialog(null, "       请选择父节点", null,
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 取得新节点的父节点
			parentNode = (DefaultMutableTreeNode) (parentPath
					.getLastPathComponent());
			new AddGoodsClassDialog(this, parentNode.toString());
			DefaultMutableTreeNode newNode = addNode;
			if (newNode != null) {
				newNode.setAllowsChildren(true);

				GoodsClassVO vo = new GoodsClassVO(newNode.toString(),
						parentNode.toString());
				int result = controller.addGoodsClass(vo);
				if (result == 0) {
					// 由DefaultTreeModel的insertNodeInto（）方法增加新节点
					treeModel.insertNodeInto(newNode, parentNode,
							parentNode.getChildCount());

					// tree的scrollPathToVisible()方法在使Tree会自动展开文件夹以便显示所加入的新节点。若没加这行则加入的新节点
					// 会被 包在文件夹中，你必须自行展开文件夹才看得到。
					tree.scrollPathToVisible(new TreePath(newNode.getPath()));

				} else {
					JOptionPane.showMessageDialog(null, "添加失败", null,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getActionCommand().equals("删除分类")) {
			TreePath treepath = tree.getSelectionPath();
			if (treepath != null) {
				// 下面两行取得选取节点的父节点.
				DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) treepath
						.getLastPathComponent();
				TreeNode parent = (TreeNode) selectionNode.getParent();
				if (parent != null) {
					GoodsClassVO vo = new GoodsClassVO(
							selectionNode.toString(), parent.toString());
					int result = controller.deleteGoodsClass(vo);
					if (result == 0) {
						// 由DefaultTreeModel的removeNodeFromParent()方法删除节点，包含它的子节点。
						System.out.println("删除节点");
						treeModel.removeNodeFromParent(selectionNode);
						treeModel.reload();
					} else {
						JOptionPane.showMessageDialog(null, "删除失败", null,
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} else if (e.getActionCommand().equals("修改分类!!!!")) {// 这个后期可以取消了，我直接在节点上改
			// 下面一行，由DefaultTreeModel的getRoot()方法取得根节点.
			DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel
					.getRoot();

			// 下面一行删除所有子节点
			rootNode.removeAllChildren();

			// 删除完后务必运行DefaultTreeModel的reload()操作，整个Tree的节点才会真正被删除.
			treeModel.reload();
		}
	}

	// 点击分类节点显示节点下的商品信息的监听
	class MouseHandle extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			try {
				JTree tree = (JTree) e.getSource();
				int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
				TreePath treepath = tree.getPathForRow(rowLocation);
				TreeNode treenode = (TreeNode) treepath.getLastPathComponent();
				nodeName = treenode.toString();
			} catch (NullPointerException ne) {
			}

			StockGoodsBLService goodsController = new GoodsController();
			ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
			if (!nodeName.equals("灯具")) {
				list = goodsController.showGoodsByClass(nodeName);
			} else {
				list = goodsController.showGoods();
			}
			goodsModel = new GoodsModel(list);
			goodsTable.setModel(goodsModel);
		}
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

		public AddGoodsClassDialog(GoodsPanel goodsPanel, String parent) {
			this.father = goodsPanel;

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
			fatherClassjtf.setText(parent);
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
			this.setLocation(goodsPanel.getX() + goodsPanel.getWidth() / 2,
					goodsPanel.getY() + goodsPanel.getHeight() / 3);
			this.setModal(true);
			this.setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == okjb) {
				if (fatherClassjtf.getText().trim().equals("")
						|| classjtf.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(this, "        请填写全部信息！",
							"Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				father.newNode = new GoodsClassNode(classjtf.getText().trim(),
						fatherClassjtf.getText().trim().toString());
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

		public UpdateGoodsClassDialog(GoodsPanel father, String parent) {
			this.father = father;

			Font font = new Font("仿宋", Font.BOLD, 16);
			oldClassDjl = new JLabel("原类名");
			oldClassDjl.setFont(font);
			oldClassDjl.setBounds(15, 20, 60, 30);
			this.add(oldClassDjl);

			classDjl = new JLabel("新类名");
			classDjl.setFont(font);
			classDjl.setBounds(15, 60, 60, 30);
			// balanceDjl.setEnabled(false);
			this.add(classDjl);

			oldClassDjtf = new JTextField();
			oldClassDjtf.setFont(font);
			oldClassDjtf.setText(parent);
			oldClassDjtf.setEditable(false);
			oldClassDjtf.setBounds(85, 20, 180, 30);
			this.add(oldClassDjtf);

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
			this.setTitle("修改商品分类");
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
					JOptionPane.showMessageDialog(this, "请填写全部信息！", "Error",
							JOptionPane.ERROR_MESSAGE);
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

	class MyButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyButton(String text, Icon icon) {
			super(text, icon);
			this.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			this.setForeground(new Color(51, 125, 86));
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}

		MyButton(Icon icon) {
			super(icon);
			this.setBorderPainted(false);
			this.setBackground(Color.white);
			this.setFocusPainted(false);
		}
	}
	// end_yan-----------------------------------------------------------

}