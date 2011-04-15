package gui.window.buildshoppingcart;

import gui.window.WindowTest;
import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import hibernate.dao.DaoTest;
import hibernate.dao.ItemDaoImpl;
import hibernate.serviceadaptor.ItemServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuildShoppingCartWindow_UT extends WindowTest{
    @Mock
    ItemDaoImpl itemDao;
    @Mock
    Blob imageBlob;

    private BuildShoppingCartWindow buildShoppingCartWindow;
    private Integer WIDTH = 500;
    private Integer HEIGHT = 600;

    @Before
    public void setUp() {
        initMocks(this);
        ItemServiceAdaptor.setItemDAO(itemDao);
    }

    @Test
    public void testProperAttributesAreSet() {
        buildShoppingCartWindow = new BuildShoppingCartWindow();
        assertEquals("Build A Shopping Cart", buildShoppingCartWindow.getTitle());
        assertEquals((double)WIDTH, buildShoppingCartWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, buildShoppingCartWindow.getSize().getHeight());
    }

    @Test
    public void testAddShoppingCartItem() throws IOException, SQLException {
        Item item = getAnItem();
        item.setItemImage(imageBlob);
        when(itemDao.getAllItems()).thenReturn(Arrays.asList(item));
        when(imageBlob.getBytes(Mockito.anyLong(), Mockito.anyInt())).thenReturn(convertFileToByteArray(new File("test.png")));
        buildShoppingCartWindow = new BuildShoppingCartWindow();
        assertFalse(buildShoppingCartWindow.getAddItemToCartButton().isEnabled());

        buildShoppingCartWindow.getItemTable().setVisible(true);
        buildShoppingCartWindow.getItemTable().changeSelection(0,0,false, false);

        assertTrue(buildShoppingCartWindow.getAddItemToCartButton().isEnabled());

        assertEquals(0, buildShoppingCartWindow.getShoppingCartTable().getRowCount());

        buildShoppingCartWindow.getAddItemToCartButton().doClick();

        assertEquals(1, buildShoppingCartWindow.getShoppingCartTable().getRowCount());
    }

    @Test
    public void testRemoveShoppingCartItem() throws IOException, SQLException {
        Item item = getAnItem();
        item.setItemImage(imageBlob);
        when(itemDao.getAllItems()).thenReturn(Arrays.asList(item));
        when(imageBlob.getBytes(Mockito.anyLong(), Mockito.anyInt())).thenReturn(convertFileToByteArray(new File("test.png")));

        buildShoppingCartWindow = new BuildShoppingCartWindow();
        assertFalse(buildShoppingCartWindow.getRemoveItemFromCartButton().isEnabled());
        buildShoppingCartWindow.getItemTable().changeSelection(0, 0, false, false);
        buildShoppingCartWindow.getAddItemToCartButton().doClick();
        buildShoppingCartWindow.getShoppingCartTable().changeSelection(0,0,false,false);
        assertTrue(buildShoppingCartWindow.getRemoveItemFromCartButton().isEnabled());
        buildShoppingCartWindow.getRemoveItemFromCartButton().doClick();
        assertEquals(0, buildShoppingCartWindow.getShoppingCartTable().getRowCount());
    }

    @Test
    public void testShoppingCartWindowWithExistingShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCartItem shoppingCartItem = getAShoppingCartItem();
        List<ShoppingCartItem> shoppingCartItems = Arrays.asList(shoppingCartItem);
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(shoppingCartItems));
        buildShoppingCartWindow = new BuildShoppingCartWindow(shoppingCart);
        assertEquals(1, buildShoppingCartWindow.getShoppingCartTable().getRowCount());

    }

    @Test
    public void testShoppingCartWindowAbstractModel() throws SQLException, FileNotFoundException {
        Item item = getAnItem();
        item.setItemImage(imageBlob);
        when(itemDao.getAllItems()).thenReturn(Arrays.asList(item));
        when(imageBlob.getBytes(Mockito.anyLong(), Mockito.anyInt())).thenReturn(convertFileToByteArray(new File("test.png")));
        buildShoppingCartWindow = new BuildShoppingCartWindow();
        assertEquals(item.getItemName(), buildShoppingCartWindow.getModel().getValueAt(0,1));
        assertTrue(buildShoppingCartWindow.getModel().getValueAt(0,0) instanceof ImageIcon);
        assertTrue(buildShoppingCartWindow.getModel().getColumnClass(0).equals(ImageIcon.class));
    }
}
