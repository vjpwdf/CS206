package hibernate.dao;

import hibernate.Item;
import hibernate.factory.DBClient;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDaoImpl implements ItemDao {

    public void saveItem(Item item) {
        DBClient.INSTANCE.saveObject(item);
    }

    public void removeItem(String itemUpc) {
        Item item = (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + itemUpc + "'");
        DBClient.databaseSession.getCurrentSession().delete(item);
    }

    public List<Item> getAllItems() {
        return (List<Item>)DBClient.INSTANCE.getListOfObjects("from Item");
    }

    public Item getItemByUpc(String itemUpc) {
        return (Item)DBClient.INSTANCE.getObject("from Item item where item.itemUpc = " + "'" + itemUpc + "'");
    }
}
