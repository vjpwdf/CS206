package gui.action.main;

import gui.window.editcoupon.EditCouponWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:05:23 PM
 */
public class RemoveCouponButtonAction implements ActionListener {
    /**
     * Opens edit coupon window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        EditCouponWindow removeCouponWindow = new EditCouponWindow();
        removeCouponWindow.setVisible(true);
    }
}
