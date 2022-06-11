package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionABD {

    static Connection connection = null;
    static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    static String url = "jdbc:ucanaccess://C:\\DBPasswordManager\\DBPasswordManager.accdb";

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(driver);
                connection = DriverManager.getConnection(url);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            connection = null;
            JOptionPane.showMessageDialog(null, "Error al guardar la cuenta en la BD");
        }
        return connection;
    }
}
