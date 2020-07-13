package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "store")
@NamedQueries({
    @NamedQuery(
            name = "getAllStore",
            query = "SELECT s FROM Store AS s ORDER BY s.id DESC"
            ),
    @NamedQuery(
            name = "getStoreCount",
            query = "SELECT COUNT(s) FROM Store AS s"
            ),
    @NamedQuery(
            name = "checkRegisteredCode",
            query = "SELECT COUNT(s) FROM Store AS s WHERE s.code = :code"
            ),
    @NamedQuery(
            name = "checkLoginCodeAndPassword",
            query = "SELECT s FROM Store AS s WHERE s.delete_flag = 0 AND s.code = :code AND s.password = :pass"
            )
})
@Entity
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "store_name", nullable = false)
    private String store_name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }





}
