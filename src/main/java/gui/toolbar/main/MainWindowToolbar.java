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
 */
public class MainWindowToolbar extends JMenuBar {

    /**
     * Main window tool bar constructor
     */
    public MainWindowToolbar() {
        addFileButton();
    }

    /**
     * Adds the file button with list of options available on the main screen
     */
    private void addFileButton() {
        JMenu fileMenu = new JMenu("File");

        addMenuItem(fileMenu, "Add Item", new OpenAddItemWindowAction());
        addMenuItem(fileMenu, "Eit Item", new EditItemButtonAction());
        addMenuItem(fileMenu, "Add Coupon", new AddCouponButtonAction());
        addMenuItem(fileMenu, "Edit Coupons", new RemoveCouponButtonAction());
        addMenuItem(fileMenu, "Build Shopping Cart", new BuildShoppingCartButtonAction());
        addMenuItem(fileMenu, "View All Coupons", new ViewAllCouponsButtonAction());
        addMenuItem(fileMenu, "View All Shopping Carts", new ViewAllShoppingCartsButtonAction());
        addMenuItem(fileMenu, "Exit", new ExitToolbarButtonAction());

        add(fileMenu);
    }

    /**
     * Adds a menu item to the file drop down
     * @param fileMenu file menu to add option
     * @param itemText text of item to add
     * @param actionListener action listener of item added to drop down
     */
    private void addMenuItem(JMenu fileMenu, String itemText, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(itemText);
        item.addActionListener(actionListener);
        fileMenu.add(item);
    }
}