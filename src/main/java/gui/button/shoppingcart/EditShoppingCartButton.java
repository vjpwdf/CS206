package gui.button.shoppingcart;

import gui.action.shoppingcart.EditShoppingCartButtonAction;
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
 * To change this template use File | Settings | File Templates.
 */
public class EditShoppingCartButton extends JButton {
    public EditShoppingCartButton(List<ShoppingCart> shoppingCartList, JTable shoppingCarts, ViewAllShoppingCartsWindow viewAllShoppingCartsWindow) {
        setText("Edit Cart");
        setMinimumSize(new Dimension(175, 50));
        setMaximumSize(new Dimension(175, 50));
        addActionListener(new EditShoppingCartButtonAction(shoppingCartList, shoppingCarts, viewAllShoppingCartsWindow));
        setIcon(new ImageIcon("main/window/build-shopping-cart.png"));
    }
}
