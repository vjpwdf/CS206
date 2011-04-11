package gui.action.shoppingcart;

import common.LoggedInUser;
import gui.window.buildshoppingcart.BuildShoppingCartWindow;
import hibernate.Item;
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
 * To change this template use File | Settings | File Templates.
 */
public class SaveShoppingCartButtonAction implements ActionListener{
    private List<Item> items;
    private JTable shoppingCartTable;
    private BuildShoppingCartWindow buildShoppingCartWindow;

    public SaveShoppingCartButtonAction(List<Item> items, JTable shoppingCartTable, BuildShoppingCartWindow buildShoppingCartWindow) {
        this.items = items;
        this.shoppingCartTable = shoppingCartTable;
        this.buildShoppingCartWindow = buildShoppingCartWindow;
    }

    public void actionPerformed(ActionEvent e) {
        Map<Item, Integer> shoppingCart = new HashMap<Item, Integer>();
        DefaultTableModel shoppingCartTableModel = (DefaultTableModel) shoppingCartTable.getModel();
        for (int i = 0; i< shoppingCartTableModel.getRowCount(); i++) {
            String itemName = (String)shoppingCartTableModel.getValueAt(i, 0);
            Item item = getItemByItemName(itemName);
            Integer quantity = Integer.valueOf((String) shoppingCartTableModel.getValueAt(i, 1));
            shoppingCart.put(item, quantity);
        }
        ShoppingCartServiceAdaptor.addShoppingCartFromListOfShoppingCartItems(shoppingCart, LoggedInUser.loggedInUser);
        JOptionPane.showMessageDialog(null, "Shopping cart has been successfully added/updated");
        buildShoppingCartWindow.setVisible(false);
    }

    private Item getItemByItemName(String itemName) {
        for (Item item : items) {
            if(item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}
