package hibernate;

import java.util.Date;
import java.util.Set;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 1:01:12 PM
 */
public class ShoppingCart {
    private Date creationDate;
    private User user;
    private int shoppingCartId;
    private Set<ShoppingCartItem> shoppingCartItems;

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }

    public Set<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        if (shoppingCartItems != null ? !shoppingCartItems.equals(that.shoppingCartItems) : that.shoppingCartItems != null)
            return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (shoppingCartItems != null ? shoppingCartItems.hashCode() : 0);
        return result;
    }
}
