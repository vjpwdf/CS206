package gui.action.main;

import gui.window.viewallcoupons.ViewAllCouponsWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:24:58 PM
 */
public class ViewAllCouponsButtonAction implements ActionListener {
    /**
     * View all coupons window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        ViewAllCouponsWindow viewAllCouponsWindow = new ViewAllCouponsWindow();
        viewAllCouponsWindow.setVisible(true);
    }
}
