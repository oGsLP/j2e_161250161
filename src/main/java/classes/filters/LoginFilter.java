package classes.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/24
 * @Time: 15:13
 * @Package: ${PACKAGE_NAME}
 */
@WebFilter("/app/*")
public class LoginFilter implements Filter {
    private String[] excludedPage;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        boolean isExcludedPage = false;
        System.out.println("to : "+((HttpServletRequest) req).getServletPath());
        for (String page : excludedPage) {
            String path =((HttpServletRequest) req).getServletPath();
            if (path.equals(page)||path.endsWith("css")||path.endsWith("js")) {
                System.out.println("exlucde "+page);
                isExcludedPage = true;
                break;
            }
        }


        if(isExcludedPage){

            chain.doFilter(req,resp);
        }
        else {
            HttpServletRequest request= (HttpServletRequest) req;
            HttpServletResponse response= (HttpServletResponse) resp;
            HttpSession session=request.getSession(false);
            if(session!=null){
                String username= (String) session.getAttribute("username");
                String traveller= (String) session.getAttribute("traveller");
                if(username==null&&traveller==null){
                    response.sendRedirect("/app/login");
                    return;
                }
            }
            else {
                response.sendRedirect("/app/login");
                return;
            }
            chain.doFilter(req, resp);
        }


    }

    public void init(FilterConfig config) {
        excludedPage=new String[]{"/index.jsp","/app/login","/app/login.jsp","/app/traveller","/app/isolate"};
    }

}
