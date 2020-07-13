package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Store;
import utils.DBUtil;

public class StoreValidator {
    public static List<String> validate(Store s, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();

        String code_error = _validateCode(s.getCode());
        if(!code_error.equals("")) {
            errors.add(code_error);
        }

        String name_error = _validateName(s.getStore_name());
        if(!name_error.equals("")) {
            errors.add(name_error);
        }

        String password_error = _validatePassword(s.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }
        return errors;
    }

    private static String _validateCode(String code) {
        if(code == null || code.equals("")) {
            return "IDを入力してください。";
        }

        EntityManager em = DBUtil.createEntityManager();
        long store_count = (long)em.createNamedQuery("checkRegisteredCode", Long.class)
                                        .setParameter("code",  code)
                                        .getSingleResult();
        em.close();
        if(store_count > 0) {
             return "入力されたIDはすでに存在しています。";
            }

        return"";
    }

    private static String _validateName(String name) {
        if(name == null || name.equals("")) {
            return "店舗名を入力してください。";
        }

        return "";
    }
    private static String _validatePassword(String password, Boolean password_check_flag) {
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";

        }
    }
