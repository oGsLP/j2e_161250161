package classes.dao.impl;

import classes.dao.StockDao;
import classes.entities.Goods;
import classes.helpers.MYSQLHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:23
 * @Package: classes.dao.impl
 */
public class StockDaoImpl implements StockDao {

    private static StockDaoImpl stockDao=new StockDaoImpl();
    private static MYSQLHelper mysqlHelper=MYSQLHelper.getInstance();

    private StockDaoImpl(){
    }
    public static StockDaoImpl getInstance(){
        return stockDao;
    }



    @Override
    public String getName(int id) {
        Connection connection=mysqlHelper.getConnection();
        PreparedStatement pstmt=null;
        ResultSet result=null;

        String name=null;

        try {
            pstmt=connection.prepareStatement("select name from goods where id=?");
            pstmt.setInt(1,id);
            result=pstmt.executeQuery();
            if(result.next()){
                name=result.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mysqlHelper.closeResultSet(result);
            mysqlHelper.closePreparedStatement(pstmt);
            mysqlHelper.closeConnection(connection);
        }
        return name;
    }

    @Override
    public Goods findGoods(String name) {
        Connection connection=mysqlHelper.getConnection();
        PreparedStatement pstmt=null;
        ResultSet result=null;

        Goods goods=null;

        try {
            pstmt=connection.prepareStatement("select * from goods where name=?");
            pstmt.setString(1,name);
            result=pstmt.executeQuery();
            if(result.next()){
                goods=new Goods();
                goods.setGoods(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mysqlHelper.closeResultSet(result);
            mysqlHelper.closePreparedStatement(pstmt);
            mysqlHelper.closeConnection(connection);
        }
        return goods;
    }

    @Override
    public List getStock() {
        Connection connection=mysqlHelper.getConnection();
        Statement statement=null;
        ResultSet result=null;

        ArrayList<Goods> goodsList=new ArrayList<Goods>();

        try {
            statement=connection.createStatement();
            result=statement.executeQuery("select * from goods");
            while (result.next()){
                Goods goods=new Goods();
                goods.setGoods(result);
                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public boolean addStock(Goods goods) {
        return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        if(goods!=null){
            Connection connection=mysqlHelper.getConnection();
            PreparedStatement pstmt=null;
            try {
                pstmt=connection.prepareStatement("update goods set name=?,kind=?,price=?,num=? where id=?");
                pstmt.setString(1,goods.getName());
                pstmt.setString(2,goods.getKind());
                pstmt.setDouble(3,goods.getPrice());
                pstmt.setInt(4,goods.getNum());
                pstmt.setInt(5,goods.getId());
                pstmt.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                mysqlHelper.closePreparedStatement(pstmt);
                mysqlHelper.closeConnection(connection);
            }
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        return false;
    }

    @Override
    public int getGoodsNum() {
        return getStock().size();
    }

}
