package gui.window.viewallshoppingcarts;

import gui.MessageBuilder;
import gui.action.shoppingcart.RemoveShoppingCartButtonAction;
import gui.window.WindowTest;
import hibernate.ShoppingCart;
import hibernate.dao.ShoppingCartDaoImpl;
import hibernate.serviceadaptor.ShoppingCartServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ViewAllShoppingCartsWindow_UT extends WindowTest{
    private ViewAllShoppingCartsWindow viewAllShoppingCartsWindow;
    private Integer WIDTH = 550;
    private Integer HEIGHT = 330;

    @Mock
    private ShoppingCartDaoImpl shoppingCartDao;

    @Mock
    private MessageBuilder messageBuilder;

    @Before
    public void setUp() {
        initMocks(this);
        ShoppingCartServiceAdaptor.setShoppingCartDao(shoppingCartDao);
        viewAllShoppingCartsWindow = new ViewAllShoppingCartsWindow();
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("View All Shopping Carts", viewAllShoppingCartsWindow.getTitle());
        assertEquals((double) WIDTH, viewAllShoppingCartsWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, viewAllShoppingCartsWindow.getSize().getHeight());
    }

    @Test
    public void testShoppingCartWindow() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCreationDate(new Date());
        shoppingCart.setShoppingCartId(10);
        when(shoppingCartDao.getAllShoppingCarts()).thenReturn(Arrays.asList(shoppingCart));
        viewAllShoppingCartsWindow = new ViewAllShoppingCartsWindow();
        initializeMockedRemoveShoppingCartButtonAction();
        assertEquals(1, viewAllShoppingCartsWindow.getShoppingCarts().getRowCount());
        assertFalse(viewAllShoppingCartsWindow.getComputeSavingsButton().isEnabled());
        assertFalse(viewAllShoppingCartsWindow.getEditShoppingCartButton().isEnabled());
        assertFalse(viewAllShoppingCartsWindow.getRemoveShoppingCartButton().isEnabled());
        viewAllShoppingCartsWindow.getShoppingCarts().changeSelection(0,0,false,false);
        assertTrue(viewAllShoppingCartsWindow.getComputeSavingsButton().isEnabled());
        assertTrue(viewAllShoppingCartsWindow.getEditShoppingCartButton().isEnabled());
        assertTrue(viewAllShoppingCartsWindow.getRemoveShoppingCartButton().isEnabled());
        viewAllShoppingCartsWindow.getRemoveShoppingCartButton().doClick();
        verify(shoppingCartDao).removeShoppingCart(shoppingCart);
        verify(messageBuilder).displayMessage("Shopping cart has been successfully removed from the database.");
    }

    public void initializeMockedRemoveShoppingCartButtonAction() {
        RemoveShoppingCartButtonAction removeShoppingCartButtonAction = (RemoveShoppingCartButtonAction)viewAllShoppingCartsWindow.getRemoveShoppingCartButton().getActionListeners()[0];
        removeShoppingCartButtonAction.setMessageBuilder(messageBuilder);
    }
}