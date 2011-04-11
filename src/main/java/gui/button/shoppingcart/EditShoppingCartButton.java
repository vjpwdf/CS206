package gui.button.shoppingcart;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditShoppingCartButton extends JButton {
    public EditShoppingCartButton() {
        setText("Edit Cart");
        setMinimumSize(new Dimension(175, 50));
        setMaximumSize(new Dimension(175, 50));
//        addActionListener(new SaveShoppingCartButtonAction(items, shoppingCartTable, buildShoppingCartWindow));
        setIcon(new ImageIcon("main/window/build-shopping-cart.png"));
    }
}
