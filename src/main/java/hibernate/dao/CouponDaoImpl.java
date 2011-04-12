package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    public Coupon addCoupon(String itemUpc, boolean couponType, Float couponValue, Date date) {
        Item item = (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + itemUpc + "'");
        System.out.println();
        Coupon coupon = new Coupon();
        coupon.setCouponType(couponType);
        coupon.setCouponValue(couponValue);
        coupon.setExpirationDate(date);
        coupon.setItem(item);
        DBClient.INSTANCE.saveObject(coupon);
        return coupon;
    }

    @Transactional
    public Coupon getCoupon(int couponId) {
        Coupon coupon = (Coupon)DBClient.INSTANCE.getObject("from Coupon coupon where coupon.couponId = "  + Integer.toString(couponId));
        return coupon;
    }

    @Transactional
    public void removeCoupon(int couponId) {
        Coupon coupon = (Coupon)DBClient.INSTANCE.getObject("from Coupon coupon where coupon.couponId = " + Integer.toString(couponId));
        DBClient.INSTANCE.deleteObject(coupon);
    }

    @Transactional
    public List<Coupon> getAllCoupons() {
        List<Coupon> coupons = (List<Coupon>)DBClient.INSTANCE.getListOfObjects("from Coupon");
        return coupons;
    }
}
