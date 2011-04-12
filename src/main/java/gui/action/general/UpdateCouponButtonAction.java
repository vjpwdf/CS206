package gui.action.general;

import gui.window.addcoupon.AddCouponWindow;
import gui.window.additem.AddItemWindow;
import gui.window.editcoupon.EditCouponWindow;
import gui.window.edititem.EditItemWindow;
import hibernate.Coupon;
import hibernate.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 4/12/11
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateCouponButtonAction implements ActionListener {
    private EditCouponWindow editCouponWindow;
    private List<Coupon> coupons;
    private JTable table;

    public UpdateCouponButtonAction(JTable table, List<Coupon> coupons, EditCouponWindow editCouponWindow) {
        this.table = table;
        this.coupons = coupons;
        this.editCouponWindow = editCouponWindow;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = table.getSelectedRow();
        AddCouponWindow addCouponWindow = new AddCouponWindow(coupons.get(selectedRow));
        addCouponWindow.setVisible(true);
        editCouponWindow.setVisible(false);
    }
}
