package classes.dao.impl;

import classes.dao.StockDao;
import classes.entities.Goods;
import classes.helpers.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2018/12/26
 * @Time: 21:23
 * @Package: classes.dao.impl
 */
public class StockDaoImpl extends BaseDaoImpl implements StockDao {

    private static StockDaoImpl stockDao=new StockDaoImpl();

    private StockDaoImpl(){
    }
    public static StockDaoImpl getInstance(){
        return stockDao;
    }



    @Override
    public String getName(int id) {
        String name=null;
        Goods goods= (Goods) super.load(Goods.class,id);
        if(goods!=null){
            name=goods.getName();
        }
        return name;
    }

    @Override
    public Goods findGoods(String name) {
        int id = getIdByName(name);
        if(id>0){
            return (Goods) super.load(Goods.class,id);
        }
        else return null;
    }

    @Override
    public List getStock() {
        return super.getAllList(Goods.class);
    }

    @Override
    public boolean addStock(Goods goods) {
        if(goods!=null){
            return super.insert(goods);
        }
        else
            return false;
    }



    @Override
    public boolean updateGoods(Goods goods) {
        if(goods!=null){
            return super.update(goods);
        }
        else
            return false;
    }

    @Override
    public boolean deleteGoods(String name) {
        if(name!=null&&getIdByName(name)>0){
            return super.delete(Goods.class,getIdByName(name));
        }
        else
            return false;
    }

    @Override
    public int getGoodsNum() {
        return super.getNum(Goods.class);
    }



//    private void setGoodsExID(Goods goods, PreparedStatement pstmt) throws SQLException {
//        pstmt.setString(1,goods.getName());
//        pstmt.setString(2,goods.getKind());
//        pstmt.setDouble(3,goods.getPrice());
//        pstmt.setInt(4,goods.getNum());
//    }

    private int getIdByName(String name){
        int id = -1;
        Session session= HibernateHelper.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("from Goods goods where goods.name=:goodsName");
        query.setParameter("goodsName",name);
        List list=query.list();transaction.commit();
        if(list!=null) {
            Goods goods = (Goods) list.get(0);
            id = goods.getId();
        }
        return id;
    }


}
