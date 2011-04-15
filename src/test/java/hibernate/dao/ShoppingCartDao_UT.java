package hibernate.dao;

import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import hibernate.User;
import hibernate.factory.DBClient;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartDao_UT extends DaoTest {
    private ShoppingCartDao shoppingCartDao;

    @Before
    public void setUp() {
        shoppingCartDao = new ShoppingCartDaoImpl();
        testSessionFactoryIsNotNull();
    }

    @Test
    public void addShoppingCartFromListOfShoppingCartItems() throws IOException {
        User user = addUser("John-the-man", "0123456");
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setItem(item);
        shoppingCartItem.setItemQuantity(5);
        List<ShoppingCartItem> shoppingCartItemList = new ArrayList<ShoppingCartItem>();
        shoppingCartItemList.add(shoppingCartItem);

        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItemList));
        shoppingCart.setUser(user);

        shoppingCartDao.addShoppingCartFromListOfShoppingCartItems(shoppingCartItemList, user.getUserName());
        List<ShoppingCart> shoppingCartFromDb = (List<ShoppingCart>) DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertNotNull(shoppingCartFromDb);
        assertTrue(shoppingCartFromDb.contains(shoppingCart));
    }

    @Test
    public void testGetAllShoppingCarts() throws IOException {
        User user = addUser("John", "0123456");
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        ShoppingCart shoppingCart;
        shoppingCartItem.setItem(item);
        shoppingCartItem.setItemQuantity(2);
        List<ShoppingCartItem> shoppingCarItems = new ArrayList<ShoppingCartItem>();
        shoppingCarItems.add(shoppingCartItem);
        shoppingCart = addShoppingCart(shoppingCarItems, user);
        List<ShoppingCart> shoppingCarts = shoppingCartDao.getAllShoppingCarts();
        assertNotNull(shoppingCarts);
        assertTrue(shoppingCarts.size() > 0);
        assertTrue(shoppingCarts.contains(shoppingCart));
        System.out.println();
    }

    @Test
    public void testAddEmptyShoppingCart() {
        User user = addUser("John", "0123456");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.addEmptyShoppingCart(user.getUserName());
        List<ShoppingCart> shoppingCarts = DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertNotNull(shoppingCarts);
        assertTrue(shoppingCarts.size() > 0);
        assertTrue(shoppingCarts.contains(shoppingCart));
    }

    @Test
    public void testUpdateShoppingCart() throws IOException {
        User user = addUser("John-the-man", "0123456");
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        Item item2 = addItem("test2", "test2", "test2", "test2", 2.25f, null);
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem();
        shoppingCartItem.setItem(item);
        shoppingCartItem.setItemQuantity(5);
        shoppingCartItem2.setItem(item2);
        shoppingCartItem2.setItemQuantity(10);
        List<ShoppingCartItem> shoppingCartItemList = new ArrayList<ShoppingCartItem>();
        shoppingCartItemList.add(shoppingCartItem);

        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItemList));
        shoppingCart.setUser(user);

        ShoppingCart shoppingCart1 = shoppingCartDao.addShoppingCartFromListOfShoppingCartItems(shoppingCartItemList, user.getUserName());
        List<ShoppingCart> shoppingCartFromDb = (List<ShoppingCart>) DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertNotNull(shoppingCartFromDb);
        assertTrue(shoppingCartFromDb.contains(shoppingCart));

        shoppingCartItemList.add(shoppingCartItem2);
        shoppingCartItemList.remove(shoppingCartItem);
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItemList));
        shoppingCartDao.updateShoppingCart(shoppingCart1, shoppingCartItemList);
        List<ShoppingCartItem> shoppingCartItems = (List<ShoppingCartItem>) DBClient.INSTANCE.getListOfObjects("from ShoppingCartItem");
        shoppingCartFromDb = (List<ShoppingCart>) DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertTrue(shoppingCartFromDb.contains(shoppingCart));
        assertFalse(shoppingCartItems.contains(shoppingCartItem));
    }

    @Test
    public void testRemoveShoppingCart() throws IOException {
        User user = addUser("John-the-man", "0123456");
        Item item = addItem("test", "test", "test", "test", 1.25f, null);
        Item item2 = addItem("test2", "test2", "test2", "test2", 2.25f, null);
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem();
        shoppingCartItem.setItem(item);
        shoppingCartItem.setItemQuantity(5);
        shoppingCartItem2.setItem(item2);
        shoppingCartItem2.setItemQuantity(10);
        List<ShoppingCartItem> shoppingCartItemList = new ArrayList<ShoppingCartItem>();
        shoppingCartItemList.add(shoppingCartItem);

        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItemList));
        shoppingCart.setUser(user);

        ShoppingCart shoppingCart1 = shoppingCartDao.addShoppingCartFromListOfShoppingCartItems(shoppingCartItemList, user.getUserName());
        List<ShoppingCart> shoppingCartFromDb = (List<ShoppingCart>) DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertNotNull(shoppingCartFromDb);
        assertTrue(shoppingCartFromDb.contains(shoppingCart));
        shoppingCartDao.removeShoppingCart(shoppingCart1);
        shoppingCartFromDb = (List<ShoppingCart>)DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertFalse(shoppingCartFromDb.contains(shoppingCart));
    }
}
