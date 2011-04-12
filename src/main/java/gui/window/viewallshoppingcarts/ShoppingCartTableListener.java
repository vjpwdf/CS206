package gui.window.viewallshoppingcarts;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:20 PM
 */
public class ShoppingCartTableListener implements ListSelectionListener {
    private List<JButton> buttons;

    /**
     * Shopping cart list selection listener to enable buttons once clicked
     * @param buttons buttons to enable once selected
     */
    public ShoppingCartTableListener(List<JButton> buttons) {
        this.buttons = buttons;
    }

    /**
     * Enables buttons upon initial selection
     * @param event makes sure the event isn't value is adjusting
     */
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            for (JButton button : buttons) {
                button.setEnabled(true);
            }
        }
    }
}
