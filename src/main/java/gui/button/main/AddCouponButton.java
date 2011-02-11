package gui.button.main;

import gui.action.main.AddCouponButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 7:54:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCouponButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;

    public AddCouponButton() {
        setText("Add Coupon");
        addActionListener(new AddCouponButtonAction());
        setIcon(new ImageIcon("main/window/add-button.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}
