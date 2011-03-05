package gui.window.edititem;

import javax.swing.*;
import javax.swing.event.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/5/11
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditItemTableListener implements ListSelectionListener {

    private JButton remove;
    private JButton edit;
    private JTable table;

    public EditItemTableListener(JTable table, JButton edit, JButton remove) {
        this.table = table;
        this.edit = edit;
        this.remove = remove;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if(!event.getValueIsAdjusting()){
            edit.setEnabled(true);
            remove.setEnabled(true);
        }
    }
}
