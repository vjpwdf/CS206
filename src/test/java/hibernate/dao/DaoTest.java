package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate/config.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class DaoTest {

    @Autowired
    public void setDbClient(DBClient dbClient){
        DBClient.INSTANCE = dbClient;
    }

    @Test
    public void testSessionFactoryIsNotNull() {
        assertNotNull(DBClient.INSTANCE);
        assertNotNull(DBClient.databaseSession);
    }

    public Item addItem(String itemUpc, String itemName, String itemDescription, String itemManufacturer, float itemPrice, Set<Coupon> itemCoupons) {
        Item item = new Item();
        item.setItemUpc(itemUpc);
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        item.setItemManufacturer(itemManufacturer);
        item.setItemPrice(itemPrice);
        item.setItemCoupons(itemCoupons);
        DBClient.databaseSession.getCurrentSession().save(item);
        return item;
    }

    public Coupon addCoupon(int couponId, float couponValue, boolean couponType, Item couponItem) {
        Coupon coupon = new Coupon();
        coupon.setCouponId(couponId);
        coupon.setCouponValue(couponValue);
        coupon.setExpirationDate(new Date());
        coupon.setCouponImage(null);
        coupon.setCouponType(couponType);
        coupon.setItem(couponItem);
        DBClient.databaseSession.getCurrentSession().save(coupon);
        return coupon;
    }
}
