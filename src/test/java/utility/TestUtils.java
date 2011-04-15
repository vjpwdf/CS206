package utility;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: will
 * Date: 4/15/11
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestUtils {
    public static Component getChildNamed(Component parent, String name) {
        if(name.equals(parent.getName())) {
            return parent;
        }
        if(parent instanceof Container) {
            Component[] children = ((Container)parent).getComponents();
            for(int i = 0; i < children.length; ++i) {
                Component child = getChildNamed(children[i], name);
                if(child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}
