package gui.window.addcoupon;

import gui.window.WindowTest;
import hibernate.Item;
import hibernate.dao.CouponDaoImpl;
import hibernate.factory.DBClient;
import hibernate.serviceadaptor.CouponServiceAdaptor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 26/02/11
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */

public class AddCouponWindow_UT extends WindowTest{
    private AddCouponWindow addCouponWindow;
    private Integer WIDTH = 600;
    private Integer HEIGHT = 330;

    @Mock
    DBClient dbClient;

    @Mock
    CouponDaoImpl couponDao;

    @Before
    public void setUp() {
        addCouponWindow = new AddCouponWindow();
        initMocks(this);
        DBClient.INSTANCE = dbClient;
        CouponServiceAdaptor.setCouponDao(couponDao);
    }

    @Test
    public void testProperAttributesAreSet() {
        assertEquals("Add A Coupon", addCouponWindow.getTitle());
        assertEquals((double)WIDTH, addCouponWindow.getSize().getWidth());
        assertEquals((double) HEIGHT, addCouponWindow.getSize().getHeight());
        assertEquals(1, (((JRootPane) addCouponWindow.getComponent(0))).getContentPane().getComponentCount());
    }

    @Test
    public void testAddCouponWindow() {
        Item item = getAnItem();
        when(dbClient.getListOfObjects(Mockito.anyString())).thenReturn(Arrays.asList(item));
        addCouponWindow = new AddCouponWindow();
        Item itemFromDropdown = (Item)addCouponWindow.getItems().getSelectedObject();

        assertEquals(item, itemFromDropdown);
        assertEquals(2, addCouponWindow.getItems().getComponentCount());
        assertEquals(2, addCouponWindow.getType().getComponentCount());

        addCouponWindow.getValue().getInput().setText("1.25");
        addCouponWindow.getExpirationDate().getInput().setText("1/2/2011");
        addCouponWindow.getSaveOrUpdateCouponButton().doClick();
        verify(couponDao).addCoupon(item.getItemUpc(), true, 1.25f, new Date("Sun Jan 02 00:00:00 CST 2011"));
    }
}
