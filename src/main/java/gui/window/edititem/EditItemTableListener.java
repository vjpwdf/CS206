package gui.window.edititem;

import javax.swing.*;
import javax.swing.event.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/5/11
 * Time: 2:07 PM
 */
public class EditItemTableListener implements ListSelectionListener {
    private JButton remove;
    private JButton edit;

    /**
     * Edit item table listener for selection
     * @param edit button to enable upon initial selection
     * @param remove button to enable upon initial selection
     */
    public EditItemTableListener(JButton edit, JButton remove) {
        this.edit = edit;
        this.remove = remove;
    }

    /**
     * Enables both buttons upon initial selection
     * @param event makes sure the event isn't value is adjusting
     */
    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            edit.setEnabled(true);
            remove.setEnabled(true);
        }
    }
}
