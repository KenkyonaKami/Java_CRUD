
package format;

import java.util.Date;
import java.util.GregorianCalendar;


public class FormatDate {
    public static java.sql.Date formatDate(String fecha){
            String [] stri = fecha.split("-");
            int dia = Integer.parseInt(stri[0]);
            int mes = Integer.parseInt(stri[1]);
            int anio = Integer.parseInt(stri[2]);
            
        GregorianCalendar gc = new GregorianCalendar(anio , mes-1 , dia);
        Date date = gc.getTime();
        java.sql.Date a = new java.sql.Date(date.getTime());
        return a;
    }
}
