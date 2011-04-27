package gui.window.edititem;

import hibernate.Item;

import javax.swing.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/04/11
 * Time: 8:34 PM
 */
public class TableDataConverter {
    /**
     * Converts a list of objects to a 2d object array
     * @param items a list of items to a 2d object array
     * @return a list of objects to a 2d object array
     */
    public Object[][] convertToObjectArray(List<Item> items) {
        Object[][] data = new Object[items.size()][4];
        for (int i = 0; i < items.size(); i++) {
            convertItemToObjectArray(items, data, i);
        }
        return data;
    }

    /**
     * Converts an item to an object array
     * @param items a list of all items
     * @param data current 2d object array
     * @param i current index
     */
    private void convertItemToObjectArray(List<Item> items, Object[][] data, int i) {
        Item item = items.get(i);
        Blob image = item.getItemImage();
        data[i][0] = "No Image";
        if (image != null) {
            try {
                byte[] bytes = image.getBytes(1, (int) image.length());
                ImageIcon imageIcon = new ImageIcon(bytes);
                data[i][0] = imageIcon;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        data[i][1] = item.getItemName();
        data[i][2] = item.getItemManufacturer();
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        data[i][3] = "$" + df.format(item.getItemPrice());
    }
}
