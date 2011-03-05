package gui.window.buildshoppingcart;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildShoppingCartWindow_UT {
    private BuildShoppingCartWindow buildShoppingCartWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        buildShoppingCartWindow = new BuildShoppingCartWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Build A Shopping Cart", buildShoppingCartWindow.getTitle());
        assertEquals((double)WIDTH, buildShoppingCartWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, buildShoppingCartWindow.getSize().getHeight());
    }
}
