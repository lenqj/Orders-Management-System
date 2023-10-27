package GUI.Product;

import GUI.Listeners;
import Model.MClient;
import Model.MProduct;

import javax.swing.*;
import java.util.List;

public class DeleteAndEditProductPanel extends JPanel {

    JComboBox productsComboBox;
    JButton deleteProductButton;
    JButton editProductButton;
    DeleteAndEditProductPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel productPanel = new JPanel();
        JLabel productsLabel = new JLabel("Products: ");

        productsComboBox = new JComboBox();
        productPanel.add(productsLabel);
        productPanel.add(productsComboBox);

        JPanel buttonPanel = new JPanel();

        deleteProductButton = new JButton("Delete!");
        editProductButton = new JButton("Edit!");

        buttonPanel.add(deleteProductButton);
        buttonPanel.add(editProductButton);

        panel.add(productPanel);
        panel.add(buttonPanel);
        add(panel);
    }
    void addButtonsListeners(){
        deleteProductButton.addActionListener(new Listeners.DeleteProductButtonListener());
        editProductButton.addActionListener(new Listeners.EditProductButtonListener());
    }
    public String getSelectedComboBoxProduct(){
        if(productsComboBox.getSelectedItem() == null)
            return "0";
        return productsComboBox.getSelectedItem().toString();
    }

    public void addComboBoxProducts(List<MProduct> products) {
        productsComboBox.removeAllItems();
        for (MProduct product : products) {
            productsComboBox.addItem(product.getID() + " - " + product.getProductName());
        }
    }
}
