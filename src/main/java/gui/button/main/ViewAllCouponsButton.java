package gui.button.main;

import gui.action.main.ViewAllCouponsButtonAction;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:23:13 PM
 */
public class ViewAllCouponsButton extends MainMenuButton {

    /**
     * View all coupons button
     */
    public ViewAllCouponsButton() {
        setText("View All Coupons");
        addActionListener(new ViewAllCouponsButtonAction());
        setIcon(new ImageIcon("main/window/all-coupons.png"));
    }
}
