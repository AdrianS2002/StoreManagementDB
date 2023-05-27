package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientsPopUp extends JFrame {

    JLabel labelName = new JLabel("Client name: ");
    JLabel labelEmail = new JLabel("Client email: ");
    JTextField textFieldName = new JTextField();
    JTextField textFieldId = new JTextField();
    JButton btnAdd = new JButton("Add");
    JTextField textFieldEmail = new JTextField();
    public ClientsPopUp() {
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Add Client");
        getContentPane().setBackground(Color.decode("#D4ADFC"));
        setResizable(false);
        setLayout(null);


        labelName.setForeground(Color.decode("#c54290"));
        labelName.setBounds(24,24,250,25);
        labelName.setFont(new Font("Arial",Font.BOLD,18));
        add(labelName);


        labelEmail.setForeground(Color.decode("#c54290"));
        labelEmail.setBounds(24,64,250,25);
        labelEmail.setFont(new Font("Arial",Font.BOLD,18));
        add(labelEmail);


        textFieldName.setBounds(200,24,250,25);
        textFieldName.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldName);


        textFieldEmail.setBounds(200,64,250,25);
        textFieldEmail.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldEmail);


        btnAdd.setBackground(Color.decode("#c54290"));
        btnAdd.setForeground(Color.decode("#F9D949"));
        btnAdd.setFont(new Font("Arial",Font.BOLD,18));
        btnAdd.setBounds(200,104,250,25);
        add(btnAdd);

    }

    public void setAddClientListener(ActionListener add) {
        btnAdd.addActionListener(add);
    }
}
