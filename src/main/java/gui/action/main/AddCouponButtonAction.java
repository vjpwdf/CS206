package gui.action.main;

import gui.window.addcoupon.AddCouponWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 7:56:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCouponButtonAction implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        AddCouponWindow addCouponWindow = new AddCouponWindow();
        addCouponWindow.setVisible(true);
    }
}
