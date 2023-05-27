package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderEdit extends JFrame {
    JLabel labelId = new JLabel("Order id: ");
    JLabel labelClientId = new JLabel("Client id: ");
    JLabel labelProductId = new JLabel("Product id: ");
    JLabel labelQuantity = new JLabel("Quantity: ");
    JTextField textFieldId = new JTextField();

    JTextField textFieldClientId = new JTextField();

    JTextField textFieldProductId = new JTextField();
    JTextField textFieldQuantity = new JTextField();
    JButton btnEditOrder = new JButton("Edit Order");
    public OrderEdit() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Edit Order");
        getContentPane().setBackground(Color.decode("#D4ADFC"));
        setResizable(false);
        setLayout(null);


        labelId.setForeground(Color.decode("#c54290"));
        labelId.setBounds(24,24,250,25);
        labelId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelId);

        labelClientId.setForeground(Color.decode("#c54290"));
        labelClientId.setBounds(24,64,250,25);
        labelClientId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelClientId);

        labelProductId.setForeground(Color.decode("#c54290"));
        labelProductId.setBounds(24,104,250,25);
        labelProductId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelProductId);

        labelQuantity.setForeground(Color.decode("#c54290"));
        labelQuantity.setBounds(24,144,250,25);
        labelQuantity.setFont(new Font("Arial",Font.BOLD,18));
        add(labelQuantity);

        textFieldId.setBounds(200,24,250,25);
        textFieldId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldId);

        textFieldClientId.setBounds(200,64,250,25);
        textFieldClientId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldClientId);

        textFieldProductId.setBounds(200,104,250,25);
        textFieldProductId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldProductId);

        textFieldQuantity.setBounds(200,144,250,25);
        textFieldQuantity.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldQuantity);

        btnEditOrder.setBackground(Color.decode("#c54290"));
        btnEditOrder.setForeground(Color.decode("#F9D949"));
        btnEditOrder.setFont(new Font("Arial",Font.BOLD,18));
        btnEditOrder.setBounds(200,184,250,25);
        add(btnEditOrder);
    }
    public void setEditOrderListener(ActionListener selectProduct) {
        btnEditOrder.addActionListener(selectProduct);
    }
}
