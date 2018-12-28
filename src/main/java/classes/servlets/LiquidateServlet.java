package classes.servlets;

import classes.factory.ServiceFactory;
import classes.models.ShopCart;
import classes.models.ShopResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/22
 * @Time: 21:29
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/liquidate")
public class LiquidateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        String username= (String) session.getAttribute("username");
        double beforeAccount=ServiceFactory.getUserService().findUser(username).getAccount();
        ShopResult shopResult;
        int i=1;int peak=getGoodsNum();String param;String message;
        ArrayList<ShopCart> list = new ArrayList<>();
        while(i<=peak){
            param="shop_goods_"+i;
            if(request.getParameter(param)!=null){
                String name=ServiceFactory.getStockService().findGoods(i).getName();
                list.add(new ShopCart(name,Integer.parseInt(request.getParameter(param))));
            }
            i++;
        }
        if(ServiceFactory.getShopService().checkAndSumList(list)){
            message=ServiceFactory.getShopService().liquidateShopCart(username,list);
            double beforeDiscount=ServiceFactory.getShopService().sumList(list);
            double afterDiscount=ServiceFactory.getShopService().getAfterDiscount(beforeDiscount);
            double afterAccount=ServiceFactory.getUserService().findUser(username).getAccount();
            shopResult=new ShopResult(message,username,list,beforeAccount,afterAccount,beforeDiscount,afterDiscount);
        }
        else {
            message="some goods out of stock";
            shopResult=new ShopResult(message,username,list,beforeAccount,beforeAccount,0,0);
        }
        session.setAttribute("shop_result",shopResult);
        response.sendRedirect("/app/giveResult");
    }


    private int getGoodsNum() {
        return ServiceFactory.getStockService().getGoodsNum();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }
}
