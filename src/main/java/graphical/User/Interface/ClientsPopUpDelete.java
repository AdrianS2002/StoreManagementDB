package graphical.User.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientsPopUpDelete extends JFrame {

    JLabel labelId = new JLabel("Client id: ");
    JTextField textFieldId = new JTextField();
    JButton btnDelete = new JButton("Delete");


    public ClientsPopUpDelete() {
        setSize(600, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Delete Client");
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

        btnDelete.setBackground(Color.decode("#c54290"));
        btnDelete.setForeground(Color.decode("#F9D949"));
        btnDelete.setFont(new Font("Arial",Font.BOLD,18));
        btnDelete.setBounds(200,64,250,25);
        add(btnDelete);

    }

    public void setDeleteClientListener(ActionListener delete) {
        btnDelete.addActionListener(delete);
    }
}
