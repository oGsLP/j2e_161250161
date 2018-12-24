package classes.listeners; /**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/24
 * @Time: 15:40
 * @Package: ${PACKAGE_NAME}
 */

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.io.*;

import static java.lang.Thread.sleep;

@WebListener
public class CounterListener implements ServletContextListener,
        ServletContextAttributeListener,HttpSessionListener, HttpSessionAttributeListener {
    private int userCounter;
    private int travellerCounter;
    private String counterPath="F:\\学习\\我的大学课程\\大三（二）\\JEE中间件\\作业\\src\\main\\webapp\\counter.txt";
    // Public constructor is required by servlet spec
    public CounterListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        try {
            BufferedReader br=new BufferedReader(new FileReader(counterPath));
            userCounter=Integer.parseInt(br.readLine());
            travellerCounter=Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServletContext context=sce.getServletContext();
        context.setAttribute("user-counter",userCounter+"");
        context.setAttribute("traveller-counter",travellerCounter+"");
    }



    public void attributeAdded(ServletContextAttributeEvent scab) {
    }


    public void attributeRemoved(ServletContextAttributeEvent scab) {
    }


    public void attributeReplaced(ServletContextAttributeEvent scab) {
        writeCounter(scab);
    }

    public synchronized void writeCounter(ServletContextAttributeEvent scab){
        ServletContext servletContext=scab.getServletContext();
        userCounter=Integer.parseInt((String) servletContext.getAttribute("user-counter"));
        travellerCounter=Integer.parseInt((String) servletContext.getAttribute("traveller-counter"));
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(counterPath));
            bw.write(""+userCounter+"\n");
            bw.write(""+travellerCounter);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(counterPath));
            bw.write("0"+"\n");
            bw.write("0");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(60);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String traveller= (String) se.getSession().getAttribute("traveller");
        String username= (String) se.getSession().getAttribute("username");
        if(traveller!=null){
            int count=Integer.parseInt((String) se.getSession().getServletContext().getAttribute("traveller-counter"));
            count--;
            se.getSession().getServletContext().setAttribute("traveller-counter",""+count);
        }
        if(username!=null){
            int count=Integer.parseInt((String) se.getSession().getServletContext().getAttribute("user-counter"));
            count--;
            se.getSession().getServletContext().setAttribute("user-counter",""+count);
        }
    }
}
