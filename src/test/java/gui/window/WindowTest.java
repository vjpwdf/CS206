package gui.window;

import hibernate.Coupon;
import hibernate.Item;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;
import hibernate.dao.DaoTest;
import hibernate.factory.DBClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/11/11
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class WindowTest extends DaoTest{

    public Item getAnItem() {
        Item item = new Item();
        item.setItemDescription("test item");
        item.setItemManufacturer("test manufacturer");
        item.setItemName("test name");
        item.setItemPrice(2.25f);
        item.setItemUpc("123456789");
        item.setItemCoupons(new HashSet(Arrays.asList(getACoupon())));
        item.setItemImage(null);
        return item;
    }

    public ShoppingCartItem getAShoppingCartItem() {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setItem(getAnItem());
        shoppingCartItem.setItemQuantity(5);
        return shoppingCartItem;
    }

//    public ShoppingCart getAShoppingCart() {
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.setShoppingCartItems(new HashSet<ShoppingCartItem>(Arrays.asList(getAShoppingCartItem())));
//        return shoppingCart;
//    }

    public Coupon getACoupon() {
        Coupon coupon = new Coupon();
        coupon.setCouponValue(25f);
        coupon.setCouponType(true);
        coupon.setExpirationDate(new Date());
        return coupon;
    }
}
