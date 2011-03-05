package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
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
    public void addCoupon(String itemUpc, boolean couponType, Float couponValue, Date date, File file) {
        Item item = (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + itemUpc + "'");
        System.out.println();
        Coupon coupon = new Coupon();
        coupon.setCouponType(couponType);
        coupon.setCouponValue(couponValue);
        coupon.setExpirationDate(date);
        coupon.setItem(item);
        DBClient.databaseSession.getCurrentSession().save(coupon);
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
