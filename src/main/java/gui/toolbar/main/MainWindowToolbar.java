package gui.toolbar.main;

import gui.action.main.AddCouponButtonAction;
import gui.action.toolbar.ExitToolbarButtonAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
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

        addAddCouponMenuItem(fileMenu);
        addExitMenuItem(fileMenu);

        add(fileMenu);
    }

    private void addExitMenuItem(JMenu fileMenu) {
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitToolbarButtonAction());
        fileMenu.add(exitMenuItem);
    }

    private void addAddCouponMenuItem(JMenu fileMenu) {
        JMenuItem addCouponMenuItem = new JMenuItem("Add Coupon");
        addCouponMenuItem.addActionListener(new AddCouponButtonAction());
        fileMenu.add(addCouponMenuItem);
    }
}
