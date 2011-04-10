package gui.window.buildshoppingcart;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 1:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildShoppingCartItemListener implements ListSelectionListener {
    private JButton addButton;

    public BuildShoppingCartItemListener(JButton addButton) {
        this.addButton = addButton;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            addButton.setEnabled(true);
        }
    }
}
