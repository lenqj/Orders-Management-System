package GUI.Order;

import Model.MClient;
import Model.MProduct;

import javax.swing.*;
import java.util.List;

public class OrderPanel extends JPanel {
    InsertOrderPanel insertOrderPanel;
    OrderTablePanel tablePanel;
    public OrderPanel() {
        JPanel contentPanel = new JPanel();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        insertOrderPanel = new InsertOrderPanel();
        tablePanel = new OrderTablePanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(insertOrderPanel);
        contentPanel.add(tablePanel);
        contentPanel.add(topPanel);
        add(contentPanel);
    }
    public void addButtonsListeners(){
        insertOrderPanel.addButtonsListeners();
    }
    public void clearFields(){
        insertOrderPanel.clearInsertOrderPanelFields();
    }
    public void addOrderClientsJTable(List<MClient> obj){
        tablePanel.addClientsJTable(obj);
    }
    public void addOrderProductsJTable(List<MProduct> obj){
        tablePanel.addProductsJTable(obj);
    }
    public void addOrderClientsComboBox(List<MClient> obj){
        insertOrderPanel.addComboBoxOrderClient(obj);
    }
    public String getSelectedComboBoxOrderClient(){
        return insertOrderPanel.getSelectedComboBoxOrderClient();
    }
    public void addOrderProductsComboBox(List<MProduct> obj){
        insertOrderPanel.addComboBoxOrderProducts(obj);
    }
    public String getSelectedComboBoxOrderProduct(){
        return insertOrderPanel.getSelectedComboBoxOrderProduct();
    }

    public int getIDTextField(){
        return insertOrderPanel.getIDTextField();
    }
    public int getQuantityTextField(){
        return insertOrderPanel.getQuantityTextField();
    }
}
