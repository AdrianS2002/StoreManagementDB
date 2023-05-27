package bll.validators;

import model.OrderTable;

/**
 * Clasa OrderValidator implementeaza interfata Validator si se foloseste de
 */

public class OrderValidator implements Validator<OrderTable> {

    private static final String QUANTITY_PATTERN = "\\d+";//^[1-9][0-9]*$
    private static final String ID_PATTERN = "\\d+";
    @Override
    public void validate(OrderTable order) {
        if (!String.valueOf(order.getOrdertableId()).matches(ID_PATTERN)) {
            throw new IllegalArgumentException("The id of the order must contain only numbers!");
        }

        if(!String.valueOf(order.getProductId()).matches(ID_PATTERN)) {
        	throw new IllegalArgumentException("The id of the product must contain only numbers!");
        }

        if(!String.valueOf(order.getClientId()).matches(ID_PATTERN)) {
        	throw new IllegalArgumentException("The id of the client must contain only numbers!");
        }
    }
}
