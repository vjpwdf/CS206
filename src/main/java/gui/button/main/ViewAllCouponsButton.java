package gui.button.main;

import gui.action.main.ViewAllCouponsButtonAction;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 8:23:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllCouponsButton extends JButton {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 35;
    
    public ViewAllCouponsButton() {
        setText("View All Coupons");
        addActionListener(new ViewAllCouponsButtonAction());
        setIcon(new ImageIcon("main/window/all-coupons.png"));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
    }
}
