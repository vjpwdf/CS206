package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDao_UT extends DaoTest{
    private ItemDao itemDao;

    @Before
    public void setUp() {
        itemDao = new ItemDaoImpl();
        testSessionFactoryIsNotNull();
    }

    @Test
    public void testGetItem() throws IOException {
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        Item databaseItem = itemDao.getItemByUpc(item.getItemUpc());
        assertNotNull(databaseItem);
        assertTrue(item.equals(databaseItem));
    }

    @Test
    public void testRemoveItem() throws IOException {
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        itemDao.removeItem(item.getItemUpc());
        List<Item> items = new ArrayList<Item>(DBClient.INSTANCE.getListOfObjects("from Item"));
        assertTrue(!items.contains(item));
    }

    @Test
    public void testGetAllItems() throws IOException {
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        List<Item> items = itemDao.getAllItems();
        assertNotNull(items);
        assertTrue(items.contains(item));
    }

    @Test
    public void addItemWithCoupons() throws IOException {
        List<Coupon> couponList = new ArrayList<Coupon>();
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        Coupon coupon = addCoupon(10, 2.5f, false, item);
        couponList.add(coupon);
        Set<Coupon> couponSet = new HashSet<Coupon>(couponList);
        item.setItemCoupons(couponSet);
        DBClient.databaseSession.getCurrentSession().save(item);
        Item itemFromDB = (Item) DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'test'");
        assertNotNull(itemFromDB.getItemCoupons());
        assertTrue(itemFromDB.getItemCoupons().contains(coupon));
    }

    @Test
    public void testSaveItem() {
        Item item = new Item();
        item.setItemDescription("test");
        item.setItemManufacturer("test");
        item.setItemName("test");
        item.setItemPrice(1.25f);
        item.setItemUpc("test");
        itemDao.saveItem(item);
        Item dbItem = (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + item.getItemUpc() + "'");
        assertNotNull(dbItem);
        assertTrue(dbItem.equals(item));
    }
}
