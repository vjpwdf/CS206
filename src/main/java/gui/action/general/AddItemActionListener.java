package gui.action.general;

import gui.MessageBuilder;
import gui.input.GeneralInput;
import gui.input.GeneralInputFileBrowser;
import gui.window.additem.AddItemWindow;
import hibernate.Item;
import hibernate.serviceadaptor.ItemServiceAdaptor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 2/27/11
 * Time: 7:24 PM
 */
public class AddItemActionListener implements ActionListener {
    private GeneralInput nameInput;
    private GeneralInput priceInput;
    private GeneralInput upc;
    private GeneralInput description;
    private GeneralInput manufacturer;
    private GeneralInputFileBrowser fileBrowser;
    private AddItemWindow addItemWindow;
    private Item editingItem;
    private MessageBuilder messageBuilder = new MessageBuilder();

    /**
     * Action listener for add item button
     * @param nameInput name
     * @param priceInput price
     * @param upc upc
     * @param description description
     * @param manufacturer manufacturer
     * @param fileBrowser file browser for image
     * @param addItemWindow add item window to close upon success
     * @param item item to be modified
     */
    public AddItemActionListener(GeneralInput nameInput, GeneralInput priceInput, GeneralInput upc, GeneralInput description, GeneralInput manufacturer, GeneralInputFileBrowser fileBrowser, AddItemWindow addItemWindow, Item item) {
        this.nameInput = nameInput;
        this.priceInput = priceInput;
        this.upc = upc;
        this.description = description;
        this.manufacturer = manufacturer;
        this.fileBrowser = fileBrowser;
        this.addItemWindow = addItemWindow;
        this.editingItem = item;
    }

    /**
     * Add action event
     * @param actionEvent action event
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String name = nameInput.getInput().getText();
        String price = priceInput.getInput().getText();
        String upcVal = upc.getInput().getText();
        String descriptionVal = description.getInput().getText();
        String manufacturerVal = manufacturer.getInput().getText();
        byte[] imageBytes;
        try {
            imageBytes = convertFileToByteArray(new File(fileBrowser.getInput().getText()));
        } catch (FileNotFoundException e) {
            messageBuilder.displayMessage("Error", "Could Not Locate Image File", JOptionPane.OK_OPTION);
            return;
        }
        ItemServiceAdaptor.saveItem(name, price, upcVal, descriptionVal, manufacturerVal, imageBytes, editingItem);

        messageBuilder.displayMessage("Item has been successfully added/updated to/in the database.");
        addItemWindow.setVisible(false);
    }

    private byte[] convertFileToByteArray(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Could Not Locate Image File", JOptionPane.OK_OPTION);
        }

        return bos.toByteArray();
    }

    public void setMessageBuilder(MessageBuilder messageBuilder) {
        this.messageBuilder = messageBuilder;
    }
}
