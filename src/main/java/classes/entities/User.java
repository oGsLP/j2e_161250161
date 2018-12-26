package classes.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/22
 * @Time: 17:33
 * @Package: classes.entities
 */
public class User {
    private int id;
    private String username;
    private String password;
    private double account;

    public User(){
    }

    public User(String username,String password){
        this.username=username;
        this.password=password;
        this.account=0;
    }

    public User(int id, String username, String password, double account) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public void setUser(ResultSet resultSet){
        try {
            this.id=resultSet.getInt(1);
            this.username=resultSet.getString(2);
            this.password=resultSet.getString(3);
            this.account=resultSet.getDouble(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
