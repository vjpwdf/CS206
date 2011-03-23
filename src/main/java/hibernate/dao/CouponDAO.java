package hibernate.dao;

import hibernate.Coupon;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CouponDAO {
    public void addCoupon(String itemUpc, boolean couponType, Float couponValue, Date date);

    public Coupon getCoupon(int couponId);

    public void removeCoupon(int couponId);

    public List<Coupon> getAllCoupons();
}
