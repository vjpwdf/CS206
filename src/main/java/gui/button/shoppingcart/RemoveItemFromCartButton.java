package gui.button.shoppingcart;

import gui.action.shoppingcart.RemoveItemFromCartButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/9/11
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveItemFromCartButton extends JButton {
    public RemoveItemFromCartButton(JTable shoppingCartTable) {
        setText("Remove From Cart");
        setMinimumSize(new Dimension(150, 50));
        setMaximumSize(new Dimension(150, 50));
        addActionListener(new RemoveItemFromCartButtonAction(shoppingCartTable, this));
        setIcon(new ImageIcon("main/window/remove-button.png"));
    }
}
