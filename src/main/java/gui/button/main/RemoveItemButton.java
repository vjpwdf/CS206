package gui.button.main;

import gui.action.main.RemoveItemButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:05:03 PM
 */
public class RemoveItemButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;

    public RemoveItemButton() {
        setText("Remove Item");
        addActionListener(new RemoveItemButtonAction());
        setIcon(new ImageIcon("main/window/remove-button.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}
