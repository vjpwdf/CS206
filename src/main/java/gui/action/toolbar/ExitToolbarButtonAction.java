package gui.action.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11-Feb-2011
 * Time: 5:36:28 PM
 */
public class ExitToolbarButtonAction implements ActionListener {
    /**
     * Exit toolbar action - closes program
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }
}
