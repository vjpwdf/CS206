package gui.window;

import hibernate.factory.DBClient;
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
 * Date: 4/11/11
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate/config.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class WindowTest {
    @Autowired
    public void setDbClient(DBClient dbClient) {
        DBClient.INSTANCE = dbClient;
    }

    @Test
    public void testSessionFactoryIsNotNull() {
        assertNotNull(DBClient.INSTANCE);
        assertNotNull(DBClient.databaseSession);
    }
}
