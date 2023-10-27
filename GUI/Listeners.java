package GUI;

import Model.MClient;
import Model.MProduct;
import Model.MOrder;
import Model.Model;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Listeners {
    /**
     *  Class handles the deletion of a client from the system.
     */
    public static class DeleteClientButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            String input = View.clientPanel.getSelectedComboBoxClient();
            int clientID;
            if(!input.equals("null")) {
                Scanner s = new Scanner(input);
                clientID = s.nextInt();
                MClient delete = model.getClient().findClientById(clientID);
                if(model.getClient().deleteClient(delete, "ID") == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Client with ID=" + delete.getID() + " doesn't exists!");
                }
                View.addClientsJTable(model.getClient().findAllClients());
                View.addClientsComboBox(model.getClient().findAllClients());
            }
        }
    }
    /**
     * Class updates the details of a client
     */
    public static class EditClientButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            String input = View.clientPanel.getSelectedComboBoxClient();
            int clientID;
            if(!input.equals("null")) {
                Scanner s = new Scanner(input);
                clientID = s.nextInt();
                MClient edit = model.getClient().findClientById(clientID);
                String Name = View.clientPanel.getClientNameTextField();
                String Address = View.clientPanel.getAddressTextField();
                String Email = View.clientPanel.getEmailTextField();
                int Age = View.clientPanel.getAgeTextField();
                int Money = View.clientPanel.getMoneyTextField();

                edit.setClientName(Name);
                edit.setAddress(Address);
                edit.setEmail(Email);
                edit.setAge(Age);
                edit.setMoney(Money);

                if(model.getClient().updateClient(edit, "ID") == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Client with ID=" + edit.getID() + " doesn't exists!");
                }
                View.addClientsJTable(model.getClient().findAllClients());
                View.addClientsComboBox(model.getClient().findAllClients());
            }
        }
    }
    /**
     * class clears the client fields.
     */
    public static class ClearClientButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            View.clearClientsFields();

        }
    }
    /**
     * class adds a new client to the system
     */
    public static class InsertClientButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            int clientID = View.clientPanel.getIDTextField();
            if(clientID != 0) {
                String Name = View.clientPanel.getClientNameTextField();
                String Address = View.clientPanel.getAddressTextField();
                String Email = View.clientPanel.getEmailTextField();
                int Age = View.clientPanel.getAgeTextField();
                int Money = View.clientPanel.getMoneyTextField();
                MClient insert = new MClient(clientID, Name, Address, Email, Age, Money);
                if(model.getClient().insertClient(insert) == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Client with ID=" + insert.getID() + " exists!");
                }
                View.addClientsJTable(model.getClient().findAllClients());
                View.addClientsComboBox(model.getClient().findAllClients());
            }
        }
    }
    /**
     * class handles the deletion of a product from the system.
     */
    public static class DeleteProductButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            String input = View.productPanel.getSelectedComboBoxProduct();
            int clientID;
            if(!input.equals("null")) {
                Scanner s = new Scanner(input);
                clientID = s.nextInt();
                MProduct delete = model.getProduct().findProductById(clientID);
                if(model.getProduct().deleteProduct(delete, "ID") == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Product with ID=" + delete.getID() + " doesn't exists!");
                }
                View.addProductsJTable(model.getProduct().findAllProducts());
                View.addProductsComboBox(model.getProduct().findAllProducts());
            }
        }
    }
    /**
     * class updates the details of a product
     */
    public static class EditProductButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            String input = View.productPanel.getSelectedComboBoxProduct();
            int productID;
            if (!input.equals("null")) {
                Scanner s = new Scanner(input);
                productID = s.nextInt();
                MProduct edit = model.getProduct().findProductById(productID);
                String Name = View.productPanel.getProductNameTextField();
                int Quantity = View.productPanel.getQuantityTextField();
                int Price = View.productPanel.getPriceTextField();

                edit.setProductName(Name);
                edit.setQuantity(Quantity);
                edit.setPrice(Price);

                if(model.getProduct().updateProduct(edit, "ID") == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Product with ID=" + edit.getID() + " doesn't exists!");
                }
                View.addProductsJTable(model.getProduct().findAllProducts());
                View.addProductsComboBox(model.getProduct().findAllProducts());
            }
        }
    }
    /**
     *class clears the product fields.
     */
    public static class ClearProductButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            View.clearProductsFields();
        }
    }
    /**
     * class adds a new product to the system.
     */
    public static class InsertProductButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            int productID = View.productPanel.getIDTextField();
            if(productID != 0) {
                String Name = View.productPanel.getProductNameTextField();
                int Quantity = View.productPanel.getQuantityTextField();
                int Price = View.productPanel.getPriceTextField();
                MProduct insert = new MProduct(productID, Name, Quantity, Price);
                if(model.getProduct().insertProduct(insert) == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Product with ID=" + insert.getID() + " exists!");
                }
                View.addProductsJTable(model.getProduct().findAllProducts());
                View.addProductsComboBox(model.getProduct().findAllProducts());
            }
        }
    }
    /**
     *class adds a new order to the system.
     */
    public static class InsertOrderButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Model model = new Model();
            String input1 = View.orderPanel.getSelectedComboBoxOrderClient();
            String input2 = View.orderPanel.getSelectedComboBoxOrderProduct();
            if(!input1.equals("null") && !input2.equals("null")) {
                Scanner s = new Scanner(input1);
                int clientID = s.nextInt();
                s = new Scanner(input2);
                int productID = s.nextInt();
                int orderID = View.orderPanel.getIDTextField();
                int quantity = View.orderPanel.getQuantityTextField();
                int totalPrice = quantity * model.getProduct().findProductById(productID).getPrice();

                MProduct edit = model.getProduct().findProductById(productID);
                if(edit.getQuantity() - quantity > 0) {
                    edit.setQuantity(edit.getQuantity() - quantity);
                    model.getProduct().updateProduct(edit, "ID");
                }else if(edit.getQuantity() - quantity == 0) {
                        model.getProduct().deleteProduct(edit, "ID");
                }else{
                    JOptionPane.showMessageDialog(View.contentPanel,"Too much quantity! Minimum: " + edit.getQuantity());
                    return;
                }
                MOrder insert = new MOrder(orderID, clientID, productID, quantity, totalPrice);
                if(model.getOrder().insertOrder(insert) == -1){
                    JOptionPane.showMessageDialog(View.contentPanel,"Order with ID=" + insert.getID() + " exists!");
                }
                View.addOrderClientsJTable(model.getClient().findAllClients());
                View.addOrderClientsComboBox(model.getClient().findAllClients());
                View.addOrderProductsJTable(model.getProduct().findAllProducts());
                View.addOrderProductsComboBox(model.getProduct().findAllProducts());
            }

        }
    }
    /**
     *class clears the order fields.
     */
    public static class ClearOrderButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            View.clearOrdersFields();
        }
    }
    /**
     * MenuListener for the Clients menu item
     */
    public static class ClientsJMenuListener implements MenuListener {
        public void menuSelected(MenuEvent e) {
            Model model = new Model();
            View.addClientsJTable(model.getClient().findAllClients());
            View.addClientsComboBox(model.getClient().findAllClients());
            View.setContentPanel("0");
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }
    /**
     * MenuListener for the Products menu item
     */
    public static class ProductsJMenuListener implements MenuListener  {
        public void menuSelected(MenuEvent e) {
            Model model = new Model();
            View.addProductsJTable(model.getProduct().findAllProducts());
            View.addProductsComboBox(model.getProduct().findAllProducts());
            View.setContentPanel("1");
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }
    /**
     * MenuListener for the Orders menu item
     */
    public static class OrdersJMenuListener implements MenuListener  {
        public void menuSelected(MenuEvent e) {
            Model model = new Model();
            View.addOrderClientsJTable(model.getClient().findAllClients());
            View.addOrderClientsComboBox(model.getClient().findAllClients());
            View.addOrderProductsJTable(model.getProduct().findAllProducts());
            View.addOrderProductsComboBox(model.getProduct().findAllProducts());
            View.setContentPanel("2");

        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }
}
