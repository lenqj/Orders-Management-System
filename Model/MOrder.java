package Model;

public class MOrder {
    int ID;
    int clientID;
    int productID;
    int quantity;
    int totalPrice;

    @Override
    public String toString() {
        return "MOrder{" +
                "ID=" + ID +
                ", clientID=" + clientID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public MOrder() {
    }

    public MOrder(int ID, int clientID, int productID, int quantity, int totalPrice) {
        this.ID = ID;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
