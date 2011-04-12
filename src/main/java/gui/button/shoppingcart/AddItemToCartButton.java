package gui.button.shoppingcart;

import gui.action.shoppingcart.AddItemToCartButtonAction;
import gui.input.GeneralInput;
import hibernate.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 4/9/11
 * Time: 7:06 PM
 */
public class AddItemToCartButton extends JButton {
    /**
     * Add item to shopping cart
     * @param itemTable item table with list of items
     * @param shoppingCartTable shopping cart table to add to
     * @param items list of items in table
     * @param quantityInput quantity of items to add to shopping cart
     */
    public AddItemToCartButton(JTable itemTable, JTable shoppingCartTable, List<Item> items, GeneralInput quantityInput) {
        setText("Add To Cart");
        setMinimumSize(new Dimension(150, 50));
        setMaximumSize(new Dimension(150, 50));
        addActionListener(new AddItemToCartButtonAction(itemTable, shoppingCartTable, items, quantityInput));
        setIcon(new ImageIcon("main/window/add-button.png"));
    }
}
