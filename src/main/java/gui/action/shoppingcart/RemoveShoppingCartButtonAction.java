package gui.action.shoppingcart;

import gui.MessageBuilder;
import gui.window.viewallshoppingcarts.ViewAllShoppingCartsWindow;
import hibernate.ShoppingCart;
import hibernate.serviceadaptor.ShoppingCartServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 11/04/11
 * Time: 2:24 PM
 */
public class RemoveShoppingCartButtonAction implements ActionListener {
    private JTable shoppingCarts;
    private List<ShoppingCart> shoppingCartList;
    private ViewAllShoppingCartsWindow viewAllShoppingCartsWindow;
    private MessageBuilder messageBuilder = new MessageBuilder();

    /**
     * Remove shopping cart button action
     * @param shoppingCartList shopping cart list
     * @param shoppingCarts shopping cart table
     * @param viewAllShoppingCartsWindow window to close upon completion
     */
    public RemoveShoppingCartButtonAction(List<ShoppingCart> shoppingCartList, JTable shoppingCarts, ViewAllShoppingCartsWindow viewAllShoppingCartsWindow) {
        this.shoppingCartList = shoppingCartList;
        this.shoppingCarts = shoppingCarts;
        this.viewAllShoppingCartsWindow = viewAllShoppingCartsWindow;
    }

    /**
     * Action to remove a shopping cart
     * @param actionEvent ignored
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int selectedRow = shoppingCarts.getSelectedRow();
        ShoppingCart selectedShoppingCart = shoppingCartList.get(selectedRow);
        ShoppingCartServiceAdaptor.removeShoppingCart(selectedShoppingCart);

        messageBuilder.displayMessage("Shopping cart has been successfully removed from the database.");
        viewAllShoppingCartsWindow.setVisible(false);

        viewAllShoppingCartsWindow = new ViewAllShoppingCartsWindow();
        viewAllShoppingCartsWindow.setVisible(true);
    }

    public void setMessageBuilder(MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }
}
