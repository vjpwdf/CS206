package hibernate;

import java.sql.Blob;
import java.util.Set;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 12:59:50 PM
 */
public class Item {
    private String itemUpc;
    private Blob itemImage;
    private String itemManufacturer;
    private String itemDescription;
    private String itemName;
    private float itemPrice;
    private Set<Coupon> itemCoupons;

    /**
     * Gets the coupons associated with an item
     * @return the coupons associated with an item
     */
    public Set<Coupon> getItemCoupons() {
        return itemCoupons;
    }

    /**
     * Sets the coupons associated with an item
     * @param itemCoupons coupons associated with an item
     */
    public void setItemCoupons(Set<Coupon> itemCoupons) {
        this.itemCoupons = itemCoupons;
    }

    /**
     * Gets the price of an item
     * @return  the price of an item
     */
    public float getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the price of an item
     * @param itemPrice the price of an item
     */
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Gets the upc of an item
     * @return the upc of an item
     */
    public String getItemUpc() {
        return itemUpc;
    }

    /**
     * Sets the upc of an item
     * @param itemUpc the upc of an item
     */
    public void setItemUpc(String itemUpc) {
        this.itemUpc = itemUpc;
    }

    /**
     * Gets the image of the item
     * @return the image of the item
     */
    public Blob getItemImage() {
        return itemImage;
    }

    /**
     * Sets the image of the item
     * @param itemImage the image of the item
     */
    public void setItemImage(Blob itemImage) {
        this.itemImage = itemImage;
    }

    /**
     * Gets the item manufacturer
     * @return the item manufacturer
     */
    public String getItemManufacturer() {
        return itemManufacturer;
    }

    /**
     * Sets the item manufacturer
     * @param itemManufacturer the item manufacturer
     */
    public void setItemManufacturer(String itemManufacturer) {
        this.itemManufacturer = itemManufacturer;
    }

    /**
     * Gets the item description
     * @return the item description
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Sets the item description
     * @param itemDescription the item description
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    /**
     * Gets the items name
     * @return the items name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the items name
     * @param itemName the items name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Float.compare(item.itemPrice, itemPrice) != 0) return false;
        if (itemDescription != null ? !itemDescription.equals(item.itemDescription) : item.itemDescription != null)
            return false;
        if (itemImage != null ? !itemImage.equals(item.itemImage) : item.itemImage != null) return false;
        if (itemManufacturer != null ? !itemManufacturer.equals(item.itemManufacturer) : item.itemManufacturer != null)
            return false;
        if (itemName != null ? !itemName.equals(item.itemName) : item.itemName != null) return false;
        if (itemUpc != null ? !itemUpc.equals(item.itemUpc) : item.itemUpc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemUpc != null ? itemUpc.hashCode() : 0;
        result = 31 * result + (itemImage != null ? itemImage.hashCode() : 0);
        result = 31 * result + (itemManufacturer != null ? itemManufacturer.hashCode() : 0);
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemPrice != +0.0f ? Float.floatToIntBits(itemPrice) : 0);
        return result;
    }

    @Override
    public String toString(){
        return itemName+" - "+itemManufacturer;
    }
}
