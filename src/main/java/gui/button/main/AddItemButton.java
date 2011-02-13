package gui.button.main;

import gui.action.main.AddItemButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:58:24 PM
 */
public class AddItemButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;

    public AddItemButton() {
        setText("Add Item");
        addActionListener(new AddItemButtonAction());
        setIcon(new ImageIcon("main/window/item-icon.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}
