package gui.window.main;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow_UT {
    private MainWindow mainWindow;
    private Integer WIDTH = 250;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        mainWindow = new MainWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Coupon Manager", mainWindow.getTitle());
        assertEquals((double)WIDTH, mainWindow.getSize().getWidth());
        assertEquals((double)HEIGHT, mainWindow.getSize().getHeight());
        assertEquals(1, (((JRootPane) mainWindow.getComponent(0))).getContentPane().getComponentCount());
        assertEquals(7, ((Box)(((JRootPane) mainWindow.getComponent(0))).getContentPane().getComponent(0)).getComponentCount());
    }
}
