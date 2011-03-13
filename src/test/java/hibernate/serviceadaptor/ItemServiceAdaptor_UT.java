package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.dao.ItemDao;
import hibernate.dao.ItemDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 3/13/11
 * Time: 2:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemServiceAdaptor_UT {
    @Mock
    private ItemDaoImpl itemDao;

    @Before
    public void setUp() {

    }

    @Test
    public void testSaveItem() throws Exception {
        Item item = new Item();
        ItemServiceAdaptor.saveItem("test", "1.25", "test", "test", "test", null, item);
        verify(itemDao).saveItem(item);
    }

    @Test
    public void testGetAllItems() throws Exception {

    }

    @Test
    public void testRemoveItem() throws Exception {

    }
}
