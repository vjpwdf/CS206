package gui.button.shoppingcart;

import gui.action.shoppingcart.SaveShoppingCartButtonAction;
import gui.window.buildshoppingcart.BuildShoppingCartWindow;
import hibernate.Item;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/10/11
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveShoppingCartButton extends JButton {
    public SaveShoppingCartButton(List<Item> items, JTable shoppingCartTable, BuildShoppingCartWindow buildShoppingCartWindow) {
        setText("Save/Update Cart");
        setMinimumSize(new Dimension(150, 50));
        setMaximumSize(new Dimension(150, 50));
        addActionListener(new SaveShoppingCartButtonAction(items, shoppingCartTable, buildShoppingCartWindow));
        setIcon(new ImageIcon("main/window/build-shopping-cart.png"));
    }
}
