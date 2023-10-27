package Model;

import Logic.ClientBLL;
import Logic.OrderBLL;
import Logic.ProductBLL;

public class Model {
    static ClientBLL client;
    static OrderBLL order;
    static ProductBLL product;
    public Model() {
        client = new ClientBLL();
        order = new OrderBLL();
        product = new ProductBLL();
    }

    public static ClientBLL getClient() {
        return client;
    }

    public static OrderBLL getOrder() {
        return order;
    }

    public static ProductBLL getProduct() {
        return product;
    }
}
