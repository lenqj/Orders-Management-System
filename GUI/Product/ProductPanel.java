package GUI.Product;

import Model.MProduct;

import javax.swing.*;
import java.util.List;

public class ProductPanel extends JPanel {
    InsertProductPanel insertProductPanel;
    DeleteAndEditProductPanel deleteAndEditProductPanel;
    ProductTablePanel tablePanel;
    public ProductPanel() {
        JPanel contentPanel = new JPanel();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        insertProductPanel = new InsertProductPanel();
        deleteAndEditProductPanel = new DeleteAndEditProductPanel();
        tablePanel = new ProductTablePanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(insertProductPanel);
        topPanel.add(deleteAndEditProductPanel);
        contentPanel.add(tablePanel);
        contentPanel.add(topPanel);
        add(contentPanel);
    }
    public void addButtonsListeners(){
        insertProductPanel.addButtonsListeners();
        deleteAndEditProductPanel.addButtonsListeners();
    }
    public void clearFields(){
        insertProductPanel.clearInsertProductPanelFields();
    }
    public void addProductsJTable(List<MProduct> obj){
        tablePanel.setJTable(obj);
    }
    public void addProductsComboBox(List<MProduct> obj){
        deleteAndEditProductPanel.addComboBoxProducts(obj);
    }
    public String getSelectedComboBoxProduct(){
        return deleteAndEditProductPanel.getSelectedComboBoxProduct();
    }
    public int getIDTextField(){
        return insertProductPanel.getIDTextField();
    }
    public String getProductNameTextField(){
        return insertProductPanel.getProductNameTextField();
    }
    public int getQuantityTextField(){
        return insertProductPanel.getQuantityTextField();
    }
    public int getPriceTextField(){
        return insertProductPanel.getPriceTextField();
    }
}
