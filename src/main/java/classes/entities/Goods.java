package classes.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/22
 * @Time: 18:38
 * @Package: classes.entities
 */
public class Goods {
    private int id;
    private String name;
    private String kind;
    private double price;
    private int num;

    public Goods(){
    }
    public Goods(int id, String name, String kind, double price, int num) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.num = num;
    }

    public void setGoods(ResultSet resultSet){
        try {
            this.id=resultSet.getInt(1);
            this.name=resultSet.getString(2);
            this.kind=resultSet.getString(3);
            this.price=resultSet.getDouble(4);
            this.num=resultSet.getInt(5);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
