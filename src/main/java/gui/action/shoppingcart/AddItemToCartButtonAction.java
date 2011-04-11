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
 * To change this template use File | Settings | File Templates.
 */
public class AddItemToCartButtonAction implements ActionListener {
    private JTable itemTable;
    private JTable shoppingCartTable;
    private List<Item> items;
    private GeneralInput quantityInput;

    public AddItemToCartButtonAction(JTable itemTable, JTable shoppingCartTable, List<Item> items, GeneralInput quantityInput) {
        this.itemTable = itemTable;
        this.shoppingCartTable = shoppingCartTable;
        this.items = items;
        this.quantityInput = quantityInput;
    }

    public void actionPerformed(ActionEvent e) {
        Item selectedItem = items.get(itemTable.getSelectedRow());
        removeOldItemInCart(selectedItem);
        ((DefaultTableModel)shoppingCartTable.getModel()).addRow(new String[]{selectedItem.getItemName(), quantityInput.getInput().getText()});
    }

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
