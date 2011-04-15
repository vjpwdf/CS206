package hibernate.dao;

import hibernate.Item;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 */
public interface ItemDao {
    /**
     * Saves an item to the database
     * @param item item object to save to the database
     */
    public void saveItem(Item item);

    /**
     * Removes and item from the database based upon its unique id
     * @param itemUpc unique id of the item
     */
    public void removeItem(String itemUpc);

    /**
     * Gets all items from the database
     * @return a list of all items from the database
     */
    public List<Item> getAllItems();

    /**
     * Gets an item from the database based upon the unique id of the item
     * @param itemUpc unique id of the item
     * @return an item object from the database
     */
    public Item getItemByUpc(String itemUpc);
}
