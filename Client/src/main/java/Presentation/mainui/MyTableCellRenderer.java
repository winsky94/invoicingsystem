package Presentation.mainui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setHorizontalAlignment(JLabel.CENTER);
		// 设置列宽自己设置
		String columnName1 = table.getColumnName(0);
		table.getColumn(columnName1).setPreferredWidth(180);
		String columnName2 = table.getColumnName(1);
		table.getColumn(columnName2).setPreferredWidth(130);

		if (row % 2 == 1)
			setBackground(Color.white); // 设置奇数行底色
		else if (row % 2 == 0)
			setBackground(new Color(225, 255, 255)); // 设置偶数行底色
		return super.getTableCellRendererComponent(table, value, isSelected,
				hasFocus, row, column);
	}
}
