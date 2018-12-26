package classes.servlets;


import classes.entities.User;
import classes.factory.ServiceFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/22
 * @Time: 14:07
 * @Package: classes.servlets
 */
@WebServlet("/app/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(ServiceFactory.getUserService().checkUserName(username)){
            if(ServiceFactory.getUserService().checkUserPassword(username,password)){
                HttpSession session = request.getSession(true);
                session.setAttribute("username", username);

                ServletContext servletContext=getServletContext();
                int counter= Integer.parseInt((String) servletContext.getAttribute("user-counter")) ;
                counter++;
                servletContext.setAttribute("user-counter",counter+"");
                response.sendRedirect("/app/listLayout");
            }
            else {
                response.sendRedirect("/app/wrongPassword.jsp");
            }
        }
        else {
            response.sendRedirect("/app/wrongUser.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        if(session!=null){
            String username= (String) session.getAttribute("username");
            if(username!=null){
                res.sendRedirect("/app/listLayout");
            }
            else {
                req.getRequestDispatcher("/app/login.jsp").forward(req,res);
            }
        }
        else {
            req.getRequestDispatcher("/app/login.jsp").forward(req,res);
        }
    }
}
