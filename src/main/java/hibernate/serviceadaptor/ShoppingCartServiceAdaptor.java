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
 */
public class ShoppingCartServiceAdaptor {
    private static ShoppingCartDaoImpl shoppingCartDao = new ShoppingCartDaoImpl();

    /**
     * Adds a shopping cart from a map of items with a corresponding quantity value
     * @param itemList map of items with corresponding quantity values
     * @param user user to save shopping cart to
     */
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

    /**
     * Sets the static shopping cart dao for the shopping cart service adaptor to use
     * @param shoppingCartDao hopping cart dao for the shopping cart service adaptor to use
     */
    public static void setShoppingCartDao(ShoppingCartDaoImpl shoppingCartDao) {
        ShoppingCartServiceAdaptor.shoppingCartDao = shoppingCartDao;
    }

    /**
     * Gets all shopping carts from the database
     * @return all shopping carts in teh database
     */
    public static List<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartDao.getAllShoppingCarts();
    }

    public static void removeShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDao.removeShoppingCart(shoppingCart);
    }

    /**
     * Update a shopping cart with a map of items and their corresponding quantities in the shopping cart
     * @param shoppingCart shopping cart to update items on
     * @param itemList a map of items and their corresponding quantities in the shopping cart
     */
    public static void updateShoppingCart(ShoppingCart shoppingCart, Map<Item, Integer> itemList) {
        List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
        for (Item item : itemList.keySet()) {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setItem(item);
            shoppingCartItem.setItemQuantity(itemList.get(item));
            shoppingCartItems.add(shoppingCartItem);
        }
        shoppingCartDao.updateShoppingCart(shoppingCart, shoppingCartItems);
    }
}
