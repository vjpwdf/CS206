package gui.window.edititem;


import gui.action.main.RemoveItemButtonAction;
import gui.action.main.UpdateItemButtonAction;
import gui.window.editcoupon.TableEventListener;
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


/**
 * @version 1.0 06/19/99
 */
public class EditItemWindow extends JFrame {
    final private int ROW_HEIGHT = 100;
    final private int HEIGHT = 600;
    final private int WIDTH = 500;
    JTable table;
    private JButton remove;
    private JButton edit;

    public EditItemWindow() {
        super("Edit Item Window");
        ItemServiceAdaptor itemServiceAdaptor = new ItemServiceAdaptor();

        List<Item> items = itemServiceAdaptor.getAllItems();

        final Object[][] data = convertToObjectArray(items);
        final Object[] column = new Object[]{"Picture", "Name", "Manufacturer", "Price"};

        AbstractTableModel model = new ItemTableModel(column, data);
        table = new JTable(model);
        new TableEventListener(table, items);
        table.setRowHeight(ROW_HEIGHT);
        setImageObserver(table);
        JScrollPane pane = new JScrollPane(table);


        Box vertBox = Box.createVerticalBox();
        vertBox.add(pane);

        Box buttonBox = Box.createHorizontalBox();

        edit = new JButton("Edit");
        edit.setMinimumSize(new Dimension(150, 50));
        edit.setMaximumSize(new Dimension(150, 50));
        edit.addActionListener(new UpdateItemButtonAction(table, items, this));
        edit.setEnabled(false);

        remove = new JButton("Remove");
        remove.setMinimumSize(new Dimension(150, 50));
        remove.setMaximumSize(new Dimension(150, 50));
        remove.addActionListener(new RemoveItemButtonAction(table, items, this));
        remove.setEnabled(false);

        buttonBox.add(edit);
        buttonBox.add(remove);

        table.getSelectionModel().addListSelectionListener(new EditItemTableListener(table, edit, remove));

        vertBox.add(buttonBox);

        getContentPane().add(vertBox);
        setSize(WIDTH, HEIGHT);
    }

    private Object[][] convertToObjectArray(List<Item> items) {
        Object[][] data = new Object[items.size()][4];
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
            data[i][2] = item.getItemManufacturer();
            DecimalFormat df = new DecimalFormat();
            df.setMinimumFractionDigits(2);
            df.setMaximumFractionDigits(2);
            data[i][3] = "$" + df.format(item.getItemPrice());
        }
        return data;
    }

    private void setImageObserver(JTable table) {
        TableModel model = table.getModel();
        int rowCount = model.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            ImageIcon icon = (ImageIcon) model.getValueAt(row, 0);
            if (icon != null)
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