package classes.factory;

import classes.service.ShopService;
import classes.service.StockManageService;
import classes.service.UserManageService;
import classes.service.impl.ShopServiceImpl;
import classes.service.impl.StockManageServiceImpl;
import classes.service.impl.UserManageServiceImpl;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 19:39
 * @Package: classes.factory
 */
public class ServiceFactory {

    public static UserManageService getUserService(){
        return UserManageServiceImpl.getInstance();
    }

    public static StockManageService getStockService(){
        return StockManageServiceImpl.getInstance();
    }

    public static ShopService getShopService(){return ShopServiceImpl.getInstance();}

}
