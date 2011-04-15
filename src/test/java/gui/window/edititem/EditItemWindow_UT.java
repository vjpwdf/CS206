package gui.window.edititem;

import gui.window.WindowTest;
import hibernate.Item;
import hibernate.dao.ItemDaoImpl;
import hibernate.serviceadaptor.ItemServiceAdaptor;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditItemWindow_UT extends WindowTest{
    private EditItemWindow removeItemWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 600;

    @Mock
    ItemDaoImpl itemDao;

    @Mock
    Blob imageBlob;

    @Before
    public void setUp() {
        initMocks(this);
        ItemServiceAdaptor.setItemDAO(itemDao);
        removeItemWindow = new EditItemWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Edit A Item", removeItemWindow.getTitle());
        assertEquals((double) WIDTH, removeItemWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, removeItemWindow.getSize().getHeight());
    }

    @Test
    public void testEditItem() throws SQLException, FileNotFoundException {
        Item item= getAnItem();
        item.setItemImage(imageBlob);
        when(itemDao.getAllItems()).thenReturn(Arrays.asList(item));
        when(imageBlob.getBytes(Mockito.anyLong(), Mockito.anyInt())).thenReturn(convertFileToByteArray(new File("test.png")));
        removeItemWindow = new EditItemWindow();
        assertEquals(1, removeItemWindow.getTable().getRowCount());
        assertFalse(removeItemWindow.getEdit().isEnabled());
        assertFalse(removeItemWindow.getRemove().isEnabled());
        removeItemWindow.getTable().changeSelection(0,0, false, false);
        assertTrue(removeItemWindow.getEdit().isEnabled());
        assertTrue(removeItemWindow.getRemove().isEnabled());
        assertEquals(ImageIcon.class, removeItemWindow.getModel().getColumnClass(0));
        assertEquals(item.getItemName(), removeItemWindow.getModel().getValueAt(0,1));
        assertEquals(item.getItemManufacturer(), removeItemWindow.getModel().getValueAt(0,2));
        assertEquals("$" + String.valueOf(item.getItemPrice()), removeItemWindow.getModel().getValueAt(0,3));
    }
}