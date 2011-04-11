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
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartTableListener implements ListSelectionListener {

    private List<JButton> buttons;

    public ShoppingCartTableListener(List<JButton> buttons) {
        this.buttons = buttons;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            for (JButton button : buttons) {
                button.setEnabled(true);
            }
        }
    }
}
