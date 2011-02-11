package gui.button.main;

import gui.action.main.RemoveCouponButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:03:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveCouponButton extends JButton {
    public RemoveCouponButton() {
        setText("Remove Coupon");
        addActionListener(new RemoveCouponButtonAction());
    }
}
