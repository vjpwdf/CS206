package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CouponDao_UT extends DaoTest{
    private CouponDAO couponDao;

    @Before
    public void setUp() {
        couponDao = new CouponDaoImpl();
        testSessionFactoryIsNotNull();
    }

    @Test
    public void testAddCoupon() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        couponDao.addCoupon("test", false, .25f, new Date(), null);
        Coupon coupon = new Coupon();
        coupon.setCouponType(false);
        coupon.setCouponImage(null);
        coupon.setCouponValue(.25f);
        coupon.setItem(item);
        List<Coupon> coupons = (List<Coupon>)DBClient.INSTANCE.getListOfObjects("from Coupon");
        assertTrue(coupons.contains(coupon));
    }

    @Test
    public void testGetCoupon() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        Coupon coupon = addCoupon(10, 1.25f, false, item);
        Coupon couponFromDatabase = couponDao.getCoupon(coupon.getCouponId());
        assertNotNull(coupon);
        assertTrue(coupon.equals(couponFromDatabase));
    }

    @Test
    public void testGetAllCoupons() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        Coupon coupon = addCoupon(10, 1.25f, false, item);
        List<Coupon> couponList = couponDao.getAllCoupons();
        assertNotNull(couponList);
        assertTrue(couponList.contains(coupon));
    }

    @Test
    public void removeCoupon() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        Coupon coupon = addCoupon(10, 1.25f, false, item);
        couponDao.removeCoupon(coupon.getCouponId());
        List<Coupon> coupons = (List<Coupon>)DBClient.INSTANCE.getListOfObjects("from Coupon");
        assertTrue(!coupons.contains(coupon));
    }
}
