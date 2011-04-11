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

    private static ItemDao itemDAO = new ItemDaoImpl();

    public static void saveItem(String name, String price, String upcVal, String descriptionVal, String manufacturerVal, byte[] image, Item item) {
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

    @SuppressWarnings("unchecked")
    public static List<Item> getAllItems() {
        return itemDAO.getAllItems();
    }

    public static void removeItem(Item item) {
        itemDAO.removeItem(item.getItemUpc());
    }

    public static void setItemDAO (ItemDaoImpl itemDao) {
        ItemServiceAdaptor.itemDAO = itemDao;
    }
}
