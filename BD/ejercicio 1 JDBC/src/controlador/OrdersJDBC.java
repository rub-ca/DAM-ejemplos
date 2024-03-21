package controlador;

import modelo.IOrderDAO;
import modelo.Order;
import modelo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersJDBC implements IOrderDAO {
    private static String NOMBRE_TABLA = "orders";
    // Limito los registros a 40 porque salta error too many connections
    private static String CONSULTA_ALL = "select * from " + NOMBRE_TABLA + " LIMIT 40";
    private static String CONSULTA_GET_BY_ID = "select * from " + NOMBRE_TABLA + " WHERE orderNumber=?";
    private static String CONSULTA_INSERT = "insert into " + NOMBRE_TABLA + " (orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static String CONSULTA_DELETE = "DELETE FROM " + NOMBRE_TABLA + " WHERE orderNumber = ?";

    private Connection connection;

    public OrdersJDBC(Connection c) {
        connection = c;
    }

    public ArrayList<Order> selectAllRows() {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_ALL);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Order> retorno = new ArrayList<Order>();
            while (resultados.next()) {
                retorno.add(new Order(resultados.getInt("orderNumber"), resultados.getString("orderDate"), resultados.getString("requiredDate"), resultados.getString("shippedDate"), resultados.getString("status"), resultados.getString("comments"), resultados.getInt("customerNumber")));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertOrder(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber) {
        try {
            PreparedStatement stmt = connection.prepareStatement(CONSULTA_INSERT);
            stmt.setInt(1, orderNumber);
            stmt.setString(2, orderDate);
            stmt.setString(3, requiredDate);
            stmt.setString(4, shippedDate);
            stmt.setString(5, status);
            stmt.setString(6, comments);
            stmt.setInt(7, customerNumber);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Order selectOrderById(int id) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_GET_BY_ID);
            prepared.setInt(1, id);
            ResultSet resultados = prepared.executeQuery();
            if (resultados.next()) {
                return new Order(resultados.getInt("orderNumber"), resultados.getString("orderDate"), resultados.getString("requiredDate"), resultados.getString("shippedDate"), resultados.getString("status"), resultados.getString("comments"), resultados.getInt("customerNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String updateField(String field, String value, int id) {
        try {
            String consulta = "UPDATE " + NOMBRE_TABLA + " SET " + field + " = ? WHERE orderNumber = ?";
            PreparedStatement prepared = connection.prepareStatement(consulta);
            prepared.setString(1, value);
            prepared.setInt(2, id);
            prepared.executeUpdate();
            return "Campo actualizado";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar campo";
        }
    }

    public ArrayList<Order> findOrdersByField(String field, String value) {
        try {
            // Aqui no me ha dejado utilizar las interragaciones para meter despues los valores no se porque
            String consulta = "select * from " + NOMBRE_TABLA + " where " + field + "=" + value;
            PreparedStatement prepared = connection.prepareStatement(consulta);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Order> retorno = new ArrayList<Order>();
            while (resultados.next()) {
                retorno.add(new Order(resultados.getInt("orderNumber"), resultados.getString("orderDate"),
                        resultados.getString("requiredDate"), resultados.getString("shippedDate"),
                        resultados.getString("status"), resultados.getString("comments"),
                        resultados.getInt("customerNumber")));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int deleteOrderById(int orderNumber) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_DELETE);
            prepared.setInt(1, orderNumber);
            return prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -5;
        }
    }
}
