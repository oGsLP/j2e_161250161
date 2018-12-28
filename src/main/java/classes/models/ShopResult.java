package classes.models;

import java.util.ArrayList;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/28
 * @Time: 23:57
 * @Package: classes.models
 */
public class ShopResult {
    private String message;
    private String username;
    private ArrayList<ShopCart> shopCarts;
    private double before_account;
    private double after_account;
    private double before_discount;
    private double after_discount;

    public ShopResult() {
    }

    public ShopResult(String message, String username, ArrayList<ShopCart> shopCarts, double before_account, double after_account, double before_discount, double after_discount) {
        this.message = message;
        this.username = username;
        this.shopCarts = shopCarts;
        this.before_account = before_account;
        this.after_account = after_account;
        this.before_discount = before_discount;
        this.after_discount = after_discount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<ShopCart> getShopCarts() {
        return shopCarts;
    }

    public void setShopCarts(ArrayList<ShopCart> shopCarts) {
        this.shopCarts = shopCarts;
    }

    public double getBefore_account() {
        return before_account;
    }

    public void setBefore_account(double before_account) {
        this.before_account = before_account;
    }

    public double getAfter_account() {
        return after_account;
    }

    public void setAfter_account(double after_account) {
        this.after_account = after_account;
    }

    public double getBefore_discount() {
        return before_discount;
    }

    public void setBefore_discount(double before_discount) {
        this.before_discount = before_discount;
    }

    public double getAfter_discount() {
        return after_discount;
    }

    public void setAfter_discount(double after_discount) {
        this.after_discount = after_discount;
    }
}
