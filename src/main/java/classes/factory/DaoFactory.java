package classes.factory;

import classes.dao.StockDao;
import classes.dao.UserDao;
import classes.dao.impl.StockDaoImpl;
import classes.dao.impl.UserDaoImpl;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 19:39
 * @Package: classes.factory
 */
public class DaoFactory {

    public static UserDao getUserDao(){
        return UserDaoImpl.getInstance();
    }

    public static StockDao getStockDao(){
        return StockDaoImpl.getInstance();
    }


}
