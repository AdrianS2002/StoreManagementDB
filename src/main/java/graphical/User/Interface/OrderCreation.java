package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderCreation extends JFrame {
    JLabel labelClientId = new JLabel("Select client id: ");
    JLabel labelProductId = new JLabel("Select product id: ");
    JLabel labelQuantity = new JLabel("Quantity: ");
    JTextField textFieldId = new JTextField();
    JTextField textFieldProductId = new JTextField();
    JTextField textFieldQuantity = new JTextField();
    JButton btnCreateOrder = new JButton("Create order");

    public OrderCreation() {
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Create order");
        getContentPane().setBackground(Color.decode("#D4ADFC"));
        setResizable(false);
        setLayout(null);

        labelClientId.setForeground(Color.decode("#c54290"));
        labelClientId.setBounds(24,24,250,25);
        labelClientId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelClientId);

        labelProductId.setForeground(Color.decode("#c54290"));
        labelProductId.setBounds(24,64,250,25);
        labelProductId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelProductId);

        labelQuantity.setForeground(Color.decode("#c54290"));
        labelQuantity.setBounds(24,104,250,25);
        labelQuantity.setFont(new Font("Arial",Font.BOLD,18));
        add(labelQuantity);

        textFieldId.setBounds(200,24,250,25);
        textFieldId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldId);

        textFieldProductId.setBounds(200,64,250,25);
        textFieldProductId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldProductId);

        textFieldQuantity.setBounds(200,104,250,25);
        textFieldQuantity.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldQuantity);

        btnCreateOrder.setBackground(Color.decode("#c54290"));
        btnCreateOrder.setForeground(Color.decode("#F9D949"));
        btnCreateOrder.setFont(new Font("Arial",Font.BOLD,18));
        btnCreateOrder.setBounds(200,144,250,25);
        add(btnCreateOrder);

    }
    public void setCreateOrderListener(ActionListener addSelectListener) {
        btnCreateOrder.addActionListener(addSelectListener);
    }
}
