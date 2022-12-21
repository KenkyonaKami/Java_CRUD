
package validator;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;


public class Validator {
    public boolean isPresent(JTextComponent c, String fieldName){
        if (c.getText().length() == 0) {
            showMessage(c, fieldName + " es un campo requerido.");
            c.requestFocusInWindow() ;
            return false;
        }
    return true;
}
public boolean isInteger(JTextComponent c, String fieldName){
    try{
        int i = Integer.parseInt(c.getText());
        return true;
    } catch (NumberFormatException e){
        showMessage(c, fieldName + " debe ser entero.");
        c.requestFocusInWindow() ;
        return false;
    }
}
public boolean isDouble(JTextComponent c, String fieldName) {
    try{
        double d = Double.parseDouble(c.getText());
        return true;
    } catch (NumberFormatException e){
        showMessage(c, fieldName + " debe ser un número válido.");
        c.requestFocusInWindow() ;
        return false;
    }
}
public void showMessage(JTextComponent c, String message){
    JOptionPane.showMessageDialog(c, message, "Dato no válido",
    JOptionPane.ERROR_MESSAGE);
}

public void showMessage2(JTextComponent c, String message){
    JOptionPane.showMessageDialog(c, message, "Dato no válido",
    JOptionPane.INFORMATION_MESSAGE);
}
}
