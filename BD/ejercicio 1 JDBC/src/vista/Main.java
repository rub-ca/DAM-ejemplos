package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Ejercicio de clase. Grado superior (DAM)

        Las posibles excepciones se controlan a fondo solo en la tabla products
        En el resto de tablas las excepciones serian controladas de forma similar

        Se adapta una tabla de entidad y una tabla de relacion al mismo objeto 'Order'

        Se pueden buscar clientes por empleados

        Se puede buscar el precio de compra de los productos

*/
public class Main {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL2 = "jdbc:mysql://192.168.56.101:3306/classicmodels?useSSL=false";

    //  Database credentials
    public static final String USER = "admin";
    public static final String PASS = "admin";

    public static void main(String[] args) throws SQLException {
        Consola.iniciar();
    }

    public static Connection getConnectionToDB() throws SQLException {
        return DriverManager.getConnection(DB_URL2, USER, PASS);
    }
}
