package gui.button.shoppingcart;

import gui.action.shoppingcart.SaveShoppingCartButtonAction;
import gui.window.buildshoppingcart.BuildShoppingCartWindow;
import hibernate.Item;
import hibernate.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 2:26 PM
 */
public class SaveShoppingCartButton extends JButton {
    /**
     * Save shopping cart button
     * @param items list of items
     * @param shoppingCartTable shopping cart table
     * @param buildShoppingCartWindow shopping cart window to close upon success
     * @param selectedShoppingCart selected shopping cart to update if necessary
     */
    public SaveShoppingCartButton(List<Item> items, JTable shoppingCartTable, BuildShoppingCartWindow buildShoppingCartWindow, ShoppingCart selectedShoppingCart) {
        setText("Save/Update Cart");
        setMinimumSize(new Dimension(150, 50));
        setMaximumSize(new Dimension(150, 50));
        addActionListener(new SaveShoppingCartButtonAction(items, shoppingCartTable, buildShoppingCartWindow, selectedShoppingCart));
        setIcon(new ImageIcon("main/window/build-shopping-cart.png"));
    }
}
