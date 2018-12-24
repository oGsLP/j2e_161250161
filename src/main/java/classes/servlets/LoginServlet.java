package classes.servlets;


import classes.entities.User;

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
    Context ctx; DataSource dataSource; ResultSet result;PreparedStatement pstmt;
    public void init(){
        try {
            ctx=new InitialContext();
            dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/jee_hw");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        try {
            Connection con= dataSource.getConnection();
            pstmt=con.prepareStatement("select * from user where username=?");
            pstmt.setString(1,username);
            result=pstmt.executeQuery();
            if(result.next()){
                if(result.getString("password").equals(password)){
                    User user =new User(result.getInt(1),result.getString(2),result.getString(3),result.getDouble(4));
                    HttpSession session = request.getSession(true);
                    session.setAttribute("username", username);

                    ServletContext servletContext=getServletContext();
                    int counter= Integer.parseInt((String) servletContext.getAttribute("user-counter")) ;
                    counter++;
                    servletContext.setAttribute("user-counter",counter+"");
                    response.sendRedirect("/app/listLayout");
                }
                else{
                    response.sendRedirect("/app/wrongPassword.jsp");
                }
            }
            else {
                response.sendRedirect("/app/wrongUser.jsp");
            }
            result.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
//                res.sendRedirect("/app/login.jsp");
                req.getRequestDispatcher("/app/login.jsp").forward(req,res);
            }
        }
        else {
//            res.sendRedirect("/app/login.jsp");
            req.getRequestDispatcher("/app/login.jsp").forward(req,res);
        }
    }
}
