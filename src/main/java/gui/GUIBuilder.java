package gui;

import gui.window.main.MainWindow;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 3-Feb-2011
 * Time: 9:49:43 PM
 */
public class GUIBuilder {

    /**
     * Builds the main windows user interface
     * @return main window
     */
    public MainWindow buildUserInterface() {
        return new MainWindow();
    }

}
