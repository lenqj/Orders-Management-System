package GUI;


import GUI.Client.ClientPanel;
import GUI.Order.OrderPanel;
import GUI.Product.ProductPanel;
import Model.MClient;
import Model.MProduct;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View extends JFrame {
    public static ClientPanel clientPanel;
    public static ProductPanel productPanel;
    public static OrderPanel orderPanel;
    public static JPanel contentPanel;
    private static CardLayout cardLayout;
    private static JMenu clientsJMenu;
    private static JMenu productsJMenu;
    private static JMenu ordersJMenu;
    public View() {
        setSize(1024, 768);
        setTitle("Polynomial Calculator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        cpuPanel = new CPUPanel();
        mainboardPanel = new MainBoardPanel();
        memoryPanel = new MemoryPanel();
        graphicsPanel = new GraphicsPanel();
        benchPanel = new BenchPanel();

        cardLayout = new CardLayout();

        JPanel menuPanel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        menuPanel.add(menuBar);

        clientsJMenu = new JMenu("Clients");
        productsJMenu = new JMenu("Products");
        ordersJMenu = new JMenu("Orders");

        menuBar.add(clientsJMenu);
        menuBar.add(productsJMenu);
        menuBar.add(ordersJMenu);

        contentPanel = new JPanel();
        contentPanel.setLayout(cardLayout);

        contentPanel.add(clientPanel, "0");
        contentPanel.add(productPanel, "1");
        contentPanel.add(orderPanel, "2");

        cardLayout.show(contentPanel, "0");


        mainPanel.add(menuPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel);
        setContentPane(mainPanel);
    }
    public static void addClientButtonsListeners(){
        clientPanel.addButtonsListeners();
    }
    public static void addProductButtonsListeners(){
        productPanel.addButtonsListeners();
    }
    public static void addOrderButtonsListeners(){
        orderPanel.addButtonsListeners();
    }

    public static void addMenuListeners(){
        clientsJMenu.addMenuListener(new Listeners.ClientsJMenuListener());
        productsJMenu.addMenuListener(new Listeners.ProductsJMenuListener());
        ordersJMenu.addMenuListener(new Listeners.OrdersJMenuListener());
    }
    public static void setContentPanel(String id){
        cardLayout.show(contentPanel, id);
    }
    public static void clearClientsFields(){
        clientPanel.clearFields();
    }
    public static void clearOrdersFields(){
        orderPanel.clearFields();
    }
    public static void clearProductsFields(){
        productPanel.clearFields();
    }
    public static void addClientsJTable(List<MClient> obj){
        clientPanel.addClientsJTable(obj);
    }
    public static void addClientsComboBox(List<MClient> obj){
        clientPanel.addClientsComboBox(obj);
    }
    public static void addProductsJTable(List<MProduct> obj){
        productPanel.addProductsJTable(obj);
    }
    public static void addProductsComboBox(List<MProduct> obj){
        productPanel.addProductsComboBox(obj);
    }
    public static void addOrderClientsJTable(List<MClient> obj){
        orderPanel.addOrderClientsJTable(obj);
    }
    public static void addOrderClientsComboBox(List<MClient> obj){
        orderPanel.addOrderClientsComboBox(obj);
    }
    public static void addOrderProductsJTable(List<MProduct> obj){
        orderPanel.addOrderProductsJTable(obj);
    }
    public static void addOrderProductsComboBox(List<MProduct> obj){
        orderPanel.addOrderProductsComboBox(obj);
    }


}

