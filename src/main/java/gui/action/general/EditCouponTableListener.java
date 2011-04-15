package gui.action.general;

import gui.window.editcoupon.EditCouponWindow;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 4/12/11
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditCouponTableListener implements ListSelectionListener {
    JButton edit;
    JButton remove;
    JTable table;
    public EditCouponTableListener(JTable table, JButton edit, JButton remove) {
        this.table = table;
        this.edit = edit;
        this.remove = remove;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        edit.setEnabled(true);
        remove.setEnabled(true);
    }
}
