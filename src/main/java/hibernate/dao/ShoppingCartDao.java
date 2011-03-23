package hibernate.dao;

import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 3/13/11
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ShoppingCartDao {
    public void addShoppingCartFromListOfShoppingCartItems(List<ShoppingCartItem> shoppingCartItems, String userName);
    public List<ShoppingCart> getAllShoppingCarts();
    public void addEmptyShoppingCart(String userName);
}
