package Model;

public class MProduct {
    private int ID;
    private String productName;
    private int quantity;
    private int price;

    public MProduct() {
    }

    public MProduct(int ID, String productName, int quantity, int price) {
        this.ID = ID;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MProduct{" +
                "ID=" + ID +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
