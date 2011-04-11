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
 * To change this template use File | Settings | File Templates.
 */
public class RemoveItemFromCartButtonAction implements ActionListener {
    private JTable shoppingCartTable;
    private RemoveItemFromCartButton removeItemFromCartButton;

    public RemoveItemFromCartButtonAction(JTable shoppingCartTable, RemoveItemFromCartButton removeItemFromCartButton) {
        this.shoppingCartTable = shoppingCartTable;
        this.removeItemFromCartButton = removeItemFromCartButton;
    }

    public void actionPerformed(ActionEvent e) {
        removeItemFromCartButton.setEnabled(false);
        ((DefaultTableModel)shoppingCartTable.getModel()).removeRow(shoppingCartTable.getSelectedRow());
    }
}
