package gui.window.viewallcoupons;

import hibernate.Coupon;
import hibernate.serviceadaptor.CouponServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:11:18 PM
 */
public class ViewAllCouponsWindow extends JFrame {
    final private int ROW_HEIGHT = 30;
    final private int HEIGHT = 600;
    final private int WIDTH = 500;
    private JTable table;
    private AbstractTableModel model;

    /**
     * View all coupons window
     */
    public ViewAllCouponsWindow() {
        super("View All Coupons");
        setSize(WIDTH, HEIGHT);

        List<Coupon> coupons = CouponServiceAdaptor.getAllCoupons();
        JScrollPane pane = buildCouponTable(coupons);

        Box viewAllCouponsBox = Box.createVerticalBox();
        viewAllCouponsBox.add(pane);

        getContentPane().add(viewAllCouponsBox);
    }

    /**
     * Builds the coupon table
     * @param coupons coupons to build table from
     * @return A scroll pane with coupons listed inside the table
     */
    private JScrollPane buildCouponTable(List<Coupon> coupons) {
        model = new CouponTableModel(getColumnNames(), convertToObjectArray(coupons));
        table = new JTable(model);
        table.setRowHeight(ROW_HEIGHT);
        return new JScrollPane(table);
    }

    /**
     * Gets the column names of the table
     * @return the column names of the table
     */
    private Object[] getColumnNames() {
        return new Object[]{"Item", "Value", "Type", "Expiration Date"};
    }

    /**
     * Converts the list of coupons to object array
     * @param coupons coupons to be converted
     * @return the list of coupons to converted object array
     */
    private Object[][] convertToObjectArray(List<Coupon> coupons) {
        Object[][] data = new Object[coupons.size()][4];
        for (int i = 0; i < coupons.size(); i++) {
            convertCouponToObject(coupons, data, i);
        }
        return data;
    }

    /**
     * Converts a coupon to an object array
     * @param coupons coupon list
     * @param data current data
     * @param i position in array
     */
    private void convertCouponToObject(List<Coupon> coupons, Object[][] data, int i) {
        Coupon coupon = coupons.get(i);
        data[i][0] = coupon.getItem().toString();

        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        data[i][1] = df.format(coupon.getCouponValue());

        data[i][2] = coupon.isCouponType()?"Percent Off":"Amount Off";

        data[i][3] = coupon.getExpirationDate().toString();
    }

    /**
     * Gets the coupon table
     * @return the coupon table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Gets the table model
     * @return the table model
     */
    public AbstractTableModel getModel() {
        return model;
    }
}