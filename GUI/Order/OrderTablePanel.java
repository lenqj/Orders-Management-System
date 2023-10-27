package GUI.Order;

import GUI.Client.ClientTablePanel;
import GUI.Product.ProductTablePanel;
import Model.MClient;
import Model.MProduct;

import javax.swing.*;
import java.util.List;

public class OrderTablePanel extends JPanel {
    ClientTablePanel clientTablePanel;
    ProductTablePanel productTablePanel;
    OrderTablePanel(){
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        clientTablePanel = new ClientTablePanel();
        productTablePanel = new ProductTablePanel();
        add(clientTablePanel);
        add(productTablePanel);
    }
    public void addClientsJTable(List<MClient> obj){
        clientTablePanel.setJTable(obj);
    }
    public void addProductsJTable(List<MProduct> obj){
        productTablePanel.setJTable(obj);
    }
}
