import gui.window.login.LoginWindow;
import hibernate.factory.DBClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 3-Feb-2011
 * Time: 9:47:44 PM
 */
public class Main {
    /**
     * Main runner of the program
     * @param args ignored
     */
    public static void main(String args[]) {
        Main main = new Main();
        main.initializeProgram();
    }

    /**
     * Initialized the program
     */
    public void initializeProgram() {
        LoginWindow loginWindow = new LoginWindow();
        loginWindow.setVisible(true);

        initIOCContainer();
    }

    /**
     * Initializes spring ioc container and sets hibernate session
     */
    private void initIOCContainer() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"/hibernate/config.xml"});
        DBClient.INSTANCE = (DBClient) applicationContext.getBean("dbClient");
    }
}
