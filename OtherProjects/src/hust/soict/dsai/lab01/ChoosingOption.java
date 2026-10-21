package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket?",
                "Choose an option", JOptionPane.YES_NO_CANCEL_OPTION);
        String result;
        if (option == JOptionPane.YES_OPTION) result = "Yes";
        else if (option == JOptionPane.NO_OPTION) result = "No";
        else result = "Cancel / Close";
        JOptionPane.showMessageDialog(null, "You've chosen: " + result);
    }
}
