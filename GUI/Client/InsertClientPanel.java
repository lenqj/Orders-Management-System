package GUI.Client;

import GUI.Listeners;

import javax.swing.*;
import java.awt.*;

public class InsertClientPanel extends JPanel{
    JTextField IDTextField;
    JTextField clientNameTextField;
    JTextField addressTextField;
    JTextField emailTextField;
    JTextField ageTextField;
    JTextField moneyTextField;

    JButton insertClientButton;
    JButton clearClientButton;
    InsertClientPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        JPanel leftPanel = new JPanel(new GridLayout(0, 1));

        JLabel IDLabel = new JLabel("Client ID: ");
        JLabel clientNameLabel = new JLabel("Client Name: ");
        JLabel addressLabel = new JLabel("Client Address: ");
        JLabel emailLabel = new JLabel("Client Email: ");
        JLabel ageLabel = new JLabel("Client Age: ");
        JLabel moneyLabel = new JLabel("Client Money: ");

        leftPanel.add(IDLabel);
        leftPanel.add(clientNameLabel);
        leftPanel.add(addressLabel);
        leftPanel.add(emailLabel);
        leftPanel.add(ageLabel);
        leftPanel.add(moneyLabel);

        JPanel rightPanel = new JPanel(new GridLayout(0, 1));

        IDTextField = new JTextField(15);
        clientNameTextField = new JTextField(15);
        addressTextField = new JTextField(15);
        emailTextField = new JTextField(15);
        ageTextField = new JTextField(15);
        moneyTextField = new JTextField(15);

        rightPanel.add(IDTextField);
        rightPanel.add(clientNameTextField);
        rightPanel.add(addressTextField);
        rightPanel.add(emailTextField);
        rightPanel.add(ageTextField);
        rightPanel.add(moneyTextField);

        topPanel.add(leftPanel);
        topPanel.add(rightPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JPanel buttonPanel = new JPanel();
        insertClientButton = new JButton("Insert!");
        clearClientButton = new JButton("Clear!");


        buttonPanel.add(insertClientButton);
        buttonPanel.add(clearClientButton);
        bottomPanel.add(buttonPanel);
        panel.add(topPanel);
        panel.add(bottomPanel);
        add(panel);
    }
    public void addButtonsListeners(){
        clearClientButton.addActionListener(new Listeners.ClearClientButtonListener());
        insertClientButton.addActionListener(new Listeners.InsertClientButtonListener());
    }

    public int getIDTextField(){
        if(IDTextField.getText() == null)
            return 0;
        return Integer.parseInt(IDTextField.getText());
    }
    public String getClientNameTextField(){
        if(clientNameTextField.getText() == null)
            return "null";
        return clientNameTextField.getText();
    }
    public String getAddressTextField(){
        if(addressTextField.getText() == null)
            return "null";
        return addressTextField.getText();
    }
    public String getEmailTextField(){
        if(emailTextField.getText() == null)
            return "null";
        return emailTextField.getText();
    }
    public int getAgeTextField(){
        if(ageTextField.getText() == null)
            return 0;
        return Integer.parseInt(ageTextField.getText());
    }
    public int getMoneyTextField(){
        if(moneyTextField.getText() == null)
            return 0;
        return Integer.parseInt(moneyTextField.getText());
    }
    public void clearInsertClientPanelFields(){
        IDTextField.setText("");
        clientNameTextField.setText("");
        addressTextField.setText("");
        emailTextField.setText("");
        ageTextField.setText("");
        moneyTextField.setText("");
    }
}
