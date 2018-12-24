package classes.servlets;

import classes.entities.Goods;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/22
 * @Time: 21:29
 * @Package: ${PACKAGE_NAME}
 */
@WebServlet("/app/liquidate")
public class LiquidateServlet extends HttpServlet {
    Context ctx; DataSource dataSource; Statement stmt; ResultSet result;
    PreparedStatement pstmt;
    Connection con;
    public void init(){
        try {
            ctx=new InitialContext();
            dataSource=(DataSource) ctx.lookup("java:comp/env/jdbc/jee_hw");
            con = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int s1= Integer.parseInt(request.getParameter("goods1"));
//        int s2= Integer.parseInt(request.getParameter("goods2"));
        double total=0;
        double sign = 0;
        try {
            con.setAutoCommit(false);
            int i=1;int peak=getGoodsNum();
            while(i<=peak){

                if(request.getParameter("shop_goods_"+i)!=null){
                    sign=buyGoods(i, Integer.parseInt(request.getParameter("shop_goods_"+i)));
                    if(sign<0){
                        con.rollback();
                        System.out.println("Rollback");
                        break;
                    }
                    else {
                        total+=sign;
                    }

                }
                i++;
            }
            con.commit();
            con.setAutoCommit(true);
            result.close();
            pstmt.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            try {
                con.rollback();
                con.close();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }



        PrintWriter pw=response.getWriter();
        pw.println("<html>" +
                "<body style=\"text-align:center\">");
        if(sign<0){
            pw.println("<p>购买失败，超出库存</p>");
            pw.println("<p>Wrong! Out of stock range!</p>");
        }
        else {
            pw.println("<p>购买成功，总计花费 "+total+"￥</p>");
            if(total>10000){
                total=10000+(total-10000)*0.8;
                pw.println("<p>购满1w,超出部分享受八折</p>");
                pw.println("<p>折后价 : "+total+"￥</p>");
            }
        }
        pw.println("<a href=\"login\">"+"back"+"</a>");
        pw.println("</body></html>");

    }

    private double buyGoods(int id,int num){
        System.out.print("Buy "+id+" "+num);
        double sign=0;

        /* to do */
        try {
            pstmt=con.prepareStatement("select * from goods where id=?");
            pstmt.setInt(1,id);
            result=pstmt.executeQuery();
            if(result.next()){
                int sum = result.getInt("num");
                double price =result.getDouble("price");
                if(sum>=num){
                    pstmt=con.prepareStatement("update goods set num=num-? where id=?");
                    pstmt.setInt(1,num);
                    pstmt.setInt(2,id);
                    sign=num*price;
                    pstmt.executeUpdate();
                    System.out.println(" success");
                }
                else {
                    sign=-1;
                    System.out.println(" failed");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sign;
    }

    private int getGoodsNum() throws SQLException {
        stmt=con.createStatement();
        result=stmt.executeQuery("select count(*) as size from goods");
        result.next();
        return result.getInt(1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
