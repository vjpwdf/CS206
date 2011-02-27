package gui.window.addcoupon;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCouponWindow_UT {
    private AddCouponWindow addCouponWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 330;

    @Before
    public void setUp() {
        addCouponWindow = new AddCouponWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Add A Coupon", addCouponWindow.getTitle());
        assertEquals((double)WIDTH, addCouponWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, addCouponWindow.getSize().getHeight());
        assertEquals(1, (((JRootPane) addCouponWindow.getComponent(0))).getContentPane().getComponentCount());
    }
}
