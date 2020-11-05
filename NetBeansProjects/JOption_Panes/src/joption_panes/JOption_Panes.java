package joption_panes;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.*;

public class JOption_Panes {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Message inside a window", "Message in a tittle bar", JOptionPane.WARNING_MESSAGE);
        //showConfirmDialog
        int confirmed = JOptionPane.showConfirmDialog(null, "Do you confirm this?");

        if (JOptionPane.OK_OPTION == confirmed) {
            System.out.println("Confirmed");
        } else {
            System.out.println("Ok... I don't delete anything...");
        }
        //showOptionDialog
        int selection = JOptionPane.showOptionDialog(null, "Select option", "Options Selector",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"option 1", "option 2", "option 3"},
                "option 2");
        if (selection != -1) {
            System.out.println("selected option" + (selection + 1));
        }
        // With text box
        String sel = JOptionPane.showInputDialog(null, "Input dialog", JOptionPane.QUESTION_MESSAGE); // the icon will be a questioner
        System.out.println("The user has typed" + sel);
        // With JCombobox
        Object selec = JOptionPane.showInputDialog(null, "Select option", "Options Selector", JOptionPane.QUESTION_MESSAGE,
                null, // null for default icon
                new Object[]{"option 1", "option 2", "option 3"},
                "option 1");
        System.out.println("The user has chosen" + selec);

    }

}
