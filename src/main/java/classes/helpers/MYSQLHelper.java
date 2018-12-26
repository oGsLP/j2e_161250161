package classes.helpers;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 19:47
 * @Package: classes.helpers
 */
public class MYSQLHelper {
    private static MYSQLHelper instance=new MYSQLHelper();
    private Connection con=null;
    private DataSource dataSource=null;

    private MYSQLHelper(){
        InitialContext jndiContext = null;
        DataSource datasource;
        Properties properties = new Properties();
        properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
        properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        try {
            jndiContext = new InitialContext(properties);
            dataSource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/jee_hw");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static MYSQLHelper getInstance(){
        return instance;
    }
    public Connection getConnection() {
        try {
            con=dataSource.getConnection();
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MYSQLHelper.getInstance().con;
    }


    // close connection ,resultSet and other resources


    public void closeConnection(Connection connection){
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeResultSet(ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closePreparedStatement(PreparedStatement preparedStatement){
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeStatement(Statement statement){
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
