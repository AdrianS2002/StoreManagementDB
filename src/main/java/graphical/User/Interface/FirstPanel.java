package graphical.User.Interface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends JFrame{

    private JLabel lblTitle = new JLabel("Orders Management");
    private JButton btnClients = new JButton("Clients");

    private JButton btnProducts = new JButton("Products");

    private JButton btnOrders = new JButton("Orders");

    public FirstPanel() throws HeadlessException {
        this.setTitle("Orders Management");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        panel.setBackground(Color.decode("#D4ADFC"));

        lblTitle.setForeground(Color.decode("#1D267D"));
        lblTitle.setFont(new Font("Arial",Font.BOLD,50));
        lblTitle.setBounds(150,50,600,100);
        panel.setLayout(null);
        panel.add(lblTitle);

        btnClients.setBackground(Color.decode("#c54290"));
        btnClients.setForeground(Color.decode("#F9D949"));
        btnClients.setFont(new Font("Arial",Font.BOLD,18));
        btnClients.setBounds(300,250,130,50);
        panel.setLayout(null);
        panel.add(btnClients);

        btnClients.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientsPanel clientsPanel = new ClientsPanel();
                clientsPanel.setVisible(true);
            }
        });

        btnProducts.setBackground(Color.decode("#c54290"));
        btnProducts.setForeground(Color.decode("#F9D949"));
        btnProducts.setFont(new Font("Arial",Font.BOLD,18));
        btnProducts.setBounds(300,350,130,50);
        panel.setLayout(null);
        panel.add(btnProducts);

        btnProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsPanel productsPanel = new ProductsPanel();
                productsPanel.setVisible(true);
            }
        });

        btnOrders.setBackground(Color.decode("#c54290"));
        btnOrders.setForeground(Color.decode("#F9D949"));
        btnOrders.setFont(new Font("Arial",Font.BOLD,18));
        btnOrders.setBounds(300,450,130,50);
        panel.setLayout(null);
        panel.add(btnOrders);

        btnOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrdersPanel ordersPanel = new OrdersPanel();
                ordersPanel.setVisible(true);
            }
        });

        this.setContentPane(panel);
    }

    public  static void main(String[] args)
    {

        FirstPanel frame = new FirstPanel();

       // ActionController c=new ActionController(frame);
        frame.setResizable(false);

        frame.setVisible(true);


    }

}