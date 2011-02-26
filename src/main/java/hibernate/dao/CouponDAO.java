package hibernate.dao;

import hibernate.Coupon;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CouponDAO {
    public void addCoupon(Coupon coupon);

    public void removeCoupon(Integer couponId);

    public List<Coupon> getAllCoupons();
}
