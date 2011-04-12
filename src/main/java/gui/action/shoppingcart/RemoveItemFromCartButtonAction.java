package gui.action.shoppingcart;

import gui.button.shoppingcart.RemoveItemFromCartButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 2:19 PM
 */
public class RemoveItemFromCartButtonAction implements ActionListener {
    private JTable shoppingCartTable;
    private RemoveItemFromCartButton removeItemFromCartButton;

    /**
     * Remove item from cart button action
     * @param shoppingCartTable shopping cart table
     * @param removeItemFromCartButton button to remove item from cart
     */
    public RemoveItemFromCartButtonAction(JTable shoppingCartTable, RemoveItemFromCartButton removeItemFromCartButton) {
        this.shoppingCartTable = shoppingCartTable;
        this.removeItemFromCartButton = removeItemFromCartButton;
    }

    /**
     * Removes item from cart
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        removeItemFromCartButton.setEnabled(false);
        ((DefaultTableModel)shoppingCartTable.getModel()).removeRow(shoppingCartTable.getSelectedRow());
    }
}
