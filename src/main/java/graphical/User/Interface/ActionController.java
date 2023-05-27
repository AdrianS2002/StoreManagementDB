package graphical.User.Interface;

import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.OrderTable;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionController {
    private ClientsPopUp clientsPopUp;
    private ClientsPopUpEdit clientsPopUpEdit;
    private ClientsPopUpDelete clientsPopUpDelete;
    private ProductsPopUp productsPopUp;
    private ProductsPopUpEdit productsPopUpEdit;
    private ProductsPopUpDelete productsPopUpDelete;
    private OrderEdit orderEditPopUp;
    private OrderDeletePopUp orderDeletePopUp;
    private OrderCreation orderCreationPopUp;
    private ClientBLL clientBLL;
    private ProductBLL productBLL;
    private OrderBLL orderBLL;

    public ActionController(ClientsPopUp clientsPopUp) {
        this.clientsPopUp = clientsPopUp;
        clientBLL = new ClientBLL();
        clientsPopUp.setAddClientListener(new AddClientListener());
    }
    public ActionController(ClientsPopUpEdit clientsPopUpEdit) {
        this.clientsPopUpEdit = clientsPopUpEdit;
        clientBLL = new ClientBLL();
        clientsPopUpEdit.setEditClientListener(new EditClientListener());
    }
    public ActionController(ClientsPopUpDelete clientsPopUpDelete) {
        this.clientsPopUpDelete = clientsPopUpDelete;
        clientBLL = new ClientBLL();
        clientsPopUpDelete.setDeleteClientListener(new DeleteClientListener());
    }
    public ActionController(ProductsPopUp productsPopUp) {
        this.productsPopUp = productsPopUp;
        productBLL = new ProductBLL();
        productsPopUp.setAddProductListener(new AddProductListener());
    }
    public ActionController(ProductsPopUpEdit productsPopUpEdit) {
        this.productsPopUpEdit = productsPopUpEdit;
        productBLL = new ProductBLL();
        productsPopUpEdit.setEditProductListener(new EditProductListener());
    }
    public ActionController(ProductsPopUpDelete productsPopUpDelete) {
        this.productsPopUpDelete = productsPopUpDelete;
        productBLL = new ProductBLL();
        productsPopUpDelete.setDeleteProductListener(new DeleteProductListener());
    }
    public ActionController(OrderDeletePopUp orderDeletePopUp) {
        this.orderDeletePopUp = orderDeletePopUp;
        orderBLL = new OrderBLL();
        orderDeletePopUp.setDeleteOrderListener(new DeleteOrderListener());
    }
    public ActionController(OrderEdit orderEditPopUp) {
        this.orderEditPopUp = orderEditPopUp;
        orderBLL = new OrderBLL();
        orderEditPopUp.setEditOrderListener(new EditOrderListener());
    }
    public ActionController(OrderCreation orderCreationPopUp) {
        this.orderCreationPopUp = orderCreationPopUp;
        orderBLL = new OrderBLL();
        orderCreationPopUp.setCreateOrderListener(new CreateOrderListener());
    }
    class AddClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = clientsPopUp.textFieldName.getText();
            String email = clientsPopUp.textFieldEmail.getText();
            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                Client client = new Client(name, email);
                try{
                    clientBLL.insertClient(client);
                    JOptionPane.showMessageDialog(null, "Client added successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Client");
                }

                clientsPopUp.textFieldName.setText("");
                clientsPopUp.textFieldEmail.setText("");
            }

        }
    }
    class EditClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = clientsPopUpEdit.textFieldName.getText();
            String email = clientsPopUpEdit.textFieldEmail.getText();
            String id = clientsPopUpEdit.textFieldId.getText();
            if(name.isEmpty() || email.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                Client client = new Client(Integer.parseInt(id),name, email);
                try{
                    clientBLL.updateClient(client);
                    JOptionPane.showMessageDialog(null, "Client updated successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Update");
                }
                clientsPopUpEdit.textFieldName.setText("");
                clientsPopUpEdit.textFieldEmail.setText("");
                clientsPopUpEdit.textFieldId.setText("");
            }
        }
    }
    class DeleteClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = clientsPopUpDelete.textFieldId.getText();
            if(id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                try{
                    clientBLL.deleteClient(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(null, "Client deleted successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Delete");
                }
                clientsPopUpDelete.textFieldId.setText("");
            }
        }
    }
    class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = productsPopUp.textFieldName.getText();
            String stock = productsPopUp.textFieldStock.getText();
            String price = productsPopUp.textFieldPrice.getText();

            if (name.isEmpty() || stock.isEmpty() || price.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                Product product = new Product(name, Integer.parseInt(stock), Double.parseDouble(price));
                try{
                    productBLL.insertProduct(product);
                    JOptionPane.showMessageDialog(null, "Product added successfully");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Product");
                }
                productsPopUp.textFieldName.setText("");
                productsPopUp.textFieldStock.setText("");
                productsPopUp.textFieldPrice.setText("");
            }
        }
    }
    class EditProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = productsPopUpEdit.textFieldName.getText();
            String stock = productsPopUpEdit.textFieldStock.getText();
            String price = productsPopUpEdit.textFieldPrice.getText();
            String id = productsPopUpEdit.textFieldId.getText();
            if(name.isEmpty() || stock.isEmpty() || price.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                Product product = new Product(Integer.parseInt(id),name, Integer.parseInt(stock), Double.parseDouble(price));
                try{
                    productBLL.updateProduct(product);
                    JOptionPane.showMessageDialog(null, "Product updated successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Update");
                }
                productsPopUpEdit.textFieldName.setText("");
                productsPopUpEdit.textFieldStock.setText("");
                productsPopUpEdit.textFieldPrice.setText("");
                productsPopUpEdit.textFieldId.setText("");
            }
        }
    }
    class DeleteProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = productsPopUpDelete.textFieldId.getText();
            if(id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                try{
                    productBLL.deleteProduct(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(null, "Product deleted successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Delete");
                }
                productsPopUpDelete.textFieldId.setText("");
            }
        }
    }
    class DeleteOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = orderDeletePopUp.textFieldId.getText();
            if(id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                try{
                    orderBLL.deleteOrder(Integer.parseInt(id));
                    JOptionPane.showMessageDialog(null, "Order deleted successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Delete");
                }
                orderDeletePopUp.textFieldId.setText("");
            }
        }
    }
    class EditOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = orderEditPopUp.textFieldId.getText();
            String quantity = orderEditPopUp.textFieldQuantity.getText();
            String clientId = orderEditPopUp.textFieldClientId.getText();
            String productId = orderEditPopUp.textFieldProductId.getText();
            if (id.isEmpty() || quantity.isEmpty() || clientId.isEmpty() || productId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                OrderTable order = new OrderTable(Integer.parseInt(id), Integer.parseInt(clientId),Integer.parseInt(productId),Integer.parseInt(quantity));
                try {
                    orderBLL.updateOrder(order);
                    JOptionPane.showMessageDialog(null, "Order updated successfully");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Update");
                }
                orderEditPopUp.textFieldId.setText("");
                orderEditPopUp.textFieldQuantity.setText("");
                orderEditPopUp.textFieldClientId.setText("");
                orderEditPopUp.textFieldProductId.setText("");
            }
        }
        }
    class CreateOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idClient = orderCreationPopUp.textFieldId.getText();
            String idProduct = orderCreationPopUp.textFieldProductId.getText();
            String quantity = orderCreationPopUp.textFieldQuantity.getText();
            if(idClient.isEmpty() || idProduct.isEmpty() || quantity.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                ProductBLL productBLL=new ProductBLL();
                OrderTable order=orderBLL.insertOrder(new OrderTable(Integer.parseInt(idClient), Integer.parseInt(idProduct), Integer.parseInt(quantity)));
                Product prod=productBLL.findProductById(order.getProductId());
                try{

                    if(prod.getProductStock()<Integer.parseInt(quantity))
                        JOptionPane.showMessageDialog(null, "Not enough stock");
                    else {
                        productBLL.updateProduct(new Product(order.getProductId(), prod.getProductName(), prod.getProductStock() - Integer.parseInt(quantity), prod.getProductPrice()));
                        JOptionPane.showMessageDialog(null, "Order created successfully");
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Order");
                }
                orderCreationPopUp.textFieldId.setText("");
                orderCreationPopUp.textFieldProductId.setText("");
                orderCreationPopUp.textFieldQuantity.setText("");
            }
        }
    }
}
