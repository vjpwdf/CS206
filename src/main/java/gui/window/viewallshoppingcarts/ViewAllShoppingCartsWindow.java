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
        setWindowProperties();

        List<ShoppingCart> shoppingCartList = ShoppingCartServiceAdaptor.getAllShoppingCarts();
        Object[][] shoppingCartDates = getDatesFromShoppingCartList(shoppingCartList);

        JScrollPane shoppingCartTablePane = buildShoppingCartsTable(shoppingCartDates);

        Box allShoppingCartsBox = Box.createVerticalBox();

        allShoppingCartsBox.add(shoppingCartTablePane);

        Box allShoppingCartsButtonBox = Box.createHorizontalBox();
        buildShoppingCartButton(shoppingCartList);
        buildRemoveShoppingCartButton(shoppingCartList);
        buildComputeSavingsButton(shoppingCartList);

        allShoppingCartsButtonBox.add(editShoppingCartButton);
        allShoppingCartsButtonBox.add(removeShoppingCartButton);
        allShoppingCartsButtonBox.add(computeSavingsButton);
        allShoppingCartsBox.add(allShoppingCartsButtonBox);

        addSelectionListenerToTable();

        add(allShoppingCartsBox);
    }

    /**
     * Adds a list selection listener to the shopping cart table to dynamically enable/disable buttons upon row selection
     */
    private void addSelectionListenerToTable() {
        shoppingCarts.getSelectionModel().addListSelectionListener(new ShoppingCartTableListener(Arrays.asList(editShoppingCartButton, removeShoppingCartButton, computeSavingsButton)));
    }

    /**
     * Builds the compute savings button
     * @param shoppingCartList shopping cat list of all shopping carts
     */
    private void buildComputeSavingsButton(List<ShoppingCart> shoppingCartList) {
        computeSavingsButton = new ComputeSavingsButton(shoppingCartList, shoppingCarts);
        computeSavingsButton.setEnabled(false);
    }

    /**
     * Builds the remove shopping cart button
     * @param shoppingCartList shopping cart list of all shopping carts
     */
    private void buildRemoveShoppingCartButton(List<ShoppingCart> shoppingCartList) {
        removeShoppingCartButton = new RemoveShoppingCartButton(shoppingCartList, shoppingCarts, this);
        removeShoppingCartButton.setEnabled(false);
    }

    /**
     * Builds the edit shopping cart button
     * @param shoppingCartList list of all shopping carts
     */
    private void buildShoppingCartButton(List<ShoppingCart> shoppingCartList) {
        editShoppingCartButton = new EditShoppingCartButton(shoppingCartList, shoppingCarts, this);
        editShoppingCartButton.setEnabled(false);
    }

    /**
     * Builds the shopping cart table from shopping cart dates
     * @param shoppingCartDates dates to build the table from
     * @return A scroll pane with the table attached to it
     */
    private JScrollPane buildShoppingCartsTable(Object[][] shoppingCartDates) {
        DefaultTableModel shoppingCartTableModel = new DefaultTableModel(shoppingCartDates, new String[]{"Creation Date"});
        shoppingCarts = new JTable(shoppingCartTableModel);
        return new JScrollPane(shoppingCarts);
    }

    /**
     * Sets the view all shopping carts window properties
     */
    private void setWindowProperties() {
        setTitle("View All Shopping Carts");
        setSize(WIDTH, HEIGHT);
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

    /**
     * Gets shopping carts table
     * @return the shopping carts table
     */
    public JTable getShoppingCarts() {
        return shoppingCarts;
    }

    /**
     * Gets the edit shopping cart button
     * @return the edit shopping cart button
     */
    public JButton getEditShoppingCartButton() {
        return editShoppingCartButton;
    }

    /**
     * Gets the remove shopping cart button
     * @return the remove shopping cart button
     */
    public JButton getRemoveShoppingCartButton() {
        return removeShoppingCartButton;
    }

    /**
     * Gets the compute savings button
     * @return the compute savings button
     */
    public JButton getComputeSavingsButton() {
        return computeSavingsButton;
    }
}