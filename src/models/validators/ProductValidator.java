package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Product;
import utils.DBUtil;

public class ProductValidator {
    public static List<String> validate(Product p) {
        List<String> errors = new ArrayList<String>();

        String brand_name_error = _validateBrand_name(p.getBrand_name());
        if(!brand_name_error.equals("")) {
            errors.add(brand_name_error);
        }


        String product_error = _validateProduct(p.getProduct());
        if(!product_error.equals("")) {
            errors.add(product_error);
        }

        String product_number_error = _validateProduct_number(p.getProduct_number());
        if(!product_number_error.equals("")) {
            errors.add(product_number_error);
        }

        String size_error = _validateSize(p.getSize());
        if(!size_error.equals("")) {
            errors.add(size_error);
        }

        String color_error = _validateColor(p.getColor());
        if(!color_error.equals("")) {
            errors.add(color_error);
        }

        String price_error = _validatePrice(p.getPrice());
        if(!price_error.equals("")) {
            errors.add(price_error);
        }

        return errors;
    }

    private static String _validateBrand_name(String brand_name) {
        if (brand_name == null || brand_name.equals("")) {
            return "ブランド名を入力してください。";
        }

        return "";
    }

    private static String _validateProduct(String product) {
        if (product == null || product.equals("")) {
            return "商品名を入力してください。";
        }

        return "";
    }

    private static String _validateProduct_number(Integer product_number) {
        if (product_number == null || product_number.equals("")) {
            return "品番を入力してください。";
        }



        EntityManager em = DBUtil.createEntityManager();
        long product_number_count = (long)em.createNamedQuery("checkRegisteredProduct_number", Long.class)
                                       .setParameter("product_number", product_number)
                                         .getSingleResult();
        em.close();
        if(product_number_count > 0) {
            return "入力された品番の情報はすでに存在しています。";
        }


    return "";
}

    private static String _validateSize(String size) {
        if (size == null || size.equals("")) {
            return "サイズを入力してください。";
        }

        return "";
    }

    private static String _validateColor(String color) {
        if (color == null || color.equals("")) {
            return "カラーを入力してください。";
        }

        return "";
    }

    private static String _validatePrice(Integer price) {
        if (price == null || price.equals("")) {
            return "価格を入力してください。";
        }

        return "";

    }
}
