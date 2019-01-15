package classes.servlets;

import classes.entities.Goods;
import classes.factory.ServiceFactory;
import classes.helpers.JSONHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/23
 * @Time: 12:06
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/listLayout")
public class ListLayoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List goods= ServiceFactory.getStockService().getStock();
        String goods_Json = JSONHelper.toJson(goods);
        System.out.println("Find "+goods.size()+" goods");
        request.setAttribute("stock_list",goods_Json);
        request.getRequestDispatcher("/app/stockList.jsp").forward(request,response);
    }
}
