package gui.button.main;

import gui.action.main.ViewAllShoppingCartsButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:23:26 PM
 */
public class ViewAllShoppingCartsButton extends MainMenuButton {

    /**
     * View all shopping carts button
     */
    public ViewAllShoppingCartsButton() {
        setText("View All Shopping Carts");
        addActionListener(new ViewAllShoppingCartsButtonAction());
        setIcon(new ImageIcon("main/window/all-shopping-carts.png"));
    }
}
