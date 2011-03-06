package gui.action.main;

import gui.window.additem.AddItemWindow;
import gui.window.edititem.EditItemWindow;
import hibernate.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/5/11
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateItemButtonAction implements ActionListener {
    private EditItemWindow editItemWindow;
    private List<Item> items;
    private JTable table;

    public UpdateItemButtonAction(JTable table, List<Item> items, EditItemWindow editItemWindow) {
        this.table = table;
        this.items = items;
        this.editItemWindow = editItemWindow;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = table.getSelectedRow();
        AddItemWindow addItemWindow = new AddItemWindow(items.get(selectedRow));
        addItemWindow.setVisible(true);
        editItemWindow.setVisible(false);
    }
}
