package gui.window.removeitem;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveItemWindow_UT {
    private RemoveItemWindow removeItemWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        removeItemWindow = new RemoveItemWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Remove An Item", removeItemWindow.getTitle());
        assertEquals((double) WIDTH, removeItemWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, removeItemWindow.getSize().getHeight());
    }
}