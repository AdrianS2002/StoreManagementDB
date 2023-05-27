package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductsPopUpDelete extends JFrame {
    JLabel labelId = new JLabel("Product id: ");
    JTextField textFieldId = new JTextField();
    JButton btnAdd = new JButton("Delete");
    public ProductsPopUpDelete() {
        setSize(600, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Delete Product");
        getContentPane().setBackground(Color.decode("#D4ADFC"));
        setResizable(false);
        setLayout(null);


        labelId.setForeground(Color.decode("#c54290"));
        labelId.setBounds(24,24,250,25);
        labelId.setFont(new Font("Arial",Font.BOLD,18));
        add(labelId);

        textFieldId.setBounds(200,24,250,25);
        textFieldId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldId);

        btnAdd.setBackground(Color.decode("#c54290"));
        btnAdd.setForeground(Color.decode("#F9D949"));
        btnAdd.setFont(new Font("Arial",Font.BOLD,18));
        btnAdd.setBounds(200,64,250,25);
        add(btnAdd);

    }
    public void setDeleteProductListener(ActionListener delete) {
        btnAdd.addActionListener(delete);
    }
}
