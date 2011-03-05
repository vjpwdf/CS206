package hibernate.dao;

import hibernate.Item;
import hibernate.factory.DBClient;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate/config.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public abstract class DaoTest {

    @Autowired
    public void setDbClient(DBClient dbClient){
        DBClient.INSTANCE = dbClient;
    }

    @Test
    public void testSessionFactoryIsNotNull() {
        assertNotNull(DBClient.INSTANCE);
        assertNotNull(DBClient.databaseSession);
    }

    public void addItem(String itemUpc, String itemName, String itemDescription, String itemManufacturer) {
        Item item = new Item();
        item.setItemUpc(itemUpc);
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        item.setItemManufacturer(itemManufacturer);
        DBClient.databaseSession.getCurrentSession().save(item);
    }
}
