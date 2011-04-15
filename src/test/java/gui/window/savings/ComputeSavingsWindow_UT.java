package gui.window.savings;

import gui.window.WindowTest;
import hibernate.Coupon;
import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/13/11
 * Time: 12:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputeSavingsWindow_UT extends WindowTest {
    private ComputeSavingsWindow computeSavingsWindow;
    private ShoppingCartItem shoppingCartItem;
    private ShoppingCart shoppingCart;
    private final int WIDTH = 525;
    private final int HEIGHT = 600;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
        shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setItem(getAnItem());
        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(Arrays.asList(shoppingCartItem)));
        computeSavingsWindow = new ComputeSavingsWindow(shoppingCart);
    }

    @Test
    public void testComputeSavingsWindowParametersAreCorrect() {
        assertEquals("Savings For Shopping Cart", computeSavingsWindow.getTitle());
        assertEquals(WIDTH, computeSavingsWindow.getWidth());
        assertEquals(HEIGHT, computeSavingsWindow.getHeight());
        assertEquals("No Coupons Applied", computeSavingsWindow.getTabbedPane().getTitleAt(0));
        assertEquals("Coupons Applied", computeSavingsWindow.getTabbedPane().getTitleAt(1));
        JTextArea jTextArea = (JTextArea)computeSavingsWindow.getCouponsAppliedPanel().getComponent(0);
        JTextArea noCouponsText = (JTextArea)computeSavingsWindow.getNoCouponsAppliedPanel().getComponent(0);
        assertEquals("Item Name\t\tQuantity\t\tTotal\n" + "\n" + "test name\t0\t\t0.0\n" + "\n" + "\n" +
            "Total:\t\t\t\t0.0", noCouponsText.getText());
        assertEquals("Item Name\t\tQuantity\t\tTotal\n" + "\n" + "test name\t0\t\t0.0\n" + "\t\t-25.0%\t\t-0.0\n" + "\n" +
            "\n" + "Total:\t\t\t\t0.0", jTextArea.getText());
    }
}
