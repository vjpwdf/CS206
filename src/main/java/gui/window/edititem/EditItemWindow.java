package gui.window.edititem;


import gui.action.main.RemoveItemButtonAction;
import gui.action.main.UpdateItemButtonAction;
import hibernate.Item;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

public class EditItemWindow extends JFrame {
    final private int ROW_HEIGHT = 100;
    final private int HEIGHT = 600;
    final private int WIDTH = 500;
    private JTable table;
    private JButton edit;
    private JButton remove;
    private AbstractTableModel model;

    /**
     * Builds the edit item window
     */
    public EditItemWindow() {
        super("Edit A Item");
        setSize(WIDTH, HEIGHT);

        List<Item> items = ItemServiceAdaptor.getAllItems();

        JScrollPane itemTablePane = buildItemTable(items);

        Box itemWindowBox = Box.createVerticalBox();
        itemWindowBox.add(itemTablePane);

        Box buttonBox = Box.createHorizontalBox();

        buildEditItemButton(items);
        buildRemoveButton(items);
        addButtonsToButtonBox(buttonBox);

        addListSelectionListenerToTable();
        itemWindowBox.add(buttonBox);

        getContentPane().add(itemWindowBox);
    }

    /**
     * Adds a list selection listener to the table and dynamically enables/disables button upon item selection
     */
    private void addListSelectionListenerToTable() {
        table.getSelectionModel().addListSelectionListener(new EditItemTableListener(edit, remove));
    }

    /**
     * Adds the edit and remove button to the button box
     * @param buttonBox  button box to add the edit and remove buttons
     */
    private void addButtonsToButtonBox(Box buttonBox) {
        buttonBox.add(edit);
        buttonBox.add(remove);
    }

    /**
     * Builds the remove button
     * @param items list of items
     */
    private void buildRemoveButton(List<Item> items) {
        remove = new JButton("Remove");
        remove.setMinimumSize(new Dimension(150, 50));
        remove.setMaximumSize(new Dimension(150, 50));
        remove.addActionListener(new RemoveItemButtonAction(table, items, this));
        remove.setEnabled(false);
    }

    /**
     * Builds the edit item button
     * @param items a list of items
     */
    private void buildEditItemButton(List<Item> items) {
        edit = new JButton("Edit");
        edit.setMinimumSize(new Dimension(150, 50));
        edit.setMaximumSize(new Dimension(150, 50));
        edit.addActionListener(new UpdateItemButtonAction(table, items, this));
        edit.setEnabled(false);
    }

    /**
     * Builds the item table
     * @param items items to convert to object for table model
     * @return a pane containing the table
     */
    private JScrollPane buildItemTable(List<Item> items) {
        TableDataConverter tableDataConverter = new TableDataConverter();
        model = new ItemTableModel(getTableColumns(), tableDataConverter.convertToObjectArray(items));
        table = new JTable(model);
        table.setRowHeight(ROW_HEIGHT);
        return new JScrollPane(table);
    }

    /**
     * Gets the table columns
     * @return the table columns
     */
    private Object[] getTableColumns() {
        return new Object[]{"Picture", "Name", "Manufacturer", "Price"};
    }

    /**
     * Gets the item table
     * @return the item table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Gets the edit button
     * @return  the edit button
     */
    public JButton getEdit() {
        return edit;
    }

    /**
     * Gets the remove button
     * @return the remove button
     */
    public JButton getRemove() {
        return remove;
    }

    /**
     * Gets the item's table model
     * @return the item's table model
     */
    public AbstractTableModel getModel() {
        return model;
    }
}