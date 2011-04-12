package gui.window.main;

import gui.button.main.*;
import gui.toolbar.main.MainWindowToolbar;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 6:58:32 PM
 */
public class MainWindow extends JFrame {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 330;

    /**
     * Main window constructor
     */
    public MainWindow() {
        setTitle("Coupon Manager");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MainWindowToolbar());
        addMainWindowButtons();
    }

    /**
     * Adds all the buttons to the main window
     */
    private void addMainWindowButtons() {
        Box buttonBox = Box.createVerticalBox();
        buttonBox.add(new OpenAddItemWindowButton());
        buttonBox.add(new EditItemButton());
        buttonBox.add(new AddCouponButton());
        buttonBox.add(new EditCouponButton());
        buttonBox.add(new BuildShoppingCartButton());
        buttonBox.add(new ViewAllCouponsButton());
        buttonBox.add(new ViewAllShoppingCartsButton());
        add(buttonBox);
    }
}
