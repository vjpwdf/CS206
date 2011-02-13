package gui.window.viewallcoupons;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:11:18 PM
 */
public class ViewAllCouponsWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public ViewAllCouponsWindow() throws HeadlessException {
        setTitle("View All Coupons");
        setSize(WIDTH, HEIGHT);
    }
}