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

    public Set<Coupon> getItemCoupons() {
        return itemCoupons;
    }

    public void setItemCoupons(Set<Coupon> itemCoupons) {
        this.itemCoupons = itemCoupons;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemUpc() {
        return itemUpc;
    }

    public void setItemUpc(String itemUpc) {
        this.itemUpc = itemUpc;
    }

    public Blob getItemImage() {
        return itemImage;
    }

    public void setItemImage(Blob itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemManufacturer() {
        return itemManufacturer;
    }

    public void setItemManufacturer(String itemManufacturer) {
        this.itemManufacturer = itemManufacturer;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

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
}
