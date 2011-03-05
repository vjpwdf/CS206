package gui.window.editcoupon;

import hibernate.Item;

import java.awt.event.*;
import javax.swing.*;
import java.beans.*;
import java.util.List;

public class TableEventListener implements PropertyChangeListener {
    private JTable table;
    private List<Item> items;

    public TableEventListener(JTable table, List<Item> items) {
        this.table = table;
        this.items = items;
        this.table.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {


    }
}
