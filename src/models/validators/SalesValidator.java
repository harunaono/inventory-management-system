package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import models.Product;
import models.Sales;

public class SalesValidator {
    public static List<String> validate(Sales s) {
        List<String> errors = new ArrayList<String>();

        String sales_date_error = _validateArrival_date(s.getSales_date());
        if (!sales_date_error.equals("")) {
            errors.add(sales_date_error);
        }

        String product_number_error = _validateProduct_number(s.getProduct());
        if (!product_number_error.equals("")) {
            errors.add(product_number_error);
        }

        String quantity_error = _validateQuantity(s.getQuantity());
        if (!quantity_error.equals("")) {
            errors.add(quantity_error);
        }

        return errors;
    }

    private static String _validateArrival_date(Date date) {
        if (date == null || date.equals("")) {
            return "日付を入力してください。";
        }

        return "";
    }

    private static String _validateProduct_number(Product product) {
        if (product == null || product.equals("")) {
            return "品番を入力してください。";
        }

        return "";
    }

    private static String _validateQuantity(Integer quantity) {
        if (quantity == null || quantity.equals("")) {
            return "個数を入力してください。";
        }

        return "";

    }
}