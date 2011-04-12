package gui.action.main;

import gui.window.addcoupon.AddCouponWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 7:56:01 PM
 */
public class AddCouponButtonAction implements ActionListener {
    /**
     * Opens add coupon window
     * @param e ignored
     */
    public void actionPerformed(ActionEvent e) {
        AddCouponWindow addCouponWindow = new AddCouponWindow();
        addCouponWindow.setVisible(true);
    }
}
