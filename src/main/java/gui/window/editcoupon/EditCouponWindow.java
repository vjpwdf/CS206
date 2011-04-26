package gui.window.editcoupon;


import gui.action.general.EditCouponTableListener;
import gui.action.general.RemoveCouponAction;
import gui.action.general.UpdateCouponButtonAction;
import gui.action.main.RemoveCouponButtonAction;
import hibernate.Coupon;
import hibernate.serviceadaptor.CouponServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class EditCouponWindow extends JFrame {
    final private int ROW_HEIGHT = 30;
    final private int HEIGHT = 600;
    final private int WIDTH = 500;
    private JTable table;
    private AbstractTableModel model;
    private JButton remove;
    private JButton edit;
    private final String name = "EditCouponWindow";

    public EditCouponWindow() {
        super("Edit A Coupon");

        List<Coupon> coupons = CouponServiceAdaptor.getAllCoupons();

        final Object[][] data = convertToObjectArray(coupons);
        final Object[] column = new Object[]{"Item", "Value", "Type", "Expiration Date"};

        JScrollPane pane = buildCouponTableModel(data, column);
        Box vertBox = Box.createVerticalBox();
        vertBox.add(pane);

        Box buttonBox = Box.createHorizontalBox();
        buildEditCouponButton(coupons);
        buildRemoveCouponButton(coupons);

        buttonBox.add(edit);
        buttonBox.add(remove);

        table.getSelectionModel().addListSelectionListener(new EditCouponTableListener(table, edit, remove));

        vertBox.add(buttonBox);

        getContentPane().add(vertBox);
        setSize(WIDTH, HEIGHT);
    }

    private JScrollPane buildCouponTableModel(Object[][] data, Object[] column) {
        model = new CouponTableModel(column, data);
        table = new JTable(model);
        table.setRowHeight(ROW_HEIGHT);
        return new JScrollPane(table);
    }

    private void buildRemoveCouponButton(List<Coupon> coupons) {
        remove = new JButton("Remove");
        remove.setMinimumSize(new Dimension(150, 50));
        remove.setMaximumSize(new Dimension(150, 50));
        remove.addActionListener(new RemoveCouponAction(coupons, table, this));
        remove.setEnabled(false);
    }

    private void buildEditCouponButton(List<Coupon> coupons) {
        edit = new JButton("Edit");
        edit.setMinimumSize(new Dimension(150, 50));
        edit.setMaximumSize(new Dimension(150, 50));
        edit.addActionListener(new UpdateCouponButtonAction(table, coupons, this));
        edit.setEnabled(false);
    }

    private Object[][] convertToObjectArray(List<Coupon> coupons) {
        Object[][] data = new Object[coupons.size()][4];
        for (int i = 0; i < coupons.size(); i++) {
            Coupon coupon = coupons.get(i);
            data[i][0] = coupon.getItem().toString();

            DecimalFormat df = new DecimalFormat();
            df.setMinimumFractionDigits(2);
            df.setMaximumFractionDigits(2);
            data[i][1] = df.format(coupon.getCouponValue());

            data[i][2] = coupon.isCouponType()?"Percent Off":"Amount Off";

            data[i][3] = coupon.getExpirationDate().toString();
        }
        return data;
    }

    public JTable getTable() {
        return table;
    }

    public AbstractTableModel getModel() {
        return model;
    }

    public JButton getRemove() {
        return remove;
    }

    public JButton getEdit() {
        return edit;
    }

    public String getName() {
        return name;
    }
}