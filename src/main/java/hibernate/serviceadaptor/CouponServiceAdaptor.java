package hibernate.serviceadaptor;

import hibernate.dao.CouponDaoImpl;

import java.io.File;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 2/22/11
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class CouponServiceAdaptor {
    private static CouponDaoImpl couponDao = new CouponDaoImpl();

    public static void addCoupon(String itemId, boolean couponType, Float couponValue, Date date, File file) {
        couponDao.addCoupon(itemId, couponType, couponValue, date, file);
    }
    public static void removeCoupon() {

    }
    public static void getAllCoupons() {

    }
}
