package hibernate.serviceadaptor;

import hibernate.Coupon;
import hibernate.dao.CouponDaoImpl;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:03 PM
 */
public class CouponServiceAdaptor {
    private static CouponDaoImpl couponDao = new CouponDaoImpl();

    /**
     * Add coupon to database
     * @param itemId unique id of item to associate with the coupon
     * @param couponType the type of the coupon whether it is %off or dollar off
     * @param couponValue value of the coupon
     * @param date expiration date of the coupon
     * @return The coupon object that was inserted into the database
     */
    public static Coupon addCoupon(String itemId, boolean couponType, Float couponValue, Date date) {
        return couponDao.addCoupon(itemId, couponType, couponValue, date);
    }

    /**
     * Removes a coupon from the database with selected coupon id
     * @param couponId unique id of coupon
     */
    public static void removeCoupon(int couponId) {
        couponDao.removeCoupon(couponId);
    }

    /**
     * Gets all coupons from the database
     * @return a list of all current coupons in the database
     */
    public static List<Coupon> getAllCoupons() {
        return couponDao.getAllCoupons();
    }

    /**
     * Sets the dao object on the coupon service adaptor
     * @param couponDao coupon dao to set
     */
    public static void setCouponDao(CouponDaoImpl couponDao) {
        CouponServiceAdaptor.couponDao = couponDao;
    }
}
