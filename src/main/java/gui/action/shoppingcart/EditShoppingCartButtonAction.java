package gui.action.shoppingcart;

import gui.window.buildshoppingcart.BuildShoppingCartWindow;
import gui.window.viewallshoppingcarts.ViewAllShoppingCartsWindow;
import hibernate.ShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class EditShoppingCartButtonAction implements ActionListener {
    private ViewAllShoppingCartsWindow viewAllShoppingCartsWindow;
    private JTable shoppingCarts;
    private List<ShoppingCart> shoppingCartList;

    public EditShoppingCartButtonAction(List<ShoppingCart> shoppingCartList, JTable shoppingCarts, ViewAllShoppingCartsWindow viewAllShoppingCartsWindow) {
        this.shoppingCartList = shoppingCartList;
        this.shoppingCarts = shoppingCarts;
        this.viewAllShoppingCartsWindow = viewAllShoppingCartsWindow;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ShoppingCart selectedShoppingCart = shoppingCartList.get(shoppingCarts.getSelectedRow());
        viewAllShoppingCartsWindow.setVisible(false);
        BuildShoppingCartWindow buildShoppingCartWindow = new BuildShoppingCartWindow(selectedShoppingCart);
        buildShoppingCartWindow.setVisible(true);
    }
}
