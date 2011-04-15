package gui.window.addcoupon;

import gui.button.general.SaveOrUpdateCouponButton;
import gui.input.GeneralDropDownInput;
import gui.input.GeneralInput;
import gui.input.validate.DateFormValidator;
import gui.input.validate.NumberFormValidator;
import hibernate.Coupon;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    private GeneralDropDownInput items;
    private GeneralDropDownInput type;
    private GeneralInput value;
    private GeneralInput expirationDate;
    private JButton saveOrUpdateCouponButton;

    /**
     * Add coupon window
     * @throws HeadlessException thrown if error
     */
    public AddCouponWindow(Coupon coupon) throws HeadlessException {
        setTitle("Add A Coupon");
        setSize(WIDTH, HEIGHT);
        Box itemForm = Box.createVerticalBox();

        value = new GeneralInput("Coupon Value", true);
        value.addNewFormValidator(new NumberFormValidator());
        itemForm.add(value );

        expirationDate = new GeneralInput("Expiration Date", true);
        expirationDate.addNewFormValidator(new DateFormValidator());
        itemForm.add(expirationDate);

        items = new GeneralDropDownInput("Item", "FROM Item");
        itemForm.add(items);

        type = new GeneralDropDownInput("Coupon Type", new String[]{"Percent Off", "Amount Off"});
        itemForm.add(type);

        saveOrUpdateCouponButton = new SaveOrUpdateCouponButton("Add", value, expirationDate, items, type, coupon, this);
        itemForm.add(saveOrUpdateCouponButton);

        value.getFormValidatorWorker().monitorButtons(Arrays.asList(saveOrUpdateCouponButton));
        expirationDate.getFormValidatorWorker().monitorButtons(Arrays.asList(saveOrUpdateCouponButton));

        add(itemForm);

        if(coupon != null){
            value.getInput().setText(""+coupon.getCouponValue());
            expirationDate.getInput().setText((new SimpleDateFormat("M/d/y")).format(coupon.getExpirationDate()));
            if(coupon.isCouponType()){
                type.setSelectedObject(0);
            } else {
                type.setSelectedObject(1);
            }
            for(int ndx = 0; ndx < items.getNumberOfElements(); ndx++){
                if(items.getObjectAt(ndx).toString().equals(coupon.getItem().toString()))
                    items.setSelectedObject(ndx);
            }
            saveOrUpdateCouponButton.setText("Update");
        }
    }

    public AddCouponWindow() throws HeadlessException {
        this(null);
    }

    public GeneralDropDownInput getItems() {
        return items;
    }

    public GeneralDropDownInput getType() {
        return type;
    }

    public GeneralInput getValue() {
        return value;
    }

    public GeneralInput getExpirationDate() {
        return expirationDate;
    }

    public JButton getSaveOrUpdateCouponButton() {
        return saveOrUpdateCouponButton;
    }
}
