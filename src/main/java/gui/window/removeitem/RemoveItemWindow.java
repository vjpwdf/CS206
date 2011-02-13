package gui.window.removeitem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:06:23 PM
 */
public class RemoveItemWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public RemoveItemWindow() throws HeadlessException {
        setTitle("Remove An Item");
        setSize(WIDTH, HEIGHT);
    }
}