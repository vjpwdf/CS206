package gui.window.buildshoppingcart;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 1:53 PM
 */
public class ShoppingCartListener implements ListSelectionListener {
    private JButton removeButton;

    /**
     * Shopping cart table list selection listener constructor
     * @param removeButton remove button to enable upon initial selection
     */
    public ShoppingCartListener(JButton removeButton) {
        this.removeButton = removeButton;
    }

    /**
     * Enables remove button
     * @param event makes sure event is not value is adjusting
     */
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            removeButton.setEnabled(true);
        }
    }
}
