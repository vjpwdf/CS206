package gui.action.general;

import gui.input.GeneralDropDownInput;
import gui.input.GeneralInput;
import hibernate.Item;
import hibernate.serviceadaptor.CouponServiceAdaptor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/13/11
 * Time: 2:49 PM
 */
public class SaveOrUpdateCouponActionListener implements ActionListener {

    GeneralInput value;
    GeneralInput expirationDate;
    GeneralDropDownInput items;
    GeneralDropDownInput type;

    /**
     * Save or update action listener for save or update button
     * @param value value for coupon
     * @param expirationDate expiration of coupon
     * @param items item drop down
     * @param type coupon type
     */
    public SaveOrUpdateCouponActionListener(GeneralInput value, GeneralInput expirationDate, GeneralDropDownInput items, GeneralDropDownInput type) {
        this.value = value;
        this.expirationDate = expirationDate;
        this.items = items;
        this.type = type;
    }

    /**
     * Action for to save/update coupon
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        CouponServiceAdaptor.addCoupon(((Item)items.getSelectedObject()).getItemUpc(), type.getSelectedObject().equals("Percent Off"), Float.valueOf(value.getInput().getText()), new Date(expirationDate.getInput().getText()));
    }
}
