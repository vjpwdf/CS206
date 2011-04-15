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

    /**
     * Gets the coupons expiration date
     * @return the coupons expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the coupons expiration date
     * @param expirationDate the coupons expiration date
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Gets the coupons value
     * @return the coupons value
     */
    public float getCouponValue() {
        return couponValue;
    }

    /**
     * Sets the coupons value
     * @param couponValue the coupons value
     */
    public void setCouponValue(float couponValue) {
        this.couponValue = couponValue;
    }

    /**
     * Gets the type of the coupon
     * @return true if the coupon is %off false if the coupon is $ off
     */
    public boolean isCouponType() {
        return couponType;
    }

    /**
     * Sets the type of hte coupon
     * @param couponType true if the coupon is %off false if the coupon is $ off
     */
    public void setCouponType(boolean couponType) {
        this.couponType = couponType;
    }

    /**
     * Gets the item the coupon is associated with
     * @return item the coupon is associated with
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the item the coupon is associated with
     * @param item item the coupon is associated with
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Gets the id of the coupon
     * @return the id of the coupon
     */
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
        if (item != null ? !item.equals(coupon.item) : coupon.item != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (couponType ? 1 : 0);
        result = 31 * result + (couponValue != +0.0f ? Float.floatToIntBits(couponValue) : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }

    /**
     * Sets the id of the coupon
     * @param couponId id of the coupon
     */
    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }
}
