package hibernate.dao;

import hibernate.Item;
import hibernate.ShoppingCartItem;
import hibernate.factory.DBClient;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 */
public class ItemDaoImpl implements ItemDao {

    /**
     * Saves an item to the database
     * @param item item object to save to the database
     */
    public void saveItem(Item item) {
        DBClient.INSTANCE.saveObject(item);
    }

    /**
     * Removes and item from the database based upon its unique id
     * @param itemUpc unique id of the item
     */
    public void removeItem(String itemUpc) {
        Item item = (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + itemUpc + "'");
        removeAllShoppingCartItemsAssociatedWithItem(item);
        DBClient.INSTANCE.deleteObject(item);
    }

    private void removeAllShoppingCartItemsAssociatedWithItem(Item item) {
        List<ShoppingCartItem> shoppingCartItems = (List<ShoppingCartItem>)DBClient.INSTANCE.getListOfObjects("from ShoppingCartItem sci where sci.item.itemUpc = " + "'" + item.getItemUpc() + "'");
        int size = shoppingCartItems.size();
        for(int i = 0; i < size; i++) {
            DBClient.INSTANCE.deleteObject(shoppingCartItems.get(i));
        }
        System.out.println();
    }

    /**
     * Gets all items from the database
     * @return a list of all items from the database
     */
    @SuppressWarnings("unchecked")
    public List<Item> getAllItems() {
        return (List<Item>)DBClient.INSTANCE.getListOfObjects("from Item");
    }

    /**
     * Gets an item from the database based upon the unique id of the item
     * @param itemUpc unique id of the item
     * @return an item object from the database
     */
    public Item getItemByUpc(String itemUpc) {
        return (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + itemUpc + "'");
    }
}
