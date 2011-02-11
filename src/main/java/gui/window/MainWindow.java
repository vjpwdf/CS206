package gui.window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 6:58:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow extends JFrame {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 250;
    
    public MainWindow() {
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
