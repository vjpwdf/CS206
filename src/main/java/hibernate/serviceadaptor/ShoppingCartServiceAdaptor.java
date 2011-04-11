package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import hibernate.User;
import hibernate.dao.ShoppingCartDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartServiceAdaptor {
    private static ShoppingCartDaoImpl shoppingCartDao = new ShoppingCartDaoImpl();

    public static void addShoppingCartFromListOfShoppingCartItems(Map<Item, Integer> itemList, User user) {
        List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
        for (Item item : itemList.keySet()) {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setItem(item);
            shoppingCartItem.setItemQuantity(itemList.get(item));
            shoppingCartItems.add(shoppingCartItem);
        }
        shoppingCartDao.addShoppingCartFromListOfShoppingCartItems(shoppingCartItems, user.getUserName());
    }

    public static void setShoppingCartDao(ShoppingCartDaoImpl shoppingCartDao) {
        ShoppingCartServiceAdaptor.shoppingCartDao = shoppingCartDao;
    }

    public static List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartDao.getAllShoppingCarts();
    }

    public static void removeShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDao.removeShoppingCart(shoppingCart);
    }
}
