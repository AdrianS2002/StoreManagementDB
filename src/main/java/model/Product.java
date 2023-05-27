package model;

/**
 * Model class for Product
 */

public class Product {
    private int productId;
    private int productStock;
    private String productName;
    private double productPrice;

    public Product( String productName,int productStock, double productPrice) {
        this.productName = productName;
        this.productStock = productStock;
        this.productPrice = productPrice;
    }
    public Product(int productId, String productName,int productStock, double productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productStock = productStock;
        this.productPrice = productPrice;
    }
    public Product() {

    }
    public Product(int productId) {
        this.productId = productId;
    }


    public int getProductId() {
        return productId;
    }

    public int getProductStock() {
        return productStock;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
   }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product " +
                productId + ":"+
                " productStock=" + productStock +
                " productName='" + productName + '\'' +
                " productPrice=" + productPrice +
                '}';
    }
}
