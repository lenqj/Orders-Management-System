package GUI.Client;

import Model.MClient;

import javax.swing.*;
import java.util.List;

public class ClientPanel extends JPanel {
    InsertClientPanel insertClientPanel;
    DeleteAndEditClientPanel deleteAndEditClientPanel;
    ClientTablePanel tablePanel;
    public ClientPanel() {
        JPanel contentPanel = new JPanel();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        insertClientPanel = new InsertClientPanel();
        deleteAndEditClientPanel = new DeleteAndEditClientPanel();
        tablePanel = new ClientTablePanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        topPanel.add(insertClientPanel);
        topPanel.add(deleteAndEditClientPanel);
        contentPanel.add(tablePanel);
        contentPanel.add(topPanel);
        add(contentPanel);
    }
    public void addButtonsListeners(){
        insertClientPanel.addButtonsListeners();
        deleteAndEditClientPanel.addButtonsListeners();
    }
    public void addClientsJTable(List<MClient> obj){
        tablePanel.setJTable(obj);
    }
    public void addClientsComboBox(List<MClient> obj){
        deleteAndEditClientPanel.addComboBoxClient(obj);
    }
    public String getSelectedComboBoxClient(){
        return deleteAndEditClientPanel.getSelectedComboBoxClient();
    }
    public void clearFields(){
        insertClientPanel.clearInsertClientPanelFields();
    }
    public int getIDTextField(){
        return insertClientPanel.getIDTextField();
    }
    public String getClientNameTextField(){
        return insertClientPanel.getClientNameTextField();
    }
    public String getAddressTextField(){
        return insertClientPanel.getAddressTextField();
    }
    public String getEmailTextField(){
        return insertClientPanel.getEmailTextField();
    }
    public int getAgeTextField(){
        return insertClientPanel.getAgeTextField();
    }
    public int getMoneyTextField(){
        return insertClientPanel.getMoneyTextField();
    }

}
