package classes.dao.impl;

import classes.dao.UserDao;
import classes.entities.User;
import classes.helpers.MYSQLHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 20:45
 * @Package: classes.dao.impl
 */
public class UserDaoImpl implements UserDao {

    private static UserDaoImpl userDao=new UserDaoImpl();
    private static MYSQLHelper mysqlHelper= MYSQLHelper.getInstance();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance(){
        return userDao;
    }



    @Override
    public String getName(int id) {

        Connection connection=mysqlHelper.getConnection();
        PreparedStatement pstmt=null;
        ResultSet result=null;

        String username=null;
        try {
            pstmt=connection.prepareStatement("select username from user where id=?");
            pstmt.setInt(1,id);
            result=pstmt.executeQuery();
            if(result.next())
                username=result.getString("username");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mysqlHelper.closeResultSet(result);
            mysqlHelper.closePreparedStatement(pstmt);
            mysqlHelper.closeConnection(connection);
        }
        return username;
    }

    @Override
    public User findUser(String username) {
        Connection connection=mysqlHelper.getConnection();
        PreparedStatement pstmt=null;
        ResultSet result=null;

        User user=null;
        try {
            pstmt=connection.prepareStatement("select * from user where username=?");
            pstmt.setString(1,username);
            result=pstmt.executeQuery();
            if(result.next()){
                user=new User();
                user.setUser(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mysqlHelper.closeResultSet(result);
            mysqlHelper.closePreparedStatement(pstmt);
            mysqlHelper.closeConnection(connection);
        }
        return user;
    }

    @Override
    public List getUsers() {
        Connection connection=mysqlHelper.getConnection();
        Statement statement=null;
        ResultSet result=null;
        ArrayList<User> users=new ArrayList<>();

        try {
            statement=connection.createStatement();
            result=statement.executeQuery("select * from user");
            while(result.next()){
                User user=new User();
                user.setUser(result);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            mysqlHelper.closeResultSet(result);
            mysqlHelper.closeStatement(statement);
            mysqlHelper.closeConnection(connection);
        }
        return users;
    }

    @Override
    public boolean addUser(User user) {
        if(user!=null){
            Connection connection=mysqlHelper.getConnection();
            PreparedStatement pstmt=null;

            try {
                pstmt=connection.prepareStatement("insert into user(username,password,account) values(?,?,?)");
                setUserExID(user,pstmt);
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
    public boolean deleteUser(String username) {
        if(username!=null){
            Connection connection=mysqlHelper.getConnection();
            PreparedStatement pstmt=null;
            try {
                pstmt=connection.prepareStatement("delete from user where username=?");
                pstmt.setString(1,username);
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
    public boolean updateUser(User user) {
        if(user!=null){
            Connection connection=mysqlHelper.getConnection();
            PreparedStatement pstmt=null;

            try {
                pstmt=connection.prepareStatement("update user set username=?,password=?,account=? where id=?");
                setUserExID(user,pstmt);
                pstmt.setInt(4,user.getId());
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
        return false;
    }


    private void setUserExID(User user, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getPassword());
        pstmt.setDouble(3,user.getAccount());
    }

}
