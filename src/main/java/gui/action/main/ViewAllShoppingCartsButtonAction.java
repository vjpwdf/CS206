package gui.action.main;

import gui.window.viewallshoppingcarts.ViewAllShoppingCartsWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:25:38 PM
 */
public class ViewAllShoppingCartsButtonAction implements ActionListener {
    /**
     * Opens view all shopping carts window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        ViewAllShoppingCartsWindow viewAllShoppingCartsWindow = new ViewAllShoppingCartsWindow();
        viewAllShoppingCartsWindow.setVisible(true);
    }
}
