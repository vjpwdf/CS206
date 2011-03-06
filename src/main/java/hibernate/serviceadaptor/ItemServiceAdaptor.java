package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.dao.ItemDao;
import hibernate.dao.ItemDaoImpl;
import hibernate.factory.DBClient;
import org.hibernate.Hibernate;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.sql.Blob;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemServiceAdaptor {

    private static final ItemDao itemDAO = new ItemDaoImpl();

    public void saveItem(String name, String price, String upcVal, String descriptionVal, String manufacturerVal, byte[] image, Item item) {
        if (item == null) {
            item = new Item();
        }
        item.setItemName(name);
        item.setItemUpc(upcVal);
        item.setItemPrice(Float.valueOf(price));
        item.setItemDescription(descriptionVal);
        if (image != null) {
            item.setItemImage(Hibernate.createBlob(image));
        }
        item.setItemManufacturer(manufacturerVal);
        itemDAO.saveItem(item);
    }

    private Blob convertBufferedImageToBlob(BufferedImage image) {
        byte[] buffer = ((DataBufferByte) (image).getRaster().getDataBuffer()).getData();
        return Hibernate.createBlob(buffer);
    }

    @SuppressWarnings("unchecked")
    public List<Item> getAllItems() {
        return (List<Item>) DBClient.INSTANCE.getListOfObjects("from Item");
    }

    public void removeItem(Item item) {
        DBClient.INSTANCE.deleteObject(item);
    }
}
