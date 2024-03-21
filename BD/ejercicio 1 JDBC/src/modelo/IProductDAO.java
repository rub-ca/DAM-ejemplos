package modelo;

import java.util.ArrayList;

public interface IProductDAO {

    ArrayList<Product> selectAllRows();

    ArrayList<Product> findProductsByField(String field, String value);

    Product selectProductById(String buscando);

    boolean insertProduct(String productCode, String productName, String productVendor, String productDescription, int quantityInStock, double buyPrice);

    int deleteProductById(String buscando);

    String updateField(String field, String value, String id);

    float selectAvgPrice();
}
