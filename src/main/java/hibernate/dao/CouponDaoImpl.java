package hibernate.dao;

import hibernate.Coupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class CouponDaoImpl implements CouponDAO {

    @Transactional
    public void addCoupon(Coupon coupon) {

    }

    @Transactional
    public void removeCoupon(Integer couponId) {

    }

    @Transactional
    public List<Coupon> getAllCoupons() {
        List<Coupon> coupons = new ArrayList<Coupon>();
        return coupons;
    }
}
