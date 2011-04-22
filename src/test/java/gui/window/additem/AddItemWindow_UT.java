package gui.window.additem;

import gui.MessageBuilder;
import gui.action.general.AddItemActionListener;
import gui.input.action.GenericBrowseButtonActionListener;
import gui.window.WindowTest;
import hibernate.Item;
import hibernate.dao.ItemDaoImpl;
import hibernate.serviceadaptor.ItemServiceAdaptor;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import utility.TestUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddItemWindow_UT extends WindowTest{
    private AddItemWindow addItemWindow;
    private Integer WIDTH = 600;
    private Integer HEIGHT = 330;

    @Mock
    Blob imageBlob;

    @Mock
    ItemDaoImpl itemDao;

    @Mock
    ItemServiceAdaptor itemServiceAdaptor;

    @Mock
    MessageBuilder messageBuilder;

    @Mock
    JFileChooser fileChooser;

    @Before
    public void setUp() {
        initMocks(this);
        ItemServiceAdaptor.setItemDAO(itemDao);
        addItemWindow = new AddItemWindow();
    }



    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Add An Item", addItemWindow.getTitle());
        assertEquals((double)WIDTH, addItemWindow.getSize().getWidth());
        assertEquals((double)HEIGHT, addItemWindow.getSize().getHeight());
        assertEquals(1, (((JRootPane)addItemWindow.getComponent(0))).getContentPane().getComponentCount());
        assertEquals(8, ((Box)(((JRootPane)addItemWindow.getComponent(0))).getContentPane().getComponent(0)).getComponentCount());
    }

    @Test
    public void testAddItemWithExistingItem() throws FileNotFoundException, SQLException {
        Item item = getAnItem();
        item.setItemImage(imageBlob);
        File file = new File("test.png");
        when(imageBlob.getBytes(Mockito.anyLong(), Mockito.anyInt())).thenReturn(convertFileToByteArray(file));
        when(fileChooser.getSelectedFile()).thenReturn(new File("test.png"));
        addItemWindow = new AddItemWindow(item);
        initializeMockedFileChooser();
        initializeActionListenerMock();
        addItemWindow.getFileBrowser().getInput().setText(file.getAbsolutePath());
        assertEquals(item.getItemName(), addItemWindow.getNameInput().getInput().getText());
        assertEquals(item.getItemDescription(), addItemWindow.getDescription().getInput().getText());
        assertEquals(item.getItemManufacturer(), addItemWindow.getManufacturer().getInput().getText());
        assertEquals(item.getItemPrice(), new Float(addItemWindow.getPriceInput().getInput().getText()));
        assertEquals(item.getItemUpc(), addItemWindow.getUpc().getInput().getText());
        addItemWindow.getFileBrowser().getBrowseButton().doClick();
        verify(fileChooser).setFileFilter(Mockito.<FileFilter>any());
        addItemWindow.getAddItem().doClick();
        verify(itemDao).saveItem(item);
        verify(messageBuilder).displayMessage("Item has been successfully added/updated to/in the database.");
    }

    private void initializeMockedFileChooser() {
        GenericBrowseButtonActionListener browseAction = (GenericBrowseButtonActionListener)addItemWindow.getFileBrowser().getBrowseButton().getActionListeners()[0];
        assertTrue(browseAction.getFileFilter().accept(new File("test.jpg")));
        assertEquals("*.jpg, *.png, *.jpeg, *.bmp", browseAction.getFileFilter().getDescription());
        fileChooser.showOpenDialog(null);
        browseAction.setFileChooser(fileChooser);
    }

    private void initializeActionListenerMock() {
        AddItemActionListener addItemActionListener = (AddItemActionListener)addItemWindow.getAddItem().getActionListeners()[0];
        addItemActionListener.setMessageBuilder(messageBuilder);
    }

    @Test
    public void testAddItemAfterFormIsFilled() throws FileNotFoundException, SQLException {
        addItemWindow = new AddItemWindow();
        initializeActionListenerMock();
        addItemWindow.getManufacturer().getInput().setText("test");
        addItemWindow.getPriceInput().getInput().setText("1.25");
        addItemWindow.getUpc().getInput().setText("test");
        addItemWindow.getDescription().getInput().setText("test");
        addItemWindow.getNameInput().getInput().setText("test");
        File file = new File("test.png");
        addItemWindow.getFileBrowser().getInput().setText(file.getAbsolutePath());
        addItemWindow.getAddItem().doClick();
        verify(itemDao).saveItem(Mockito.<Item>any());
        verify(messageBuilder).displayMessage("Item has been successfully added/updated to/in the database.");
    }
}
