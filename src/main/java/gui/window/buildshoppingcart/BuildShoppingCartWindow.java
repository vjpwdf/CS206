package gui.window.buildshoppingcart;

import gui.button.shoppingcart.AddItemToCartButton;
import gui.button.shoppingcart.RemoveItemFromCartButton;
import gui.button.shoppingcart.SaveShoppingCartButton;
import gui.input.GeneralInput;
import gui.input.validate.NumberFormValidator;
import gui.window.edititem.EditItemTableListener;
import hibernate.Item;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:08:55 PM
 */
public class BuildShoppingCartWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 600;
    private static final int ROW_HEIGHT = 100;
    private List<Item> items;

    public BuildShoppingCartWindow() throws HeadlessException {
        setTitle("Build A Shopping Cart");
        setSize(WIDTH, HEIGHT);

        Box shoppingCartVerticalBox = Box.createVerticalBox();

        items = ItemServiceAdaptor.getAllItems();

        final Object[][] data = convertToObjectArray(items);
        final Object[] column = new Object[]{"Picture", "Name", "Manufacturer", "Price"};

        AbstractTableModel model = new ItemTableModel(column, data);
        JTable itemTable = new JTable(model);
        itemTable.setRowHeight(ROW_HEIGHT);
        setImageObserver(itemTable);
        JScrollPane pane = new JScrollPane(itemTable);

        shoppingCartVerticalBox.add(pane);
        DefaultTableModel shoppingCartTableModel = new DefaultTableModel(new String[][]{}, new String[]{"Item Name", "Quantity"});
        JTable shoppingCartTable = new JTable(shoppingCartTableModel);

        GeneralInput quantityInput = new GeneralInput("Quantity", true);
        quantityInput.getInput().setText("1");
        Box buttonBox = Box.createHorizontalBox();
        JButton addItemToCartButton = new AddItemToCartButton(itemTable, shoppingCartTable, items, quantityInput);
        addItemToCartButton.setEnabled(false);
        buttonBox.add(addItemToCartButton);

        JButton removeItemFromCartButton = new RemoveItemFromCartButton(shoppingCartTable);
        removeItemFromCartButton.setEnabled(false);
        buttonBox.add(removeItemFromCartButton);

        quantityInput.addNewFormValidator(new NumberFormValidator());
        quantityInput.getFormValidatorWorker().monitorButtons(Arrays.asList(addItemToCartButton));
        buttonBox.add(quantityInput);

        shoppingCartVerticalBox.add(buttonBox);


        JScrollPane shoppingCartTablePane = new JScrollPane(shoppingCartTable);
        shoppingCartVerticalBox.add(shoppingCartTablePane);

        getContentPane().add(shoppingCartVerticalBox);

        itemTable.getSelectionModel().addListSelectionListener(new BuildShoppingCartItemListener(addItemToCartButton));
        shoppingCartTable.getSelectionModel().addListSelectionListener(new ShoppingCartListener(removeItemFromCartButton));

        JButton saveShoppingCartButton = new SaveShoppingCartButton(items, shoppingCartTable, this);
        shoppingCartVerticalBox.add(saveShoppingCartButton);
    }

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