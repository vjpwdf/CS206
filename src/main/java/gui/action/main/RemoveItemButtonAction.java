package gui.action.main;

import gui.window.removecoupon.RemoveCouponWindow;
import gui.window.removeitem.RemoveItemWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:05:48 PM
 */
public class RemoveItemButtonAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        RemoveItemWindow removeItemWindow = new RemoveItemWindow();
        removeItemWindow.setVisible(true);
    }
}
