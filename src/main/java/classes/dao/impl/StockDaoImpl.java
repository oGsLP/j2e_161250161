package classes.dao.impl;

import classes.dao.BaseDao;
import classes.dao.StockDao;
import classes.entities.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:23
 * @Package: classes.dao.impl
 */

@Repository
public class StockDaoImpl implements StockDao {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

//    private static StockDaoImpl stockDao=new StockDaoImpl();
//
//    private StockDaoImpl(){
//    }
//    public static StockDaoImpl getInstance(){
//        return stockDao;
//    }



    @Override
    public String getName(int id) {
        String name=null;
        Goods goods= (Goods) baseDao.load(Goods.class,id);
        if(goods!=null){
            name=goods.getName();
        }
        return name;
    }

    @Override
    public Goods findGoods(String name) {
        int id = getIdByName(name);
        if(id>0){
            return (Goods) baseDao.load(Goods.class,id);
        }
        else return null;
    }

    @Override
    public List getStock() {
        return baseDao.getAllList(Goods.class);
    }

    @Override
    public boolean addStock(Goods goods) {
        if(goods!=null){
            return baseDao.insert(goods);
        }
        else
            return false;
    }



    @Override
    public boolean updateGoods(Goods goods) {
        if(goods!=null){
            return baseDao.update(goods);
        }
        else
            return false;
    }

    @Override
    public boolean deleteGoods(String name) {
        if(name!=null&&getIdByName(name)>0){
            return baseDao.delete(Goods.class,getIdByName(name));
        }
        else
            return false;
    }

    @Override
    public int getGoodsNum() {
        return baseDao.getNum(Goods.class);
    }



//    private void setGoodsExID(Goods goods, PreparedStatement pstmt) throws SQLException {
//        pstmt.setString(1,goods.getName());
//        pstmt.setString(2,goods.getKind());
//        pstmt.setDouble(3,goods.getPrice());
//        pstmt.setInt(4,goods.getNum());
//    }

    private int getIdByName(String name){
        int id = -1;
        Query query=getSession().createQuery("from Goods goods where goods.name=:goodsName");
        query.setParameter("goodsName",name);
        List list=query.list();
        if(list!=null) {
            Goods goods = (Goods) list.get(0);
            id = goods.getId();
        }
        return id;
    }


}
