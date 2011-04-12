package gui.window.edititem;

import gui.window.WindowTest;
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
public class RemoveItemWindow_UT extends WindowTest{
    private EditItemWindow removeItemWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 600;

    @Before
    public void setUp() {
        removeItemWindow = new EditItemWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Edit A Item", removeItemWindow.getTitle());
        assertEquals((double) WIDTH, removeItemWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, removeItemWindow.getSize().getHeight());
    }
}