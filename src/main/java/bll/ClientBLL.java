package bll;

import bll.validators.ClientValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;
import model.OrderTable;

import java.util.*;
/**
 * Clasa ClientBLL contine logica aplicatiei
 * Aceasta clasa este folosita pentru a apela metodele corespunzatoare din pachetul DAO
 * Aceasta clasa contine si validarea datelor de intrare
 */
public class ClientBLL {
    private List<Validator<Client>> validators;

    private ClientDAO clientDAO;
    private OrderBLL orderBLL;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientValidator());
        clientDAO = new ClientDAO();
        orderBLL = new OrderBLL();
    }
    public Client findClientById(int id) {
        ClientDAO cDAO = new ClientDAO();
        Client clt = cDAO.findById(id);
        if (clt == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return clt;
    }

    public List<Client> findAllClients() {
        List<Client> clients = clientDAO.findAll();
        if (clients.size()==0) {
            throw new NoSuchElementException("The clients were not found!");
        }
        return clients;
    }
    public Client insertClient(Client client) {

        for (Validator<Client> v : validators) {
           try {
               v.validate(client);
           }
           catch (IllegalArgumentException e) {
               throw new IllegalArgumentException("The client was not inserted!");
           }
        }
        return clientDAO.insert(client);
    }

    public void deleteClient( int Id) {
       List<OrderTable> orders = orderBLL.findAllOrders();
        if (orders != null) {
            for (OrderTable o : orders) {
                if (o.getClientId() == Id)
                    orderBLL.deleteOrder(o.getOrdertableId());
            }
        }
    	clientDAO.delete(clientDAO.findById(Id));
    }

    public void updateClient(Client client) {
    	clientDAO.update(client);
    }
}
