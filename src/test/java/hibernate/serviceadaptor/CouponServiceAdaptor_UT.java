package hibernate.serviceadaptor;

import hibernate.dao.CouponDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 3/13/11
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class CouponServiceAdaptor_UT {

    @Mock
    private CouponDaoImpl couponDao;

    @Before
    public void setUp() {
        initMocks(this);
        CouponServiceAdaptor.setCouponDao(couponDao);
    }

    @Test
    public void testAddCoupon() throws Exception {
        Date date = new Date();
        CouponServiceAdaptor.addCoupon("1", true, 1.25f, date, null);
        verify(couponDao).addCoupon("1", true, 1.25f, date);
    }

    @Test
    public void testRemoveCoupon() throws Exception {
        CouponServiceAdaptor.removeCoupon(5);
        verify(couponDao).removeCoupon(5);
    }

    @Test
    public void testGetAllCoupons() throws Exception {
        CouponServiceAdaptor.getAllCoupons();
        verify(couponDao).getAllCoupons();
    }
}
