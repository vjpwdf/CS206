import gui.GUIBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
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

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testMainCallsBuildUserInterface() throws Exception {
        Main main = new Main();
        main.setGuiBuilder(guiBuilder);
        main.initializeProgram();

        verify(guiBuilder).buildUserInterface();
    }
}
