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
 * @Date: 2018/12/29
 * @Time: 1:10
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/giveResult")
public class GiveResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if(session.getAttribute("shop_result")!=null){
            request.setAttribute("shop_result",session.getAttribute("shop_result"));
        }
        request.getRequestDispatcher("/app/shopResult.jsp").forward(request,response);
    }
}
