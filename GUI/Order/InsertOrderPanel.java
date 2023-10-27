package GUI.Order;

import GUI.Listeners;
import Model.MClient;
import Model.MProduct;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InsertOrderPanel extends JPanel {

    JComboBox clientsComboBox;
    JComboBox productsComboBox;
    JTextField IDTextField;
    JTextField quantityTextField;
    JButton insertOrderButton;
    JButton clearOrderButton;
    InsertOrderPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        JLabel IDLabel = new JLabel("Order ID: ");
        JLabel quantityLabel = new JLabel("Product Quantity: ");
        JLabel clientsLabel = new JLabel("Clients: ");
        JLabel productsLabel = new JLabel("Products: ");

        IDTextField = new JTextField(15);
        quantityTextField = new JTextField(15);
        clientsComboBox = new JComboBox();
        productsComboBox = new JComboBox();

        JPanel leftPanel = new JPanel(new GridLayout(0, 1));
        leftPanel.add(clientsLabel);
        leftPanel.add(clientsComboBox);

        JPanel middlePanel = new JPanel(new GridLayout(0, 1));
        leftPanel.add(productsLabel);
        leftPanel.add(productsComboBox);

        JPanel rightPanel = new JPanel(new GridLayout(0, 1));

        rightPanel.add(IDLabel);
        rightPanel.add(IDTextField);
        rightPanel.add(quantityLabel);
        rightPanel.add(quantityTextField);

        topPanel.add(leftPanel);
        topPanel.add(middlePanel);
        topPanel.add(rightPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        insertOrderButton = new JButton("Insert!");
        clearOrderButton = new JButton("Clear!");


        buttonPanel.add(insertOrderButton);
        buttonPanel.add(clearOrderButton);
        bottomPanel.add(buttonPanel);
        panel.add(topPanel);
        panel.add(bottomPanel);
        add(panel);
    }
    public void addButtonsListeners(){
        insertOrderButton.addActionListener(new Listeners.InsertOrderButtonListener());
        clearOrderButton.addActionListener(new Listeners.ClearOrderButtonListener());
    }
    public void clearInsertOrderPanelFields(){
        quantityTextField.setText("");
    }

    public int getIDTextField(){
        if(IDTextField.getText() == null)
            return 0;
        return Integer.parseInt(IDTextField.getText());
    }
    public int getQuantityTextField(){
        if(quantityTextField.getText() == null)
            return 0;
        return Integer.parseInt(quantityTextField.getText());
    }
    public void addComboBoxOrderProducts(List<MProduct> products) {
        productsComboBox.removeAllItems();
        for (MProduct product : products) {
            productsComboBox.addItem(product.getID() + " - " + product.getProductName());
        }
    }
    public String getSelectedComboBoxOrderProduct(){
        if(productsComboBox.getSelectedItem() == null)
            return "0";
        return productsComboBox.getSelectedItem().toString();
    }
    public String getSelectedComboBoxOrderClient(){
        if(clientsComboBox.getSelectedItem() == null)
            return "0";
        return clientsComboBox.getSelectedItem().toString();
    }

    public void addComboBoxOrderClient(List<MClient> Clients) {
        clientsComboBox.removeAllItems();
        for (MClient client : Clients) {
            clientsComboBox.addItem(client.getID() + " - " + client.getClientName());
        }
    }
}
