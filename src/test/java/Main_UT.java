import gui.GUIBuilder;
import gui.window.main.MainWindow;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
* Created by IntelliJ IDEA.
* User: vincent
* Date: 3-Feb-2011
* Time: 9:51:54 PM
*/
public class Main_UT {
    @Mock
    private GUIBuilder guiBuilder;

    @Mock
    private MainWindow mainWindow;

    @Before
    public void setUp() {
        initMocks(this);
        when(guiBuilder.buildUserInterface()).thenReturn(mainWindow);
    }

    @Test
    public void testMainCallsBuildUserInterface() throws Exception {
        Main main = new Main();
        main.initializeProgram();
    }
}
