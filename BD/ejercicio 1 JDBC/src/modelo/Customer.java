package modelo;

public class Customer {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String city;
    private int salesRepEmployeeNumber;

    public Customer(int customerNumber, String customerName, String contactLastName, String contactFirstName, String city, int salesRepEmployeeNumber) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.city = city;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    @Override
    public String toString() {
        return "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", city='" + city + '\'' +
                ", salesRepEmployeeNumber=" + salesRepEmployeeNumber;
    }
}
