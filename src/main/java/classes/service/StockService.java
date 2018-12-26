package classes.service;

import classes.entities.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 20:45
 * @Package: classes.service
 */
public interface StockService  {



    /**
     * 根据名字找goods
     * @param id
     * @return
     */
    Goods findGoods(int id);

    /**
     * 根据名字找goods
     * @param name
     * @return
     */
    Goods findGoods(String name);

    /**
     * 返回goods列表
     * @return
     */
    List getStock();

    /**
     * 增加一个goods
     * @param goods
     * @return
     */
    boolean addStock(Goods goods);

    /**
     * 更新goods信息
     * @param goods
     * @return
     */
    boolean updateGoods(Goods goods);

    /**
     * 删除一个goods
     * @param goods
     * @return
     */
    boolean deleteGoods(Goods goods);

    /**
     * 获得所有goods个数
     * @return
     */
    int getGoodsNum();

    /**
     * 买一种goods
     * @param name
     * @param num
     * @return
     */
    boolean buyGoods(String name,int num);


}
