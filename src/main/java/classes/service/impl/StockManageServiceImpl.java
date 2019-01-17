package classes.service.impl;

import classes.dao.StockDao;
import classes.dao.UserDao;
import classes.entities.Goods;
import classes.factory.DaoFactory;
import classes.service.StockManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:28
 * @Package: classes.service.impl
 */
@Service(value = "StockManageService")
public class StockManageServiceImpl implements StockManageService {

    @Autowired
    private StockDao stockDao;

//    private static StockManageServiceImpl stockService=new StockManageServiceImpl();
//    public static StockManageServiceImpl getInstance(){return stockService;}

    @Override
    public Goods findGoods(int id) {
        Goods goods=null;
        String name=stockDao.getName(id);
        if(name!=null){
            goods=findGoods(name);
        }
        return goods;
    }

    @Override
    public Goods findGoods(String name) {
        return stockDao.findGoods(name);
    }

    @Override
    public List getStock() {
        return stockDao.getStock();
    }

    @Override
    public boolean addStock(Goods goods) {
        return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return stockDao.updateGoods(goods);
    }

    @Override
    public boolean deleteGoods(String name) {
        return false;
    }

    @Override
    public int getGoodsNum() {
        return stockDao.getGoodsNum();
    }

    @Override
    public boolean buyGoods(String name, int num) {
            return false;
    }

}
