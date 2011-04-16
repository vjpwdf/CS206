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

    /**
     * Gets the shopping cart id
     * @return the shopping cart id
     */
    public int getShoppingCartId() {
        return shoppingCartId;
    }

    /**
     * Sets the shopping cart id
     * @param shoppingCartId the shopping cart id
     */
    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    /**
     * Gets the owner of the shopping cart
     * @return the owner of the shopping cart
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the owner of the shopping cart
     * @param user the owner of the shopping cart
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the creation date of the shopping cart
     * @return the creation date of the shopping cart
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the shopping cart
     * @param creationDate the creation date of the shopping cart
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets the shopping cart items for the shopping cart
     * @param shoppingCartItems the shopping cart items for the shopping cart
     */
    public void setShoppingCartItems(Set<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
    }

    /**
     * Gets the shopping cart items for the shopping cart
     * @return the shopping cart items for the shopping cart
     */
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
}
