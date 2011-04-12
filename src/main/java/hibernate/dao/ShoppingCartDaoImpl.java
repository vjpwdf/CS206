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
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartDaoImpl implements ShoppingCartDao {
    public void addShoppingCartFromListOfShoppingCartItems(List<ShoppingCartItem> shoppingCartItems, String userName) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = (User) DBClient.INSTANCE.getObject("from User user where user.userName = " + "'" + userName + "'");
        shoppingCart.setCreationDate(new Date());
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItems));
        shoppingCart.setUser(user);
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            shoppingCartItem.setShoppingCart(shoppingCart);
        }
        DBClient.INSTANCE.saveObject(shoppingCart);
    }

    public List<ShoppingCart> getAllShoppingCarts() {
        return (List<ShoppingCart>)DBClient.INSTANCE.getListOfObjects("from ShoppingCart");
    }

    public void addEmptyShoppingCart(String userName) {
        User user = (User)DBClient.INSTANCE.getObject("from User user where user.userName = " + "'" + userName + "'");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCreationDate(new Date());
        shoppingCart.setUser(user);
        DBClient.INSTANCE.saveObject(shoppingCart);
    }

    public void removeShoppingCart(ShoppingCart shoppingCart) {
        DBClient.INSTANCE.deleteObject(shoppingCart);
    }

    public void updateShoppingCart(ShoppingCart shoppingCart, List<ShoppingCartItem> shoppingCartItems) {
        removePreviousShoppingCartItems(shoppingCart);
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItems));
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            shoppingCartItem.setShoppingCart(shoppingCart);
        }
        DBClient.INSTANCE.saveObject(shoppingCart);
    }

    private void removePreviousShoppingCartItems(ShoppingCart shoppingCart) {
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItems()) {
            DBClient.INSTANCE.deleteObject(shoppingCartItem);
        }
    }
}
