package gui.button.main;

import gui.action.main.ViewAllShoppingCartsButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:23:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllShoppingCartsButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;

    public ViewAllShoppingCartsButton() {
        setText("View All Shopping Carts");
        addActionListener(new ViewAllShoppingCartsButtonAction());
        setIcon(new ImageIcon("main/window/all-shopping-carts.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}
