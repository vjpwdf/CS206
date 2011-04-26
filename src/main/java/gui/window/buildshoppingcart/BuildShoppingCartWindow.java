package gui.window.buildshoppingcart;

import gui.button.shoppingcart.AddItemToCartButton;
import gui.button.shoppingcart.RemoveItemFromCartButton;
import gui.button.shoppingcart.SaveShoppingCartButton;
import gui.input.GeneralInput;
import gui.input.validate.NumberFormValidator;
import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
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
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:08:55 PM
 */
public class BuildShoppingCartWindow extends JFrame {
    private static final Integer WIDTH = 750;
    private static final Integer HEIGHT = 600;
    private static final int ROW_HEIGHT = 100;
    private ShoppingCart selectedShoppingCart;
    private JTable shoppingCartTable;
    private JTable itemTable;
    private JButton addItemToCartButton;
    private JButton removeItemFromCartButton;
    private AbstractTableModel model;

    /**
     * Build shopping cart window constructor
     * @throws HeadlessException thrown if could not build window
     */
    public BuildShoppingCartWindow() throws HeadlessException {
        buildShoppingCartWindow();
    }

    /**
     * Builds the gui components for the shopping cart window
     */
    private void buildShoppingCartWindow() {
        setTitle("Build A Shopping Cart");
        setSize(WIDTH, HEIGHT);

        Box shoppingCartVerticalBox = Box.createVerticalBox();

        List<Item> items = ItemServiceAdaptor.getAllItems();

        final Object[][] data = convertToObjectArray(items);
        final Object[] column = new Object[]{"Picture", "Name", "Manufacturer", "Price"};

        buildTableModel(data, column);
        JScrollPane pane = new JScrollPane(itemTable);

        shoppingCartVerticalBox.add(pane);
        DefaultTableModel shoppingCartTableModel = new DefaultTableModel(new String[][]{}, new String[]{"Item Name", "Quantity"});
        shoppingCartTable = new JTable(shoppingCartTableModel);

        GeneralInput quantityInput = new GeneralInput("Quantity", true);
        quantityInput.getInput().setText("1");
        Box buttonBox = Box.createHorizontalBox();

        addAddItemToCartButton(items, quantityInput, buttonBox);
        addRemoveItemFromCartButton(buttonBox);

        quantityInput.addNewFormValidator(new NumberFormValidator());
        quantityInput.getFormValidatorWorker().monitorButtons(Arrays.asList(addItemToCartButton));
        buttonBox.add(quantityInput);

        shoppingCartVerticalBox.add(buttonBox);

        JScrollPane shoppingCartTablePane = new JScrollPane(shoppingCartTable);
        shoppingCartVerticalBox.add(shoppingCartTablePane);

        getContentPane().add(shoppingCartVerticalBox);

        itemTable.getSelectionModel().addListSelectionListener(new BuildShoppingCartItemListener(addItemToCartButton));
        shoppingCartTable.getSelectionModel().addListSelectionListener(new ShoppingCartListener(removeItemFromCartButton));

        JButton saveShoppingCartButton = new SaveShoppingCartButton(items, shoppingCartTable, this, selectedShoppingCart);
        shoppingCartVerticalBox.add(saveShoppingCartButton);
    }

    private void buildTableModel(Object[][] data, Object[] column) {
        model = new ItemTableModel(column, data);
        itemTable = new JTable(model);
        itemTable.setRowHeight(ROW_HEIGHT);
    }

    private void addAddItemToCartButton(List<Item> items, GeneralInput quantityInput, Box buttonBox) {
        addItemToCartButton = new AddItemToCartButton(itemTable, shoppingCartTable, items, quantityInput);
        addItemToCartButton.setEnabled(false);
        buttonBox.add(addItemToCartButton);
    }

    private void addRemoveItemFromCartButton(Box buttonBox) {
        removeItemFromCartButton = new RemoveItemFromCartButton(shoppingCartTable);
        removeItemFromCartButton.setEnabled(false);
        buttonBox.add(removeItemFromCartButton);
    }

    /**
     * Build shopping cart window constructor for editing an existing shopping cart
     * @param selectedShoppingCart shopping cart to edit
     */
    public BuildShoppingCartWindow(ShoppingCart selectedShoppingCart) {
        this.selectedShoppingCart = selectedShoppingCart;
        buildShoppingCartWindow();
        for (ShoppingCartItem shoppingCartItem : selectedShoppingCart.getShoppingCartItems()) {
            ((DefaultTableModel)shoppingCartTable.getModel()).addRow(new String[]{shoppingCartItem.getItem().getItemName(), String.valueOf(shoppingCartItem.getItemQuantity())});
        }
    }

    /**
     * Converts a list of items to object array
     * @param items items to convert
     * @return a list of items in an object array
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

    public JTable getItemTable() {
        return itemTable;
    }

    public JButton getAddItemToCartButton() {
        return addItemToCartButton;
    }

    public JTable getShoppingCartTable() {
        return shoppingCartTable;
    }

    public JButton getRemoveItemFromCartButton() {
        return removeItemFromCartButton;
    }

    public AbstractTableModel getModel() {
        return model;
    }
}