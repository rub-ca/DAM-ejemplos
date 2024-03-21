package controlador;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import modelo.IProductDAO;
import modelo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductJDBC implements IProductDAO {
    private static String NOMBRE_TABLA = "products";
    private static String CONSULTA_ALL = "select * from " + NOMBRE_TABLA;
    private static String CONSULTA_GET_BY_ID = "select * from " + NOMBRE_TABLA + " WHERE productCode=?";
    private static String CONSULTA_INSERT = "insert into " + NOMBRE_TABLA + " (productCode, productName, productVendor, productDescription, quantityInStock, buyPrice) VALUES (?, ?, ?, ?, ?, ?)";
    private static String CONSULTA_DELETE = "DELETE FROM " + NOMBRE_TABLA + " WHERE productCode = ?";


    private Connection connection;

    public ProductJDBC(Connection c) {
        connection = c;
    }

    @Override
    public ArrayList<Product> selectAllRows() {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_ALL);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Product> retorno = new ArrayList<Product>();
            while (resultados.next()) {
                retorno.add(new Product(resultados.getString("productCode"), resultados.getString("productName"),
                        resultados.getString("productVendor"), resultados.getString("productDescription"),
                        resultados.getInt("quantityInStock"), resultados.getDouble("buyPrice")));
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public ArrayList<Product> findProductsByField(String field, String value) {
        try {
            // Aqui no me ha dejado utilizar las interragaciones para meter despues los valores no se porque
            String consulta = "select * from " + NOMBRE_TABLA + " where " + field + "=" + value;
            PreparedStatement prepared = connection.prepareStatement(consulta);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Product> retorno = new ArrayList<Product>();
            while (resultados.next()) {
                retorno.add(new Product(resultados.getString("productCode"), resultados.getString("productName"),
                        resultados.getString("productVendor"), resultados.getString("productDescription"),
                        resultados.getInt("quantityInStock"), resultados.getDouble("buyPrice")));
            }
            return retorno;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Product selectProductById(String buscando) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_GET_BY_ID);
            prepared.setString(1, buscando);
            ResultSet resultados = prepared.executeQuery();
            if (resultados.next()) {
                return new Product(resultados.getString("productCode"), resultados.getString("productName"),
                        resultados.getString("productVendor"), resultados.getString("productDescription"),
                        resultados.getInt("quantityInStock"), resultados.getDouble("buyPrice"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public boolean insertProduct(String productCode, String productName, String productVendor, String
            productDescription, int quantityInStock, double buyPrice) {
        try {
            PreparedStatement stmt = connection.prepareStatement(CONSULTA_INSERT);
            stmt.setString(1, productCode);
            stmt.setString(2, productName);
            stmt.setString(3, productVendor);
            stmt.setString(4, productDescription);
            stmt.setInt(5, quantityInStock);
            stmt.setDouble(6, buyPrice);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            int codigoError = e.getErrorCode();
            System.out.println("CODIGO ERROR: " + codigoError);
            switch (codigoError) {
                case 1062:
                    System.out.println("Ya existe un registro con ese id");
                    return false;
                case 1366:
                    System.out.println("Debes introducir un tipo de dato correcto");
                    return false;
            }
            return false;
        }
    }

    @Override
    public int deleteProductById(String buscando) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_DELETE);
            prepared.setString(1, buscando);
            return prepared.executeUpdate();
        } catch (SQLException e) {
            return -5;
        }
    }

    @Override
    public String updateField(String field, String value, String id) {
        try {
            // Por seguridad hay que controlar que campo se va a actualizar
            // De lo contrario una persona podria setear cualquier campo
            String consulta = "UPDATE " + NOMBRE_TABLA + " SET " + field + "=? where productCode=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, value);
            stmt.setString(2, id);
            return "Registros actualizados: " + stmt.executeUpdate();
        } catch (SQLException e) {
            int codigoError = e.getErrorCode();
            System.out.println("CODIGO ERROR: " + codigoError);
            switch (codigoError) {
                case 1054:
                    return "Campo no encontrado";
                case 1064:
                    return "Syntax error";
                case 1366:
                    return "Debes introducir un tipo de dato correcto";
            }
            System.out.println(e.getErrorCode());
            return "No se ha podido actualizar el registro";
        }
    }

    public float selectAvgPrice() {
        try {
            String consulta = "SELECT AVG(buyPrice) FROM " + NOMBRE_TABLA;
            PreparedStatement prepared = connection.prepareStatement(consulta);
            ResultSet resultados = prepared.executeQuery();
            if (resultados.next()) {
                return resultados.getFloat(1);
            }
        } catch (SQLException e) {
        }
        return -1;
    }
}
