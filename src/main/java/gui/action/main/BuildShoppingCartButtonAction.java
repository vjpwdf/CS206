package gui.action.main;

import gui.window.buildshoppingcart.BuildShoppingCartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:07:58 PM
 */
public class BuildShoppingCartButtonAction implements ActionListener {
    /**
     * Opens build shopping cart window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        BuildShoppingCartWindow buildShoppingCartWindow = new BuildShoppingCartWindow();
        buildShoppingCartWindow.setVisible(true);
    }
}
