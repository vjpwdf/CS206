package gui.button.general;

import gui.action.general.AddItemActionListener;
import gui.action.general.SaveOrUpdateCouponActionListener;
import gui.input.GeneralDropDownInput;
import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import gui.window.additem.AddItemWindow;
import hibernate.Item;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/13/11
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class SaveOrUpdateCouponButton extends JButton {


public SaveOrUpdateCouponButton(String title, GeneralInput value, GeneralInput expirationDate, GeneralDropDownInput items, GeneralDropDownInput type) {
    super(title);
    addActionListener(new SaveOrUpdateCouponActionListener(value, expirationDate, items, type));
    }
}
