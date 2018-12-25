package classes.servlets;

import classes.entities.Goods;

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

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/23
 * @Time: 12:06
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/listLayout")
public class ListLayoutServlet extends HttpServlet {
    Context ctx; DataSource dataSource; Statement stmt; ResultSet result;Connection con;
    public void init(){
        try {
            ctx=new InitialContext();
            dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/jee_hw");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session=request.getSession(false);
//        if(session==null){
//            response.sendRedirect("/app/login");
//        }
//        else {
//            String s= (String) session.getAttribute("username");
//            if(s == null){
//                response.sendRedirect("/app/login");
//                return;
//            }
//        }

        try {
            con = dataSource.getConnection();
            stmt=con.createStatement();
            result=stmt.executeQuery("select * from goods");

            ArrayList<Goods> goods = new ArrayList<>();
            while(result.next()){
                goods.add(new Goods(result.getInt(1),result.getString(2),result.getString(3),result.getDouble(4),result.getInt(5)));
//                System.out.println("Goods:" +result.getString(2));
            }
            System.out.println("Find "+goods.size()+" goods");
            result.close();
            stmt.close();
            con.close();
            request.setAttribute("goods",goods);
            request.getRequestDispatcher("/app/stockList.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
