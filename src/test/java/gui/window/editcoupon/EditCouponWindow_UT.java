package gui.window.editcoupon;

import gui.window.WindowTest;
import hibernate.Coupon;
import hibernate.dao.CouponDaoImpl;
import hibernate.serviceadaptor.CouponServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import utility.TestUtils;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditCouponWindow_UT extends WindowTest{
    private EditCouponWindow removeCouponWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 600;

    @Mock
    CouponDaoImpl couponDao;

    @Before
    public void setUp() {
        initMocks(this);
        CouponServiceAdaptor.setCouponDao(couponDao);
        removeCouponWindow = new EditCouponWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Edit A Coupon", removeCouponWindow.getTitle());
        assertEquals((double) WIDTH, removeCouponWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, removeCouponWindow.getSize().getHeight());
    }

    @Test
    public void testEditCoupon() {
        Coupon coupon = new Coupon();
        coupon.setExpirationDate(new Date());
        coupon.setCouponId(10);
        coupon.setCouponType(true);
        coupon.setCouponValue(2.25f);
        coupon.setItem(getAnItem());
        when(couponDao.getAllCoupons()).thenReturn(Arrays.asList(coupon));
        removeCouponWindow = new EditCouponWindow();
        removeCouponWindow.setVisible(true);

        //JFrame testFrame = (JFrame) TestUtils.getChildNamed()

        assertEquals(1, removeCouponWindow.getTable().getRowCount());
        assertEquals(coupon.getItem().getItemName() + " - " + coupon.getItem().getItemManufacturer(), removeCouponWindow.getModel().getValueAt(0, 0));
        assertEquals(coupon.getCouponValue(), new Float(removeCouponWindow.getModel().getValueAt(0, 1).toString()));
        assertEquals(coupon.isCouponType() ? "Percent Off" : "Amount Off", removeCouponWindow.getModel().getValueAt(0, 2));
        assertEquals(coupon.getExpirationDate().toString(), (String) removeCouponWindow.getModel().getValueAt(0, 3));
        removeCouponWindow.getTable().changeSelection(0, 0, false, false);
        assertTrue(removeCouponWindow.getEdit().isEnabled());
        assertTrue(removeCouponWindow.getRemove().isEnabled());
        assertEquals(String.class, removeCouponWindow.getModel().getColumnClass(0));

        removeCouponWindow.getEdit().doClick();
    }
}
