package classes.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/22
 * @Time: 14:07
 * @Package: classes.servlets
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        pw.println("<html>");
        pw.println ("user with name "+username+"psww"+ password+" was added.");
        pw.println("</body></html>");
    }
}
