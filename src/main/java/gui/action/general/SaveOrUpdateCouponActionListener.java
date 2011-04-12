package gui.action.general;

import gui.input.GeneralDropDownInput;
import gui.input.GeneralInput;
import gui.window.editcoupon.EditCouponWindow;
import hibernate.Coupon;
import hibernate.Item;
import hibernate.serviceadaptor.CouponServiceAdaptor;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

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
    Coupon couponToUpdate;
    JFrame returnWindow;

    /**
     * Save or update action listener for save or update button
     * @param value value for coupon
     * @param expirationDate expiration of coupon
     * @param items item drop down
     * @param type coupon type
     * @param couponToUpdate determines whether or not the coupon is being updated or saved
     */
    public SaveOrUpdateCouponActionListener(GeneralInput value, GeneralInput expirationDate, GeneralDropDownInput items, GeneralDropDownInput type, Coupon couponToUpdate, JFrame returnWindow) {
        this.value = value;
        this.expirationDate = expirationDate;
        this.items = items;
        this.type = type;
        this.couponToUpdate = couponToUpdate;
        this.returnWindow = returnWindow;
    }

    /**
     * Action for to save/update coupon
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(couponToUpdate != null){
            int cid = couponToUpdate.getCouponId();
            CouponServiceAdaptor.removeCoupon(couponToUpdate.getCouponId());
            Coupon added = CouponServiceAdaptor.addCoupon(((Item)items.getSelectedObject()).getItemUpc(), type.getSelectedObject().equals("Percent Off"), Float.valueOf(value.getInput().getText()), new Date(expirationDate.getInput().getText()));
            added.setCouponId(cid);
            JOptionPane.showMessageDialog(null, "Coupon has been successfully updated.");
            returnWindow.setVisible(false);
            returnWindow = new EditCouponWindow();
            returnWindow.setVisible(true);
        } else {
            CouponServiceAdaptor.addCoupon(((Item)items.getSelectedObject()).getItemUpc(), type.getSelectedObject().equals("Percent Off"), Float.valueOf(value.getInput().getText()), new Date(expirationDate.getInput().getText()));
            JOptionPane.showMessageDialog(null, "Coupon has been successfully saved.");
            returnWindow.setVisible(false);
        }
    }
}
