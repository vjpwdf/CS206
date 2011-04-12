package gui.window.addcoupon;

import gui.window.WindowTest;
import hibernate.factory.DBClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */

public class AddCouponWindow_UT extends WindowTest{
    private AddCouponWindow addCouponWindow;
    private Integer WIDTH = 600;
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
