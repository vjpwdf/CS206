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

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getShoppingCartItemId() {
        return shoppingCartItemId;
    }

    public void setShoppingCartItemId(int shoppingCartItemId) {
        this.shoppingCartItemId = shoppingCartItemId;
    }
}
