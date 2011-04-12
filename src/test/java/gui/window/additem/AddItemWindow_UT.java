package gui.window.additem;

import gui.window.WindowTest;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddItemWindow_UT extends WindowTest{
    private AddItemWindow addItemWindow;
    private Integer WIDTH = 600;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        addItemWindow = new AddItemWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Add An Item", addItemWindow.getTitle());
        assertEquals((double)WIDTH, addItemWindow.getSize().getWidth());
        assertEquals((double)HEIGHT, addItemWindow.getSize().getHeight());
        assertEquals(1, (((JRootPane)addItemWindow.getComponent(0))).getContentPane().getComponentCount());
        assertEquals(8, ((Box)(((JRootPane)addItemWindow.getComponent(0))).getContentPane().getComponent(0)).getComponentCount());
    }
}
