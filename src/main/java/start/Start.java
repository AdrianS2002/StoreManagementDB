package start;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import model.Client;
import model.OrderTable;
import model.Product;

/**
 * Main class
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {

        ClientBLL clientBLL = new ClientBLL();
        ProductBLL productBLL = new ProductBLL();
        OrderBLL orderBLL = new OrderBLL();


//        clientBLL.insertClient(new Client("Ion","ionica.2002@yahoo.com"));
//        clientBLL.insertClient(new Client("Miron","miron.2002@yahoo.com"));
//        clientBLL.insertClient(new Client("Adi","adi.2002@yahoo.com"));
//        clientBLL.updateClient(new Client(3,"Adi","dawd@yahoo.com"));

//        orderBLL.insertOrder(new OrderTable(1,1,2));
//        orderBLL.insertOrder(new OrderTable(2,1,3));
//        System.out.println(orderBLL.findAllOrders());

       // orderBLL.deleteOrder(1);
      //  System.out.println(orderBLL.findAllOrders());

    //    orderBLL.insertOrder(new OrderTable(2,2,1));
        //orderBLL.deleteOrder(1);
  //      orderBLL.updateOrder(new OrderTable(2,1,2,100));

       // orderBLL.updateOrder(new OrderTable(1,3,20));
//        System.out.println(orderBLL.findAllOrders());

       System.out.println(productBLL.findProductById(1));
                System.out.println(productBLL.findAllProducts());
//        productBLL.deleteProduct(1);
//        System.out.println(productBLL.findAllProducts());
//
//    productBLL.updateProduct(new Product(2,"wwdadawdda",2,10.2));
//        System.out.println(productBLL.findAllProducts());
//
//       System.out.println(clientBLL.findAllClients());
//        clientBLL.deleteClient(1);
//
//        clientBLL.updateClient(new Client(3,"Gavrea","gavrea.math@yahoo.com"));
//        System.out.println(clientBLL.findAllClients());


    }

}

