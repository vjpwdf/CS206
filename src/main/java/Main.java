import gui.GUIBuilder;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 3-Feb-2011
 * Time: 9:47:44 PM
 */
public class Main {
    GUIBuilder guiBuilder;

    public void setGuiBuilder(GUIBuilder guiBuilder) {
        this.guiBuilder = guiBuilder;
    }

    public static void main(String args[]) {
        Main main = new Main();
        main.setGuiBuilder(new GUIBuilder());
        main.initializeProgram();
    }

    public void initializeProgram() {
        guiBuilder.buildUserInterface();
    }
}
