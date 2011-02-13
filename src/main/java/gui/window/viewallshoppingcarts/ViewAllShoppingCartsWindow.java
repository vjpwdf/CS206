package gui.window.viewallshoppingcarts;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:10:14 PM
 */
public class ViewAllShoppingCartsWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public ViewAllShoppingCartsWindow() throws HeadlessException {
        setTitle("View All Shopping Carts");
        setSize(WIDTH, HEIGHT);
    }
}