package hibernate.dao;

import hibernate.Item;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ItemDao {
    public void saveItem(hibernate.Item item);
    public void removeItem(String itemUpc);
    public List<Item> getAllItems();
    public Item getItemByUpc(String itemUpc);
}
