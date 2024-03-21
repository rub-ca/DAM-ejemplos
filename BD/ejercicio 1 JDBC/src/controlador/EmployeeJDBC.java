package controlador;

import modelo.Employee;
import modelo.IEmployeeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeJDBC implements IEmployeeDAO {
    private static String NOMBRE_TABLA = "employees";

    private static String CONSULTA_ALL = "select * from " + NOMBRE_TABLA;
    private static String CONSULTA_GET_BY_ID = "select * from " + NOMBRE_TABLA + " WHERE employeeNumber=?";
    private static String CONSULTA_INSERT = "insert into " + NOMBRE_TABLA + " (employeeNumber, lastName, firstName, email, reportsTo, jobTitle) VALUES (?, ?, ?, ?, ?, ?)";

    private static String CONSULTA_DELETE = "DELETE FROM " + NOMBRE_TABLA + " WHERE employeeNumber = ?";

    private Connection connection;

    public EmployeeJDBC(Connection c) {
        connection = c;
    }

    @Override
    public ArrayList<Employee> selectAllRows() throws SQLException {
        PreparedStatement prepared = connection.prepareStatement(CONSULTA_ALL);
        ResultSet resultados = prepared.executeQuery();
        ArrayList<Employee> retorno = new ArrayList<Employee>();
        while (resultados.next()) {
            retorno.add(new Employee(resultados.getInt("employeeNumber"), resultados.getString("lastName"),
                    resultados.getString("firstName"), resultados.getString("email"),
                    resultados.getInt("reportsTo"), resultados.getString("jobTitle")));
        }
        return retorno;
    }

    public ArrayList<Employee> findEmployeesByField(String field, String value) {
        try {
            // Aqui no me ha dejado utilizar las interragaciones para meter despues los valores no se porque
            String consulta = "select * from " + NOMBRE_TABLA + " where " + field + "=" + value;
            PreparedStatement prepared = connection.prepareStatement(consulta);
            ResultSet resultados = prepared.executeQuery();
            ArrayList<Employee> retorno = new ArrayList<Employee>();
            while (resultados.next()) {
                retorno.add(new Employee(resultados.getInt("employeeNumber"), resultados.getString("lastName"),
                        resultados.getString("firstName"), resultados.getString("email"),
                        resultados.getInt("reportsTo"), resultados.getString("jobTitle")));
            }
            return retorno;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee selectEmployeeById(int buscando) throws SQLException {
        PreparedStatement prepared = connection.prepareStatement(CONSULTA_GET_BY_ID);
        prepared.setInt(1, buscando);
        ResultSet resultados = prepared.executeQuery();
        if (resultados.next()) {
            return new Employee(resultados.getInt("employeeNumber"), resultados.getString("lastName"),
                    resultados.getString("firstName"), resultados.getString("email"),
                    resultados.getInt("reportsTo"), resultados.getString("jobTitle"));
        }
        return null;
    }


    @Override
    public boolean insertEmployee(int employeeNumber, String lastName, String firstName, String email, int reportsTo, String jobTitle) {
        try {
            PreparedStatement stmt = connection.prepareStatement(CONSULTA_INSERT);
            stmt.setInt(1, employeeNumber);
            stmt.setString(2, lastName);
            stmt.setString(3, firstName);
            stmt.setString(4, email);
            stmt.setInt(5, reportsTo);
            stmt.setString(6, jobTitle);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean deleteEmployeeById(int buscando) {
        try {
            PreparedStatement prepared = connection.prepareStatement(CONSULTA_DELETE);
            prepared.setInt(1, buscando);
            prepared.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateField(String field, String value, int id) {
        try {
            // Por seguridad hay que controlar que campo se va a actualizar
            // De lo contrario una persona podria setear cualquier campo
            String consulta = "UPDATE " + NOMBRE_TABLA + " SET " + field + "=? where employeeNumber=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, value);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
