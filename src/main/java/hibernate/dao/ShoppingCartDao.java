package hibernate.dao;

import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 3/13/11
 * Time: 12:14 PM
 */
public interface ShoppingCartDao {
    /**
     * Adds a shopping cart to the database with a list of shopping cart items
     * @param shoppingCartItems items to add to the shopping cart and persist in the database
     * @param userName user who the shopping cart belongs to
     * @return the shopping cart saved to the database
     */
    public ShoppingCart addShoppingCartFromListOfShoppingCartItems(List<ShoppingCartItem> shoppingCartItems, String userName);

    /**
     * Gets all the shopping carts from the database
     * @return a list of all shopping carts from the database
     */
    public List<ShoppingCart> getAllShoppingCarts();

    /**
     * Adds an empty shopping cart to the database
     * @param userName user to add shopping cart for
     */
    public void addEmptyShoppingCart(String userName);

    /**
     * Removes a shopping cart from the database
     * @param shoppingCart shopping cart to remove from the database
     */
    public void removeShoppingCart(ShoppingCart shoppingCart);

    /**
     * Updates a shopping cart from the database
     * @param shoppingCart shopping cart to update
     * @param shoppingCartItems list of shopping cart items to update
     */
    public void updateShoppingCart(ShoppingCart shoppingCart, List<ShoppingCartItem> shoppingCartItems);
}
