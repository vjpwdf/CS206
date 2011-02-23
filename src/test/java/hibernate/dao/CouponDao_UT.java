package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class CouponDao_UT extends DaoTest{

    @Test
    public void testAddCoupon() {
        Item item = new Item();
        item.setItemDescription("Test description");
        item.setItemManufacturer("Bob");
        item.setItemName("Builder");
        item.setItemUpc("0123456");
        sessionFactory.getCurrentSession().save(item);

        Coupon coupon = new Coupon();
        coupon.setCouponId(1);
        coupon.setCouponType(true);
        coupon.setCouponValue(.25f);
        coupon.setExpirationDate(new Date());
        coupon.setItem(item);
        sessionFactory.getCurrentSession().save(coupon);
        System.out.println("Passed");
    }
}
