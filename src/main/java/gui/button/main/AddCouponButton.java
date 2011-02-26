package gui.button.main;

import gui.action.main.AddCouponButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 7:54:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCouponButton extends MainMenuButton {

    public AddCouponButton() {
        setText("Add Coupon");
        addActionListener(new AddCouponButtonAction());
        setIcon(new ImageIcon("main/window/add-button.png"));
    }
}
