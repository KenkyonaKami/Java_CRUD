
package DataBase;
import java.sql.*;


public class ConectionDB {
    public Connection connectDatabase(String host, String port, String database,String user, String password) {
        String url = "";
        Connection connection = null;
        try {
            
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            
            url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(url,user, password);           
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) { 
            System.out.println("Error al conectar con la base de datos de PostgreSQL (" + url + "): " + sqle);
        }
    return connection;
    }
}
