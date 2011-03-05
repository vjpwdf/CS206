package gui.window.editcoupon;/* (swing1.1.1beta2) */
//package jp.gr.java_conf.tame.swing.examples;


import hibernate.Item;
import hibernate.factory.DBClient;

import java.awt.*;
import java.awt.image.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;


/**
 * @version 1.0 06/19/99
 */
public class EditCouponWindow extends JFrame {


    public EditCouponWindow() {
        super("AnimatedIconTable Example");
        List<Item> items = (List<Item>) DBClient.INSTANCE.getListOfObjects("from Item");


        final Object[][] data = convertToObjectArray(items);
        final Object[] column = new Object[]{"Item Picture", "Item Name", "Item Description"};

        AbstractTableModel model = new ItemTableModel(column, data);
        JTable table = new JTable(model);
        table.setRowHeight(100);
        setImageObserver(table);
        JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane);
    }

    private Object[][] convertToObjectArray(List<Item> items) {
        Object[][] data = new Object[items.size()][3];
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            Blob image = item.getItemImage();
            try {
                byte[] bytes = image.getBytes(1, (int) image.length());
                ImageIcon imageIcon = new ImageIcon(bytes);
                data[i][0] = imageIcon;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.toString());
            }
            data[i][1] = item.getItemName();
            data[i][2] = item.getItemDescription();
        }
        return data;
    }

    private void setImageObserver(JTable table) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        for(int row = 0; row < rowCount; row++){
            ImageIcon icon = (ImageIcon) model.getValueAt(row, 0);
            if(icon != null)
                icon.setImageObserver(new CellImageObserver(table, row, 0));
        }
    }

    private static class ItemTableModel extends AbstractTableModel {
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

    class CellImageObserver implements ImageObserver {
        JTable table;
        int row;
        int col;

        CellImageObserver(JTable table, int row, int col) {
            this.table = table;
            this.row = row;
            this.col = col;
        }

        public boolean imageUpdate(Image img, int flags,
                                   int x, int y, int w, int h) {
            if ((flags & (FRAMEBITS | ALLBITS)) != 0) {
                Rectangle rect = table.getCellRect(row, col, false);
                table.repaint(rect);
            }
            return (flags & (ALLBITS | ABORT)) == 0;
        }
    }
}