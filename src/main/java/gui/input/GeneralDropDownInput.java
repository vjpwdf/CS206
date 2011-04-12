package gui.input;

import hibernate.factory.DBClient;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: timhuff
 * Date: 3/13/11
 * Time: 2:11 PM
 */
public class GeneralDropDownInput extends Box {

    private JComboBox dropdown;
    private List list;

    /**
     * General drop down input list
     * @param label drop down list label
     * @param options list options
     */
    public GeneralDropDownInput(String label, String[] options) {
        super(0);
        list = Arrays.asList(options);
        setFields(label, options);
    }

    /**
     * General drop down input list
     * @param label label drop down list label
     * @param query query to perform to populate list
     */
    @SuppressWarnings("unchecked")
    public GeneralDropDownInput(String label, String query){
        super(0);
        list = DBClient.INSTANCE.getListOfObjects(query);
        List objectNames = new ArrayList();
        for (Object listOfObject : list) {
            objectNames.add(listOfObject.toString());
        }
        String[] names = new String[list.size()];
        setFields(label, (String[]) objectNames.toArray(names));
    }

    /**
     * Sets the fields for the drop down
     * @param label label to set
     * @param options list of options to set on drop down
     */
    private void setFields(String label, String[] options) {
        JLabel label1 = new JLabel(label);
        this.dropdown = new JComboBox(options);
        add(label1);
        add(dropdown);
        label1.setMaximumSize(new Dimension(100, 25));
        dropdown.setMaximumSize(new Dimension(200, 25));
    }

    /**
     * gets the selected object from the list of data
     * @return the selected object
     */
    public Object getSelectedObject(){
        return list.get(dropdown.getSelectedIndex());
    }

}
