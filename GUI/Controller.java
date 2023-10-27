package GUI;

import Model.Model;

public class Controller {
    View view;
    Model model;
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.addClientButtonsListeners();
        view.addProductButtonsListeners();
        view.addOrderButtonsListeners();
        view.addMenuListeners();
        view.addClientsJTable(model.getClient().findAllClients());
        view.addClientsComboBox(model.getClient().findAllClients());
        view.addProductsJTable(model.getProduct().findAllProducts());
        view.addProductsComboBox(model.getProduct().findAllProducts());
        view.addOrderClientsJTable(model.getClient().findAllClients());
        view.addOrderClientsComboBox(model.getClient().findAllClients());
        view.addOrderProductsJTable(model.getProduct().findAllProducts());
        view.addOrderProductsComboBox(model.getProduct().findAllProducts());
    }
    public void setVisible(boolean flag){
        view.setVisible(flag);
    }
}
