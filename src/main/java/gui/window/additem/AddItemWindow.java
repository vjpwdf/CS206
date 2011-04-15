package gui.window.additem;

import gui.button.general.AddItemButton;
import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import gui.input.image.ImagePreviewPanel;
import gui.input.validate.MaxLengthFormValidator;
import gui.input.validate.MinLengthFormValidator;
import gui.input.validate.NumberFormValidator;
import hibernate.Item;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: vincent
 * Date: 12-Feb-2011
 * Time: 5:59:57 PM
 */
public class AddItemWindow extends JFrame {
    private static final Integer WIDTH = 600;
    private static final Integer HEIGHT = 330;

    private GeneralInput nameInput;
    private GeneralInput priceInput;
    private GeneralInput upc;
    private GeneralInput description;
    private GeneralInput manufacturer;
    private ImagePreviewPanel imagePreviewPanel;
    private JButton addItem;
    private GeneralInputFileBrowser fileBrowser;

    /**
     * Add item window
     * @param item item to overload to be able to save instead of add
     * @throws HeadlessException thrown if error upon creation
     */
    public AddItemWindow(Item item) throws HeadlessException {
        setTitle("Add An Item");
        setSize(WIDTH, HEIGHT);
        Box itemForm = Box.createVerticalBox();

        nameInput = new GeneralInput("Item Name", true);
        nameInput.addNewFormValidator(new MinLengthFormValidator(3));
        nameInput.addNewFormValidator(new MaxLengthFormValidator(30));
        itemForm.add(nameInput);

        priceInput = new GeneralInput("Price", true);
        priceInput.addNewFormValidator(new NumberFormValidator());
        itemForm.add(priceInput);

        upc = new GeneralInput("UPC", true);
        upc.addNewFormValidator(new MinLengthFormValidator(14));
        upc.addNewFormValidator(new MaxLengthFormValidator(14));
        itemForm.add(upc);

        description = new GeneralInput("Description", true);
        description.addNewFormValidator(new MaxLengthFormValidator(500));
        itemForm.add(description);

        manufacturer = new GeneralInput("Manufacturer", true);
        manufacturer.addNewFormValidator(new MinLengthFormValidator(3));
        manufacturer.addNewFormValidator(new MaxLengthFormValidator(100));
        itemForm.add(manufacturer);


        fileBrowser = new GeneralInputFileBrowser("Select Image");
        itemForm.add(fileBrowser);
        imagePreviewPanel = new ImagePreviewPanel(120, 120);
        itemForm.add(imagePreviewPanel);
        fileBrowser.getInput().addPropertyChangeListener(imagePreviewPanel);

        addItem = new AddItemButton("Add/Update Item", nameInput, priceInput, upc, description, manufacturer, fileBrowser, this, item);
        itemForm.add(addItem);

        add(itemForm);

        nameInput.getFormValidatorWorker().monitorButtons(Arrays.asList(addItem));
        priceInput.getFormValidatorWorker().monitorButtons(Arrays.asList(addItem));
        upc.getFormValidatorWorker().monitorButtons(Arrays.asList(addItem));
        description.getFormValidatorWorker().monitorButtons(Arrays.asList(addItem));
        manufacturer.getFormValidatorWorker().monitorButtons(Arrays.asList(addItem));


        if (item != null) {
            manufacturer.getInput().setText(item.getItemManufacturer());
            description.getInput().setText(item.getItemDescription());
            upc.getInput().setText(item.getItemUpc());
            priceInput.getInput().setText(Float.toString(item.getItemPrice()));
            nameInput.getInput().setText(item.getItemName());

            try {
                byte[] bytes = item.getItemImage().getBytes(1, (int) item.getItemImage().length());
                ImageIcon imageIcon = new ImageIcon(bytes);
                imagePreviewPanel.setImage(imageIcon.getImage());
                imagePreviewPanel.scaleImage();
                imagePreviewPanel.repaint();
            } catch (SQLException e) {
                //Do nothing
            }
        }
    }

    /**
     * Default add item window constructor - for adding item not updating
     * @throws HeadlessException thrown if error upon creation
     */
    public AddItemWindow() throws HeadlessException {
        this(null);
    }

    public GeneralInput getNameInput() {
        return nameInput;
    }

    public GeneralInput getPriceInput() {
        return priceInput;
    }

    public GeneralInput getUpc() {
        return upc;
    }

    public GeneralInput getDescription() {
        return description;
    }

    public GeneralInput getManufacturer() {
        return manufacturer;
    }

    public JButton getAddItem() {
        return addItem;
    }

    public GeneralInputFileBrowser getFileBrowser() {
        return fileBrowser;
    }
}
