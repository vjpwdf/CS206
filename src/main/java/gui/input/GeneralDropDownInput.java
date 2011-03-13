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
 * To change this template use File | Settings | File Templates.
 */
public class GeneralDropDownInput extends Box {

    private JLabel label;
    private JComboBox dropdown;
    private List list;

    public GeneralDropDownInput(String label, String[] options) {
        super(0);
        list = Arrays.asList(options);
        setFields(label, options);
    }

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

    private void setFields(String label, String[] options) {
        this.label = new JLabel(label);
        this.dropdown = new JComboBox(options);
        add(this.label);
        add(dropdown);
        this.label.setMaximumSize(new Dimension(100, 25));
        dropdown.setMaximumSize(new Dimension(200, 25));
    }

    public Object getSelectedObject(){
        return list.get(dropdown.getSelectedIndex());
    }

}
