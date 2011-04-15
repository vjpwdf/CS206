package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 */
public class CouponDaoImpl implements CouponDAO {

    /**
     * Add coupon to database
     * @param itemUpc unique id of item to associate with the coupon
     * @param couponType the type of the coupon whether it is %off or dollar off
     * @param couponValue value of the coupon
     * @param date expiration date of the coupon
     * @return The coupon object that was inserted into the database
     */
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

    /**
     * Gets a coupon from the database based upon its coupon id
     * @param couponId coupon id that uniquely identifies the coupon
     * @return the coupon from the database
     */
    @Transactional
    public Coupon getCoupon(int couponId) {
        return (Coupon)DBClient.INSTANCE.getObject("from Coupon coupon where coupon.couponId = "  + Integer.toString(couponId));
    }

    /**
     * Removes a coupon from the database with selected coupon id
     * @param couponId unique id of coupon
     */
    @Transactional
    public void removeCoupon(int couponId) {
        Coupon coupon = (Coupon)DBClient.INSTANCE.getObject("from Coupon coupon where coupon.couponId = " + Integer.toString(couponId));
        DBClient.INSTANCE.deleteObject(coupon);
    }

    /**
     * Gets all coupons from the database
     * @return a list of all current coupons in the database
     */
    @Transactional
    @SuppressWarnings("unchecked")
    public List<Coupon> getAllCoupons() {
        return (List<Coupon>)DBClient.INSTANCE.getListOfObjects("from Coupon");
    }
}
