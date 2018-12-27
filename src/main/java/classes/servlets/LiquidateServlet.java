package classes.servlets;

import classes.entities.Goods;
import classes.factory.ServiceFactory;
import classes.models.ShopCart;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        int i=1;int peak=getGoodsNum();
        ArrayList<ShopCart> list = new ArrayList<>();
        while(i<=peak){
            if(request.getParameter("shop_goods_"+i)!=null){
                String name=ServiceFactory.getStockService().findGoods(i).getName();
                list.add(new ShopCart(name,Integer.parseInt(request.getParameter("shop_goods_"+i))));
            }
            i++;
        }
        if(ServiceFactory.getShopService().checkAndSumList(list)){
            String username= (String) request.getSession().getAttribute("username");
            double beforeAccount=ServiceFactory.getUserService().findUser(username).getAccount();
            String message=ServiceFactory.getShopService().liquidateShopCart(username,list);
            double beforeDiscount=ServiceFactory.getShopService().sumList(list);
            double afterDiscount=ServiceFactory.getShopService().getAfterDiscount(beforeDiscount);
            double afterAccount=ServiceFactory.getUserService().findUser(username).getAccount();


            PrintWriter pw=response.getWriter();
            pw.println("<html>" +
                    "<body style=\"text-align:center\">");
            pw.println("<p>"+message+"</p>");
            pw.println("<p>beforeAccount</p>");
            pw.println("<p>"+beforeAccount+"</p>");
            pw.println("<p>afterAccount</p>");
            pw.println("<p>"+afterAccount+"</p>");

            pw.println("<p>beforeDiscount</p>");
            pw.println("<p>"+beforeDiscount+"</p>");
            pw.println("<p>afterDiscount</p>");
            pw.println("<p>"+afterDiscount+"</p>");

            pw.println("<a href=\"login\">"+"back"+"</a>");
            pw.println("</body></html>");

        }
        else {
            PrintWriter pw=response.getWriter();
            pw.println("<html>" +
                    "<body style=\"text-align:center\">");
            pw.println("<p>out of stock</p>");
            pw.println("<a href=\"login\">"+"back"+"</a>");
            pw.println("</body></html>");
        }

    }


    private int getGoodsNum() {
        return ServiceFactory.getStockService().getGoodsNum();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
