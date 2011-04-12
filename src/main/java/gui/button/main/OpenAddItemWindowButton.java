package gui.button.main;

import gui.action.main.OpenAddItemWindowAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:58:24 PM
 */
public class OpenAddItemWindowButton extends MainMenuButton {

    /**
     * Open add item window button
     */
    public OpenAddItemWindowButton() {
        setText("Add Item");
        addActionListener(new OpenAddItemWindowAction());
        setIcon(new ImageIcon("main/window/item-icon.png"));
    }
}
