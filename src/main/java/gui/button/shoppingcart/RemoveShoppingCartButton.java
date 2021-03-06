package gui.button.shoppingcart;

import gui.action.shoppingcart.RemoveShoppingCartButtonAction;
import gui.window.viewallshoppingcarts.ViewAllShoppingCartsWindow;
import hibernate.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:13 PM
 */
public class RemoveShoppingCartButton extends JButton {
    /**
     * Remove shopping cart button
     * @param shoppingCartList shopping cart list
     * @param shoppingCarts shopping carts table
     * @param viewAllShoppingCartsWindow window to close upon success
     */
    public RemoveShoppingCartButton(List<ShoppingCart> shoppingCartList, JTable shoppingCarts, ViewAllShoppingCartsWindow viewAllShoppingCartsWindow) {
        setText("Remove Cart");
        setMinimumSize(new Dimension(175, 50));
        setMaximumSize(new Dimension(175, 50));
        addActionListener(new RemoveShoppingCartButtonAction(shoppingCartList, shoppingCarts, viewAllShoppingCartsWindow));
        setIcon(new ImageIcon("main/window/remove-button.png"));
    }
}
