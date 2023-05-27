package bll;

import bll.validators.Validator;
import dao.OrderDAO;
import model.OrderTable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Clasa OrderBLL contine logica aplicatiei
 * Aceasta clasa este folosita pentru a apela metodele corespunzatoare din pachetul DAO
 * Aceasta clasa contine si validarea datelor de intrare
 */

public class OrderBLL {
    private List<Validator<OrderTable>> validators;
    private OrderDAO orderDAO;

    public OrderBLL() {
        validators = new ArrayList<Validator<OrderTable>>();
        orderDAO = new OrderDAO();
        orderDAO = new OrderDAO();
    }

    public OrderTable findOrderById(int id) {
        OrderDAO oDAO = new OrderDAO();
        OrderTable ord = oDAO.findById(id);
        if (ord== null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return ord;
    }

    public List<OrderTable> findAllOrders() {
        List<OrderTable> order = orderDAO.findAll();
        if (order.size()==0) {
           return null;
        }
        return order;
    }
    public OrderTable insertOrder(OrderTable order) {
        for (Validator<OrderTable> v : validators) {
            try {
                v.validate(order);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("The order was not inserted!");
            }
        }
        return orderDAO.insert(order);
    }
    public int deleteOrder( int Id) {
        if(orderDAO.delete(orderDAO.findById(Id)))
            return Id;
        else
        return -1;
    }
    public void updateOrder(OrderTable order) {
        orderDAO.update(order);
    }
}
