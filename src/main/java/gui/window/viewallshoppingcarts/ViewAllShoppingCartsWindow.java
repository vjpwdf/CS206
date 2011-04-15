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
    private JTable shoppingCarts;
    private JButton editShoppingCartButton;
    private JButton removeShoppingCartButton;
    private JButton computeSavingsButton;

    /**
     * Builds the view all shopping carts window
     * @throws HeadlessException thrown if could not build the shopping cart window
     */
    public ViewAllShoppingCartsWindow() throws HeadlessException {
        setTitle("View All Shopping Carts");
        setSize(WIDTH, HEIGHT);

        List<ShoppingCart> shoppingCartList = ShoppingCartServiceAdaptor.getAllShoppingCarts();
        Object[][] shoppingCartDates = getDatesFromShoppingCartList(shoppingCartList);

        DefaultTableModel shoppingCartTableModel = new DefaultTableModel(shoppingCartDates, new String[]{"Creation Date"});
        shoppingCarts = new JTable(shoppingCartTableModel);
        JScrollPane shoppingCartTablePane = new JScrollPane(shoppingCarts);

        Box allShoppingCartsBox = Box.createVerticalBox();

        allShoppingCartsBox.add(shoppingCartTablePane);

        Box allShoppingCartsButtonBox = Box.createHorizontalBox();
        editShoppingCartButton = new EditShoppingCartButton(shoppingCartList, shoppingCarts, this);
        removeShoppingCartButton = new RemoveShoppingCartButton(shoppingCartList, shoppingCarts, this);
        computeSavingsButton = new ComputeSavingsButton(shoppingCartList, shoppingCarts);
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

    /**
     * Gets a list of dates from the shopping cart list
     * @param shoppingCartList shopping cart list to get dates from
     * @return a list of dates from the shopping cart list
     */
    private Object[][] getDatesFromShoppingCartList(List<ShoppingCart> shoppingCartList) {
        Object[][] shoppingCartDates = new String[shoppingCartList.size()][1];
        for (int i = 0; i < shoppingCartList.size(); i++) {
            shoppingCartDates[i][0] = shoppingCartList.get(i).getCreationDate().toString();
        }
        return  shoppingCartDates;
    }

    public JTable getShoppingCarts() {
        return shoppingCarts;
    }

    public JButton getEditShoppingCartButton() {
        return editShoppingCartButton;
    }

    public JButton getRemoveShoppingCartButton() {
        return removeShoppingCartButton;
    }

    public JButton getComputeSavingsButton() {
        return computeSavingsButton;
    }
}