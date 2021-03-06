package gui.window.viewallcoupons;

import gui.window.WindowTest;
import hibernate.Coupon;
import hibernate.dao.CouponDaoImpl;
import hibernate.serviceadaptor.CouponServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllCouponsWindow_UT extends WindowTest{
    private ViewAllCouponsWindow viewAllCouponsWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 600;
    @Mock
    CouponDaoImpl couponDao;

    @Before
    public void setUp() {
        initMocks(this);
        CouponServiceAdaptor.setCouponDao(couponDao);
        viewAllCouponsWindow = new ViewAllCouponsWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("View All Coupons", viewAllCouponsWindow.getTitle());
        assertEquals((double) WIDTH, viewAllCouponsWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, viewAllCouponsWindow.getSize().getHeight());
    }

    @Test
    public void testViewAllCoupons() {
        Coupon coupon = new Coupon();
        coupon.setCouponType(true);
        coupon.setExpirationDate(new Date());
        coupon.setCouponValue(1.25f);
        coupon.setItem(getAnItem());
        when(couponDao.getAllCoupons()).thenReturn(Arrays.asList(coupon));
        viewAllCouponsWindow = new ViewAllCouponsWindow();
        assertEquals(1, viewAllCouponsWindow.getTable().getRowCount());
        assertEquals(coupon.getItem().getItemName() + " - " + coupon.getItem().getItemManufacturer(), viewAllCouponsWindow.getModel().getValueAt(0,0));
        assertEquals(coupon.getCouponValue(), Float.valueOf(viewAllCouponsWindow.getModel().getValueAt(0,1).toString()));
        assertEquals(coupon.isCouponType()? "Percent Off" : "Amount Off", viewAllCouponsWindow.getModel().getValueAt(0,2));
        assertEquals(coupon.getExpirationDate().toString(), viewAllCouponsWindow.getModel().getValueAt(0,3).toString());
        assertEquals(String.class, viewAllCouponsWindow.getModel().getColumnClass(0));
    }
}