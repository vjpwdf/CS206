package gui.button.main;

import gui.action.main.RemoveCouponButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:03:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveCouponButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;
    
    public RemoveCouponButton() {
        setText("Remove Coupon");
        addActionListener(new RemoveCouponButtonAction());
        setIcon(new ImageIcon("main/window/remove-button.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}
