package gui.window.removecoupon;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveCouponWindow_UT {
    private RemoveCouponWindow removeCouponWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        removeCouponWindow = new RemoveCouponWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Remove A Coupon", removeCouponWindow.getTitle());
        assertEquals((double) WIDTH, removeCouponWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, removeCouponWindow.getSize().getHeight());
    }
}
