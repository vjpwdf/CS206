package hibernate;

import java.util.Date;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 1:01:12 PM
 */
public class ShoppingCart {
    private Date creationDate;
    private User user;
    private int shoppingCartId;

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
}
