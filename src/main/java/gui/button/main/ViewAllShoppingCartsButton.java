package gui.button.main;

import gui.action.main.ViewAllShoppingCartsButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:23:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllShoppingCartsButton extends JButton {
    public ViewAllShoppingCartsButton() {
        setText("View All Shopping Carts");
        addActionListener(new ViewAllShoppingCartsButtonAction());
    }
}
