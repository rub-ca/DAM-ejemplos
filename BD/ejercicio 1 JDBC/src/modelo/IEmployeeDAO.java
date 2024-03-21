package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEmployeeDAO {
    ArrayList<Employee> selectAllRows() throws SQLException;

    Employee selectEmployeeById(int buscando) throws SQLException;

    boolean insertEmployee(int employeeNumber, String lastName, String firstName, String email, int reportsTo, String jobTitle);

    boolean deleteEmployeeById(int buscando);

    boolean updateField(String field, String value, int id);

    ArrayList<Employee> findEmployeesByField(String field, String value);
}