package graphical.User.Interface;

import model.Product;

import java.util.List;

public class ProductTable extends TableAbstract<Product> {
    public ProductTable(List<Product> list) {
        super(list);
    }
}
