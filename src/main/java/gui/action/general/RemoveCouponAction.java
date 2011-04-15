package gui.action.general;

import gui.window.editcoupon.EditCouponWindow;
import gui.window.edititem.EditItemWindow;
import hibernate.Coupon;
import hibernate.serviceadaptor.CouponServiceAdaptor;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 4/12/11
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveCouponAction implements ActionListener {

    List<Coupon> coupons;
    JTable table;
    EditCouponWindow editCouponWindow;

    public RemoveCouponAction(List<Coupon> coupons, JTable table, EditCouponWindow editCouponWindow) {
        this.coupons = coupons;
        this.table = table;
        this.editCouponWindow = editCouponWindow;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = table.getSelectedRow();
        CouponServiceAdaptor.removeCoupon(coupons.get(selectedRow).getCouponId());
        JOptionPane.showMessageDialog(null, "Coupon has been successfully removed.");
        editCouponWindow.setVisible(false);
        editCouponWindow = new EditCouponWindow();
        editCouponWindow.setVisible(true);
    }
}