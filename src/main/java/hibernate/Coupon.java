package hibernate;

import java.sql.Blob;
import java.util.Date;

/**
 * User: vincent
 * Date: 22-Feb-2011
 * Time: 1:00:00 PM
 */
public class Coupon {
    private int couponId;
    private Item item;
    private boolean couponType;
    private float couponValue;
    private Date expirationDate;
    private Blob couponImage;

    public Blob getCouponImage() {
        return couponImage;
    }

    public void setCouponImage(Blob couponImage) {
        this.couponImage = couponImage;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(float couponValue) {
        this.couponValue = couponValue;
    }

    public boolean isCouponType() {
        return couponType;
    }

    public void setCouponType(boolean couponType) {
        this.couponType = couponType;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }
}
