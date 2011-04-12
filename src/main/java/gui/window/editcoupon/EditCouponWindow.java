package gui.window.editcoupon;


import hibernate.Coupon;
import hibernate.serviceadaptor.CouponServiceAdaptor;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;


/**
 * @version 1.0 06/19/99
 */
public class EditCouponWindow extends JFrame {
    final private int ROW_HEIGHT = 30;
    final private int HEIGHT = 600;
    final private int WIDTH = 500;
    JTable table;
    private JButton remove;
    private JButton edit;

    public EditCouponWindow() {
        super("Edit Coupon Window");

        List<Coupon> coupons = CouponServiceAdaptor.getAllCoupons();

        final Object[][] data = convertToObjectArray(coupons);
        final Object[] column = new Object[]{"Item", "Value", "Type", "Expiration Date"};

        AbstractTableModel model = new CouponTableModel(column, data);
        table = new JTable(model);
        table.setRowHeight(ROW_HEIGHT);
        JScrollPane pane = new JScrollPane(table);


        Box vertBox = Box.createVerticalBox();
        vertBox.add(pane);

        Box buttonBox = Box.createHorizontalBox();

        edit = new JButton("Edit");
        edit.setMinimumSize(new Dimension(150, 50));
        edit.setMaximumSize(new Dimension(150, 50));
//        edit.addActionListener(new UpdateItemButtonAction(table, items, this));
        edit.setEnabled(false);

        remove = new JButton("Remove");
        remove.setMinimumSize(new Dimension(150, 50));
        remove.setMaximumSize(new Dimension(150, 50));
//        remove.addActionListener(new RemoveItemButtonAction(table, items, this));
        remove.setEnabled(false);

        buttonBox.add(edit);
        buttonBox.add(remove);

//        table.getSelectionModel().addListSelectionListener(new EditItemTableListener(table, edit, remove));

        vertBox.add(buttonBox);

        getContentPane().add(vertBox);
        setSize(WIDTH, HEIGHT);
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