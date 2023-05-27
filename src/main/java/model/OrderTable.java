package model;
/**
 * Model class for Order
 */

public class OrderTable {
    private int ordertableId;
    private int clientId;
    private int productId;
    private int quantity;


    public OrderTable( int clientId, int productId) {
        this.clientId = clientId;
        this.productId = productId;
    }
    public OrderTable(int ordertableId, int clientId, int productId, int quantity) {
        this.ordertableId = ordertableId;
        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }
    public OrderTable() {

    }
    public OrderTable( int clientId, int productId, int quantity) {

        this.clientId = clientId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
    public int getOrdertableId() {
        return ordertableId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getProductId() {
        return productId;
    }



    public void setOrdertableId(int orderId) {
        this.ordertableId = orderId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order " +
                ordertableId + ":" +
                ", clientId=" + clientId +
                ", productId=" + productId +
                ", Quantity: " + quantity +
                '}';
    }
}
