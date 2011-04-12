package hibernate.serviceadaptor;

import hibernate.Coupon;
import hibernate.dao.CouponDaoImpl;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CouponServiceAdaptor {
    private static CouponDaoImpl couponDao = new CouponDaoImpl();

    public static Coupon addCoupon(String itemId, boolean couponType, Float couponValue, Date date) {
        return couponDao.addCoupon(itemId, couponType, couponValue, date);
    }
    public static void removeCoupon(int couponId) {
        couponDao.removeCoupon(couponId);
    }
    public static List<Coupon> getAllCoupons() {
        return couponDao.getAllCoupons();
    }

    public static void setCouponDao(CouponDaoImpl couponDao) {
        CouponServiceAdaptor.couponDao = couponDao;
    }
}
