package modelo;

public class Product {
    private String productCode;
    private String productName;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private double buyPrice;

    public Product(String productCode, String productName, String productVendor, String productDescription, int quantityInStock, double buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "productCode=" + productCode +
                ", productName='" + productName + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", buyPrice=" + buyPrice;
    }
}
