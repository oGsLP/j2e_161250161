package classes.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/15
 * @Time: 15:57
 * @Package: classes.entities
 */
@Entity
@Table(name="deal")
public class Deal implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="uid",referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="gid",referencedColumnName = "id")
    private Goods goods;
    private int num;
    private Timestamp date;


    public Deal(){
    }

    public Deal(int num,User user,Goods goods){
        this.num=num;
        this.user=user;
        this.goods=goods;
        this.date=new Timestamp(new java.util.Date().getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
