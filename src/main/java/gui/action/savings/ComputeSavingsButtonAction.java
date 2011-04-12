package gui.action.savings;

import gui.window.savings.ComputeSavingsWindow;
import hibernate.ShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:32 PM
 */
public class ComputeSavingsButtonAction implements ActionListener {
    private JTable shoppingCarts;
    private List<ShoppingCart> shoppingCartList;

    /**
     * Compute savings button action
     * @param shoppingCartList shopping cart list
     * @param shoppingCarts shopping cart list table
     */
    public ComputeSavingsButtonAction(List<ShoppingCart> shoppingCartList, JTable shoppingCarts) {
        this.shoppingCartList = shoppingCartList;
        this.shoppingCarts = shoppingCarts;
    }

    /**
     * Computes the savings of a selected shopping cart opening a new window
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = shoppingCarts.getSelectedRow();
        ShoppingCart selectedShoppingCart = shoppingCartList.get(selectedRow);
        JFrame computeSavingsWindow = new ComputeSavingsWindow(selectedShoppingCart);
        computeSavingsWindow.setVisible(true);
    }
}
