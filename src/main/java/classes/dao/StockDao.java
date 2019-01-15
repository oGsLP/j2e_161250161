package classes.dao;


import classes.entities.Goods;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 19:41
 * @Package: classes.dao
 */
public interface StockDao {

    /**
     * 根据id找goods名称
     * @param id
     * @return
     */
    String getName(int id);

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
     * @param name
     * @return
     */
    boolean deleteGoods(String name);

    /**
     * 获得所有商品的个数
     * @return
     */
    int getGoodsNum();


}
