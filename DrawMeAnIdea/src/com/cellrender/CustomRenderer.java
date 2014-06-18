package com.cellrender;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class CustomRenderer extends DefaultTableCellRenderer {
	
	private int column;
	
	private int row;
	
	private Color color;

	public CustomRenderer(int col, int row, Color colorToSetInBackground) {
		this.column = col;
		this.row = row;
		this.color = colorToSetInBackground;
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);

		setBackground((column == this.column && row == this.row) ? color
				: Color.white);
		return c;
	}
}
