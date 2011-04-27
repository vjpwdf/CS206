package gui.window.edititem;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/04/11
 * Time: 8:29 PM
 */

import javax.swing.table.AbstractTableModel;

/**
 * Item table model for the item table
 */
public class ItemTableModel extends AbstractTableModel {
    private final Object[] column;
    private final Object[][] data;

    public ItemTableModel(Object[] column, Object[][] data) {
        this.column = column;
        this.data = data;
    }

    public int getColumnCount() {
        return column.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return (String) column[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int col) {
        return data[0][col].getClass();
    }
}
