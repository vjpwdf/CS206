import gui.GUIBuilder;
import gui.window.main.MainWindow;
import hibernate.Item;
import hibernate.factory.DBClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        MainWindow mainWindow = guiBuilder.buildUserInterface();
        mainWindow.setVisible(true);
        initIOCContainer();
    }

    private void initIOCContainer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"/hibernate/config.xml"});
        DBClient.INSTANCE = (DBClient)applicationContext.getBean("dbClient");
    }
}
