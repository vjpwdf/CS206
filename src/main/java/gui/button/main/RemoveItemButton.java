package gui.button.main;

import gui.action.main.RemoveItemButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:05:03 PM
 */
public class RemoveItemButton extends MainMenuButton {

    public RemoveItemButton() {
        setText("Remove Item");
        addActionListener(new RemoveItemButtonAction());
        setIcon(new ImageIcon("main/window/remove-button.png"));
    }
}
