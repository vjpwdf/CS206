package hibernate;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 1:01:20 PM
 */
public class ShoppingCartItem {
    private int shoppingCartItemId;
    private ShoppingCart shoppingCart;
    private Item item;
    private int itemQuantity;

    /**
     * Gets the quantity of the item
     * @return the quantity of the item
     */
    public int getItemQuantity() {
        return itemQuantity;
    }

    /**
     * Sets the quantity of the item
     * @param itemQuantity the quantity of the item
     */
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    /**
     * Gets the item of the shopping cart item
     * @return the item of the shopping cart item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the item of the shopping cart item
     * @param item the item of the shopping cart item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Gets the shopping cart the shopping cart item belongs to
     * @return the shopping cart the shopping cart item belongs to
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Sets the shopping cart the shopping cart item belongs to
     * @param shoppingCart the shopping cart the shopping cart item belongs to
     */
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Gets the id of the shopping cart item
     * @return the id of the shopping cart item
     */
    public int getShoppingCartItemId() {
        return shoppingCartItemId;
    }

    /**
     * Sets the id of the shopping cart item
     * @param shoppingCartItemId the id of the shopping cart item
     */
    public void setShoppingCartItemId(int shoppingCartItemId) {
        this.shoppingCartItemId = shoppingCartItemId;
    }
}
