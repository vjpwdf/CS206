package gui.window.savings;

import hibernate.ShoppingCart;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputeSavingsWindow extends JFrame {
    private static final Integer WIDTH = 500;
    private static final Integer HEIGHT = 330;

    public ComputeSavingsWindow(ShoppingCart selectedShoppingCart) throws HeadlessException {
        setTitle("Savings For Shopping Cart");
        setSize(WIDTH, HEIGHT);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("No Coupons Applied", createNoCouponsAppliedPane(selectedShoppingCart));
        tabbedPane.addTab("Coupons Applied", createCouponsAppliedPane(selectedShoppingCart));
    }

    private JPanel createCouponsAppliedPane(ShoppingCart selectedShoppingCart) {
        JPanel panel = new JPanel();
        return panel;
    }

    private JPanel createNoCouponsAppliedPane(ShoppingCart selectedShoppingCart) {
        JPanel panel = new JPanel();
        return panel;
    }
}
