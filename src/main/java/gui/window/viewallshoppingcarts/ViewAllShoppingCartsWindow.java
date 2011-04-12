package gui.window.viewallshoppingcarts;

import gui.button.shoppingcart.ComputeSavingsButton;
import gui.button.shoppingcart.EditShoppingCartButton;
import gui.button.shoppingcart.RemoveShoppingCartButton;
import hibernate.ShoppingCart;
import hibernate.serviceadaptor.ShoppingCartServiceAdaptor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 6:10:14 PM
 */
public class ViewAllShoppingCartsWindow extends JFrame {
    private static final Integer WIDTH = 550;
    private static final Integer HEIGHT = 330;

    public ViewAllShoppingCartsWindow() throws HeadlessException {
        setTitle("View All Shopping Carts");
        setSize(WIDTH, HEIGHT);

        List<ShoppingCart> shoppingCartList = ShoppingCartServiceAdaptor.getAllShoppingCarts();
        Object[][] shoppingCartDates = getDatesFromShoppingCartList(shoppingCartList);

        DefaultTableModel shoppingCartTableModel = new DefaultTableModel(shoppingCartDates, new String[]{"Creation Date"});
        JTable shoppingCarts = new JTable(shoppingCartTableModel);
        JScrollPane shoppingCartTablePane = new JScrollPane(shoppingCarts);

        Box allShoppingCartsBox = Box.createVerticalBox();

        allShoppingCartsBox.add(shoppingCartTablePane);

        Box allShoppingCartsButtonBox = Box.createHorizontalBox();
        JButton editShoppingCartButton = new EditShoppingCartButton(shoppingCartList, shoppingCarts, this);
        JButton removeShoppingCartButton = new RemoveShoppingCartButton(shoppingCartList, shoppingCarts, this);
        JButton computeSavingsButton = new ComputeSavingsButton(shoppingCartList, shoppingCarts);
        editShoppingCartButton.setEnabled(false);
        removeShoppingCartButton.setEnabled(false);
        computeSavingsButton.setEnabled(false);
        allShoppingCartsButtonBox.add(editShoppingCartButton);
        allShoppingCartsButtonBox.add(removeShoppingCartButton);
        allShoppingCartsButtonBox.add(computeSavingsButton);
        allShoppingCartsBox.add(allShoppingCartsButtonBox);

        shoppingCarts.getSelectionModel().addListSelectionListener(new ShoppingCartTableListener(Arrays.asList(editShoppingCartButton, removeShoppingCartButton, computeSavingsButton)));

        add(allShoppingCartsBox);

    }

    private Object[][] getDatesFromShoppingCartList(List<ShoppingCart> shoppingCartList) {
        Object[][] shoppingCartDates = new String[shoppingCartList.size()][1];
        for (int i = 0; i < shoppingCartList.size(); i++) {
            shoppingCartDates[i][0] = shoppingCartList.get(i).getCreationDate().toString();
        }
        return  shoppingCartDates;
    }
}