package gui;

import gui.window.MainWindow;
import gui.window.MainWindowToolbar;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 3-Feb-2011
 * Time: 9:49:43 PM
 */
public class GUIBuilder {

    public MainWindow buildUserInterface() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setJMenuBar(new MainWindowToolbar());
        return mainWindow;
    }

}
