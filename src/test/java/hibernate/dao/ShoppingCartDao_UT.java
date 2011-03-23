package hibernate.dao;

import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import hibernate.User;
import hibernate.factory.DBClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartDao_UT extends DaoTest{
    private ShoppingCartDao shoppingCartDao;

    @Before
    public void setUp() {
        shoppingCartDao = new ShoppingCartDaoImpl();
        testSessionFactoryIsNotNull();
    }

    @Test
    public void addShoppingCartFromListOfShoppingCartItems() {
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
        List<ShoppingCart> shoppingCartFromDb = (List<ShoppingCart>)DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
        assertNotNull(shoppingCartFromDb);
        assertTrue(shoppingCartFromDb.contains(shoppingCart));
    }

    @Test
    public void testGetAllShoppingCarts() {
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
}
