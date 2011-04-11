package gui.window.buildshoppingcart;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartListener implements ListSelectionListener {
    private JButton removeButton;

    public ShoppingCartListener(JButton removeButton) {
        this.removeButton = removeButton;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            removeButton.setEnabled(true);
        }
    }
}
