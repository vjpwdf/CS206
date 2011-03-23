package hibernate.serviceadaptor;

import hibernate.Item;
import hibernate.ShoppingCartItem;
import hibernate.User;
import hibernate.dao.ShoppingCartDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 3/13/11
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartServiceAdaptor_UT {

    @Mock
    ShoppingCartDaoImpl shoppingCartDao;

    @Before
    public void setUp() {
        initMocks(this);
        ShoppingCartServiceAdaptor.setShoppingCartDao(shoppingCartDao);
    }

    @Test
    public void testAddShoppingCartFromListOfShoppingCartItems() {
        User user = new User();
        Item item = new Item();
        Map<Item, Integer> itemIntegerMap = new HashMap<Item, Integer>();
        itemIntegerMap.put(item, 10);
        ShoppingCartServiceAdaptor.addShoppingCartFromListOfShoppingCartItems(itemIntegerMap, user);
        verify(shoppingCartDao).addShoppingCartFromListOfShoppingCartItems(Mockito.anyList(), Mockito.anyString());
    }
}
