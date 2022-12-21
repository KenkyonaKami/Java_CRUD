
package format;
import java.text.NumberFormat;

public class Format {
    
    public static String formaterNumber(double n){
        return NumberFormat.getCurrencyInstance().format(n);
    }
}
