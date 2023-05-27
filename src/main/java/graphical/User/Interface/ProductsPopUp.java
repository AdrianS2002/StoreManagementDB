package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductsPopUp extends JFrame {
    JLabel labelName = new JLabel("Product name: ");
    JLabel labelPrice = new JLabel("Product price: ");

    JLabel labelStock = new JLabel("Product stock: ");
    JTextField textFieldName = new JTextField();
    JTextField textFieldPrice = new JTextField();

    JTextField textFieldStock = new JTextField();

    JButton btnAdd = new JButton("Add");

    public ProductsPopUp() {
        setSize(600, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Add Product");
        getContentPane().setBackground(Color.decode("#D4ADFC"));
        setResizable(false);
        setLayout(null);

        labelName.setForeground(Color.decode("#c54290"));
        labelName.setBounds(24,24,250,25);
        labelName.setFont(new Font("Arial",Font.BOLD,18));
        add(labelName);

        labelStock.setForeground(Color.decode("#c54290"));
        labelStock.setBounds(24,64,250,25);
        labelStock.setFont(new Font("Arial",Font.BOLD,18));
        add(labelStock);


        labelPrice.setForeground(Color.decode("#c54290"));
        labelPrice.setBounds(24,104,250,25);
        labelPrice.setFont(new Font("Arial",Font.BOLD,18));
        add(labelPrice);



        textFieldName.setBounds(200,24,250,25);
        textFieldName.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldName);

        textFieldStock.setBounds(200,64,250,25);
        textFieldStock.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldStock);

        textFieldPrice.setBounds(200,104,250,25);
        textFieldPrice.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldPrice);


        btnAdd.setBackground(Color.decode("#c54290"));
        btnAdd.setForeground(Color.decode("#F9D949"));
        btnAdd.setFont(new Font("Arial",Font.BOLD,18));
        btnAdd.setBounds(200,144,250,25);
        add(btnAdd);

//        btnAdd.addActionListener(e -> {
//
//            String name = textFieldName.getText();
//
//            String stock = textFieldStock.getText();
//            String price = textFieldPrice.getText();
//            if (name.isEmpty() || stock.isEmpty() || price.isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Please fill all the fields");
//            } else {
//                JOptionPane.showMessageDialog(null, "Product added successfully");
//                textFieldName.setText("");
//                textFieldPrice.setText("");
//                textFieldStock.setText("");
//            }
//        });

    }
    public void setAddProductListener(ActionListener addProductListener) {
        btnAdd.addActionListener(addProductListener);
    }
}
