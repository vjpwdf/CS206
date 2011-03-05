package hibernate.dao;

import hibernate.Item;
import hibernate.factory.DBClient;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemDaoImpl implements ItemDao {

    @Override
    public void saveItem(Item item) {
        DBClient.INSTANCE.saveObject(item);
    }
}
