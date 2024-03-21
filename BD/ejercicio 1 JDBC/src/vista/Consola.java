package vista;

import controlador.CustomerJDBC;
import controlador.EmployeeJDBC;
import controlador.OrdersJDBC;
import controlador.ProductJDBC;
import modelo.Customer;
import modelo.Employee;
import modelo.Order;
import modelo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static vista.Main.*;

//import static obtenerConexion;

public class Consola {

    public static void iniciar() {
        System.out.println("\n\n\nBienvenido a la consola de la base de datos de Classic Models\n");
        while (true) {
            System.out.println("\nOpciones:\n");
            System.out.println("[0] Salir");
            System.out.println("[1] Tabla Products");
            System.out.println("[2] Tabla Customers");
            System.out.println("[3] Tabla Employees");
            System.out.println("[4] Tabla Orders");
            System.out.print("\nOpcion -> $");

            Scanner sca = new Scanner(System.in);
            int opcion = sca.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("\n\nSaliendo...\n");
                    System.exit(0);
                    break;
                case 1:
                    tablaProducts();
                    break;
                case 2:
                    tablaCustomers();
                    break;
                case 3:
                    tablaEmployees();
                    break;
                case 4:
                    tablaOrders();
                    break;

                default:
                    System.out.println("Seleccione una tabla ");
                    break;
            }
        }
    }

    private static void tablaProducts() {
        try {
            System.out.println("\nColumnas de la tabla Products:");
            System.out.println("productCode productName productVendor productDescription quantityInStock buyPrice\n");
            printMenuStandar("[7] obtener el precio medio de compra de los productos");

            Scanner scaInt = new Scanner(System.in);
            Scanner scaStr = new Scanner(System.in);
            int opcion = scaInt.nextInt();

            ProductJDBC conexionProducto = new ProductJDBC(getConnectionToDB());

            switch (opcion) {
                case 1:
                    ArrayList<Product> array = conexionProducto.selectAllRows();
                    for (Product s : array) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    System.out.print("Introduzca ID: ");
                    String intro2 = scaStr.nextLine();
                    Product p = conexionProducto.selectProductById(intro2);
                    if (p == null) System.out.println("\nNo se ha encontrado el registro");
                    else System.out.println("\n" + p);
                    break;
                case 3:
                    System.out.println("Insertar registro");
                    System.out.print("Introduzca productCode: ");
                    String intro3productCode = scaStr.nextLine();
                    System.out.print("Introduzca productName: ");
                    String intro3productName = scaStr.nextLine();
                    System.out.print("Introduzca productVendor: ");
                    String intro3productVendor = scaStr.nextLine();
                    System.out.print("Introduzca productDescription: ");
                    String intro3productDescription = scaStr.nextLine();
                    System.out.print("Introduzca quantityInStock: ");
                    int intro3quantityInStock = scaInt.nextInt();
                    System.out.print("Introduzca buyPrice: ");
                    double intro3buyPrice = scaInt.nextDouble();
                    System.out.println("\n" + conexionProducto.insertProduct(intro3productCode, intro3productName, intro3productVendor, intro3productDescription, intro3quantityInStock, intro3buyPrice));
                    break;
                case 4:
                    System.out.println("Eliminar registro por ID");
                    System.out.print("Introduzca ID: ");
                    String intro4 = scaStr.nextLine();
                    if (conexionProducto.deleteProductById(intro4) == 0)
                        System.out.println("No se ha encontrado el registro");
                    else System.out.println("Registro eliminado");
                    break;
                case 5:
                    System.out.println("Actualizar campo");
                    System.out.print("Introduzca ID: ");
                    String intro5 = scaStr.nextLine();
                    System.out.print("Introduzca columna: ");
                    String intro5columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro5valor = scaStr.nextLine();
                    System.out.println("\n" + conexionProducto.updateField(intro5columna, intro5valor, intro5));
                    break;
                case 6:
                    System.out.println("Buscar registros por campo");
                    System.out.print("Introduzca columna: ");
                    String intro6columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro6valor = scaStr.nextLine();
                    intro6valor += "'";
                    intro6valor = "'" + intro6valor;
                    ArrayList<Product> array6 = conexionProducto.findProductsByField(intro6columna, intro6valor);
                    for (Product s : array6) {
                        System.out.println(s);
                    }
                    System.out.println(array6.size() + " registros encontrados");
                    break;
                case 7:
                    System.out.println("Precio medio de compra de los productos: " + conexionProducto.selectAvgPrice());
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InputMismatchException a) {
            System.out.println("Introduce un tipo de valor adecuado");
        }
    }

    private static void tablaCustomers() {
        try {
            System.out.println("Columnas:");
            System.out.println("customerNumber customerName contactLastName contactFirstName  city salesRepEmployeeNumber");
            printMenuStandar("[7] Buscar clientes por empleados");

            Scanner scaInt = new Scanner(System.in);
            Scanner scaStr = new Scanner(System.in);
            int opcion = scaInt.nextInt();

            CustomerJDBC conexionCliente = new CustomerJDBC(getConnectionToDB());

            switch (opcion) {
                case 1:
                    ArrayList<Customer> array = conexionCliente.selectAllRows();
                    for (Customer s : array) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    System.out.print("Introduzca ID: ");
                    int intro2 = scaInt.nextInt();
                    Customer c = conexionCliente.selectCustomerById(intro2);
                    if (c == null) System.out.println("\nNo se ha encontrado el registro");
                    else System.out.println("\n" + c);
                    break;
                case 3:
                    System.out.println("Insertar registro");
                    System.out.print("Introduzca customerNumber: ");
                    int intro3customerNumber = scaInt.nextInt();
                    System.out.print("Introduzca customerName: ");
                    String intro3customerName = scaStr.nextLine();
                    System.out.print("Introduzca contactLastName: ");
                    String intro3contactLastName = scaStr.nextLine();
                    System.out.print("Introduzca contactFirstName: ");
                    String intro3contactFirstName = scaStr.nextLine();
                    System.out.print("Introduzca city: ");
                    String intro3city = scaStr.nextLine();
                    System.out.print("Introduzca salesRepEmployeeNumber: ");
                    int intro3salesRepEmployeeNumber = scaInt.nextInt();
                    System.out.println("\n" + conexionCliente.insertCustomer(intro3customerNumber, intro3customerName, intro3contactLastName, intro3contactFirstName, intro3city, intro3salesRepEmployeeNumber));
                    break;
                case 4:
                    System.out.println("Eliminar registro por ID");
                    System.out.print("Introduzca ID: ");
                    int intro4 = scaInt.nextInt();
                    if (conexionCliente.deleteCustomerById(intro4)) System.out.println("Registro eliminado");
                    else System.out.println("No se ha encontrado el registro");
                    break;
                case 5:
                    System.out.println("Actualizar campo");
                    System.out.print("Introduzca ID: ");
                    int intro5 = scaInt.nextInt();
                    System.out.print("Introduzca columna: ");
                    String intro5columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro5valor = scaStr.nextLine();
                    System.out.println("\n" + conexionCliente.updateField(intro5columna, intro5valor, intro5));
                    break;
                case 6:
                    System.out.println("Buscar registros por campo");
                    System.out.print("Introduzca columna: ");
                    String intro6columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro6valor = scaStr.nextLine();
                    intro6valor += "'";
                    intro6valor = "'" + intro6valor;
                    ArrayList<Customer> array6 = conexionCliente.findCustomersByField(intro6columna, intro6valor);
                    for (Customer s : array6) {
                        System.out.println(s);
                    }
                    System.out.println(array6.size() + " registros encontrados");
                    break;

                case 7:
                    System.out.println("Buscar clientes por empleados");
                    System.out.print("Introduzca ID del empleado: ");
                    int intro7 = scaInt.nextInt();
                    ArrayList<Customer> array7 = conexionCliente.selectCustomersByEmployee(intro7);
                    for (Customer s : array7) {
                        System.out.println(s);
                    }
                    System.out.println(array7.size() + " registros encontrados");
                    break;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void tablaEmployees() {
        try {
            System.out.println("Columnas:");
            System.out.println("employeeNumber lastName firstName email reportsTo jobTitle");
            printMenuStandar();

            Scanner scaInt = new Scanner(System.in);
            Scanner scaStr = new Scanner(System.in);
            int opcion = scaInt.nextInt();

            EmployeeJDBC conexionEmpleado = new EmployeeJDBC(getConnectionToDB());

            switch (opcion) {
                case 1:
                    ArrayList<Employee> array = conexionEmpleado.selectAllRows();
                    for (Employee s : array) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    System.out.print("Introduzca ID: ");
                    int intro2 = scaInt.nextInt();
                    Employee e = conexionEmpleado.selectEmployeeById(intro2);
                    if (e == null) System.out.println("\nNo se ha encontrado el registro");
                    else System.out.println("\n" + e);
                    break;
                case 3:
                    System.out.println("Insertar registro");
                    System.out.print("Introduzca employeeNumber: ");
                    int intro3employeeNumber = scaInt.nextInt();
                    System.out.print("Introduzca lastName: ");
                    String intro3lastName = scaStr.nextLine();
                    System.out.print("Introduzca firstName: ");
                    String intro3firstName = scaStr.nextLine();
                    System.out.print("Introduzca email: ");
                    String intro3email = scaStr.nextLine();
                    System.out.print("Introduzca reportsTo: ");
                    int intro3reportsTo = scaInt.nextInt();
                    System.out.print("Introduzca jobTitle: ");
                    String intro3jobTitle = scaStr.nextLine();
                    System.out.println("\n" + conexionEmpleado.insertEmployee(intro3employeeNumber, intro3lastName, intro3firstName, intro3email, intro3reportsTo, intro3jobTitle));
                    break;
                case 4:
                    System.out.println("Eliminar registro por ID");
                    System.out.print("Introduzca ID: ");
                    int intro4 = scaInt.nextInt();
                    if (conexionEmpleado.deleteEmployeeById(intro4)) System.out.println("Registro eliminado");
                    else System.out.println("No se ha encontrado el registro");
                    break;
                case 5:
                    System.out.println("Actualizar campo");
                    System.out.print("Introduzca ID: ");
                    int intro5 = scaInt.nextInt();
                    System.out.print("Introduzca columna: ");
                    String intro5columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro5valor = scaStr.nextLine();
                    System.out.println("\n" + conexionEmpleado.updateField(intro5columna, intro5valor, intro5));
                    break;
                case 6:
                    System.out.println("Buscar registros por campo");
                    System.out.print("Introduzca columna: ");
                    String intro6columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro6valor = scaStr.nextLine();
                    intro6valor += "'";
                    intro6valor = "'" + intro6valor;
                    ArrayList<Employee> array6 = conexionEmpleado.findEmployeesByField(intro6columna, intro6valor);
                    for (Employee s : array6) {
                        System.out.println(s);
                    }
                    System.out.println(array6.size() + " registros encontrados");
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void tablaOrders() {
        try {
            System.out.println("Columnas:");
            System.out.println("orderNumber orderDate requiredDate shippedDate status comments customerNumber");
            printMenuStandar();

            Scanner scaInt = new Scanner(System.in);
            Scanner scaStr = new Scanner(System.in);
            int opcion = scaInt.nextInt();

            OrdersJDBC conexionPedido = new OrdersJDBC(getConnectionToDB());

            switch (opcion) {
                case 1:
                    ArrayList<Order> array = conexionPedido.selectAllRows();
                    for (Order o : array) {
                        System.out.println(o);
                    }
                    System.out.println("Las busqueda ha sido limitada a 40 filas");
                    System.out.println("Saltaba el error de mysql 'too many connetions'");
                    break;
                case 2:
                    System.out.print("Introduzca ID: ");
                    int intro2 = scaInt.nextInt();
                    Order o = conexionPedido.selectOrderById(intro2);
                    if (o == null) System.out.println("\nNo se ha encontrado el registro");
                    else System.out.println("\n" + o);
                    break;
                case 3:
                    System.out.println("Insertar registro");
                    System.out.print("Introduzca orderNumber: ");
                    int intro3orderNumber = scaInt.nextInt();
                    System.out.print("Introduzca orderDate año-mes-dia: ");
                    String intro3orderDate = scaStr.nextLine();
                    System.out.print("Introduzca requiredDate año-mes-dia: ");
                    String intro3requiredDate = scaStr.nextLine();
                    System.out.print("Introduzca shippedDate año-mes-dia: ");
                    String intro3shippedDate = scaStr.nextLine();
                    System.out.print("Introduzca status: ");
                    String intro3status = scaStr.nextLine();
                    System.out.print("Introduzca comments: ");
                    String intro3comments = scaStr.nextLine();
                    System.out.print("Introduzca customerNumber: ");
                    int intro3customerNumber = scaInt.nextInt();

                    System.out.println("Cantidad de articulos en el pedido: ");
                    int cantidadArticulos = scaInt.nextInt();

                    System.out.println("\n" + conexionPedido.insertOrder(intro3orderNumber, intro3orderDate, intro3requiredDate, intro3shippedDate, intro3status, intro3comments, intro3customerNumber));

                    // Por cada articulo tenemos que hacer un insert en la tabla orderdetails
                    String consultaAddDetails = "insert into orderdetails (orderNumber, productCode," + "quantityOrdered, priceEach) VALUES (?, ?, ?, ?)";
                    Connection conexionADetalles = Main.getConnectionToDB();
                    for (int i = 0; i < cantidadArticulos; i++) {
                        System.out.print("Introduzca productCode: ");
                        String productCode = scaStr.nextLine();
                        System.out.print("Introduzca quantityOrdered: ");
                        int quantityOrdered = scaInt.nextInt();
                        System.out.print("Introduzca priceEach: ");
                        float priceEach = scaInt.nextFloat();

                        PreparedStatement preparedDetalles = conexionADetalles.prepareStatement(consultaAddDetails);
                        preparedDetalles.setInt(1, intro3orderNumber);
                        preparedDetalles.setString(2, productCode);
                        preparedDetalles.setInt(3, quantityOrdered);
                        preparedDetalles.setFloat(4, priceEach);
                        preparedDetalles.executeUpdate();
                    }
                    break;
                case 4:
                    System.out.println("Eliminar registro por ID");
                    System.out.print("Introduzca ID: ");
                    int intro4 = scaInt.nextInt();

                    // Tenemos que borrar primero todos los registros de orderDetails
                    // y despues borramos el registro order
                    String consultaDeleteDetails = "DELETE FROM classicmodels.orderdetails WHERE orderNumber = " + intro4;
                    Connection conexionDeleteDetails = Main.getConnectionToDB();
                    PreparedStatement preparedDeleteDetails = conexionDeleteDetails.prepareStatement(consultaDeleteDetails);
                    preparedDeleteDetails.executeUpdate();

                    conexionPedido.deleteOrderById(intro4);
                    break;
                case 5:
                    System.out.println("Actualizar campo");
                    System.out.print("Introduzca ID: ");
                    int intro5 = scaInt.nextInt();

                    System.out.println("Introduzca columna:");
                    String intro5columna = scaStr.nextLine();
                    System.out.println("Introduzca valor:");
                    String intro5valor = scaStr.nextLine();
                    System.out.println(conexionPedido.updateField(intro5columna, intro5valor, intro5));
                    break;

                case 6:
                    System.out.println("Buscar registros por campo");
                    System.out.print("Introduzca columna: ");
                    String intro6columna = scaStr.nextLine();
                    System.out.print("Introduzca valor: ");
                    String intro6valor = scaStr.nextLine();
                    intro6valor += "'";
                    intro6valor = "'" + intro6valor;
                    ArrayList<Order> array6 = conexionPedido.findOrdersByField(intro6columna, intro6valor);

                    for (Order s : array6) {
                        System.out.println(s);
                    }
                    System.out.println(array6.size() + " registros encontrados");
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMenuStandar() {
        System.out.println("[1] Ver todos los registros");
        System.out.println("[2] Ver registro por ID");
        System.out.println("[3] Insertar registro");
        System.out.println("[4] Eliminar registro por ID");
        System.out.println("[5] Actualizar campo");
        System.out.println("[6] Buscar registros por campo");
        System.out.print("\nOpcion -> $");
    }

    private static void printMenuStandar(String espec) {
        System.out.println("\t[1] Ver todos los registros");
        System.out.println("\t[2] Ver registro por ID");
        System.out.println("\t[3] Insertar registro");
        System.out.println("\t[4] Eliminar registro por ID");
        System.out.println("\t[5] Actualizar campo");
        System.out.println("\t[6] Buscar registros por campo");
        System.out.println("\t" + espec);
        System.out.print("\nOpcion -> $");
    }
}
