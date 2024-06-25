package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private String db = "citas";  
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";  
    private String password = "";  
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection cx;  

    // Constructor
    public MySQL() {
        try {
            // Cargar el driver JDBC
            Class.forName(driver);
            // Establecer la conexión
            cx = DriverManager.getConnection(url + db, user, password);
            if (cx != null) {
                System.out.println("Conexión exitosa a la base de datos " + db);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return cx;
    }

    // Método para cerrar la conexión
    public void closeConnection() {
        try {
            if (cx != null && !cx.isClosed()) {
                cx.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
