package gui.button.general;

import gui.action.general.SaveOrUpdateCouponActionListener;
import gui.input.GeneralDropDownInput;
import gui.input.GeneralInput;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/13/11
 * Time: 2:45 PM
 */
public class SaveOrUpdateCouponButton extends JButton {

    /**
     * Save or update coupon button
     * @param title coupon title
     * @param value coupon value
     * @param expirationDate expiration date
     * @param items list of items to associate with the coupon
     * @param type coupon type
     */
    public SaveOrUpdateCouponButton(String title, GeneralInput value, GeneralInput expirationDate, GeneralDropDownInput items, GeneralDropDownInput type) {
        super(title);
        addActionListener(new SaveOrUpdateCouponActionListener(value, expirationDate, items, type));
    }
}
