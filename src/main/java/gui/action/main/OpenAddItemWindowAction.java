package gui.action.main;

import gui.window.additem.AddItemWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:59:16 PM
 */
public class OpenAddItemWindowAction implements ActionListener {
    /**
     * Opens add item window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        AddItemWindow addItemWindow = new AddItemWindow();
        addItemWindow.setVisible(true);
    }
}
