package classes.models;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/27
 * @Time: 14:41
 * @Package: classes.models
 */
public class ShopCart {
    private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ShopCart(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
