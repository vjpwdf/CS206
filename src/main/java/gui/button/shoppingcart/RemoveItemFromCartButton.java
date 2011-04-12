package gui.button.shoppingcart;

import gui.action.shoppingcart.RemoveItemFromCartButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/9/11
 * Time: 7:17 PM
 */
public class RemoveItemFromCartButton extends JButton {
    /**
     * Remove item from shopping cart
     * @param shoppingCartTable shopping cart table to remove item from
     */
    public RemoveItemFromCartButton(JTable shoppingCartTable) {
        setText("Remove From Cart");
        setMinimumSize(new Dimension(150, 50));
        setMaximumSize(new Dimension(150, 50));
        addActionListener(new RemoveItemFromCartButtonAction(shoppingCartTable, this));
        setIcon(new ImageIcon("main/window/remove-button.png"));
    }
}
