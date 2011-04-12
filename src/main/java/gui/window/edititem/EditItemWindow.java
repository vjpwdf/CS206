package gui.window.edititem;


import gui.action.main.RemoveItemButtonAction;
import gui.action.main.UpdateItemButtonAction;
import hibernate.Item;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

public class EditItemWindow extends JFrame {
    final private int ROW_HEIGHT = 100;
    final private int HEIGHT = 600;
    final private int WIDTH = 500;
    JTable table;

    /**
     * Builds the edit item window
     */
    public EditItemWindow() {
        super("Edit A Item");

        List<Item> items = ItemServiceAdaptor.getAllItems();

        final Object[][] data = convertToObjectArray(items);
        final Object[] column = new Object[]{"Picture", "Name", "Manufacturer", "Price"};

        AbstractTableModel model = new ItemTableModel(column, data);
        table = new JTable(model);
        table.setRowHeight(ROW_HEIGHT);
        setImageObserver(table);
        JScrollPane pane = new JScrollPane(table);


        Box vertBox = Box.createVerticalBox();
        vertBox.add(pane);

        Box buttonBox = Box.createHorizontalBox();

        JButton edit = new JButton("Edit");
        edit.setMinimumSize(new Dimension(150, 50));
        edit.setMaximumSize(new Dimension(150, 50));
        edit.addActionListener(new UpdateItemButtonAction(table, items, this));
        edit.setEnabled(false);

        JButton remove = new JButton("Remove");
        remove.setMinimumSize(new Dimension(150, 50));
        remove.setMaximumSize(new Dimension(150, 50));
        remove.addActionListener(new RemoveItemButtonAction(table, items, this));
        remove.setEnabled(false);

        buttonBox.add(edit);
        buttonBox.add(remove);

        table.getSelectionModel().addListSelectionListener(new EditItemTableListener(edit, remove));

        vertBox.add(buttonBox);

        getContentPane().add(vertBox);
        setSize(WIDTH, HEIGHT);
    }

    /**
     * Converts a list of objects to a 2d object array
     * @param items a list of items to a 2d object array
     * @return a list of objects to a 2d object array
     */
    private Object[][] convertToObjectArray(List<Item> items) {
        Object[][] data = new Object[items.size()][4];
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            Blob image = item.getItemImage();
            data[i][0] = "No Image";
            if (image != null) {
                try {
                    byte[] bytes = image.getBytes(1, (int) image.length());
                    ImageIcon imageIcon = new ImageIcon(bytes);
                    data[i][0] = imageIcon;
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, e.toString());
                }
            }
            data[i][1] = item.getItemName();
            data[i][2] = item.getItemManufacturer();
            DecimalFormat df = new DecimalFormat();
            df.setMinimumFractionDigits(2);
            df.setMaximumFractionDigits(2);
            data[i][3] = "$" + df.format(item.getItemPrice());
        }
        return data;
    }

    /**
     * Sets the image observer for the JTable for first column
     * @param table table to set the image observer of
     */
    private void setImageObserver(JTable table) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            if (model.getValueAt(row, 0).getClass() == ImageIcon.class) {
                ImageIcon icon = (ImageIcon) model.getValueAt(row, 0);
                if (icon != null)
                    icon.setImageObserver(new CellImageObserver(table, row, 0));
            }
        }
    }

    /**
     * Item table model for the item table
     */
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