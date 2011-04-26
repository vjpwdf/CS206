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

    private JTabbedPane tabbedPane;
    private JPanel noCouponsAppliedPanel;
    private JPanel couponsAppliedPanel;

    private String couponsAppliedText;
    private String noCouponsAppliedText;
    /**
     * Computes saving window
     * @param selectedShoppingCart shopping cart to compute savings up
     * @throws HeadlessException thrown if window could not be created
     */
    public ComputeSavingsWindow(ShoppingCart selectedShoppingCart) throws HeadlessException {
        setTitle("Savings For Shopping Cart");
        setSize(WIDTH, HEIGHT);
        tabbedPane = new JTabbedPane();
        noCouponsAppliedPanel = createNoCouponsAppliedPane(selectedShoppingCart);
        couponsAppliedPanel = createCouponsAppliedPane(selectedShoppingCart);
        tabbedPane.addTab("No Coupons Applied", noCouponsAppliedPanel);
        tabbedPane.addTab("Coupons Applied", couponsAppliedPanel);
        add(tabbedPane);
    }

    /**
     * Creates the coupon applied pane
     * @param selectedShoppingCart shopping cart to get coupons applied pane
     * @return the coupon applied pane
     */
    private JPanel createCouponsAppliedPane(ShoppingCart selectedShoppingCart) {
        JPanel createCouponsAppliedPane = new JPanel();
        couponsAppliedText = "Item Name\t\tQuantity\t\tTotal\n\n";
        Float totalCartPrice = 0.0f;
        totalCartPrice = computeSavingsForShoppingCartItems(selectedShoppingCart, totalCartPrice);
        couponsAppliedText += "\n\nTotal:\t\t\t\t" + totalCartPrice;
        JTextArea couponsAppliedTextArea = new JTextArea(couponsAppliedText);
        couponsAppliedTextArea.setBackground(getBackground());
        createCouponsAppliedPane.add(couponsAppliedTextArea);
        return createCouponsAppliedPane;
    }

    /**
     * Computes the savings on a shopping cart
     * @param selectedShoppingCart the shopping cart
     * @param totalCartPrice total price of the shopping cart (with savings)
     * @return Float the total price after savings
     */
    private Float computeSavingsForShoppingCartItems(ShoppingCart selectedShoppingCart, Float totalCartPrice) {
        for (ShoppingCartItem shoppingCartItem : selectedShoppingCart.getShoppingCartItems()) {
            Set<Coupon> itemCoupons = shoppingCartItem.getItem().getItemCoupons();
            Float totalItemPrice = shoppingCartItem.getItemQuantity() * shoppingCartItem.getItem().getItemPrice();
            totalCartPrice += totalItemPrice;
            couponsAppliedText += shoppingCartItem.getItem().getItemName() + "\t" + shoppingCartItem.getItemQuantity() + "\t\t" +
                    totalItemPrice + "\n";
            totalCartPrice = computeSavingsForCoupons(totalCartPrice, itemCoupons, totalItemPrice);
        }
        return totalCartPrice;
    }

    /**
     * Computes savings on a shopping cart item
     * @param totalCartPrice the total cart price
     * @param itemCoupons the coupons on an item
     * @param totalItemPrice the total price of an item
     * @return Float the total price
     */
    private Float computeSavingsForCoupons(Float totalCartPrice, Set<Coupon> itemCoupons, Float totalItemPrice) {
        for (Coupon itemCoupon : itemCoupons) {
            if(itemCoupon.isCouponType()) {
                totalCartPrice -= (totalItemPrice*itemCoupon.getCouponValue()*0.01);
                couponsAppliedText += "\t\t-" + itemCoupon.getCouponValue() + "%\t\t-" + totalItemPrice*itemCoupon.getCouponValue()*0.01 + "\n";
            } else {
                totalCartPrice -= (totalItemPrice-(totalItemPrice-itemCoupon.getCouponValue()));
                couponsAppliedText += "\t\t-$" + itemCoupon.getCouponValue() + "\t\t-" + (totalItemPrice-(totalItemPrice-itemCoupon.getCouponValue())) + "\n";
            }
        }
        return totalCartPrice;
    }

    /**
     * Creates the no coupon applied pane
     * @param selectedShoppingCart shopping cart to get no coupons applied pane
     * @return the no coupon applied pane
     */
    private JPanel createNoCouponsAppliedPane(ShoppingCart selectedShoppingCart) {
        JPanel createNoCouponsAppliedPane = new JPanel();
        noCouponsAppliedText = "Item Name\t\tQuantity\t\tTotal\n\n";
        float totalCartPrice = 0.0f;
        totalCartPrice = computePricesForShoppingCartItems(selectedShoppingCart, totalCartPrice);
        noCouponsAppliedText += "\n\nTotal:\t\t\t\t" + totalCartPrice;
        JTextArea noCouponsAppliedTextArea = new JTextArea(noCouponsAppliedText);
        noCouponsAppliedTextArea.setBackground(getBackground());
        createNoCouponsAppliedPane.add(noCouponsAppliedTextArea);
        return createNoCouponsAppliedPane;
    }

    /**
     * Computes prices for shopping cart items (with no savings)
     * @param selectedShoppingCart the shopping cart
     * @param totalCartPrice the total cart price without savings applied
     * @return float the total price
     */
    private float computePricesForShoppingCartItems(ShoppingCart selectedShoppingCart, float totalCartPrice) {
        for (ShoppingCartItem shoppingCartItem : selectedShoppingCart.getShoppingCartItems()) {
            float totalItemPrice = shoppingCartItem.getItemQuantity() * shoppingCartItem.getItem().getItemPrice();
            totalCartPrice += totalItemPrice;
            noCouponsAppliedText += shoppingCartItem.getItem().getItemName() + "\t" + shoppingCartItem.getItemQuantity() + "\t\t" +
                    totalItemPrice + "\n";
        }
        return totalCartPrice;
    }

    /**
     * Gets the tabbed pane
     * @return JTabbedPane the pane
     */
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    /**
     * Gets the panel for no coupons applied
     * @return JPanel the no coupons applied panel
     */
    public JPanel getNoCouponsAppliedPanel() {
        return noCouponsAppliedPanel;
    }

    /**
     * Gets the coupons applied panel
     * @return JPanel the panel for coupons applied
     */
    public JPanel getCouponsAppliedPanel() {
        return couponsAppliedPanel;
    }
}
