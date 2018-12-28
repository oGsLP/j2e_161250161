package classes.servlets;

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
 * @Time: 21:06
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String traveller = (String) session.getAttribute("traveller");
            if (traveller != null) {
                int count = Integer.parseInt((String) getServletContext().getAttribute("traveller-counter")) - 1;
                getServletContext().setAttribute("traveller-counter", count + "");
                request.getSession(false).removeAttribute("traveller");
                response.sendRedirect("/app/login");
                return;
            }
            String username = (String) session.getAttribute("username");
            if (username != null) {
                int count = Integer.parseInt((String) getServletContext().getAttribute("user-counter")) - 1;
                getServletContext().setAttribute("user-counter", count + "");
                request.getSession(false).removeAttribute("username");
                response.sendRedirect("/app/login");
            }
        }

    }
}
