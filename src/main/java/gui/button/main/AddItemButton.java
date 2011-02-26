package gui.button.main;

import gui.action.main.AddItemButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:58:24 PM
 */
public class AddItemButton extends MainMenuButton {

    public AddItemButton() {
        setText("Add Item");
        addActionListener(new AddItemButtonAction());
        setIcon(new ImageIcon("main/window/item-icon.png"));
    }
}
