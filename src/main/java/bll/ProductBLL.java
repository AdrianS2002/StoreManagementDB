package bll;


import bll.validators.ProductValidator;
import bll.validators.Validator;

import dao.ProductDAO;
import model.Client;
import model.OrderTable;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa ProductBLL contine logica aplicatiei
 * Aceasta clasa este folosita pentru a apela metodele corespunzatoare din pachetul DAO
 * Aceasta clasa contine si validarea datelor de intrare
 */

public class ProductBLL {
    private List<Validator<Product>> validators;
    private ProductDAO productDAO;
    private OrderBLL orderBLL;

    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductValidator());
        productDAO = new ProductDAO();
        orderBLL = new OrderBLL();
    }

    public Product findProductById(int id) {
        ProductDAO pDAO = new ProductDAO();
        Product prod = pDAO.findById(id);
        if (prod == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return prod;
    }
    public List<Product> findAllProducts() {
        List<Product> products = productDAO.findAll();
        if (products.size()==0) {
            throw new NoSuchElementException("The products were not found!");
        }
        return products;
    }
    public Product insertProduct(Product products) {
        for (Validator<Product> v : validators) {
            try{
            v.validate(products);
        }
            catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("The product was not inserted!");
            }
        }
        return productDAO.insert(products);
    }
    public void deleteProduct( int Id) {
        List<OrderTable> orders = orderBLL.findAllOrders();
        if (orders != null)
        {
            for (OrderTable o : orders) {
                if (o.getClientId() == Id)
                    orderBLL.deleteOrder(o.getOrdertableId());
            }
        }
        productDAO.delete(productDAO.findById(Id));
    }
    public void updateProduct(Product product) {
        productDAO.update(product);
    }
}
