package gui.window;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: Feb 10, 2011
 * Time: 7:07:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindowToolbar extends JMenuBar {
    String[ ] fileItems = new String[ ] { "New Coupon", "Open Coupon", "Export Coupons", "Exit" };
    
    public MainWindowToolbar() {
        addFileButton();
    }

    private void addFileButton() {
        JMenu fileMenu = new JMenu("File");
        for (String fileItem : fileItems) {
            fileMenu.add(new JMenuItem(fileItem));
        }
        this.add(fileMenu);
    }
}
