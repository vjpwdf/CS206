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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coupon coupon = (Coupon) o;

        if (couponType != coupon.couponType) return false;
        if (Float.compare(coupon.couponValue, couponValue) != 0) return false;
        if (couponImage != null ? !couponImage.equals(coupon.couponImage) : coupon.couponImage != null) return false;
        if (item != null ? !item.equals(coupon.item) : coupon.item != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (couponType ? 1 : 0);
        result = 31 * result + (couponValue != +0.0f ? Float.floatToIntBits(couponValue) : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (couponImage != null ? couponImage.hashCode() : 0);
        return result;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }
}
