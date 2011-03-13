package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.dao.ItemDao;
import hibernate.dao.ItemDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    }

    @Test
    public void testSaveItem() throws Exception {
        Item item = new Item();
        ItemServiceAdaptor.saveItem("test", "1.25", "test", "test", "test", null, item);
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

    @Test
    public void testConvertBufferedImageToBlob() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/images/check.png"));
    }
}
