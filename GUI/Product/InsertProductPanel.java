package GUI.Product;

import GUI.Listeners;

import javax.swing.*;
import java.awt.*;

public class InsertProductPanel extends JPanel{
    JTextField IDTextField;
    JTextField productNameTextField;
    JTextField quantityTextField;
    JTextField priceTextField;

    JButton insertProductButton;
    JButton clearProductButton;
    InsertProductPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel(new GridLayout(0, 1));

        JLabel IDLabel = new JLabel("Product ID: ");
        JLabel productNameLabel = new JLabel("Product Name: ");
        JLabel quantityLabel = new JLabel("Product Quantity: ");
        JLabel priceLabel = new JLabel("Product Price: ");

        leftPanel.add(IDLabel);
        leftPanel.add(productNameLabel);
        leftPanel.add(quantityLabel);
        leftPanel.add(priceLabel);

        JPanel rightPanel = new JPanel(new GridLayout(0, 1));

        IDTextField = new JTextField(15);
        productNameTextField = new JTextField(15);
        quantityTextField = new JTextField(15);
        priceTextField = new JTextField(15);

        rightPanel.add(IDTextField);
        rightPanel.add(productNameTextField);
        rightPanel.add(quantityTextField);
        rightPanel.add(priceTextField);

        topPanel.add(leftPanel);
        topPanel.add(rightPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        insertProductButton = new JButton("Insert!");
        clearProductButton = new JButton("Clear!");


        buttonPanel.add(insertProductButton);
        buttonPanel.add(clearProductButton);
        bottomPanel.add(buttonPanel);
        panel.add(topPanel);
        panel.add(bottomPanel);
        add(panel);
    }
    public void addButtonsListeners(){
        clearProductButton.addActionListener(new Listeners.ClearProductButtonListener());
        insertProductButton.addActionListener(new Listeners.InsertProductButtonListener());
    }
    public void clearInsertProductPanelFields(){
        IDTextField.setText("");
        productNameTextField.setText("");
        quantityTextField.setText("");
        priceTextField.setText("");
    }

    public int getIDTextField(){
        if(IDTextField.getText() == null)
            return 0;
        return Integer.parseInt(IDTextField.getText());
    }
    public String getProductNameTextField(){
        if(productNameTextField.getText() == null)
            return "null";
        return productNameTextField.getText();
    }
    public int getQuantityTextField(){
        if(quantityTextField.getText() == null)
            return 0;
        return Integer.parseInt(quantityTextField.getText());
    }
    public int getPriceTextField(){
        if(priceTextField.getText() == null)
            return 0;
        return Integer.parseInt(priceTextField.getText());
    }
}
