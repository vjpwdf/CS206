package gui.window.viewallcoupons;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllCouponsWindow_UT {
    private ViewAllCouponsWindow viewAllCouponsWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        viewAllCouponsWindow = new ViewAllCouponsWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("View All Coupons", viewAllCouponsWindow.getTitle());
        assertEquals((double) WIDTH, viewAllCouponsWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, viewAllCouponsWindow.getSize().getHeight());
    }
}