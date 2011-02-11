package gui;

import gui.window.MainWindow;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 3-Feb-2011
 * Time: 9:54:33 PM
 */
public class GUIBuilder_UT {
    private static final Integer WIDTH = 250;
    private static final Integer HEIGHT = 250;

    @Test
    public void testBuildUserInterface_ReturnsNonNullMainWindow() throws Exception {
        GUIBuilder guiBuilder = new GUIBuilder();
        MainWindow mainWindow = guiBuilder.buildUserInterface();

        assertNotNull(mainWindow);
    }

    @Test
    public void testBuildUserInterface_ReturnsBuiltMainWindow_WithCorrectDimensions() throws Exception {
        GUIBuilder guiBuilder = new GUIBuilder();
        MainWindow mainWindow = guiBuilder.buildUserInterface();

        assertEquals(mainWindow.getSize().getWidth(), (double)WIDTH);
        assertEquals(mainWindow.getSize().getHeight(), (double)HEIGHT);
    }

    @Test
    public void testBuildUserInterface_ReturnsBuiltMainWindow_WithJMenuBar() throws Exception {
        GUIBuilder guiBuilder = new GUIBuilder();
        MainWindow mainWindow = guiBuilder.buildUserInterface();

        assertNotNull(mainWindow.getJMenuBar());
        assertEquals("File", mainWindow.getJMenuBar().getMenu(0).getText());
    }


}
