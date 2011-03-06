package gui.button.general;

import gui.action.general.AddItemActionListener;
import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import gui.window.additem.AddItemWindow;
import hibernate.Item;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 2/27/11
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddItemButton extends JButton {
    public AddItemButton(String title, GeneralInput nameInput, GeneralInput priceInput, GeneralInput upc, GeneralInput description, GeneralInput manufacturer, GeneralInputFileBrowser fileBrowser, AddItemWindow addItemWindow, Item item) {
        super(title);
        addActionListener(new AddItemActionListener(nameInput, priceInput, upc, description, manufacturer, fileBrowser, addItemWindow, item));
    }
}
