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
 */
public class UpdateItemButtonAction implements ActionListener {
    private EditItemWindow editItemWindow;
    private List<Item> items;
    private JTable table;

    /**
     * Update Item button constructor
     * @param table item table
     * @param items items in table
     * @param editItemWindow window to close once update is complete
     */
    public UpdateItemButtonAction(JTable table, List<Item> items, EditItemWindow editItemWindow) {
        this.table = table;
        this.items = items;
        this.editItemWindow = editItemWindow;
    }

    /**
     * Updates selected item
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = table.getSelectedRow();
        AddItemWindow addItemWindow = new AddItemWindow(items.get(selectedRow));
        addItemWindow.setVisible(true);
        editItemWindow.setVisible(false);
    }
}
