package graphical.User.Interface;

import bll.validators.ProductValidator;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductsPopUpEdit extends JFrame {
    JLabel labelId = new JLabel("Product id: ");
    JLabel labelName = new JLabel("Product name: ");
    JLabel labelPrice = new JLabel("Product price: ");
    JLabel labelStock = new JLabel("Product stock: ");
    JTextField textFieldStock = new JTextField();
    JTextField textFieldName = new JTextField();
    JTextField textFieldId = new JTextField();
    JTextField textFieldPrice = new JTextField();
    JButton btnEdit = new JButton("Edit");
    public ProductsPopUpEdit() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Edit Product");
        getContentPane().setBackground(Color.decode("#D4ADFC"));
        setResizable(false);
        setLayout(null);


        labelId.setForeground(Color.decode("#c54290"));
        labelId.setBounds(24,24,250,25);
        labelId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelId);


        labelName.setForeground(Color.decode("#c54290"));
        labelName.setBounds(24,64,250,25);
        labelName.setFont(new Font("Arial",Font.BOLD,18));
        add(labelName);

        labelStock.setForeground(Color.decode("#c54290"));
        labelStock.setBounds(24,104,250,25);
        labelStock.setFont(new Font("Arial",Font.BOLD,18));
        add(labelStock);


        labelPrice.setForeground(Color.decode("#c54290"));
        labelPrice.setBounds(24,144,250,25);
        labelPrice.setFont(new Font("Arial",Font.BOLD,18));
        add(labelPrice);


        textFieldId.setBounds(200,24,250,25);
        textFieldId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldId);


        textFieldName.setBounds(200,64,250,25);
        textFieldName.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldName);

        textFieldStock.setBounds(200,104,250,25);
        textFieldStock.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldStock);


        textFieldPrice.setBounds(200,144,250,25);
        textFieldPrice.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldPrice);


        btnEdit.setBackground(Color.decode("#c54290"));
        btnEdit.setForeground(Color.decode("#F9D949"));
        btnEdit.setFont(new Font("Arial",Font.BOLD,18));
        btnEdit.setBounds(200,184,250,25);
        add(btnEdit);

    }
    public void setEditProductListener(ActionListener editProductListener) {
        btnEdit.addActionListener(editProductListener);
    }
}
