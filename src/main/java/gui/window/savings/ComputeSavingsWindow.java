package gui.window.savings;

import hibernate.Coupon;
import hibernate.ShoppingCart;
import hibernate.ShoppingCartItem;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:31 PM
 */
public class ComputeSavingsWindow extends JFrame {
    private static final Integer WIDTH = 525;
    private static final Integer HEIGHT = 600;

    /**
     * Computes saving window
     * @param selectedShoppingCart shopping cart to compute savings up
     * @throws HeadlessException thrown if window could not be created
     */
    public ComputeSavingsWindow(ShoppingCart selectedShoppingCart) throws HeadlessException {
        setTitle("Savings For Shopping Cart");
        setSize(WIDTH, HEIGHT);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("No Coupons Applied", createNoCouponsAppliedPane(selectedShoppingCart));
        tabbedPane.addTab("Coupons Applied", createCouponsAppliedPane(selectedShoppingCart));
        add(tabbedPane);
    }

    /**
     * Creates the coupon applied pane
     * @param selectedShoppingCart shopping cart to get coupons applied pane
     * @return the coupon applied pane
     */
    private JPanel createCouponsAppliedPane(ShoppingCart selectedShoppingCart) {
        JPanel createCouponsAppliedPane = new JPanel();
        String couponsAppliedText = "Item Name\t\tQuantity\t\tTotal\n\n";
        float totalCartPrice = 0.0f;
        for (ShoppingCartItem shoppingCartItem : selectedShoppingCart.getShoppingCartItems()) {
            Set<Coupon> itemCoupons = shoppingCartItem.getItem().getItemCoupons();
            float totalItemPrice = shoppingCartItem.getItemQuantity() * shoppingCartItem.getItem().getItemPrice();
            totalCartPrice += totalItemPrice;
            couponsAppliedText += shoppingCartItem.getItem().getItemName() + "\t" + shoppingCartItem.getItemQuantity() + "\t\t" +
                    totalItemPrice + "\n";
            for (Coupon itemCoupon : itemCoupons) {
                if(itemCoupon.isCouponType()) {
                    totalCartPrice -= (totalItemPrice*itemCoupon.getCouponValue()*0.01);
                    couponsAppliedText += "\t\t-" + itemCoupon.getCouponValue() + "%\t\t-" + totalItemPrice*itemCoupon.getCouponValue()*0.01 + "\n";
                } else {
                    totalCartPrice -= (totalItemPrice-(totalItemPrice-itemCoupon.getCouponValue()));
                    couponsAppliedText += "\t\t-$" + itemCoupon.getCouponValue() + "\t\t-" + (totalItemPrice-(totalItemPrice-itemCoupon.getCouponValue())) + "\n";
                }
            }
        }
        couponsAppliedText += "\n\nTotal:\t\t\t\t" + totalCartPrice;
        JTextArea couponsAppliedTextArea = new JTextArea(couponsAppliedText);
        couponsAppliedTextArea.setBackground(getBackground());
        createCouponsAppliedPane.add(couponsAppliedTextArea);
        return createCouponsAppliedPane;
    }

    /**
     * Creates the no coupon applied pane
     * @param selectedShoppingCart shopping cart to get no coupons applied pane
     * @return the no coupon applied pane
     */
    private JPanel createNoCouponsAppliedPane(ShoppingCart selectedShoppingCart) {
        JPanel createNoCouponsAppliedPane = new JPanel();
        String noCouponsAppliedText = "Item Name\t\tQuantity\t\tTotal\n\n";
        float totalCartPrice = 0.0f;
        for (ShoppingCartItem shoppingCartItem : selectedShoppingCart.getShoppingCartItems()) {
            float totalItemPrice = shoppingCartItem.getItemQuantity() * shoppingCartItem.getItem().getItemPrice();
            totalCartPrice += totalItemPrice;
            noCouponsAppliedText += shoppingCartItem.getItem().getItemName() + "\t" + shoppingCartItem.getItemQuantity() + "\t\t" +
                    totalItemPrice + "\n";
        }
        noCouponsAppliedText += "\n\nTotal:\t\t\t\t" + totalCartPrice;
        JTextArea noCouponsAppliedTextArea = new JTextArea(noCouponsAppliedText);
        noCouponsAppliedTextArea.setBackground(getBackground());
        createNoCouponsAppliedPane.add(noCouponsAppliedTextArea);
        return createNoCouponsAppliedPane;
    }
}
