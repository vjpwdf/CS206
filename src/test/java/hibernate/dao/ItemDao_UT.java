package hibernate.dao;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void testGetItem() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        Item databaseItem = itemDao.getItemByUpc(item.getItemUpc());
        assertNotNull(databaseItem);
        assertTrue(item.equals(databaseItem));
    }

    @Test
    public void testRemoveItem() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        Coupon coupon = addCoupon(10, 2.5f, false, item);
        //itemDao.removeItem(item.getItemUpc());
        List<Item> items = DBClient.INSTANCE.getListOfObjects("from Item");
        assertTrue(items.contains(item));
    }

    @Test
    public void testGetAllItems() {
        Item item = addItem("test", "test", "test", "test", 1.25f);
        List<Item> items = itemDao.getAllItems();
        assertNotNull(items);
        assertTrue(items.contains(item));
    }
}
