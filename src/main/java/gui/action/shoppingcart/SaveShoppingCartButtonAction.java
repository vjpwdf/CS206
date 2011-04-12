package gui.action.shoppingcart;

import common.LoggedInUser;
import gui.window.buildshoppingcart.BuildShoppingCartWindow;
import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.serviceadaptor.ShoppingCartServiceAdaptor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 2:30 PM
 */
public class SaveShoppingCartButtonAction implements ActionListener {
    private List<Item> items;
    private JTable shoppingCartTable;
    private BuildShoppingCartWindow buildShoppingCartWindow;
    private ShoppingCart selectedShoppingCart;

    /**
     * Save shopping cart button action
     * @param items item list
     * @param shoppingCartTable shopping cart table
     * @param buildShoppingCartWindow window to close upon completion
     * @param selectedShoppingCart shopping cart selected
     */
    public SaveShoppingCartButtonAction(List<Item> items, JTable shoppingCartTable, BuildShoppingCartWindow buildShoppingCartWindow, ShoppingCart selectedShoppingCart) {
        this.items = items;
        this.shoppingCartTable = shoppingCartTable;
        this.buildShoppingCartWindow = buildShoppingCartWindow;
        this.selectedShoppingCart = selectedShoppingCart;
    }

    /**
     * Saves selected shopping cart
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        Map<Item, Integer> shoppingCart = new HashMap<Item, Integer>();
        DefaultTableModel shoppingCartTableModel = (DefaultTableModel) shoppingCartTable.getModel();
        for (int i = 0; i < shoppingCartTableModel.getRowCount(); i++) {
            String itemName = (String) shoppingCartTableModel.getValueAt(i, 0);
            Item item = getItemByItemName(itemName);
            Integer quantity = Integer.valueOf((String) shoppingCartTableModel.getValueAt(i, 1));
            shoppingCart.put(item, quantity);
        }
        if (selectedShoppingCart == null) {
            ShoppingCartServiceAdaptor.addShoppingCartFromListOfShoppingCartItems(shoppingCart, LoggedInUser.loggedInUser);
        } else {
            ShoppingCartServiceAdaptor.updateShoppingCart(selectedShoppingCart, shoppingCart);
        }
        JOptionPane.showMessageDialog(null, "Shopping cart has been successfully added/updated");
        buildShoppingCartWindow.setVisible(false);
    }

    /**
     * Gets item by comparing name
     * @param itemName item name to find in list of items
     * @return equal item
     */
    private Item getItemByItemName(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
