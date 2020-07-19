package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import models.Arrival;

public class ArrivalValidator {
    public static List<String> validate(Arrival a) {
        List<String> errors = new ArrayList<String>();

        String arrival_date_error = _validateArrival_date(a.getArrival_date());
        if(!arrival_date_error.equals("")) {
            errors.add(arrival_date_error);
        }

        String product_number_error = _validateProduct_number(a.getProduct_number());
        if(!product_number_error.equals("")) {
            errors.add(product_number_error);
        }

        String quantity_error = _validateQuantity(a.getQuantity());
        if(!quantity_error.equals("")) {
            errors.add(quantity_error);
        }

        return errors;
    }

    private static String _validateArrival_date(Date date) {
        if(date == null || date.equals("")) {
            return "日付を入力してください。";
            }

        return "";
    }

    private static String _validateProduct_number(Integer product_number) {
        if(product_number == null || product_number.equals("")) {
            return "品番を入力してください。";
            }

        return "";
    }

    private static String _validateQuantity(Integer quantity) {
        if(quantity == null || quantity.equals("")) {
            return "個数を入力してください。";
            }

        return "";

}
}