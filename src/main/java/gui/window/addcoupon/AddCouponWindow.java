package gui.window.addcoupon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11-Feb-2011
 * Time: 5:02:49 PM
 */
public class AddCouponWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 325;

    public AddCouponWindow() throws HeadlessException {
        setTitle("Add A Coupon");
        setSize(WIDTH, HEIGHT);
        add(new AddCouponWindowBackgroundPicture());
    }
}
