package modelo;

import java.util.ArrayList;

public interface IOrderDAO {
    ArrayList<Order> selectAllRows();

    Order selectOrderById(int buscando);

    boolean insertOrder(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber);

    int deleteOrderById(int buscando);

    String updateField(String field, String value, int id);

    ArrayList<Order> findOrdersByField(String field, String value);

}
