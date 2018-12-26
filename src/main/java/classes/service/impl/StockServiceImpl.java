package classes.service.impl;

import classes.entities.Goods;
import classes.factory.DaoFactory;
import classes.factory.ServiceFactory;
import classes.service.StockService;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:28
 * @Package: classes.service.impl
 */
public class StockServiceImpl implements StockService {
    private static StockServiceImpl stockService=new StockServiceImpl();
    public static StockServiceImpl getInstance(){return stockService;}

    @Override
    public Goods findGoods(int id) {
        Goods goods=null;
        String name=DaoFactory.getStockDao().getName(id);
        if(name!=null){
            goods=findGoods(name);
        }
        return null;
    }

    @Override
    public Goods findGoods(String name) {
        return DaoFactory.getStockDao().findGoods(name);
    }

    @Override
    public List getStock() {
        return DaoFactory.getStockDao().getStock();
    }

    @Override
    public boolean addStock(Goods goods) {
        return false;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return DaoFactory.getStockDao().updateGoods(goods);
    }

    @Override
    public boolean deleteGoods(Goods goods) {
        return false;
    }

    @Override
    public int getGoodsNum() {
        return DaoFactory.getStockDao().getGoodsNum();
    }

    @Override
    public boolean buyGoods(String name, int num) {
        Goods goods=DaoFactory.getStockDao().findGoods(name);
        if(goods!=null){
            int stockNum=goods.getNum();
            if(stockNum<num){
                return false;
            }
            else {
                goods.setNum(stockNum-num);
                updateGoods(goods);
                return true;
            }
        }
        else
            return false;
    }
}
