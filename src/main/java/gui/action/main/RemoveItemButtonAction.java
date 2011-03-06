package gui.action.main;

import gui.window.edititem.EditItemWindow;
import hibernate.Item;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/5/11
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveItemButtonAction implements ActionListener{
    private List<Item> items;
    private JTable table;
    private EditItemWindow editItemWindow;

    public RemoveItemButtonAction(JTable table, List<Item> items, EditItemWindow editItemWindow) {
        this.table = table;
        this.items = items;
        this.editItemWindow = editItemWindow;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = table.getSelectedRow();
        ItemServiceAdaptor itemServiceAdaptor = new ItemServiceAdaptor();
        itemServiceAdaptor.removeItem(items.get(selectedRow));
        JOptionPane.showMessageDialog(null, "Item has been successfully removed.");
        editItemWindow.setVisible(false);
        editItemWindow = new EditItemWindow();
        editItemWindow.setVisible(true);
    }
}
