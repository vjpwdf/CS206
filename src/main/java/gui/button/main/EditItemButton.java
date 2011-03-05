package gui.button.main;

import gui.action.main.EditItemButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:05:03 PM
 */
public class EditItemButton extends MainMenuButton {

    public EditItemButton() {
        setText("Edit Item");
        addActionListener(new EditItemButtonAction());
        setIcon(new ImageIcon("main/window/remove-button.png"));
    }
}
