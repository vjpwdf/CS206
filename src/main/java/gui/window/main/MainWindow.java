package gui.window.main;

import gui.button.main.*;
import gui.toolbar.main.MainWindowToolbar;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 6:58:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow extends JFrame {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 250;
    
    public MainWindow() {
        setTitle("Coupon Manager");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new MainWindowToolbar());
        addMainWindowButtons();
    }

    private void addMainWindowButtons() {
        Box buttonBox = Box.createVerticalBox();
        buttonBox.add(new AddCouponButton());
        buttonBox.add(new RemoveCouponButton());
        buttonBox.add(new BuildShoppingCartButton());
        buttonBox.add(new ViewAllCouponsButton());
        buttonBox.add(new ViewAllShoppingCartsButton());
        add(buttonBox);
    }
}
