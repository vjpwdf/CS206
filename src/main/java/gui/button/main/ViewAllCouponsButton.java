package gui.button.main;

import gui.action.main.ViewAllCouponsButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:23:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllCouponsButton extends JButton {
    public ViewAllCouponsButton() {
        setText("View All Coupons");
        addActionListener(new ViewAllCouponsButtonAction());
    }
}
