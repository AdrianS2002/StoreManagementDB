package graphical.User.Interface;

import bll.OrderBLL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OrdersPanel extends JFrame {
    private JLabel lblTitle = new JLabel("Orders Area");

    private JButton btnEditOrder = new JButton("Edit order");

    private JButton btnCreateOrder = new JButton("Create order");

    private JButton btnDeleteOrder = new JButton("Delete order");

    private JButton btnViewOrders = new JButton("View orders");


    public OrdersPanel() throws HeadlessException {
        this.setTitle("Products Management");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,800);
        panel.setBackground(Color.decode("#D4ADFC"));

        lblTitle.setForeground(Color.decode("#1D267D"));
        lblTitle.setFont(new Font("Arial",Font.BOLD,35));
        lblTitle.setBounds(280,20,400,50);
        panel.setLayout(null);
        panel.add(lblTitle);

        btnCreateOrder.setBackground(Color.decode("#c54290"));
        btnCreateOrder.setForeground(Color.decode("#F9D949"));
        btnCreateOrder.setFont(new Font("Arial",Font.BOLD,18));
        btnCreateOrder.setBounds(125,250,200,50);
        panel.setLayout(null);
        panel.add(btnCreateOrder);

        btnCreateOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderCreation orderClient = new OrderCreation();
                orderClient.setVisible(true);
                ActionController actionController = new ActionController(orderClient);
            }
        });

        btnEditOrder.setBackground(Color.decode("#c54290"));
        btnEditOrder.setForeground(Color.decode("#F9D949"));
        btnEditOrder.setFont(new Font("Arial",Font.BOLD,18));
        btnEditOrder.setBounds(480,250,200,50);
        panel.setLayout(null);
        panel.add(btnEditOrder);

        btnEditOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderEdit orderEdit = new OrderEdit();
                orderEdit.setVisible(true);
                ActionController actionController = new ActionController(orderEdit);
            }
        });
        btnDeleteOrder.setBackground(Color.decode("#c54290"));
        btnDeleteOrder.setForeground(Color.decode("#F9D949"));
        btnDeleteOrder.setFont(new Font("Arial",Font.BOLD,18));
        btnDeleteOrder.setBounds(125,350,200,50);
        panel.setLayout(null);
        panel.add(btnDeleteOrder);

        btnDeleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderDeletePopUp orderDeletePopUp = new OrderDeletePopUp();
                orderDeletePopUp.setVisible(true);
                ActionController actionController = new ActionController(orderDeletePopUp);
            }
        });

        btnViewOrders.setBackground(Color.decode("#c54290"));
        btnViewOrders.setForeground(Color.decode("#F9D949"));
        btnViewOrders.setFont(new Font("Arial",Font.BOLD,18));
        btnViewOrders.setBounds(480,350,200,50);
        panel.setLayout(null);
        panel.add(btnViewOrders);

        btnViewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderBLL orderBLL = new OrderBLL();
                OrderssTable orderTable = new OrderssTable(orderBLL.findAllOrders());
                orderTable.setVisible(true);
            }
        });
        this.setContentPane(panel);
    }
}
