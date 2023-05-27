package bll.validators;

import model.Product;

import java.util.regex.Pattern;

/**
 * Clasa ProductValidator implementeaza interfata Validator si se foloseste de
 */
public class ProductValidator implements Validator<Product> {
    private static final String PRICE_PATTERN ="^(?!0)\\d*\\.?\\d+$";
    private static final String NUMBER_OF_PRODUCTS_PATTERN = "\\d+";
    private static final String ID_PATTERN = "\\d+";
    @Override
    public void validate(Product product) {
        Pattern patternID = Pattern.compile(ID_PATTERN);
        if (!patternID.matcher(String.valueOf(product.getProductId())).matches()) {
            throw new NumberFormatException("The id of the product must contain only numbers!");
        }
        Pattern patterPrice = Pattern.compile(PRICE_PATTERN);
        if (!patterPrice.matcher(String.valueOf(product.getProductPrice())).matches()) {
            throw new NumberFormatException("The price of the product must contain only numbers!");
        }
        if (!String.valueOf(product.getProductStock()).matches(NUMBER_OF_PRODUCTS_PATTERN)) {
            throw new NumberFormatException("The number of products must contain only numbers!");
        }

    }
}
