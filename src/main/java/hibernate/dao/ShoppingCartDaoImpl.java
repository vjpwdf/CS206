package hibernate.dao;

import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import hibernate.User;
import hibernate.factory.DBClient;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 */
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    /**
     * Adds a shopping cart to the database with a list of shopping cart items
     * @param shoppingCartItems items to add to the shopping cart and persist in the database
     * @param userName user who the shopping cart belongs to
     * @return the shopping cart saved to the database
     */
    public ShoppingCart addShoppingCartFromListOfShoppingCartItems(List<ShoppingCartItem> shoppingCartItems, String userName) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = (User) DBClient.INSTANCE.getObject("from User user where user.userName = " + "'" + userName + "'");
        shoppingCart.setCreationDate(new Date());
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItems));
        shoppingCart.setUser(user);
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            shoppingCartItem.setShoppingCart(shoppingCart);
        }
        DBClient.INSTANCE.saveObject(shoppingCart);
        return shoppingCart;
    }

    /**
     * Gets all the shopping carts from the database
     * @return a list of all shopping carts from the database
     */
    @SuppressWarnings("unchecked")
    public List<ShoppingCart> getAllShoppingCarts() {
        return (List<ShoppingCart>)DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
    }

    /**
     * Adds an empty shopping cart to the database
     * @param userName user to add shopping cart for
     */
    public void addEmptyShoppingCart(String userName) {
        User user = (User)DBClient.INSTANCE.getObject("from User user where user.userName = " + "'" + userName + "'");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCreationDate(new Date());
        shoppingCart.setUser(user);
        DBClient.INSTANCE.saveObject(shoppingCart);
    }

    /**
     * Removes a shopping cart from the database
     * @param shoppingCart shopping cart to remove from the database
     */
    public void removeShoppingCart(ShoppingCart shoppingCart) {
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItems()) {
            DBClient.INSTANCE.deleteObject(shoppingCartItem);
        }
        DBClient.INSTANCE.deleteObject(shoppingCart);
    }

    /**
     * Updates a shopping cart from the database
     * @param shoppingCart shopping cart to update
     * @param shoppingCartItems list of shopping cart items to update
     */
    public void updateShoppingCart(ShoppingCart shoppingCart, List<ShoppingCartItem> shoppingCartItems) {
        removePreviousShoppingCartItems(shoppingCart);
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItems));
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            shoppingCartItem.setShoppingCart(shoppingCart);
        }
        DBClient.INSTANCE.saveObject(shoppingCart);
    }

    /**
     * Removes old shopping cart items from the existing shopping cart
     * @param shoppingCart shopping cart object to remove the existing items
     */
    private void removePreviousShoppingCartItems(ShoppingCart shoppingCart) {
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItems()) {
            DBClient.INSTANCE.deleteObject(shoppingCartItem);
        }
    }
}
