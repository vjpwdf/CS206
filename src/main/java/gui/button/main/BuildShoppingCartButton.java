package gui.button.main;

import gui.action.main.BuildShoppingCartButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:07:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildShoppingCartButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;

    public BuildShoppingCartButton() {
        setText("Build Shopping Cart");
        addActionListener(new BuildShoppingCartButtonAction());
        setIcon(new ImageIcon("main/window/build-shopping-cart.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}