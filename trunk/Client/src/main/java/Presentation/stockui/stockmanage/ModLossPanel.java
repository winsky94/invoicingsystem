package Presentation.stockui.stockmanage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vo.LogVO;
import vo.StockOverOrLowVO;
import Presentation.mainui.MainFrame;
import Presentation.mainui.headPane;
import Presentation.mainui.log;
import businesslogic.stockbl.stockManage.StockLowReceipt;
import businesslogic.stockbl.stockManage.StockOverOrLowManage;

public class ModLossPanel extends LossPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StockOverOrLowVO overVo;
	StockOverOrLowManage manage;

	public ModLossPanel(MainFrame frame, String ID) {
		super(frame);
		manage = new StockOverOrLowManage();
		overVo = manage.find(ID);
		this.remove(addGoodsBtn);
		IDLbl.setText("单据编号:" + overVo.getId());
		nameLbl.setText("商品名：" + overVo.getGoodsName());
		sizeLbl.setText("型号：" + overVo.getSize());
		numLbl.setText("库存数量：" + String.valueOf(overVo.getNum()));
		exactNumFld.setText(String.valueOf(overVo.getExactNum()));
		submitBtn.removeActionListener(this);
		exitBtn.removeActionListener(this);
		submitBtn.addActionListener(new SubmitActionListener());
		// 取消的监听===================
	}

	class SubmitActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO 自动生成的方法存根
			// 监测实际库存是否填写合格
			int exactNum = 0;
			try {
				exactNum = Integer.parseInt(exactNumFld.getText());
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "         请确定你的输入合法噢~",
						null, JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (exactNum < 0) {
				JOptionPane.showMessageDialog(null, "       请确定实际库存数量合法噢~",
						null, JOptionPane.WARNING_MESSAGE);
				return;
			}

			StockLowReceipt receipt = new StockLowReceipt(overVo.getId(),
					overVo.getMemberName(), overVo.getMemberID(),
					overVo.getUser(), overVo.getHurry(), overVo.getInfo(),
					overVo.getGoodsName(), overVo.getSize(), overVo.getNum(),
					exactNum);

			if (receipt.Modify(overVo.getId()) == 0) {
				log.addLog(new LogVO(log.getdate(), parent.getUser().getID(),
						parent.getUser().getName(), "修改一笔库存报溢/报损单", 3));
				try {
					headPane.RefreshGrades();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "修改失败", "提示",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}
