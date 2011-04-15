package hibernate.dao;

import hibernate.Coupon;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 9:03 PM
 */
public interface CouponDAO {
    /**
     * Add coupon to database
     * @param itemUpc unique id of item to associate with the coupon
     * @param couponType the type of the coupon whether it is %off or dollar off
     * @param couponValue value of the coupon
     * @param date expiration date of the coupon
     * @return The coupon object that was inserted into the database
     */
    public Coupon addCoupon(String itemUpc, boolean couponType, Float couponValue, Date date);

    /**
     * Gets a coupon from the database based upon its coupon id
     * @param couponId coupon id that uniquely identifies the coupon
     * @return the coupon from the database
     */
    public Coupon getCoupon(int couponId);

    /**
     * Removes a coupon from the database with selected coupon id
     * @param couponId unique id of coupon
     */
    public void removeCoupon(int couponId);

    /**
     * Gets all coupons from the database
     * @return a list of all current coupons in the database
     */
    public List<Coupon> getAllCoupons();
}
