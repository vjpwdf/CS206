package gui.window.editcoupon;

import gui.window.WindowTest;
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
public class RemoveCouponWindow_UT extends WindowTest{
    private EditCouponWindow removeCouponWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 600;

    @Before
    public void setUp() {
        removeCouponWindow = new EditCouponWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Edit A Coupon", removeCouponWindow.getTitle());
        assertEquals((double) WIDTH, removeCouponWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, removeCouponWindow.getSize().getHeight());
    }
}
