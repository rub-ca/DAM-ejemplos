package modelo;

import vista.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Order {
    private int orderNumber;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    private int productsAmount;
    private String[] productCodes;
    private int[] quantitiesOrdered;
    private float[] pricesEach;

    public Order(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status, String comments, int customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;

        inicializarDetalles();
    }

    private void inicializarDetalles() {
        /*
         * Hola profe si ves esto puedes pensar que no es el mejor sitio para acceder a la base de datos
         * ya que estamos en el modelo y deberiamos de hacerlo en el controlador pero como no hemos creado
         * un controlador para la tabla ordersDetails no se cual es la forma correcta de abstraer esto
         * */
        try {
            String consultaCantidad = "SELECT COUNT(orderNumber) as cantidad FROM classicmodels.orderdetails where orderNumber=?";
            String consultaDetalles = "SELECT * FROM classicmodels.orderdetails where orderNumber=?";

            Connection conexion = Main.getConnectionToDB();

            // Consulta para obtener la cantidad de productos en la orden
            PreparedStatement preparedCantidad = conexion.prepareStatement(consultaCantidad);
            preparedCantidad.setInt(1, orderNumber);
            ResultSet resultadosCantidad = preparedCantidad.executeQuery();

            if (resultadosCantidad.next()) {
                // Obtenemos la cantidad de articulos del pedido
                productsAmount = resultadosCantidad.getInt("cantidad");

                // Incializamos los arrays con la cantidad de articulos pedidos
                productCodes = new String[productsAmount];
                quantitiesOrdered = new int[productsAmount];
                pricesEach = new float[productsAmount];

                PreparedStatement preparedDetalles = conexion.prepareStatement(consultaDetalles);
                preparedDetalles.setInt(1, orderNumber);
                ResultSet resultadosDetalles = preparedDetalles.executeQuery();

                for (int x = 0; x < productsAmount; x++) {
                    if (resultadosDetalles.next()) {
                        productCodes[x] = resultadosDetalles.getString("productCode");
                        quantitiesOrdered[x] = resultadosDetalles.getInt("quantityOrdered");
                        pricesEach[x] = resultadosDetalles.getFloat("priceEach");
                    }
                }
            } else {
                System.out.println("orderNumber no encontrado");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String retorno = "orderNumber=" + orderNumber +
                ", orderDate='" + orderDate + '\'' +
                ", requiredDate='" + requiredDate + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customerNumber=" + customerNumber;

        for (int x = 0; x < productsAmount; x++) {
            retorno += "\n\t\tproductCode=" + productCodes[x] +
                    ", quantityOrdered=" + quantitiesOrdered[x] +
                    ", priceEach=" + pricesEach[x];
        }

        return retorno;
    }
}
