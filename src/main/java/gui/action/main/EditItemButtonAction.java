package gui.action.main;

import gui.window.edititem.EditItemWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:05:48 PM
 */
public class EditItemButtonAction implements ActionListener {
    /**
     * Opens edit item window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        EditItemWindow removeItemWindow = new EditItemWindow();
        removeItemWindow.setVisible(true);
    }
}
