package gui.window.additem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:59:57 PM
 */
public class AddItemWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public AddItemWindow() throws HeadlessException {
        setTitle("Add An Item");
        setSize(WIDTH, HEIGHT);
    }
}
