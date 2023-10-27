package GUI.Client;

import GUI.Listeners;
import Model.MClient;

import javax.swing.*;
import java.util.List;

public class DeleteAndEditClientPanel extends JPanel {

    JComboBox clientsComboBox;
    JButton deleteClientButton;
    JButton editClientButton;
    DeleteAndEditClientPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel clientsPanel = new JPanel();
        JLabel clientsLabel = new JLabel("Clients: ");

        clientsComboBox = new JComboBox();
        clientsPanel.add(clientsLabel);
        clientsPanel.add(clientsComboBox);

        JPanel buttonPanel = new JPanel();

        deleteClientButton = new JButton("Delete!");
        editClientButton = new JButton("Edit!");

        buttonPanel.add(deleteClientButton);
        buttonPanel.add(editClientButton);

        panel.add(clientsPanel);
        panel.add(buttonPanel);
        add(panel);
    }
    void addButtonsListeners(){
        deleteClientButton.addActionListener(new Listeners.DeleteClientButtonListener());
        editClientButton.addActionListener(new Listeners.EditClientButtonListener());
    }
    public String getSelectedComboBoxClient(){
        if(clientsComboBox.getSelectedItem() == null)
            return "0";
        return clientsComboBox.getSelectedItem().toString();
    }

    public void addComboBoxClient(List<MClient> Clients) {
        clientsComboBox.removeAllItems();
        for (MClient client : Clients) {
            clientsComboBox.addItem(client.getID() + " - " + client.getClientName());
        }
    }
}
