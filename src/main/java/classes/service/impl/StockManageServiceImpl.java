package classes.service.impl;

import classes.entities.Goods;
import classes.factory.DaoFactory;
import classes.service.StockManageService;

import java.util.ArrayList;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:28
 * @Package: classes.service.impl
 */
public class StockManageServiceImpl implements StockManageService {
    private static StockManageServiceImpl stockService=new StockManageServiceImpl();
    public static StockManageServiceImpl getInstance(){return stockService;}

    @Override
    public Goods findGoods(int id) {
        Goods goods=null;
        String name=DaoFactory.getStockDao().getName(id);
        if(name!=null){
            goods=findGoods(name);
        }
        return goods;
    }

    @Override
    public Goods findGoods(String name) {
        return DaoFactory.getStockDao().findGoods(name);
    }

    @Override
    public ArrayList<Goods> getStock() {
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
    public boolean deleteGoods(String name) {
        return false;
    }

    @Override
    public int getGoodsNum() {
        return DaoFactory.getStockDao().getGoodsNum();
    }

    @Override
    public boolean buyGoods(String name, int num) {
//        Goods goods=DaoFactory.getStockDao().findGoods(name);
//        if(goods!=null){
//            int stockNum=goods.getNum();
//            if(stockNum<num){
//                return false;
//            }
//            else {
//                goods.setNum(stockNum-num);
//                updateGoods(goods);
//                return true;
//            }
//        }
//        else
            return false;
    }

}
