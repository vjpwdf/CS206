package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

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
        couponDao.addCoupon("test", false, .25f, new Date(), null);
        Coupon coupon = new Coupon();
        List<Coupon> coupons = (List<Coupon>)DBClient.INSTANCE.getListOfObjects("from Coupon");
        System.out.println();
        //assert(coupons.contains())
        //couponDao.addCoupon();
    }
}
