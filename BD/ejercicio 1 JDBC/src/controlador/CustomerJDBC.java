package controlador;

import modelo.Customer;
import modelo.ICustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerJDBC implements ICustomerDAO {
    private static String NOMBRE_TABLA = "customers";
    private static String CONSULTA_ALL = "select * from " + NOMBRE_TABLA;
    private static String CONSULTA_GET_BY_ID = "select * from " + NOMBRE_TABLA + " WHERE customerNumber=?";

    private static String CONSULTA_INSERT = "insert into " + NOMBRE_TABLA + " (customerNumber, customerName, contactLastName, contactFirstName, city, salesRepEmployeeNumber) VALUES (?, ?, ?, ?, ?, ?)";

    private static String CONSULTA_DELETE = "DELETE FROM " + NOMBRE_TABLA + " WHERE customerNumber = ?";

    private static String CONSULTA_FIND_BY_EMPLOYEE = "select * from " + NOMBRE_TABLA + " where salesRepEmployeeNumber=?";
    private Connection connection;

    public CustomerJDBC(Connection c) {
        connection = c;
    }

    @Override
    public ArrayList<Customer> selectAllRows() {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_ALL);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Customer> retorno = new ArrayList<Customer>();
            while (resultados.next()) {
                retorno.add(new Customer(resultados.getInt("customerNumber"), resultados.getString("customerName"),
                        resultados.getString("contactLastName"), resultados.getString("contactFirstName"),
                        resultados.getString("city"), resultados.getInt("salesRepEmployeeNumber")));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Customer> findCustomersByField(String field, String value) {
        try {
            // Aqui no me ha dejado utilizar las interragaciones para meter despues los valores no se porque
            String consulta = "select * from " + NOMBRE_TABLA + " where " + field + "=" + value;
            PreparedStatement prepared = connection.prepareStatement(consulta);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Customer> retorno = new ArrayList<Customer>();
            while (resultados.next()) {
                retorno.add(new Customer(resultados.getInt("customerNumber"), resultados.getString("customerName"),
                        resultados.getString("contactLastName"), resultados.getString("contactFirstName"),
                        resultados.getString("city"), resultados.getInt("salesRepEmployeeNumber")));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Customer selectCustomerById(int buscando) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_GET_BY_ID);
            prepared.setInt(1, buscando);
            ResultSet resultados = prepared.executeQuery();
            if (resultados.next()) {
                return new Customer(resultados.getInt("customerNumber"), resultados.getString("customerName"),
                        resultados.getString("contactLastName"), resultados.getString("contactFirstName"),
                        resultados.getString("city"), resultados.getInt("salesRepEmployeeNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insertCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName, String city, int salesRepEmployeeNumber) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_INSERT);
            prepared.setInt(1, customerNumber);
            prepared.setString(2, customerName);
            prepared.setString(3, contactLastName);
            prepared.setString(4, contactFirstName);
            prepared.setString(5, city);
            prepared.setInt(6, salesRepEmployeeNumber);
            prepared.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomerById(int buscando) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_DELETE);
            prepared.setInt(1, buscando);
            prepared.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateField(String field, String value, int id) {
        try {
            // Por seguridad hay que controlar que campo se va a actualizar
            // De lo contrario una persona podria setear cualquier campo
            String consulta = "UPDATE " + NOMBRE_TABLA + " SET " + field + "=? where customerNumber=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, value);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public ArrayList<Customer> selectCustomersByEmployee(int employeeNumber) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_FIND_BY_EMPLOYEE);
            prepared.setInt(1, employeeNumber);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Customer> retorno = new ArrayList<Customer>();
            while (resultados.next()) {
                retorno.add(new Customer(resultados.getInt("customerNumber"), resultados.getString("customerName"),
                        resultados.getString("contactLastName"), resultados.getString("contactFirstName"),
                        resultados.getString("city"), resultados.getInt("salesRepEmployeeNumber")));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }
    }
}

