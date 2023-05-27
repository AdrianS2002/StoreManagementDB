package graphical.User.Interface;
import bll.ProductBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductsPanel extends JFrame {
    private JLabel lblTitle = new JLabel("Products Area");

    private JButton btnAddProducts = new JButton("Add new product");

    private JButton btnEditProduct = new JButton("Edit Product");

    private JButton btnDeleteProduct = new JButton("Delete Product");

    private JButton btnViewProducts = new JButton("View Products");

    public ProductsPanel() throws HeadlessException {
        this.setTitle("Products Management");
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800,800);
        panel.setBackground(Color.decode("#D4ADFC"));

        lblTitle.setForeground(Color.decode("#1D267D"));
        lblTitle.setFont(new Font("Arial",Font.BOLD,35));
        lblTitle.setBounds(280,20,400,50);
        panel.setLayout(null);
        panel.add(lblTitle);

        btnAddProducts.setBackground(Color.decode("#c54290"));
        btnAddProducts.setForeground(Color.decode("#F9D949"));
        btnAddProducts.setFont(new Font("Arial",Font.BOLD,18));
        btnAddProducts.setBounds(125,250,200,50);
        panel.setLayout(null);
        panel.add(btnAddProducts);

        btnAddProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsPopUp productsPopUp = new ProductsPopUp();
                productsPopUp.setVisible(true);
                ActionController actionController = new ActionController(productsPopUp);
            }
        });

        btnEditProduct.setBackground(Color.decode("#c54290"));
        btnEditProduct.setForeground(Color.decode("#F9D949"));
        btnEditProduct.setFont(new Font("Arial",Font.BOLD,18));
        btnEditProduct.setBounds(480,250,200,50);
        panel.setLayout(null);
        panel.add(btnEditProduct);

        btnEditProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsPopUpEdit editProductPopUp = new ProductsPopUpEdit();
                editProductPopUp.setVisible(true);
                ActionController actionController = new ActionController(editProductPopUp);
            }
        });
        btnDeleteProduct.setBackground(Color.decode("#c54290"));
        btnDeleteProduct.setForeground(Color.decode("#F9D949"));
        btnDeleteProduct.setFont(new Font("Arial",Font.BOLD,18));
        btnDeleteProduct.setBounds(125,350,200,50);
        panel.setLayout(null);
        panel.add(btnDeleteProduct);

        btnDeleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductsPopUpDelete deleteProductPopUp = new ProductsPopUpDelete();
                deleteProductPopUp.setVisible(true);
                ActionController actionController = new ActionController(deleteProductPopUp);
            }
        });

        btnViewProducts.setBackground(Color.decode("#c54290"));
        btnViewProducts.setForeground(Color.decode("#F9D949"));
        btnViewProducts.setFont(new Font("Arial",Font.BOLD,18));
        btnViewProducts.setBounds(480,350,200,50);
        panel.setLayout(null);
        panel.add(btnViewProducts);

        btnViewProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductBLL productBLL = new ProductBLL();
                ProductTable viewProductPopUp = new ProductTable(productBLL.findAllProducts());
                viewProductPopUp.setVisible(true);
            }
        });
        this.setContentPane(panel);
    }
}
