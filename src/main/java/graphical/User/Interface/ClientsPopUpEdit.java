package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientsPopUpEdit extends JFrame {
    JLabel labelId = new JLabel("Client id: ");
    JLabel labelName = new JLabel("Client name: ");
    JLabel labelEmail = new JLabel("Client address: ");
    JTextField textFieldId = new JTextField();
    JTextField textFieldName = new JTextField();
    JTextField textFieldEmail = new JTextField();
    JButton btnEdit = new JButton("Edit");

    public ClientsPopUpEdit() {
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Edit Client");
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


        labelEmail.setForeground(Color.decode("#c54290"));
        labelEmail.setBounds(24,104,250,25);
        labelEmail.setFont(new Font("Arial",Font.BOLD,18));
        add(labelEmail);

        textFieldId.setBounds(200,24,250,25);
        textFieldId.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldId);

        textFieldName.setBounds(200,64,250,25);
        textFieldName.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldName);


        textFieldEmail.setBounds(200,104,250,25);
        textFieldEmail.setFont(new Font("Arial",Font.BOLD,15));
        add(textFieldEmail);

        btnEdit.setBackground(Color.decode("#c54290"));
        btnEdit.setForeground(Color.decode("#F9D949"));
        btnEdit.setFont(new Font("Arial",Font.BOLD,18));
        btnEdit.setBounds(200,144,250,25);
        add(btnEdit);

    }
    public void setEditClientListener(ActionListener edit) {
        btnEdit.addActionListener(edit);
    }


}
