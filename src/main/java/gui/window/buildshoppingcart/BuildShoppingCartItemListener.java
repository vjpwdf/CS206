package gui.window.buildshoppingcart;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 1:50 PM
 */
public class BuildShoppingCartItemListener implements ListSelectionListener {
    private JButton addButton;

    /**
     * Builds shopping cart table list selection listener
     * @param addButton button to enable upon selection
     */
    public BuildShoppingCartItemListener(JButton addButton) {
        this.addButton = addButton;
    }

    /**
     * Enables the button
     * @param event makes sure it is not value is adjusting event
     */
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            addButton.setEnabled(true);
        }
    }
}
