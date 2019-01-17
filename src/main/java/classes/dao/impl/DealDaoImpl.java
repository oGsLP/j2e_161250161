package classes.dao.impl;

import classes.dao.BaseDao;
import classes.dao.DealDao;
import classes.entities.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @你大爷: XYF
 * @author: lenovo XYF
 * @Date: 2019/1/15
 * @Time: 13:03
 * @Package: classes.dao.impl
 */
@Repository
public class DealDaoImpl implements DealDao {
    @Autowired
    private BaseDao baseDao;


//    private static DealDaoImpl dealDao=new DealDaoImpl();
//
//    private DealDaoImpl(){
//    }
//
//    public static DealDaoImpl getInstance(){return dealDao;}

    @Override
    public Deal findDeal(int id) {
        return (Deal) baseDao.load(Deal.class,id);
    }

    @Override
    public List getDeals() {
        return baseDao.getAllList(Deal.class);
    }

    @Override
    public List getDeals(String username) {
        //to do
        return null;
    }

    @Override
    public boolean addDeal(Deal deal) {
        if(deal!=null){
            return baseDao.insert(deal);
        }
        else return false;
    }

    @Override
    public boolean deleteDeal(int id) {
        Deal deal= findDeal(id);
        if(deal!=null){
            return baseDao.delete(Deal.class,id);
        }
        else
        return false;
    }

    @Override
    public boolean updateDeal(Deal deal) {
        if(deal!=null){
            return baseDao.update(deal);
        }
        else
        return false;
    }
}
