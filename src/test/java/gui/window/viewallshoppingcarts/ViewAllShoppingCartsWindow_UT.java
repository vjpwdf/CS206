package gui.window.viewallshoppingcarts;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllShoppingCartsWindow_UT {
    private ViewAllShoppingCartsWindow viewAllCouponsWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        viewAllCouponsWindow = new ViewAllShoppingCartsWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("View All Shopping Carts", viewAllCouponsWindow.getTitle());
        assertEquals((double) WIDTH, viewAllCouponsWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, viewAllCouponsWindow.getSize().getHeight());
    }
}