package classes.factory;

import classes.service.StockService;
import classes.service.UserService;
import classes.service.impl.StockServiceImpl;
import classes.service.impl.UserServiceImpl;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 19:39
 * @Package: classes.factory
 */
public class ServiceFactory {

    public static UserService getUserService(){
        return UserServiceImpl.getInstance();
    }

    public static StockService getStockService(){
        return StockServiceImpl.getInstance();
    }
}
