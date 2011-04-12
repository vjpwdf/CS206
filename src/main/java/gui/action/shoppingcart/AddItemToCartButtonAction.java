package gui.action.shoppingcart;

import gui.input.GeneralInput;
import hibernate.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 2:00 PM
 */
public class AddItemToCartButtonAction implements ActionListener {
    private JTable itemTable;
    private JTable shoppingCartTable;
    private List<Item> items;
    private GeneralInput quantityInput;

    /**
     * Add item to cart button action constuctor
     * @param itemTable item table
     * @param shoppingCartTable shopping cart table
     * @param items items in table
     * @param quantityInput quantity to add
     */
    public AddItemToCartButtonAction(JTable itemTable, JTable shoppingCartTable, List<Item> items, GeneralInput quantityInput) {
        this.itemTable = itemTable;
        this.shoppingCartTable = shoppingCartTable;
        this.items = items;
        this.quantityInput = quantityInput;
    }

    /**
     * Adds selected item to cart
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        Item selectedItem = items.get(itemTable.getSelectedRow());
        removeOldItemInCart(selectedItem);
        ((DefaultTableModel)shoppingCartTable.getModel()).addRow(new String[]{selectedItem.getItemName(), quantityInput.getInput().getText()});
    }

    /**
     * Removes the selected item from the list to re add anoter later
     * @param selectedItem selected item to be removed
     */
    private void removeOldItemInCart(Item selectedItem) {
        DefaultTableModel shoppingCartTableModel = (DefaultTableModel)shoppingCartTable.getModel();
        for(int i = 0; i < shoppingCartTable.getRowCount(); i++) {
            if(shoppingCartTableModel.getValueAt(i, 0).equals(selectedItem.getItemName())) {
                shoppingCartTableModel.removeRow(i);
                break;
            }
        }
    }
}
