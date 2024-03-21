package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICustomerDAO {
    ArrayList<Customer> selectAllRows();

    Customer selectCustomerById(int buscando);

    boolean insertCustomer(int customerNumber, String customerName, String contactLastName, String contactFirstName, String city, int salesRepEmployeeNumber);

    boolean deleteCustomerById(int buscando);

    boolean updateField(String field, String value, int id);

    ArrayList<Customer> selectCustomersByEmployee(int employeeNumber);

    ArrayList<Customer> findCustomersByField(String field, String value);
}
