package gui.window.buildshoppingcart;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:08:55 PM
 */
public class BuildShoppingCartWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public BuildShoppingCartWindow() throws HeadlessException {
        setTitle("Build A Shopping Cart");
        setSize(WIDTH, HEIGHT);
    }
}