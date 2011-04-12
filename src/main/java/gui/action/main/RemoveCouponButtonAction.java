package gui.action.main;

import gui.window.addcoupon.AddCouponWindow;
import gui.window.editcoupon.EditCouponWindow;
import hibernate.Coupon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        EditCouponWindow editCouponWindow = new EditCouponWindow();
        editCouponWindow.setVisible(true);
    }
}
