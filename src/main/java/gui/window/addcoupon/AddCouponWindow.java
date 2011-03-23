package gui.window.addcoupon;

import gui.button.general.SaveOrUpdateCouponButton;
import gui.input.GeneralDropDownInput;
import gui.input.GeneralInput;
import gui.input.validate.DateFormValidator;
import gui.input.validate.NumberFormValidator;
import hibernate.Item;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:59:57 PM
 */
public class AddCouponWindow extends JFrame {
    private static final Integer WIDTH = 600;
    private static final Integer HEIGHT = 330;

    public AddCouponWindow(Item item) throws HeadlessException {
        setTitle("Add A Coupon");
        setSize(WIDTH, HEIGHT);
        Box itemForm = Box.createVerticalBox();

        GeneralInput value = new GeneralInput("Coupon Value", true);
        value.addNewFormValidator(new NumberFormValidator());
        itemForm.add(value );

        GeneralInput expirationDate = new GeneralInput("Expiration Date", true);
        expirationDate.addNewFormValidator(new DateFormValidator());
        itemForm.add(expirationDate);

        GeneralDropDownInput items = new GeneralDropDownInput("Item", "FROM Item");
        itemForm.add(items);

        GeneralDropDownInput type = new GeneralDropDownInput("Coupon Type", new String[]{"Percent Off", "Amount Off"});
        itemForm.add(type);

        JButton saveOrUpdateCouponButton = new SaveOrUpdateCouponButton("Add", value, expirationDate, items, type);
        itemForm.add(saveOrUpdateCouponButton);

        value.getFormValidatorWorker().monitorButtons(Arrays.asList(saveOrUpdateCouponButton));
        expirationDate.getFormValidatorWorker().monitorButtons(Arrays.asList(saveOrUpdateCouponButton));

        add(itemForm);

    }

    public AddCouponWindow() throws HeadlessException {
        this(null);
    }
}
