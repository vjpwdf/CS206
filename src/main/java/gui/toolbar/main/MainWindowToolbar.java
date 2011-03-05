package gui.toolbar.main;

import gui.action.main.*;
import gui.action.toolbar.ExitToolbarButtonAction;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 7:07:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindowToolbar extends JMenuBar {

    public MainWindowToolbar() {
        addFileButton();
    }

    private void addFileButton() {
        JMenu fileMenu = new JMenu("File");

        addMenuItem(fileMenu, "Add Item", new OpenAddItemWindowAction());
        addMenuItem(fileMenu, "Remove Item", new RemoveItemButtonAction());
        addMenuItem(fileMenu, "Add Coupon", new AddCouponButtonAction());
        addMenuItem(fileMenu, "Remove Coupon", new RemoveCouponButtonAction());
        addMenuItem(fileMenu, "Build Shopping Cart", new BuildShoppingCartButtonAction());
        addMenuItem(fileMenu, "View All Coupons", new ViewAllCouponsButtonAction());
        addMenuItem(fileMenu, "View All Shopping Carts", new ViewAllShoppingCartsButtonAction());
        addMenuItem(fileMenu, "Exit", new ExitToolbarButtonAction());

        add(fileMenu);
    }

    private void addMenuItem(JMenu fileMenu, String itemText, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(itemText);
        item.addActionListener(actionListener);
        fileMenu.add(item);
    }
}