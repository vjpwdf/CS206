package hibernate;

import java.sql.Blob;

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
}
