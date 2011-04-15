package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.dao.ItemDao;
import hibernate.dao.ItemDaoImpl;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:03 PM
 */
public class ItemServiceAdaptor {

    private static ItemDao itemDAO = new ItemDaoImpl();

    /**
     * Saves an item to the database
     * @param name name of the item
     * @param price price of the item
     * @param upcVal upc of the item
     * @param descriptionVal description of the item
     * @param manufacturerVal manufacturer of the item
     * @param image item image if available
     * @param item item to update - not necessary if adding
     */
    public static void saveItem(String name, String price, String upcVal, String descriptionVal, String manufacturerVal, byte[] image, Item item) {
        if (item == null) {
            item = new Item();
        }
        item.setItemName(name);
        item.setItemUpc(upcVal);
        item.setItemPrice(Float.valueOf(price));
        item.setItemDescription(descriptionVal);
        if (image != null) {
            item.setItemImage(Hibernate.createBlob(image));
        }
        item.setItemManufacturer(manufacturerVal);
        itemDAO.saveItem(item);
    }

    /**
     * Gets all items from the database
     * @return a list of all items from the database
     */
    @SuppressWarnings("unchecked")
    public static List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    /**
     * Removes and item from the database
     * @param item item object
     */
    public static void removeItem(Item item) {
        itemDAO.removeItem(item.getItemUpc());
    }

    /**
     * Sets the static item dao for the service adaptor to use statically
     * @param itemDao item dao to set
     */
    public static void setItemDAO (ItemDaoImpl itemDao) {
        ItemServiceAdaptor.itemDAO = itemDao;
    }
}
