package gui.button.shoppingcart;

import gui.action.savings.ComputeSavingsButtonAction;
import hibernate.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ComputeSavingsButton extends JButton {
    public ComputeSavingsButton(List<ShoppingCart> shoppingCartList, JTable shoppingCarts) {
        setText("Compute Savings");
        setMinimumSize(new Dimension(200, 50));
        setMaximumSize(new Dimension(200, 50));
        addActionListener(new ComputeSavingsButtonAction(shoppingCartList, shoppingCarts));
        setIcon(new ImageIcon("main/window/all-coupons.png"));
    }
}
