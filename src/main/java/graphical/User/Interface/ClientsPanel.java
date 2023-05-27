package graphical.User.Interface;

import bll.ClientBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientsPanel extends JFrame {
    private JLabel lblTitle = new JLabel("Clients Area");

    private JButton btnAddClients = new JButton("Add new client");

    private JButton btnEditClient = new JButton("Edit Client");

    private JButton btnDeletClient = new JButton("Delete Client");

    private JButton btnViewClients = new JButton("View Clients");

    public ClientsPanel() throws HeadlessException {
        this.setTitle("Clients Management");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,800);
        panel.setBackground(Color.decode("#D4ADFC"));

        lblTitle.setForeground(Color.decode("#1D267D"));
        lblTitle.setFont(new Font("Arial",Font.BOLD,35));
        lblTitle.setBounds(280,20,400,50);
        panel.setLayout(null);
        panel.add(lblTitle);

        btnAddClients.setBackground(Color.decode("#c54290"));
        btnAddClients.setForeground(Color.decode("#F9D949"));
        btnAddClients.setFont(new Font("Arial",Font.BOLD,18));
        btnAddClients.setBounds(125,250,180,50);
        panel.setLayout(null);
        panel.add(btnAddClients);

        btnAddClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientsPopUp clientsPopUp = new ClientsPopUp();
                clientsPopUp.setVisible(true);
                ActionController actionController = new ActionController(clientsPopUp);
            }
        });

        btnEditClient.setBackground(Color.decode("#c54290"));
        btnEditClient.setForeground(Color.decode("#F9D949"));
        btnEditClient.setFont(new Font("Arial",Font.BOLD,18));
        btnEditClient.setBounds(480,250,180,50);
        panel.setLayout(null);
        panel.add(btnEditClient);

        btnEditClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientsPopUpEdit editClientPopUp = new ClientsPopUpEdit();
                editClientPopUp.setVisible(true);
                ActionController actionController = new ActionController(editClientPopUp);
            }
        });
        btnDeletClient.setBackground(Color.decode("#c54290"));
        btnDeletClient.setForeground(Color.decode("#F9D949"));
        btnDeletClient.setFont(new Font("Arial",Font.BOLD,18));
        btnDeletClient.setBounds(125,350,180,50);
        panel.setLayout(null);
        panel.add(btnDeletClient);

        btnDeletClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientsPopUpDelete deleteClientPopUp = new ClientsPopUpDelete();
                deleteClientPopUp.setVisible(true);
                ActionController actionController = new ActionController(deleteClientPopUp);
            }
        });

        btnViewClients.setBackground(Color.decode("#c54290"));
        btnViewClients.setForeground(Color.decode("#F9D949"));
        btnViewClients.setFont(new Font("Arial",Font.BOLD,18));
        btnViewClients.setBounds(480,350,180,50);
        panel.setLayout(null);
        panel.add(btnViewClients);

        btnViewClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientBLL clientBLL = new ClientBLL();

                ClientTable viewClientsPopUp = new ClientTable(clientBLL.findAllClients());
                viewClientsPopUp.setVisible(true);
            }
        });

        this.setContentPane(panel);
    }
}
