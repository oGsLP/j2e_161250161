package classes.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/24
 * @Time: 17:18
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/traveller")
public class TravellerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("traveller", "1");

        ServletContext servletContext=getServletContext();
        int counter= Integer.parseInt((String) servletContext.getAttribute("traveller-counter")) ;
        counter++;
        servletContext.setAttribute("traveller-counter",counter+"");
        response.sendRedirect("/app/traveller.jsp");
    }
}
