package gui.window.viewallcoupons;

import hibernate.Coupon;
import hibernate.serviceadaptor.CouponServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;

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
    JTable table;

    /**
     * View all coupons window
     */
    public ViewAllCouponsWindow() {
        super("View All Coupons");

        java.util.List<Coupon> coupons = CouponServiceAdaptor.getAllCoupons();

        final Object[][] data = convertToObjectArray(coupons);
        final Object[] column = new Object[]{"Item", "Value", "Type", "Expiration Date"};

        AbstractTableModel model = new CouponTableModel(column, data);
        table = new JTable(model);
        table.setRowHeight(ROW_HEIGHT);
        JScrollPane pane = new JScrollPane(table);


        Box vertBox = Box.createVerticalBox();
        vertBox.add(pane);

        getContentPane().add(vertBox);
        setSize(WIDTH, HEIGHT);
    }

    /**
     * Converts the list of coupons to object array
     * @param coupons coupons to be converted
     * @return the list of coupons to converted object array
     */
    private Object[][] convertToObjectArray(java.util.List<Coupon> coupons) {
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

    /**
     * Coupon table model for coupon table
     */
    private static class CouponTableModel extends AbstractTableModel {
        private final Object[] column;
        private final Object[][] data;

        public CouponTableModel(Object[] column, Object[][] data) {
            this.column = column;
            this.data = data;
        }

        public int getColumnCount() {
            return column.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return (String) column[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int col) {
            return data[0][col].getClass();
        }
    }
}