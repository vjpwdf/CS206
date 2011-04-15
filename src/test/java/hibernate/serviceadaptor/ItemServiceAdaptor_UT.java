package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.dao.ItemDao;
import hibernate.dao.ItemDaoImpl;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

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
        initMocks(this);
        ItemServiceAdaptor.setItemDAO(itemDao);
        ItemServiceAdaptor itemServiceAdaptor = new ItemServiceAdaptor();
        assertNotNull(itemServiceAdaptor);
    }

    @Test
    public void testSaveItem() throws Exception {
        Item item = new Item();
        ItemServiceAdaptor.saveItem("test", "1.25", "test", "test", "test", null, item);
        verify(itemDao).saveItem(item);
    }

    @Test
    public void testSaveItemWithItemNull() throws Exception {
        Item item = null;
        ItemServiceAdaptor.saveItem("test", "1.25", "test", "test", "test", null, item);
        verify(itemDao).saveItem(any(Item.class));
    }

    @Test
    public void testSaveItemWithImage() throws Exception {
        File file = new File("test.png");

        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
            }
        } catch (IOException ex) {
        }

        Item item = new Item();
        ItemServiceAdaptor.saveItem("test", "1.25", "test", "test", "test", bos.toByteArray(), item);
        verify(itemDao).saveItem(item);
    }

    @Test
    public void testGetAllItems() throws Exception {
        ItemServiceAdaptor.getAllItems();
        verify(itemDao).getAllItems();
    }

    @Test
    public void testRemoveItem() throws Exception {
        Item item = new Item();
        ItemServiceAdaptor.removeItem(item);
        verify(itemDao).removeItem(item.getItemUpc());
    }
}
